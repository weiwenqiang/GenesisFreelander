package com.wwq.genesisfreelander.mvp.contract.login;

import com.wwq.genesisfreelander.model.json.LoginEntity;
import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

import rx.Observable;

/**
 * Created by wwq on 2017/4/19.
 */

public interface SignInContract {
    interface View extends BaseView {
        void showDialog();

        void onSucceed(LoginEntity entity);

        void onFail(String err);

        void hideDialog();
    }

    interface Model extends BaseModel {
        Observable<LoginEntity> ShoppingLogin(String phoneNumber, String password);

        Observable<String> jpushRegistrationId(String registrationId, int type, int status, String token);

        void saveLoginEntity(LoginEntity entity);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void ShoppingLogin(String phoneNumber, String password);

        public abstract void jpushRegistrationId(String registrationId, int type, int status, String token);
    }
}