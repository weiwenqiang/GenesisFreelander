package com.wwq.genesisfreelander.view.fragment.setting.child;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.mvp.contract.setting.child.FeedbackIdeaContract;
import com.wwq.genesisfreelander.mvp.presenter.setting.child.FeedbackIdeaPresenter;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

/**
 * Created by wwq on 2017/6/9.
 */

public class FeedbackIdeaFragment extends BaseMvpFragment<FeedbackIdeaPresenter> implements FeedbackIdeaContract.View {

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_set_child_fkyj;
    }

    @Override
    public FeedbackIdeaPresenter onCreatePresenter() {
        return new FeedbackIdeaPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
    }
}
