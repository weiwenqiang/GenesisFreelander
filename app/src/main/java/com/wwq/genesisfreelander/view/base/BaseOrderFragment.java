package com.wwq.genesisfreelander.view.base;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.controller.utils.UiUtils;
import com.wwq.genesisfreelander.model.json.WaitingOrderEntity;
import com.wwq.genesisfreelander.mvp.contract.home.BaseOrderContract;
import com.wwq.genesisfreelander.mvp.presenter.home.BaseOrderPresenter;
import com.wwq.genesisfreelander.view.adapter.list.BGAWaitingOrderAdapter;

import butterknife.BindView;
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * Created by wwq on 2017/3/16.
 */

public abstract class BaseOrderFragment extends BaseMvpFragment<BaseOrderPresenter> implements BGARefreshLayout.BGARefreshLayoutDelegate, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, BaseOrderContract.View {
    @BindView(R.id.lst_fragment_listview)
    ListView listView;
    @BindView(R.id.rl_listview_refresh)
    BGARefreshLayout mRefreshLayout;

    private BGAWaitingOrderAdapter adapter;

//    @Override
//    public void onSucceed(WaitingOrderEntity entity) {
//        if(getPageNumber()>1){
//            adapter.addMoreData(entity.getData());
//            mRefreshLayout.endLoadingMore();
//        }else{
//            adapter.setData(entity.getData());
//            mRefreshLayout.endRefreshing();
//        }
//        if (adapter.getData().size() == 0) {
//            mRefreshLayout.setBackgroundResource(R.mipmap.ic_empty_page);
//        } else {
//            mRefreshLayout.setBackgroundColor(Color.WHITE);
//        }
//    }

    @Override
    public BaseOrderPresenter onCreatePresenter() {
        return new BaseOrderPresenter(this);
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_listview;
    }

    @Override
    protected void initView() {
        super.initView();
        BGAMeiTuanRefreshViewHolder meiTuanRefreshViewHolder = new BGAMeiTuanRefreshViewHolder(BaseApplication.getApplication(), true);
        meiTuanRefreshViewHolder.setPullDownImageResource(R.drawable.loading_anim);
        meiTuanRefreshViewHolder.setChangeToReleaseRefreshAnimResId(R.drawable.loading_anim);
        meiTuanRefreshViewHolder.setRefreshingAnimResId(R.drawable.loading_anim);

        mRefreshLayout.setRefreshViewHolder(meiTuanRefreshViewHolder);
        mRefreshLayout.setDelegate(this);
//        mRefreshLayout.setIsShowLoadingMoreView(false);

        adapter = new BGAWaitingOrderAdapter(mActivity);
        listView.setAdapter(adapter);
    }

//    /* 创建了空的界面 */
//    protected View createEmptyView() {
//        View view = View.inflate(UiUtils.getContext(), R.layout.loadpage_empty, null);
//        return view;
//    }
//
//    /* 创建了错误界面 */
//    protected View createErrorView() {
//        View view = View.inflate(UiUtils.getContext(), R.layout.loadpage_error, null);
//        Button page_bt = (Button) view.findViewById(R.id.page_bt);
//        page_bt.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
////                show();
//            }
//        });
//        return view;
//    }
//
//    /* 创建加载中的界面 */
//    protected View createLoadingView() {
//        View view = View
//                .inflate(UiUtils.getContext(), R.layout.loadpage_loading, null);
//        return view;
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    @Override
    public abstract void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout);

    @Override
    public abstract boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout);

    public abstract int getPageNumber();
}
