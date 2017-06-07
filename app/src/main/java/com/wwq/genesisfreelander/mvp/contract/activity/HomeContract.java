package com.wwq.genesisfreelander.mvp.contract.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wwq.genesisfreelander.mvp.base.BaseModel;
import com.wwq.genesisfreelander.mvp.base.BasePresenter;
import com.wwq.genesisfreelander.mvp.base.BaseView;

/**
 * Created by wwq on 2017/6/6.
 */

public interface HomeContract {
    interface View extends BaseView {
        void initPager(FragmentPagerAdapter adapter);
    }

    interface Model extends BaseModel {
        String[] getContent();

        Fragment FragmentFactory(int position);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getPagerAdapter(FragmentManager childFragmentManager);
    }
}