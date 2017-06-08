package com.wwq.genesisfreelander.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.activity.VesselContract;
import com.wwq.genesisfreelander.mvp.presenter.activity.VesselPresenter;
import com.wwq.genesisfreelander.view.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by wwq on 2017/6/8.
 */

public class VesselActivity extends BaseActivity<VesselPresenter> implements VesselContract.View {

    @BindView(R.id.activity_main_toolbar)
    Toolbar toolbar;

    @Override
    public VesselPresenter onCreatePresenter() {
        return new VesselPresenter(this);
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_vessel;
    }

    @Override
    public void initView() {
        FragmentManager fm = getSupportFragmentManager();
        String fragmentString = getIntent().getStringExtra("fragment");
        mPresenter.switchFragment(fragmentString, fm);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void initToolbar(String title) {
        toolbar.setFitsSystemWindows(true);//解决与状态栏重叠
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}