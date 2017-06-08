package com.wwq.genesisfreelander.view.fragment.setting;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.setting.SetSettingContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.SetSettingPresenter;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetSettingFragment extends BaseMvpFragment<SetSettingPresenter> implements SetSettingContract.View {

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_setting;
    }

    @Override
    public SetSettingPresenter onCreatePresenter() {
        return new SetSettingPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }
}
