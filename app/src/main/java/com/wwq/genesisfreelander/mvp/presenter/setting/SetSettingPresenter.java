package com.wwq.genesisfreelander.mvp.presenter.setting;

import com.wwq.genesisfreelander.mvp.contract.setting.SetSettingContract;
import com.wwq.genesisfreelander.mvp.model.setting.SetSettingModel;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetSettingPresenter extends SetSettingContract.Presenter {
    public SetSettingPresenter(SetSettingContract.View view) {
        mView = view;
        mModel = new SetSettingModel();
    }
}