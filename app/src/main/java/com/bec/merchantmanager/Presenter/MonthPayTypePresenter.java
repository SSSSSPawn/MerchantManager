package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.MonthTradeDetailVO;
import com.bec.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.bec.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/10/31.
 */

public class MonthPayTypePresenter extends BasePresenter<MonthPayTypePresenter.MvpView> {


    private ArrayList<MonthTradeDetailVO.RowsBean> mRowsBeen = new ArrayList<>();

    public void getTradeFormDetailList(TradeFormDetailParamsVO paramsVO) {
        Call<MonthTradeDetailVO> call = mApiService.getMonthTradeDetail(paramsVO);
        call.enqueue(new OnResponseListener<MonthTradeDetailVO>(getContext(), true) {
            @Override
            public void onSuccess(MonthTradeDetailVO monthTradeDetailVO) {
                if (mvpView != null) {
                    if (monthTradeDetailVO == null || monthTradeDetailVO.getRows() == null) {
                        mvpView.emptyData();
                        return;
                    }
                    mRowsBeen.clear();
                    mRowsBeen.addAll(monthTradeDetailVO.getRows());
                    mvpView.updateMonthTradeDetailList(mRowsBeen);
                }
            }
        });
    }

    public interface MvpView extends IMvpView {

        void updateMonthTradeDetailList(ArrayList<MonthTradeDetailVO.RowsBean> lists);

        void emptyData();
    }
}
