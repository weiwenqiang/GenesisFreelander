package com.wwq.genesisfreelander.mvp.presenter.activity;

import com.wwq.genesisfreelander.mvp.contract.activity.HomeContract;
import com.wwq.genesisfreelander.mvp.model.activity.HomeModel;

/**
 * Created by wwq on 2017/6/6.
 */

public class HomePresenter extends HomeContract.Presenter {
    public HomePresenter(HomeContract.View view) {
        mView = view;
        mModel = new HomeModel();
    }
}