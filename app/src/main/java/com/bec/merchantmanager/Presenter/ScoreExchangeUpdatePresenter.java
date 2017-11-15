package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.CodeMessageVO;
import com.bec.merchantmanager.bean.params.ScoreExchangeUpdateParamsVO;
import com.bec.merchantmanager.net.OnResponseListener;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/15.
 */

public class ScoreExchangeUpdatePresenter extends BasePresenter<ScoreExchangeUpdatePresenter.MvpView> {

    public void scoreExchangeEdit(ScoreExchangeUpdateParamsVO paramsVO) {
        Call<CodeMessageVO> call = mApiService.scoreExchangeEdit(paramsVO);
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
