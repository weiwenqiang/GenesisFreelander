package com.wwq.genesisfreelander.view.activity;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.activity.HomeContract;
import com.wwq.genesisfreelander.mvp.presenter.activity.HomePresenter;
import com.wwq.genesisfreelander.view.base.BaseActivity;

/**
 * Created by wwq on 2017/6/6.
 */

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @Override
    public HomePresenter onCreatePresenter() {
        return new HomePresenter(this);
    }
    
    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_home;
    }
    
    @Override
    protected void initView() {
    }
}
