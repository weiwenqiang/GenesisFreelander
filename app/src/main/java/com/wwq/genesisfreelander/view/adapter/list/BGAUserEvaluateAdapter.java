package com.wwq.genesisfreelander.view.adapter.list;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.controller.pref.GlobalContants;
import com.wwq.genesisfreelander.controller.utils.T;
import com.wwq.genesisfreelander.controller.utils.UiUtils;
import com.wwq.genesisfreelander.model.json.FindTalkEntity;
import com.wwq.genesisfreelander.model.json.RequestErrorEntity;
import com.wwq.genesisfreelander.view.base.BaseApplication;
import com.wwq.genesisfreelander.view.fragment.setting.SetCommentFragment;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.Arrays;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

/**
 * Created by wwq on 2017/5/3.
 */

public class BGAUserEvaluateAdapter extends BGAAdapterViewAdapter<FindTalkEntity.DataBean.ReplyBean> {
    private Context context;

    private myWatcher mWatcher;
    private int index = -1;//记录选中的位置
    private String text[];//记录输入的值
    private ImageOptions imageOptions;
    private SetCommentFragment setCommentFragment;

    public BGAUserEvaluateAdapter(Context context, List<FindTalkEntity.DataBean.ReplyBean> data, SetCommentFragment setCommentFragment) {
        super(context, R.layout.item_set_comment);
        this.context = context;
        text=new String[data.size()];
        imageOptions = new ImageOptions.Builder()
//                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                .setRadius(DensityUtil.dip2px(5))
                .setCrop(true)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();
        this.setCommentFragment = setCommentFragment;
    }

    @Override
    protected void fillData(final BGAViewHolderHelper helper, final int position, final FindTalkEntity.DataBean.ReplyBean model) {
        //用户名称
//        helper.setText(R.id.txt_yhpj_user_name, model.getNickName());
        if (!TextUtils.isEmpty(model.getNickName().trim())) {
            helper.setText(R.id.txt_yhpj_user_name, model.getNickName());
        }else{
            helper.setText(R.id.txt_yhpj_user_name, "匿名");
        }
        //创建时间
        helper.setText(R.id.txt_yhpj_create_time, GlobalContants.DATEMMDD.format(Float.valueOf(model.getTalkedDate().trim())));
        //确认到达时间
        helper.setText(R.id.txt_yhpj_end_time, GlobalContants.DATEHHMM.format(Float.valueOf(model.getSendTime().trim()))+"送达");
        //星级评分
        AppCompatRatingBar rtbGrade = helper.getView(R.id.rtb_grade);
        rtbGrade.setMax(5);
        rtbGrade.setRating(Float.valueOf(model.getShopScore()));
        //商家回复
        TextView merchantText = helper.getView(R.id.txt_yhpj_merchant_text);
        //回复布局
        LinearLayout lytReply = helper.getView(R.id.lyt_yhpj_reply);
        if (GlobalContants.isLeftRight) {
            //未回复
            merchantText.setVisibility(View.GONE);
            lytReply.setVisibility(View.VISIBLE);

        } else {
            //已回复
            merchantText.setVisibility(View.VISIBLE);
            merchantText.setText("商家回复:"+model.getShopReply());

            lytReply.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(model.getGuardTarge())) {
            String[] guardTarge = model.getGuardTarge().split(",");
            List<String> list = Arrays.asList(guardTarge);
            //流布局
            FrameLayout lytMerchantGrade = helper.getView(R.id.lyt_merchant_grade);
            lytMerchantGrade.addView(UiUtils.getEllipseStreamLayout(list));
        }

        ImageView imageView = helper.getView(R.id.img_yhpj_image);
        if (!TextUtils.isEmpty(model.getTalkedImage())) {
            imageView.setVisibility(View.VISIBLE);
            x.image().bind(imageView, "http://124.165.205.15:8080/image/" + model.getTalkedImage(), imageOptions);
        }else{
            imageView.setVisibility(View.GONE);
        }

        //评论内容
        helper.setText(R.id.txt_yhpj_user_text, model.getTalkContent());
        //评论内容
        helper.setText(R.id.txt_order_text, model.getOrderDetail());
        try {
            //
            final EditText editText = helper.getView(R.id.edt_yhpj_reply_centent);
            editText.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // TODO Auto-generated method stub
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        index = position;
                    }
                    return false;
                }
            });
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                //设置焦点监听，当获取到焦点的时候才给它设置内容变化监听解决卡的问题

                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    EditText et = (EditText) v;
                    if (mWatcher == null) {
                        mWatcher = new myWatcher();
                    }
                    if (hasFocus) {
                        et.addTextChangedListener(mWatcher);//设置edittext内容监听
                    } else {
                        et.removeTextChangedListener(mWatcher);
                    }

                }
            });
            editText.clearFocus();//防止点击以后弹出键盘，重新getview导致的焦点丢失
            if (index != -1 && index == position) {
                // 如果当前的行下标和点击事件中保存的index一致，手动为EditText设置焦点。
                editText.requestFocus();
            }
            editText.setText(text[position]);
            editText.setSelection(editText.getText().length());
//        editText.addTextChangedListener(new myWatcher());//放弃直接的为每一个edittext设置监听内容变化
            //回复
            helper.getView(R.id.btn_yhpj_reply).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!TextUtils.isEmpty(editText.getText().toString().trim())) {
//                        RequestParams params = new RequestParams(GlobalContants.TALK_SHOPREPLY);
//                        params.addQueryStringParameter("id", "" + model.getId());
//                        params.addBodyParameter("replyContent", "" + editText.getText().toString());
//                        params.addBodyParameter("orderId", model.getOrderId());
//                        networkRequest(params);
                        T.showShort(mContext, editText.getText().toString());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class myWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            // TODO Auto-generated method stub


        }

        @Override
        public void afterTextChanged(Editable s) {
            text[index] = s.toString();//为输入的位置内容设置数组管理器，防止item重用机制导致的上下内容一样的问题
        }
    }

    /**
     * 请求服务器获取数据
     */
    protected void networkRequest(RequestParams params) {
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(final String result) {
                parseData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void parseData(String result) {
        Gson gson = new Gson();
        RequestErrorEntity requestErrorEntity = gson.fromJson(result, RequestErrorEntity.class);
        T.showShort(BaseApplication.getApplication(), requestErrorEntity.getMsg());
        setCommentFragment.initView();
    }
}
