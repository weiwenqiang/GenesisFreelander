package com.wwq.genesisfreelander.mvp.contract.function;

import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

/**
 * Created by wwq on 2017/6/9.
 */

public interface TextPlainContract {
    interface View extends BaseView {

    }

    interface Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<View, Model> {

    }
}