package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.CodeMessageVO;
import com.bec.merchantmanager.bean.params.ScoreExchangeAddParamsVO;
import com.bec.merchantmanager.net.OnResponseListener;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/14.
 */

public class ScoreExchangeAddPresenter extends BasePresenter<ScoreExchangeAddPresenter.MvpView> {


    public void scoreExchangeAdd(ScoreExchangeAddParamsVO paramsVO) {
        Call<CodeMessageVO> call = mApiService.scoreExchangeAdd(paramsVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), true) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {
                if (mvpView != null) {
                    mvpView.showMsg(codeMessageVO.getRspmsg());
                }
            }
        });
    }

    public interface MvpView extends IMvpView {
        void showMsg(String msg);
    }

}
