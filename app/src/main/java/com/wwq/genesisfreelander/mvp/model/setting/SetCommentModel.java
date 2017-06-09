package com.wwq.genesisfreelander.mvp.model.setting;

import com.wwq.genesisfreelander.model.json.FindTalkEntity;
import com.wwq.genesisfreelander.mvp.api.ApiEngine;
import com.wwq.genesisfreelander.mvp.api.RxSchedulers;
import com.wwq.genesisfreelander.mvp.contract.setting.SetCommentContract;

import rx.Observable;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetCommentModel implements SetCommentContract.Model {

    @Override
    public Observable<FindTalkEntity> getFindTalk(String token, int type, int start) {
        return ApiEngine.getInstance().getApiService()
                .OrderNotEvaluated(token, type, start)
                .compose(RxSchedulers.<FindTalkEntity>switchThread());
    }
}