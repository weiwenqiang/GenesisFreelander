package com.wwq.genesisfreelander.mvp.contract.home;

import com.wwq.genesisfreelander.model.json.WaitingOrderEntity;
import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

import rx.Observable;

/**
 * Created by wwq on 2017/6/3.
 */

public interface BaseOrderContract {
    interface View extends BaseView {
//        void showDialog();
//
//        void onFail(String err);
//
//        void hideDialog();
//
//        void onSucceed(WaitingOrderEntity entity);
    }

    interface Model extends BaseModel {
//        Observable<WaitingOrderEntity> WaitingOrder(String token, int type, int rum);
//
//        Observable<WaitingOrderEntity> OrderManageList(String token, String type, String date, int rum);
//
//        Observable<RequestErrorEntity> ReceiveOrder(String token, String orderNo, String type);
//
//        Observable<RequestErrorEntity> replayReminder(long uid, String orderNo, String replayMessage, long replayId, String reminderTime);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
//        public abstract void WaitingOrder(String token, int type, int rum);
//
//        public abstract void OrderManageList(String token, String type, String date, int rum);
//
//        public abstract void ReceiveOrder(String token, String orderNo, String type);
//
//        public abstract void replayReminder(long uid, String orderNo, String replayMessage, long replayId, String reminderTime);
    }
}