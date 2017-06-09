package com.wwq.genesisfreelander.mvp.presenter.setting;

import com.wwq.genesisfreelander.model.json.FindTalkEntity;
import com.wwq.genesisfreelander.mvp.contract.setting.SetCommentContract;
import com.wwq.genesisfreelander.mvp.model.setting.SetCommentModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetCommentPresenter extends SetCommentContract.Presenter {
    public SetCommentPresenter(SetCommentContract.View view) {
        mView = view;
        mModel = new SetCommentModel();
    }

    @Override
    public void getFindTalk(String token, int type, int start) {
        Subscription subscribe = mModel.getFindTalk(token, type, start)
                .subscribe(new Subscriber<FindTalkEntity>() {
                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onFail(e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(FindTalkEntity findTalkEntity) {
                        mView.onSucceed(findTalkEntity);
                    }
                });
        addSubscribe(subscribe);
    }
}