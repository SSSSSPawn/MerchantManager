package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.MonthTradeDetailVO;
import com.iotek.merchantmanager.bean.MonthTradeFormVO;
import com.iotek.merchantmanager.bean.TradeFormPayDetailVO;
import com.iotek.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/10/31.
 */

public class MonthPayTypePresenter extends BasePresenter<MonthPayTypePresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private ArrayList<MonthTradeDetailVO.RowsBean> mRowsBeen = new ArrayList<>();

    public void getTradeFormDetailList(TradeFormDetailParamsVO paramsVO) {
        Call<TradeFormPayDetailVO> call = mApiService.getMonthTradeDetail(paramsVO);
        call.enqueue(new OnResponseListener<TradeFormPayDetailVO>(getContext(), false) {
            @Override
            public void onSuccess(TradeFormPayDetailVO tradeFormDetailVO) {
                if (mvpView != null) {
                    if (tradeFormDetailVO == null || tradeFormDetailVO.getRows() == null) {
                        return;
                    }
                    mRowsBeen.clear();
                    mRowsBeen.addAll(tradeFormDetailVO.getRows());
                    mvpView.updateMonthTradeDetailList(mRowsBeenPay);
                }
            }
        });
    }

    public interface MvpView extends IMvpView {

        void updateMonthTradeDetailList(ArrayList<MonthTradeDetailVO.RowsBean> lists);

        void stopLoadMore();
    }
}
