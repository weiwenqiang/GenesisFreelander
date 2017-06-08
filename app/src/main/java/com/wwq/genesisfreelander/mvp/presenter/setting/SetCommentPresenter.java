package com.wwq.genesisfreelander.mvp.presenter.setting;

import com.wwq.genesisfreelander.mvp.contract.setting.SetCommentContract;
import com.wwq.genesisfreelander.mvp.model.setting.SetCommentModel;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetCommentPresenter extends SetCommentContract.Presenter {
    public SetCommentPresenter(SetCommentContract.View view) {
        mView = view;
        mModel = new SetCommentModel();
    }
}