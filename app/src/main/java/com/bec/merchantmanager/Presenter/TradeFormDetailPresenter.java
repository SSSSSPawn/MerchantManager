package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.TradeFormPayDetailVO;
import com.bec.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.bec.merchantmanager.net.OnResponseListener;

import retrofit2.Call;

/**
 * Created by admin on 2017/10/17.
 */

public class TradeFormDetailPresenter extends BasePresenter<TradeFormDetailPresenter.MvpView> {

    public void getTradeFormDetailList(TradeFormDetailParamsVO paramsVO){
        Call<TradeFormPayDetailVO> call = mApiService.getDayTradeDetail(paramsVO);
        call.enqueue(new OnResponseListener<TradeFormPayDetailVO>(getContext(),false) {
            @Override
            public void onSuccess(TradeFormPayDetailVO tradeFormDetailVO) {

            }
        });
    }


    public interface MvpView extends IMvpView {

    }

}
