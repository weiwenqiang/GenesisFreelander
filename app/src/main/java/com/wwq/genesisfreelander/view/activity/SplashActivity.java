package com.wwq.genesisfreelander.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.activity.SplashContract;
import com.wwq.genesisfreelander.mvp.presenter.activity.SplashPresenter;
import com.wwq.genesisfreelander.view.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wwq on 2017/6/6.
 */

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.rl_root)
    RelativeLayout rlRoot;

    @Override
    public SplashPresenter onCreatePresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mPresenter.startAnim(rlRoot);
    }

    @Override
    public void jumpNextPage(boolean isJump) {
        if (!isJump) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
        finish();
    }
}
