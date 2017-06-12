package com.wwq.genesisfreelander.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.controller.pref.GlobalContants;
import com.wwq.genesisfreelander.mvp.contract.activity.SettingContract;
import com.wwq.genesisfreelander.mvp.presenter.activity.SettingPresenter;
import com.wwq.genesisfreelander.view.base.BaseActivity;
import com.wwq.genesisfreelander.view.fragment.function.LocationActivity;
import com.wwq.genesisfreelander.view.fragment.function.RideRouteCalculateActivity;
import com.wwq.genesisfreelander.view.widget.custom.SelectableRoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wwq on 2017/6/7.
 */

public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingContract.View {
    @BindView(R.id.activity_main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.user_round_img)
    SelectableRoundedImageView userRoundImg;
    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.rat_bar)
    RatingBar ratBar;
    @BindView(R.id.txt_day_earnings)
    TextView txtDayEarnings;
    @BindView(R.id.txt_month_earnings)
    TextView txtMonthEarnings;

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
        initToolbar(toolbar);
    }

    private void initToolbar(Toolbar toolbar) {
        toolbar.setFitsSystemWindows(true);//解决与状态栏重叠
        toolbar.setTitle("设置中心");
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.lyt_day_earnings, R.id.lyt_month_earnings, R.id.lty_set_wallet, R.id.lty_set_phone, R.id.lty_set_comment, R.id.lty_set_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lyt_day_earnings:
//                GlobalContants.startVesselActivity(SettingActivity.this, "SetDealDetailsFragment");
                startActivity(new Intent(SettingActivity.this, RideRouteCalculateActivity.class));
                break;
            case R.id.lyt_month_earnings:
                startActivity(new Intent(SettingActivity.this, LocationActivity.class));
//                GlobalContants.startVesselActivity(SettingActivity.this, "SetDealDetailsFragment");
                break;
            case R.id.lty_set_wallet:
                GlobalContants.startVesselActivity(SettingActivity.this, "SetWalletFragment");
                break;
            case R.id.lty_set_phone:
                GlobalContants.startVesselActivity(SettingActivity.this, "SetAlterPhoneFragment");
                break;
            case R.id.lty_set_comment:
                GlobalContants.startVesselActivity(SettingActivity.this, "SetCommentFragment");
                break;
            case R.id.lty_set_setting:
                GlobalContants.startVesselActivity(SettingActivity.this, "SetSettingFragment");
                break;
        }
    }
}
