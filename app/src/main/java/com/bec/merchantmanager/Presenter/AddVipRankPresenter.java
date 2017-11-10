package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.CodeMessageVO;
import com.bec.merchantmanager.bean.params.AddVipRankParamsVO;
import com.bec.merchantmanager.net.OnResponseListener;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/6.
 */

public class AddVipRankPresenter extends BasePresenter<AddVipRankPresenter.MvpView> {


    public void addVipRank(AddVipRankParamsVO paramsVO){
        Call<CodeMessageVO> call = mApiService.addVipRank(paramsVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(),true) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {
                if (mvpView != null){
                    mvpView.showMsg(codeMessageVO.getRspmsg());
                }
            }
        });
    }


    public interface MvpView extends IMvpView {
        void showMsg(String msg);
    }
}
