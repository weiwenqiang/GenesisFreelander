package com.wwq.genesisfreelander.mvp.presenter.setting;

import com.wwq.genesisfreelander.mvp.contract.setting.SetDealDetailsContract;
import com.wwq.genesisfreelander.mvp.model.setting.SetDealDetailsModel;

/**
 * Created by wwq on 2017/6/9.
 */

public class SetDealDetailsPresenter extends SetDealDetailsContract.Presenter {
    public SetDealDetailsPresenter(SetDealDetailsContract.View view) {
        mView = view;
        mModel = new SetDealDetailsModel();
    }
}