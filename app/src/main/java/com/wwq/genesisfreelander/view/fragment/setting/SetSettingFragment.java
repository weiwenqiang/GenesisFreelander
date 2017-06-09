package com.wwq.genesisfreelander.view.fragment.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.listener.DialogUIItemListener;
import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.controller.library.xutils.DownloadManager;
import com.wwq.genesisfreelander.controller.pref.GlobalContants;
import com.wwq.genesisfreelander.controller.utils.AppUtils;
import com.wwq.genesisfreelander.controller.utils.DataCleanManagerUtils;
import com.wwq.genesisfreelander.controller.utils.SPUtils;
import com.wwq.genesisfreelander.controller.utils.T;
import com.wwq.genesisfreelander.model.entity.TextPlainEntity;
import com.wwq.genesisfreelander.model.json.CheckUpgradeApkEntity;
import com.wwq.genesisfreelander.mvp.contract.setting.SetSettingContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.SetSettingPresenter;
import com.wwq.genesisfreelander.view.activity.LoginActivity;
import com.wwq.genesisfreelander.view.base.BaseApplication;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;
import com.wwq.genesisfreelander.view.widget.custom.SwitchButton;

import org.greenrobot.eventbus.EventBus;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.jpush.android.api.JPushInterface;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetSettingFragment extends BaseMvpFragment<SetSettingPresenter> implements SetSettingContract.View {

    @BindView(R.id.swb_tint_color)
    SwitchButton swbTintColor;
    @BindView(R.id.txt_set_new_versions)
    TextView txtSetNewVersions;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_setting;
    }

    @Override
    public SetSettingPresenter onCreatePresenter() {
        return new SetSettingPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void setListener() {
        super.setListener();
        swbTintColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                T.showShort(mActivity, ""+isChecked);
            }
        });
    }

    @OnClick({R.id.lyt_set_pass_alter, R.id.lyt_set_idea_feedback, R.id.lyt_set_news_inform, R.id.lyt_set_clear_cache, R.id.lyt_set_regard_we, R.id.lyt_set_inspect_version, R.id.lyt_set_share, R.id.lyt_set_quit_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lyt_set_pass_alter:
                String[] replyArray = new String[]{"通过旧密码修改", "通过手机号修改"};
                DialogUIUtils.showSingleChoose(mActivity, "修改密码", 0, replyArray, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        switch (position){
                            case 0:
                                T.showShort(mActivity, "通过旧密码修改");
                                break;
                            case 1:
                                T.showShort(mActivity, "通过手机号修改");
                                break;
                        }
                    }
                }).show();
                break;
            case R.id.lyt_set_idea_feedback:
                GlobalContants.startVesselActivity(mActivity, "FeedbackIdeaFragment");
                break;
            case R.id.lyt_set_news_inform:
                swbTintColor.setChecked(!swbTintColor.isChecked());
                break;
            case R.id.lyt_set_clear_cache:
//                DataCleanManagerUtils.cleanInternalCache(mActivity);//谨慎使用
                T.showShort(mActivity, "缓存清理完成");
                break;
            case R.id.lyt_set_regard_we:
                EventBus.getDefault().postSticky(new TextPlainEntity(R.string.text_about_us, "关于我们"));
                GlobalContants.startVesselActivity(mActivity, "TextPlainFragment");
                break;
            case R.id.lyt_set_inspect_version:
                mPresenter.getAppUpdate();
                break;
            case R.id.lyt_set_share:
                mPresenter.showShare(mActivity, null, true);
                break;
            case R.id.lyt_set_quit_login:
                //解绑极光
//                mPresenter.jpushRegistrationId(JPushInterface.getRegistrationID(BaseApplication.getApplication()), 3, 2, GlobalContants.TOKEN);
                SPUtils.put(mActivity, "login", false);
                BaseApplication.getApplication().closeActivitys();
                mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
                break;
        }
    }

    @Override
    public void onAppUpdateSucceed(final CheckUpgradeApkEntity checkUpgradeApkEntity) {
        final String downUrl = checkUpgradeApkEntity.getDownloadUrl();
        final String fileName = downUrl.substring(downUrl.lastIndexOf("/") + 1, downUrl.length() - 4);
        if (AppUtils.getVersionCode(mActivity) < checkUpgradeApkEntity.getVersionCode()) {
            final SweetAlertDialog mNewApkDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.NORMAL_TYPE);
            mNewApkDialog.setCancelable(false);
            mNewApkDialog.setConfirmText("升级");
            mNewApkDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    try {
                        DownloadManager.getInstance().startDownload(
                                downUrl, checkUpgradeApkEntity.getDescription(),
                                "/sdcard/xUtils/" + fileName + ".apk", true, false, null);
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                    T.showShort(mActivity, "请等待下载");
                    mNewApkDialog.dismiss();
                }
            });
            mNewApkDialog.setCancelText("取消");
            mNewApkDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    mNewApkDialog.dismiss();
                }
            });
            mNewApkDialog.setTitleText("有新版本，是否升级？");
            mNewApkDialog.setContentText(checkUpgradeApkEntity.getDescription());
            mNewApkDialog.show();
        } else {
            txtSetNewVersions.setVisibility(View.VISIBLE);
        }
    }
}
