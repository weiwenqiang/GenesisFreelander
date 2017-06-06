package com.wwq.genesisfreelander.mvp.model.login;

import com.wwq.genesisfreelander.controller.utils.SPUtils;
import com.wwq.genesisfreelander.model.json.LoginEntity;
import com.wwq.genesisfreelander.mvp.api.ApiEngine;
import com.wwq.genesisfreelander.mvp.api.RxSchedulers;
import com.wwq.genesisfreelander.mvp.contract.login.SignInContract;
import com.wwq.genesisfreelander.view.base.BaseApplication;

import rx.Observable;

/**
 * Created by wwq on 2017/4/19.
 */

public class SignInModel implements SignInContract.Model {
    @Override
    public Observable<LoginEntity> ShoppingLogin(String phoneNumber, String password) {
        return ApiEngine.getInstance().getApiService()
                .ShoppingLogin(phoneNumber,password)
                .compose(RxSchedulers.<LoginEntity>switchThread());
    }

    @Override
    public Observable<String> jpushRegistrationId(String registrationId, int type, int status, String token) {
        return ApiEngine.getInstance().getApiService()
                .jpushRegistrationId(registrationId, type, status, token)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public void saveLoginEntity(LoginEntity loginEntity) {
        try {
            SPUtils.put(BaseApplication.getApplication(), "login_shopToken", loginEntity.getData().getToken());
////            SPUtils.setObject(BaseApplication.getApplication(), "login_entity", loginEntity);
//            SPUtils.put(BaseApplication.getApplication(), "login_datePrice", loginEntity.getData().getDatePrice());
//            SPUtils.put(BaseApplication.getApplication(), "login_dateSum", loginEntity.getData().getDateSum());
//            SPUtils.put(BaseApplication.getApplication(), "login_id", loginEntity.getData().getId());
//            SPUtils.put(BaseApplication.getApplication(), "login_shopAddress", loginEntity.getData().getShopAddress());
////            SPUtils.put(BaseApplication.getApplication(), "login_shopCity", loginEntity.getData().getShopCity());
////            SPUtils.put(BaseApplication.getApplication(), "login_shopDesc", loginEntity.getData().getShopDesc());
//            SPUtils.put(BaseApplication.getApplication(), "login_shopIcon", loginEntity.getData().getShopIcon());
//            SPUtils.put(BaseApplication.getApplication(), "login_shopName", loginEntity.getData().getShopName());
//            SPUtils.put(BaseApplication.getApplication(), "login_shopPhone", loginEntity.getData().getShopPhone());
////            SPUtils.put(BaseApplication.getApplication(), "login_shopPrice", loginEntity.getData().getShopPrice());
//            SPUtils.put(BaseApplication.getApplication(), "login_shopProvince", loginEntity.getData().getShopProvince());
////            SPUtils.put(BaseApplication.getApplication(), "login_shopRegion", loginEntity.getData().getShopRegion());
//            SPUtils.put(BaseApplication.getApplication(), "login_shopStatus", loginEntity.getData().getShopStatus());
//            SPUtils.put(BaseApplication.getApplication(), "login_shopType", loginEntity.getData().getShopType());
//            SPUtils.put(BaseApplication.getApplication(), "login_agentName", loginEntity.getData().getAgentName());
//
//            SPUtils.put(BaseApplication.getApplication(), "weekString", loginEntity.getData().getWeek());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}