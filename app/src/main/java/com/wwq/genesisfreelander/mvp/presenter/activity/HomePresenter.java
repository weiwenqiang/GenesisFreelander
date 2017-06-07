package com.wwq.genesisfreelander.mvp.presenter.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wwq.genesisfreelander.mvp.contract.activity.HomeContract;
import com.wwq.genesisfreelander.mvp.model.activity.HomeModel;

/**
 * Created by wwq on 2017/6/6.
 */

public class HomePresenter extends HomeContract.Presenter {
    public HomePresenter(HomeContract.View view) {
        mView = view;
        mModel = new HomeModel();
    }

    @Override
    public void getPagerAdapter(FragmentManager childFragmentManager) {
        FragmentPagerAdapter adapter = new GoogleMusicAdapter(childFragmentManager);
        mView.initPager(adapter);
    }

    class GoogleMusicAdapter extends FragmentPagerAdapter {
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mModel.FragmentFactory(position % mModel.getContent().length);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mModel.getContent()[position % mModel.getContent().length].toUpperCase();
        }

        @Override
        public int getCount() {
            return mModel.getContent().length;
        }
    }
}