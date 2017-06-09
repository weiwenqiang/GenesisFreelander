package com.wwq.genesisfreelander.mvp.contract.setting;

import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

/**
 * Created by wwq on 2017/6/9.
 */

public interface SetDealDetailsContract {
    interface View extends BaseView {

    }

    interface Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<View, Model> {

    }
}