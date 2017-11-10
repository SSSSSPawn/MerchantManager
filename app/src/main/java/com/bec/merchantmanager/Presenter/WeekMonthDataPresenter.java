package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.Utils.LogUtil;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.DayTradeFormVO;
import com.bec.merchantmanager.bean.params.TradeFormParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/10/31.
 */

public class WeekMonthDataPresenter extends BasePresenter<WeekMonthDataPresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<DayTradeFormVO.RowsBean> mRowsBeen = new ArrayList<>();

    private boolean tag = false;

    public void getWeekMonthDataLists(final int page, String sTime, String eTime) {
        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        TradeFormParamsVO paramsVO = new TradeFormParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page, sTime, eTime);

        Call<DayTradeFormVO> call = mApiService.getDayTradeForm(paramsVO);
        call.enqueue(new OnResponseListener<DayTradeFormVO>(getContext(), true) {
            @Override
            public void onSuccess(DayTradeFormVO vo) {
                if (mvpView != null) {
                    if (vo == null || vo.getRows() == null) {
                        if (tag) {
                            return;
                        }
                        mvpView.emptyData();
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


    public void getNextData(String sTime, String eTime) {

        tag = true;

        LogUtil.e("currentPage currentPage ==>>" + currentPage + "\ntotalPage totalPage ==>> " + totalPage);
        //TODO：存在刷新两次的问题，后台未返回总页数或总条目
        if (currentPage > totalPage) {
            mvpView.stopLoadMore();
        }
        getWeekMonthDataLists(++currentPage, sTime, eTime);
    }

    public interface MvpView extends IMvpView {

        void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists);

        void stopLoadMore();

        void emptyData();
    }
}
