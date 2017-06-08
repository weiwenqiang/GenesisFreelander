package com.wwq.genesisfreelander.mvp.presenter.setting;

import com.wwq.genesisfreelander.mvp.contract.setting.SetAlterPhoneContract;
import com.wwq.genesisfreelander.mvp.model.setting.SetAlterPhoneModel;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetAlterPhonePresenter extends SetAlterPhoneContract.Presenter {
    public SetAlterPhonePresenter(SetAlterPhoneContract.View view) {
        mView = view;
        mModel = new SetAlterPhoneModel();
    }
}