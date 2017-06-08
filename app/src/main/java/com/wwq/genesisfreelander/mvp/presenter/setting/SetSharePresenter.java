package com.wwq.genesisfreelander.mvp.presenter.setting;

import com.wwq.genesisfreelander.mvp.contract.setting.SetShareContract;
import com.wwq.genesisfreelander.mvp.model.setting.SetShareModel;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetSharePresenter extends SetShareContract.Presenter {
    public SetSharePresenter(SetShareContract.View view) {
        mView = view;
        mModel = new SetShareModel();
    }
}