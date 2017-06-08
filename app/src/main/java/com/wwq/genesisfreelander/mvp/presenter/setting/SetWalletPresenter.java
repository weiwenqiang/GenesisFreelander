package com.wwq.genesisfreelander.mvp.presenter.setting;

import com.wwq.genesisfreelander.mvp.contract.setting.SetWalletContract;
import com.wwq.genesisfreelander.mvp.model.setting.SetWalletModel;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetWalletPresenter extends SetWalletContract.Presenter {
    public SetWalletPresenter(SetWalletContract.View view) {
        mView = view;
        mModel = new SetWalletModel();
    }

}