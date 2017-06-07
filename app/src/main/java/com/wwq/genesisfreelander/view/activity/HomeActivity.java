package com.wwq.genesisfreelander.view.activity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;
import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.activity.HomeContract;
import com.wwq.genesisfreelander.mvp.presenter.activity.HomePresenter;
import com.wwq.genesisfreelander.view.base.BaseActivity;
import com.wwq.genesisfreelander.view.widget.custom.SelectableRoundedImageView;
import com.wwq.genesisfreelander.view.widget.custom.SwitchButton;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wwq on 2017/6/6.
 */

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.indicator)
    TabPageIndicator indicator;
    @BindView(R.id.txt_state)
    TextView txtState;
    @BindView(R.id.img_user_round)
    SelectableRoundedImageView imgUserRound;
    @BindView(R.id.swb_tint_color)
    SwitchButton swbTintColor;

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
        mPresenter.getPagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void initPager(FragmentPagerAdapter adapter) {
        pager.setOffscreenPageLimit(0);
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        swbTintColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtState.setText("开工");
                } else {
                    txtState.setText("休息");
                }
            }
        });
    }

    @OnClick(R.id.img_user_round)
    public void onViewClicked() {

    }
}
