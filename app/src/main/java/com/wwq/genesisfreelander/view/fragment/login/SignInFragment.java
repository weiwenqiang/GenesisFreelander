package com.wwq.genesisfreelander.view.fragment.login;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.controller.pref.GlobalContants;
import com.wwq.genesisfreelander.controller.utils.RegexUtil;
import com.wwq.genesisfreelander.controller.utils.SPUtils;
import com.wwq.genesisfreelander.controller.utils.T;
import com.wwq.genesisfreelander.model.json.LoginEntity;
import com.wwq.genesisfreelander.mvp.contract.login.SignInContract;
import com.wwq.genesisfreelander.mvp.model.activity.LoginModel;
import com.wwq.genesisfreelander.mvp.presenter.login.SignInPresenter;
import com.wwq.genesisfreelander.view.activity.LoginActivity;
import com.wwq.genesisfreelander.view.base.BaseApplication;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by wwq on 2017/6/6.
 */

public class SignInFragment extends BaseMvpFragment<SignInPresenter> implements SignInContract.View {
    @BindView(R.id.login_edt_phone)
    EditText loginEdtPhone;
    @BindView(R.id.login_edt_password)
    EditText loginEdtPassword;
    private LoginActivity loginActivity;

    //反转显示密码
    private boolean passShow = true;
    private String phoneStr;
    private String passwordStr;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_login_signin;
    }

    @Override
    public SignInPresenter onCreatePresenter() {
        return new SignInPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
        loginActivity = (LoginActivity) mActivity;
        loginActivity.setToolbarTitle("轮到专送商家端");
        boolean login = (boolean) SPUtils.get(mActivity, "login", false);
        if (login) {
            GlobalContants.TOKEN = (String) SPUtils.get(mActivity, "login_shopToken", "");
            //绑定极光
            mPresenter.jpushRegistrationId(JPushInterface.getRegistrationID(BaseApplication.getApplication()), 3, 1, GlobalContants.TOKEN);

            loginActivity.login();
        }
    }

    @OnClick(R.id.login_img_eye)
    void onImgEyeClick(View view) {
        passShow = !passShow;
        if (passShow) {
            loginEdtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//如果选中，显示密码
        } else {
            loginEdtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());//否则隐藏密码
        }
    }

    @OnClick(R.id.login_txt_findpass)
    void onTxtFindPassClick(View view) {
//        loginActivity.mPresenter.cutFragment(loginActivity.fm, LoginModel.TAG_FORGOT_PASSWORD);
    }

    @OnClick(R.id.login_txt_enter)
    void onTxtEnterClick(View view) {
//        loginActivity.mPresenter.cutFragment(loginActivity.fm, LoginModel.TAG_APPLY_ENTER);
    }

    @OnClick(R.id.login_btn_login)
    void onLoginClick(View view) {
//        if (isInspect()) {
//            mPresenter.ShoppingLogin(phoneStr, passwordStr);
//        }
        loginActivity.login();
    }

    @Override
    public void showDialog() {
        loginActivity.showLoadingDialog();
    }

    @Override
    public void onSucceed(LoginEntity loginEntity) {
        GlobalContants.TOKEN = loginEntity.getData().getToken();
        SPUtils.put(mActivity, "login", true);
        //绑定极光
        mPresenter.jpushRegistrationId(JPushInterface.getRegistrationID(BaseApplication.getApplication()), 3, 1, GlobalContants.TOKEN);
        loginActivity.login();
    }

    @Override
    public void onFail(String err) {
        T.showShort(mActivity, err);
    }

    @Override
    public void hideDialog() {
        loginActivity.dismissLoadingDialog();
    }

    private boolean isInspect() {
        phoneStr = loginEdtPhone.getText().toString().trim();
        passwordStr = loginEdtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(phoneStr)) {
            T.showShort(mActivity, "请输入手机号");
            return false;
        } else if (TextUtils.isEmpty(passwordStr)) {
            T.showShort(mActivity, "请输入密码");
            return false;
        } else if (!RegexUtil.isMobileNO(phoneStr)) {
            T.showShort(mActivity, "请确认手机号有效");
            return false;
        } else {
            return true;
        }
    }

    @OnClick(R.id.login_txt_register_way)
    public void onViewClicked() {
//        loginActivity.mPresenter.cutFragment(loginActivity.fm, LoginModel.TAG_REGISTER_WAY);
    }
}
