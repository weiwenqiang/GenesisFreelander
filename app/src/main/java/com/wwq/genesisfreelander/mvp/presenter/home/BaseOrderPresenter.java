package com.wwq.genesisfreelander.mvp.presenter.home;

import android.text.TextUtils;

import com.wwq.genesisfreelander.model.json.WaitingOrderEntity;
import com.wwq.genesisfreelander.mvp.contract.home.BaseOrderContract;
import com.wwq.genesisfreelander.mvp.model.home.BaseOrderModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by wwq on 2017/6/3.
 */

public class BaseOrderPresenter extends BaseOrderContract.Presenter {
    public BaseOrderPresenter(BaseOrderContract.View view) {
        mView = view;
        mModel = new BaseOrderModel();
    }
//
//    @Override
//    public void WaitingOrder(String token, int type, int rum) {
//        Subscription subscribe = mModel.WaitingOrder(token, type, rum)
//                .subscribe(new Subscriber<WaitingOrderEntity>() {
//                    @Override
//                    public void onStart() {
////                        mView.showDialog();
//                    }
//
//                    @Override
//                    public void onCompleted() {
////                        mView.hideDialog();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if(!TextUtils.isEmpty(e.getMessage())){
//                            mView.onFail(e.getMessage());
//                        }
//                        onCompleted();
//                    }
//
//                    @Override
//                    public void onNext(WaitingOrderEntity entity) {
//                        if(!entity.getCode().equals("SUCCESS")){
//                            mView.onFail(entity.getMsg());
//                        }
//                        mView.onSucceed(entity);
//                    }
//                });
//        addSubscribe(subscribe);
//    }
//
//    @Override
//    public void OrderManageList(String token, String type, String date, int rum) {
//        Subscription subscribe = mModel.OrderManageList(token, type, date, rum)
//                .subscribe(new Subscriber<WaitingOrderEntity>() {
//                    @Override
//                    public void onStart() {
////                        mView.showDialog();
//                    }
//
//                    @Override
//                    public void onCompleted() {
////                        mView.hideDialog();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if(!TextUtils.isEmpty(e.getMessage())){
//                            mView.onFail(e.getMessage());
//                        }
//                        onCompleted();
//                    }
//
//                    @Override
//                    public void onNext(WaitingOrderEntity entity) {
//                        if(!entity.getCode().equals("SUCCESS")){
//                            mView.onFail(entity.getMsg());
//                        }
//                        mView.onSucceed(entity);
//                    }
//                });
//        addSubscribe(subscribe);
//    }
//
//    @Override
//    public void ReceiveOrder(String token, String orderNo, String type) {
//        Subscription subscribe = mModel.ReceiveOrder(token, orderNo, type)
//                .subscribe(new Subscriber<RequestErrorEntity>() {
//                    @Override
//                    public void onStart() {
////                        mView.showDialog();
//                    }
//
//                    @Override
//                    public void onCompleted() {
////                        mView.hideDialog();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if(!TextUtils.isEmpty(e.getMessage())){
//                            mView.onFail(e.getMessage());
//                        }
//                        onCompleted();
//                    }
//
//                    @Override
//                    public void onNext(RequestErrorEntity entity) {
//                        if(!entity.getCode().equals("SUCCESS")){
//                            mView.onFail(entity.getMsg());
//                        }
//                    }
//                });
//        addSubscribe(subscribe);
//    }
//
//    @Override
//    public void replayReminder(long uid, String orderNo, String replayMessage, long replayId, String reminderTime) {
//        Subscription subscribe = mModel.replayReminder(uid, orderNo, replayMessage, replayId, reminderTime)
//                .subscribe(new Subscriber<RequestErrorEntity>() {
//                    @Override
//                    public void onStart() {
////                        mView.showDialog();
//                    }
//
//                    @Override
//                    public void onCompleted() {
////                        mView.hideDialog();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if(!TextUtils.isEmpty(e.getMessage())){
//                            mView.onFail(e.getMessage());
//                        }
//                        onCompleted();
//                    }
//
//                    @Override
//                    public void onNext(RequestErrorEntity entity) {
//                        if(!entity.getCode().equals("SUCCESS")){
//                            mView.onFail(entity.getMsg());
//                        }
//                    }
//                });
//        addSubscribe(subscribe);
//    }
}