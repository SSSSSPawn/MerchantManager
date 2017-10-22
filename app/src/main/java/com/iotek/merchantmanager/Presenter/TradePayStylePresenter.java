package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.TradeFormPayDetailVO;
import com.iotek.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.iotek.merchantmanager.net.OnResponseListener;

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
