package com.wwq.genesisfreelander.mvp.presenter.login;

import android.text.TextUtils;

import com.wwq.genesisfreelander.controller.utils.T;
import com.wwq.genesisfreelander.model.json.LoginEntity;
import com.wwq.genesisfreelander.mvp.contract.login.SignInContract;
import com.wwq.genesisfreelander.mvp.model.login.SignInModel;
import com.wwq.genesisfreelander.view.base.BaseApplication;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by wwq on 2017/4/19.
 */

public class SignInPresenter extends SignInContract.Presenter {
    public SignInPresenter(SignInContract.View view) {
        mView = view;
        mModel = new SignInModel();
    }

    @Override
    public void ShoppingLogin(String phoneNumber, String password) {
        Subscription subscribe = mModel.ShoppingLogin(phoneNumber, password)
                .subscribe(new Subscriber<LoginEntity>() {
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
                        if(!TextUtils.isEmpty(e.getMessage())){
                            mView.onFail(e.getMessage());
                        }
                        onCompleted();
                    }

                    @Override
                    public void onNext(LoginEntity loginBean) {
                        if(!loginBean.getCode().equals("SUCCESS")){
                            mView.onFail(loginBean.getMsg());
                        }
                        mView.onSucceed(loginBean);
                        mModel.saveLoginEntity(loginBean);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void jpushRegistrationId(String registrationId, int type, int status, String token) {
        Subscription subscribe = mModel.jpushRegistrationId(registrationId, type, status, token)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                    }

                    @Override
                    public void onNext(String str) {
                        T.showShort(BaseApplication.getApplication(), str);
                    }
                });
        addSubscribe(subscribe);
    }
}