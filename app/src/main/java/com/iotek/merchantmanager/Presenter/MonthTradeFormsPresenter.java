package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.MonthTradeFormVO;
import com.iotek.merchantmanager.bean.params.TradeFormParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/10/16.
 */

public class MonthTradeFormsPresenter extends BasePresenter<MonthTradeFormsPresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<MonthTradeFormVO.RowsBean> mRowsBeen = new ArrayList<>();

    public void getMonthTradeList(final int page) {
        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        TradeFormParamsVO paramsVO = new TradeFormParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);

        Call<MonthTradeFormVO> call = mApiService.getMonthTradeForm(paramsVO);
        call.enqueue(new OnResponseListener<MonthTradeFormVO>(getContext(), false) {
            @Override
            public void onSuccess(MonthTradeFormVO monthTradeFormVO) {
                if (mvpView != null) {
                    if (monthTradeFormVO == null || monthTradeFormVO.getRows() == null) {
                        return;
                    }

                    if (page == 1) {
                        mRowsBeen.clear();
                    }
                    mRowsBeen.addAll(monthTradeFormVO.getRows());
                    mvpView.updateTradeFromList(mRowsBeen);
                    currentPage = page;
                    totalPage = (int) Math.ceil(mRowsBeen.size() * 1.0 / LIMIT_SIZE);
                }
            }
        });
    }

    public void getNextData() {
        LogUtil.e("currentPage currentPage ==>>" + currentPage + "\ntotalPage totalPage ==>> " + totalPage);
        //TODO：存在刷新两次的问题，后台未返回总页数或总条目
        if (currentPage > totalPage) {
            mvpView.stopLoadMore();
        }
        getMonthTradeList(++currentPage);
    }

    public interface MvpView extends IMvpView {

        void updateTradeFromList(ArrayList<MonthTradeFormVO.RowsBean> lists);

        void stopLoadMore();
    }

}
