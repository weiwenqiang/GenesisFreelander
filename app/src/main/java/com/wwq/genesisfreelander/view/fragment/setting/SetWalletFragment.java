package com.wwq.genesisfreelander.view.fragment.setting;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.setting.SetWalletContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.SetWalletPresenter;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetWalletFragment extends BaseMvpFragment<SetWalletPresenter> implements SetWalletContract.View {

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_wallet;
    }

    @Override
    public SetWalletPresenter onCreatePresenter() {
        return new SetWalletPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }
}
