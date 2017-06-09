package com.wwq.genesisfreelander.view.fragment.setting;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.setting.SetDealDetailsContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.SetDealDetailsPresenter;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

/**
 * Created by wwq on 2017/6/9.
 */

public class SetDealDetailsFragment extends BaseMvpFragment<SetDealDetailsPresenter> implements SetDealDetailsContract.View {

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_deal_details;
    }

    @Override
    public SetDealDetailsPresenter onCreatePresenter() {
        return new SetDealDetailsPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }
}
