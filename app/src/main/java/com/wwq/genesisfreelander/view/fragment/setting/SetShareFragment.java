package com.wwq.genesisfreelander.view.fragment.setting;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.setting.SetShareContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.SetSharePresenter;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetShareFragment extends BaseMvpFragment<SetSharePresenter> implements SetShareContract.View {

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_share;
    }

    @Override
    public SetSharePresenter onCreatePresenter() {
        return new SetSharePresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }
}
