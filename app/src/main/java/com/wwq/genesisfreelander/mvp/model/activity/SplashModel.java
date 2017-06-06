package com.wwq.genesisfreelander.mvp.model.activity;

import com.wwq.genesisfreelander.controller.utils.SPUtils;
import com.wwq.genesisfreelander.mvp.contract.activity.SplashContract;
import com.wwq.genesisfreelander.view.base.BaseApplication;

/**
 * Created by wwq on 2017/6/6.
 */

public class SplashModel implements SplashContract.Model {
    @Override
    public boolean getUserGuide() {
        return (boolean) SPUtils.get(BaseApplication.getApplication(), "is_user_guide_showed", false);
    }
}