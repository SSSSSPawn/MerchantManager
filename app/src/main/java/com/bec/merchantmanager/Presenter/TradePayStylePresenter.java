package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.TradeFormPayDetailVO;
import com.bec.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.bec.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/10/19.
 */

public class TradePayStylePresenter extends BasePresenter<TradePayStylePresenter.MvpView> {

    private ArrayList<TradeFormPayDetailVO.RowsBean> mRowsBeen = new ArrayList<>();

    public void getTradeFormDetailList(TradeFormDetailParamsVO paramsVO){
        Call<TradeFormPayDetailVO> call = mApiService.getDayTradeDetail(paramsVO);
        call.enqueue(new OnResponseListener<TradeFormPayDetailVO>(getContext(),false) {
            @Override
            public void onSuccess(TradeFormPayDetailVO tradeFormDetailVO) {
                if (mvpView != null) {
                    if (tradeFormDetailVO == null || tradeFormDetailVO.getRows() == null) {
                        return;
                    }
                    mRowsBeen.clear();
                    mRowsBeen.addAll(tradeFormDetailVO.getRows());
                    mvpView.showPayStyle(mRowsBeen);
                }
            }
        });
    }


    public interface MvpView extends IMvpView {
        void showPayStyle(ArrayList<TradeFormPayDetailVO.RowsBean> lists);
    }
}
