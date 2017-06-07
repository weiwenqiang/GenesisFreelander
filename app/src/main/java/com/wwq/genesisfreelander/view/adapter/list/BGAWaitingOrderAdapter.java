package com.wwq.genesisfreelander.view.adapter.list;

import android.content.Context;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.model.json.WaitingOrderEntity;


import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

/**
 * Created by wwq on 2017/6/7.
 */

public class BGAWaitingOrderAdapter extends BGAAdapterViewAdapter<WaitingOrderEntity.DataBean> {
    private Context context;

    public BGAWaitingOrderAdapter(Context context) {
        super(context, R.layout.item_waiting_order_bga);
        this.context = context;
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper helper) {
        super.setItemChildListener(helper);
    }

    @Override
    protected void fillData(final BGAViewHolderHelper helper, final int position, final WaitingOrderEntity.DataBean model) {

    }
}
