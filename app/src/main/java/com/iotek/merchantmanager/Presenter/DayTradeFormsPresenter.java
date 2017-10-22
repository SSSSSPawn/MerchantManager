package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.bean.TradeFormPayDetailVO;
import com.iotek.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.iotek.merchantmanager.bean.params.TradeFormParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/9/30.
 */

public class DayTradeFormsPresenter extends BasePresenter<DayTradeFormsPresenter.MvpView> {


    private final int LIMIT_SIZE = 1;

    private int currentPage, totalPage;

    private ArrayList<DayTradeFormVO.RowsBean> mRowsBeen = new ArrayList<>();

    private ArrayList<TradeFormPayDetailVO.RowsBean> mRowsBeenPay = new ArrayList<>();

    public void getDayTradeList(final int page) {
        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        TradeFormParamsVO paramsVO = new TradeFormParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);

        Call<DayTradeFormVO> call = mApiService.getDayTradeForm(paramsVO);
        call.enqueue(new OnResponseListener<DayTradeFormVO>(getContext(), true) {
            @Override
            public void onSuccess(DayTradeFormVO vo) {
                if (mvpView != null) {
                    if (vo == null || vo.getRows() == null) {
                        return;
                    }

                    if (page == 1) {
                        mRowsBeen.clear();
                    }
                    mRowsBeen.addAll(vo.getRows());
                    mvpView.updateTradeFromList(mRowsBeen);
                    currentPage = page;
                    totalPage = (int) Math.ceil(mRowsBeen.size() * 1.0 / LIMIT_SIZE);
                }
            }
        });
    }

    public void getTradeFormDetailList(TradeFormDetailParamsVO paramsVO){
        Call<TradeFormPayDetailVO> call = mApiService.getDayTradeDetail(paramsVO);
        call.enqueue(new OnResponseListener<TradeFormPayDetailVO>(getContext(),false) {
            @Override
            public void onSuccess(TradeFormPayDetailVO tradeFormDetailVO) {
                if (mvpView != null) {
                    if (tradeFormDetailVO == null || tradeFormDetailVO.getRows() == null) {
                        return;
                    }
                    mRowsBeenPay.clear();
                    mRowsBeenPay.addAll(tradeFormDetailVO.getRows());
                    mvpView.showPayStyle(mRowsBeenPay);
                }
            }
        });
    }

    public void getNextData() {
        LogUtil.e("currentPage currentPage ==>>" + currentPage + "\ntotalPage totalPage ==>> " + totalPage);
        //TODO：存在刷新两次的问题，后台未返回总页数或总条目
        if (currentPage > totalPage){
            mvpView.stopLoadMore();
        }
        getDayTradeList(++currentPage);
    }

    public interface MvpView extends IMvpView {

        void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists);

        void showPayStyle(ArrayList<TradeFormPayDetailVO.RowsBean> lists);

        void stopLoadMore();
    }

}
