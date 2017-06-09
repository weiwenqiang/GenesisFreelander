package com.wwq.genesisfreelander.mvp.presenter.function;

import com.wwq.genesisfreelander.mvp.contract.function.TextPlainContract;
import com.wwq.genesisfreelander.mvp.model.function.TextPlainModel;

/**
 * Created by wwq on 2017/6/9.
 */

public class TextPlainPresenter extends TextPlainContract.Presenter {
    public TextPlainPresenter(TextPlainContract.View view) {
        mView = view;
        mModel = new TextPlainModel();
    }
}