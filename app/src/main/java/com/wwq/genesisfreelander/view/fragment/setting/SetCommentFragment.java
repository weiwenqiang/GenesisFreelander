package com.wwq.genesisfreelander.view.fragment.setting;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.setting.SetCommentContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.SetCommentPresenter;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetCommentFragment extends BaseMvpFragment<SetCommentPresenter> implements SetCommentContract.View {

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_comment;
    }

    @Override
    public SetCommentPresenter onCreatePresenter() {
        return new SetCommentPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }
}
