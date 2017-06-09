package com.wwq.genesisfreelander.mvp.model.setting;

import com.wwq.genesisfreelander.model.json.CheckUpgradeApkEntity;
import com.wwq.genesisfreelander.mvp.api.ApiEngine;
import com.wwq.genesisfreelander.mvp.api.RxSchedulers;
import com.wwq.genesisfreelander.mvp.contract.setting.SetSettingContract;

import rx.Observable;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetSettingModel implements SetSettingContract.Model {

    @Override
    public Observable<CheckUpgradeApkEntity> getAppUpdate() {
        return ApiEngine.getInstance().getApiService()
                .getAppUpdate()
                .compose(RxSchedulers.<CheckUpgradeApkEntity>switchThread());
    }

    @Override
    public Observable<String> jpushRegistrationId(String registrationId, int type, int status, String token) {
        return ApiEngine.getInstance().getApiService()
                .jpushRegistrationId(registrationId, type, status, token)
                .compose(RxSchedulers.<String>switchThread());
    }

}