package com.wwq.genesisfreelander.mvp.model.home;

import com.wwq.genesisfreelander.model.json.WaitingOrderEntity;
import com.wwq.genesisfreelander.mvp.api.ApiEngine;
import com.wwq.genesisfreelander.mvp.api.RxSchedulers;
import com.wwq.genesisfreelander.mvp.contract.home.BaseOrderContract;

import rx.Observable;

/**
 * Created by wwq on 2017/6/3.
 */

public class BaseOrderModel implements BaseOrderContract.Model {
//
//    @Override
//    public Observable<WaitingOrderEntity> WaitingOrder(String token, int type, int rum) {
//        return ApiEngine.getInstance().getApiService()
//                .WaitingOrder(token, type, rum)
//                .compose(RxSchedulers.<WaitingOrderEntity>switchThread());
//    }
//
//    @Override
//    public Observable<WaitingOrderEntity> OrderManageList(String token, String type, String date, int rum) {
//        return ApiEngine.getInstance().getApiService()
//                .OrderManageList(token, type, date, rum)
//                .compose(RxSchedulers.<WaitingOrderEntity>switchThread());
//    }
//
//    @Override
//    public Observable<RequestErrorEntity> ReceiveOrder(String token, String orderNo, String type) {
//        return ApiEngine.getInstance().getApiService()
//                .ReceiveOrder(token, orderNo, type)
//                .compose(RxSchedulers.<RequestErrorEntity>switchThread());
//    }
//
//    @Override
//    public Observable<RequestErrorEntity> replayReminder(long uid, String orderNo, String replayMessage, long replayId, String reminderTime) {
//        return ApiEngine.getInstance().getApiService()
//                .replayReminder(uid, orderNo, replayMessage, replayId, reminderTime)
//                .compose(RxSchedulers.<RequestErrorEntity>switchThread());
//    }
}