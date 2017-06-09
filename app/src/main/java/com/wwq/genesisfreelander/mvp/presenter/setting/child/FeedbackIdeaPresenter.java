package com.wwq.genesisfreelander.mvp.presenter.setting.child;

import com.wwq.genesisfreelander.mvp.contract.setting.child.FeedbackIdeaContract;
import com.wwq.genesisfreelander.mvp.model.setting.child.FeedbackIdeaModel;

/**
 * Created by wwq on 2017/6/9.
 */

public class FeedbackIdeaPresenter extends FeedbackIdeaContract.Presenter {
    public FeedbackIdeaPresenter(FeedbackIdeaContract.View view) {
        mView = view;
        mModel = new FeedbackIdeaModel();
    }
}