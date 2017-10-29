package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.SalesDataDetailVO;
import com.iotek.merchantmanager.bean.params.SalesDataParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by Administrator on 2017/10/22.
 */

public class SalesDataPresenter extends BasePresenter<SalesDataPresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<SalesDataDetailVO.RowsBean> mDataVOs = new ArrayList<>();

    public void getDaySalesDataList(final int page, int orderType, String sTime, String eTime) {

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        SalesDataParamsVO paramsVO = new SalesDataParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page, orderType, sTime, eTime);
        Call<SalesDataDetailVO> call = mApiService.saleDataList(paramsVO);
        call.enqueue(new OnResponseListener<SalesDataDetailVO>(getContext(), false) {
            @Override
            public void onSuccess(SalesDataDetailVO dataVO) {
                if (mvpView != null) {
                    if (dataVO == null || dataVO.getRows() == null) {
                        return;
                    }

                    if (page == 1) {
                        mDataVOs.clear();
                    }
                    mDataVOs.addAll(dataVO.getRows());
                    mvpView.updateSalesDataList(mDataVOs);

                    currentPage = page;
                    totalPage = (int) Math.ceil(mDataVOs.size() * 1.0 / LIMIT_SIZE);
                }
            }
        });
    }

    public void getNextData(int orderType, String sTime, String eTime) {
        LogUtil.e("currentPage currentPage ==>>" + currentPage + "\ntotalPage totalPage ==>> " + totalPage);
        //TODO：存在刷新两次的问题，后台未返回总页数或总条目
        if (currentPage > totalPage) {
            mvpView.stopLoadMore();
        }
        getDaySalesDataList(++currentPage, orderType, sTime, eTime);
    }


    public interface MvpView extends IMvpView {

        void updateSalesDataList(ArrayList<SalesDataDetailVO.RowsBean> lists);

        void stopLoadMore();
    }
}
