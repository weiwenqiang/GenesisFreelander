package com.wwq.genesisfreelander.mvp.contract.activity;

import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

/**
 * Created by wwq on 2017/6/7.
 */

public interface SettingContract {
    interface View extends BaseView {

    }

    interface Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<View, Model> {

    }
}