package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.CodeMessageVO;
import com.bec.merchantmanager.bean.params.MembMoneyResetParamsVO;
import com.bec.merchantmanager.net.OnResponseListener;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/10.
 */

public class VipDatumDetailPresenter extends BasePresenter<VipDatumDetailPresenter.MvpView> {


    public void membMoneyResetData(MembMoneyResetParamsVO paramsVO) {
        Call<CodeMessageVO> call = mApiService.membMoneyReset(paramsVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), true) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {
                if (mvpView != null) {
                    mvpView.showMsg(codeMessageVO);
                }
            }
        });
    }

    public interface MvpView extends IMvpView {
        void showMsg(CodeMessageVO msg);
    }

}
