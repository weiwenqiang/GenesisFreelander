package com.wwq.genesisfreelander.view.fragment.function;

import android.widget.TextView;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.model.entity.TextPlainEntity;
import com.wwq.genesisfreelander.mvp.contract.function.TextPlainContract;
import com.wwq.genesisfreelander.mvp.presenter.function.TextPlainPresenter;
import com.wwq.genesisfreelander.view.activity.VesselActivity;
import com.wwq.genesisfreelander.view.base.BaseMvpFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by wwq on 2017/6/9.
 */

public class TextPlainFragment extends BaseMvpFragment<TextPlainPresenter> implements TextPlainContract.View {

    @BindView(R.id.txt_text)
    TextView txtText;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_text_plain;
    }

    @Override
    public TextPlainPresenter onCreatePresenter() {
        return new TextPlainPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void setTextResourceId(TextPlainEntity entity) {
        txtText.setText(entity.getStringId());
        ((VesselActivity)mActivity).initToolbar(entity.getTitle());
        EventBus.getDefault().removeAllStickyEvents();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
