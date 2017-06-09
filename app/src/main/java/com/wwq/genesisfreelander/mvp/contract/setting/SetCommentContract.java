package com.wwq.genesisfreelander.mvp.contract.setting;

import com.wwq.genesisfreelander.model.json.FindTalkEntity;
import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

import rx.Observable;

/**
 * Created by wwq on 2017/6/8.
 */

public interface SetCommentContract {
    interface View extends BaseView {
        void showDialog();

        void onSucceed(FindTalkEntity entity);

        void onFail(String err);

        void hideDialog();
    }

    interface Model extends BaseModel {
        Observable<FindTalkEntity> getFindTalk(String token, int type, int start);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getFindTalk(String token, int type, int start);
    }
}