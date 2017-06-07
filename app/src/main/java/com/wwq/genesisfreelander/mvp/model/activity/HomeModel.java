package com.wwq.genesisfreelander.mvp.model.activity;

import android.support.v4.app.Fragment;

import com.wwq.genesisfreelander.mvp.contract.activity.HomeContract;
import com.wwq.genesisfreelander.view.fragment.home.CompletedFragment;
import com.wwq.genesisfreelander.view.fragment.home.NewOrdersFragment;
import com.wwq.genesisfreelander.view.fragment.home.OngoingFragment;
import com.wwq.genesisfreelander.view.fragment.home.ReminderFragment;
import com.wwq.genesisfreelander.view.fragment.home.SingleBackFragment;

/**
 * Created by wwq on 2017/6/6.
 */

public class HomeModel implements HomeContract.Model {
    @Override
    public String[] getContent() {
        return new String[]{"新订单", "进行中", "催单", "已完成", "退单"};
    }

    @Override
    public Fragment FragmentFactory(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new NewOrdersFragment();
        } else if (position == 1) {
            fragment = new OngoingFragment();
        } else if (position == 2) {
            fragment = new ReminderFragment();
        } else if (position == 3) {
            fragment = new CompletedFragment();
        } else if (position == 4) {
            fragment = new SingleBackFragment();
        }
        return fragment;
    }
}