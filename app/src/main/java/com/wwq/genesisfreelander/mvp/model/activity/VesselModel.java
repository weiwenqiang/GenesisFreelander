package com.wwq.genesisfreelander.mvp.model.activity;

import android.support.v4.app.Fragment;

import com.wwq.genesisfreelander.mvp.contract.activity.VesselContract;
import com.wwq.genesisfreelander.view.fragment.function.TextPlainFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetAlterPhoneFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetCommentFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetDealDetailsFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetSettingFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetShareFragment;
import com.wwq.genesisfreelander.view.fragment.setting.SetWalletFragment;
import com.wwq.genesisfreelander.view.fragment.setting.child.FeedbackIdeaFragment;

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
            case "SetSettingFragment"://设置
                fragment = new SetSettingFragment();
                break;
            case "SetDealDetailsFragment"://交易明细
                fragment = new SetDealDetailsFragment();
                break;
            case "FeedbackIdeaFragment"://反馈意见
                fragment = new FeedbackIdeaFragment();
                break;
            case "TextPlainFragment"://纯文本
                fragment = new TextPlainFragment();
                break;
        }
        return fragment;
    }

    @Override
    public String getFragmentTitle(String str) {
        String title = "";
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
            case "SetDealDetailsFragment":
                title = "交易明细";
                break;
            case "FeedbackIdeaFragment":
                title = "反馈意见";
                break;
            case "TextPlainFragment":
                title = "纯文本";
                break;
        }
        return title;
    }
}