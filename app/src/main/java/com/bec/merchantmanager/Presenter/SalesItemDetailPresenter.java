package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.Utils.LogUtil;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.SalesDataItemDetailVO;
import com.bec.merchantmanager.bean.params.SalesDataDetailParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/10/23.
 */

public class SalesItemDetailPresenter extends BasePresenter<SalesItemDetailPresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<SalesDataItemDetailVO.RowsBean> mDataVOs = new ArrayList<>();

    public void getSalesItemDataList(final int page, String orderId) {

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        SalesDataDetailParamsVO paramsVO = new SalesDataDetailParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page, orderId);
        Call<SalesDataItemDetailVO> call = mApiService.saleItemDataList(paramsVO);
        call.enqueue(new OnResponseListener<SalesDataItemDetailVO>(getContext(), false) {
            @Override
            public void onSuccess(SalesDataItemDetailVO salesDataItemDetailVO) {
                LogUtil.e(" salesDataItemDetailVO==>>"  + salesDataItemDetailVO.toString());
                if (mvpView != null) {
                    if (salesDataItemDetailVO == null) {
                        return;
                    }

                    if (page == 1) {
                        mDataVOs.clear();
                    }
                    if (salesDataItemDetailVO.getRows() == null) {
                        mvpView.updateSalesItemDataList(mDataVOs);
                        return;
                    }
                    mDataVOs.addAll(salesDataItemDetailVO.getRows());
                    mvpView.updateSalesItemDataList(mDataVOs);

                    currentPage = page;
                    totalPage = (int) Math.ceil(mDataVOs.size() * 1.0 / LIMIT_SIZE);

                }
            }
        });
    }

    public void getNextData(String orderId) {
        if (currentPage > totalPage) {
            mvpView.stopLoadMore();
        }
        getSalesItemDataList(++currentPage, orderId);
    }


    public interface MvpView extends IMvpView {

        void updateSalesItemDataList(ArrayList<SalesDataItemDetailVO.RowsBean> lists);

        void stopLoadMore();
    }
}
