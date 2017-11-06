package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.CodeMessageVO;
import com.iotek.merchantmanager.bean.params.AddVipRankParamsVO;
import com.iotek.merchantmanager.net.OnResponseListener;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/6.
 */

public class AddVipRankPresenter extends BasePresenter<AddVipRankPresenter.MvpView> {


    public void AddVipRank(AddVipRankParamsVO paramsVO){
        Call<CodeMessageVO> call = mApiService.AddVipRank(paramsVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(),true) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {
                if (mvpView != null){
                    mvpView.showMsg(codeMessageVO.getRspmsg());
                }
            }
        });
    }


    public interface MvpView extends IMvpView{
        void showMsg(String msg);
    }
}
