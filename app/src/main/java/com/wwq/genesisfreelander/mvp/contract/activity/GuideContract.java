package com.wwq.genesisfreelander.mvp.contract.activity;

import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

/**
 * Created by wwq on 2017/4/17.
 */

public interface GuideContract {
    interface View extends BaseView {
        void initGuide();
    }

    interface Model extends BaseModel {
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void initGuide();
    }
}