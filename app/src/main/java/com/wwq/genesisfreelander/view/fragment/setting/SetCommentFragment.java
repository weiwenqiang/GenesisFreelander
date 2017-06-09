package com.wwq.genesisfreelander.view.fragment.setting;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.controller.pref.GlobalContants;
import com.wwq.genesisfreelander.model.json.FindTalkEntity;
import com.wwq.genesisfreelander.mvp.contract.setting.SetCommentContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.SetCommentPresenter;
import com.wwq.genesisfreelander.view.adapter.list.BGAUserEvaluateAdapter;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetCommentFragment extends BaseMvpFragment<SetCommentPresenter> implements SetCommentContract.View {
    @BindView(R.id.rdo_left)
    RadioButton rdoLeft;
    @BindView(R.id.rdo_right)
    RadioButton rdoRight;
    @BindView(R.id.mdyy_lst_yhpj)
    ListView mdyyLstYhpj;

    BGAUserEvaluateAdapter adapter;
    FindTalkEntity findTalkEntity;
    @BindView(R.id.img_no_comment)
    ImageView imgNoComment;

    private int start = 1;
    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_comment;
    }

    @Override
    public SetCommentPresenter onCreatePresenter() {
        return new SetCommentPresenter(this);
    }

    @Override
    public void initView() {
        super.initView();
        mPresenter.getFindTalk(GlobalContants.TOKEN, 1, start);
    }

    @OnClick({R.id.rdo_left, R.id.rdo_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rdo_left:
                GlobalContants.isLeftRight = true;
                mPresenter.getFindTalk(GlobalContants.TOKEN, 1, start);
                break;
            case R.id.rdo_right:
                GlobalContants.isLeftRight = false;
                mPresenter.getFindTalk(GlobalContants.TOKEN, 2, start);
                break;
        }
    }

    @Override
    public void onSucceed(FindTalkEntity entity) {
        adapter = new BGAUserEvaluateAdapter(mActivity, findTalkEntity.getData().getReply(), this);
        mdyyLstYhpj.setAdapter(adapter);
        adapter.setData(findTalkEntity.getData().getReply());
        rdoLeft.setText("未回复评价(" + findTalkEntity.getData().getCount2() + ")");
        rdoRight.setText("已回复评价(" + findTalkEntity.getData().getCount1() + ")");
    }

    @Override
    public void onFail(String err) {
        super.onFail(err);
        imgNoComment.setVisibility(View.VISIBLE);
    }
}
