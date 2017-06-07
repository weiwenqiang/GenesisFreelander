package com.wwq.genesisfreelander.mvp.presenter.activity;

import com.wwq.genesisfreelander.mvp.contract.activity.SettingContract;
import com.wwq.genesisfreelander.mvp.model.activity.SettingModel;

/**
 * Created by wwq on 2017/6/7.
 */

public class SettingPresenter extends SettingContract.Presenter {
    public SettingPresenter(SettingContract.View view) {
        mView = view;
        mModel = new SettingModel();
    }
}