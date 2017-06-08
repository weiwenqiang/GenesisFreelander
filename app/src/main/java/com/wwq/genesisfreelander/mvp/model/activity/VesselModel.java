package com.wwq.genesisfreelander.mvp.model.activity;

import android.support.v4.app.Fragment;

import com.wwq.genesisfreelander.mvp.contract.activity.VesselContract;
import com.wwq.genesisfreelander.view.fragment.setting.SetAlterPhoneFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetCommentFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetSettingFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetShareFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetWalletFragment;

/**
 * Created by wwq on 2017/6/8.
 */

public class VesselModel implements VesselContract.Model {
    @Override
    public Fragment FragmentFactory(String str) {
        Fragment fragment = null;
        switch (str) {
            case "SetWalletFragment"://我的钱包
                fragment = new SetWalletFragment();
                break;
            case "SetAlterPhoneFragment"://修改手机号
                fragment = new SetAlterPhoneFragment();
                break;
            case "SetCommentFragment"://评论
                fragment = new SetCommentFragment();
                break;
            case "SetSettingFragment"://评论
                fragment = new SetSettingFragment();
                break;
        }
        return fragment;
    }

    @Override
    public String getFragmentTitle(String str) {
        String title = null;
        switch (str) {
            case "SetWalletFragment":
                title = "我的钱包";
                break;
            case "SetAlterPhoneFragment":
                title = "修改手机号";
                break;
            case "SetCommentFragment":
                title = "评论";
                break;
            case "SetSettingFragment":
                title = "设置";
                break;
        }
        return title;
    }
}