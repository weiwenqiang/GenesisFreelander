package com.wwq.genesisfreelander.view.fragment.home;

import com.wwq.genesisfreelander.view.base.BaseMvpFragment;
import com.wwq.genesisfreelander.view.base.BaseOrderFragment;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 新订单
 * Created by wwq on 2017/6/7.
 */

public class NewOrdersFragment extends BaseOrderFragment {
    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public int getPageNumber() {
        return 0;
    }
}
