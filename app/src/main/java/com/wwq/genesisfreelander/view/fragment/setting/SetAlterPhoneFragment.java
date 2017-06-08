package com.wwq.genesisfreelander.view.fragment.setting;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.setting.SetAlterPhoneContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.SetAlterPhonePresenter;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetAlterPhoneFragment extends BaseMvpFragment<SetAlterPhonePresenter> implements SetAlterPhoneContract.View {

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_alter_phone;
    }

    @Override
    public SetAlterPhonePresenter onCreatePresenter() {
        return new SetAlterPhonePresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }
}
