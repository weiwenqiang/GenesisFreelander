package com.wwq.genesisfreelander.view.activity;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.activity.SettingContract;
import com.wwq.genesisfreelander.mvp.presenter.activity.SettingPresenter;
import com.wwq.genesisfreelander.view.base.BaseActivity;

/**
 * Created by wwq on 2017/6/7.
 */

public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingContract.View {
    @Override
    public SettingPresenter onCreatePresenter() {
        return new SettingPresenter(this);
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {

    }
}
