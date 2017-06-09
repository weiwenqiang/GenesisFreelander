package com.wwq.genesisfreelander.mvp.contract.setting;

import android.app.Activity;
import android.content.Context;

import com.wwq.genesisfreelander.model.json.CheckUpgradeApkEntity;
import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

import rx.Observable;

/**
 * Created by wwq on 2017/6/8.
 */

public interface SetSettingContract {
    interface View extends BaseView {
        void onAppUpdateSucceed(CheckUpgradeApkEntity checkUpgradeApkEntity);
    }

    interface Model extends BaseModel {
        Observable<CheckUpgradeApkEntity> getAppUpdate();

        Observable<String> jpushRegistrationId(String registrationId, int type, int status, String token);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getAppUpdate();

        public abstract void jpushRegistrationId(String registrationId, int type, int status, String token);

        public abstract void showShare(Context context, String platformToShare, boolean showContentEdit);
    }
}