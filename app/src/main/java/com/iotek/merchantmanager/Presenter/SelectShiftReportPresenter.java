package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.SelectShiftReportVO;
import com.iotek.merchantmanager.bean.params.SelectShiftReportParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/2.
 */

public class SelectShiftReportPresenter extends BasePresenter<SelectShiftReportPresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<SelectShiftReportVO.RowsBean> mDataVOs = new ArrayList<>();

    private boolean tag = false;

    public void getSelectShiftReportList(final int page) {

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        SelectShiftReportParamsVO paramsVO = new SelectShiftReportParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);

        Call<SelectShiftReportVO> call = mApiService.selectShiftReport(paramsVO);
        call.enqueue(new OnResponseListener<SelectShiftReportVO>(getContext(), true) {
            @Override
            public void onSuccess(SelectShiftReportVO dataVO) {
                if (mvpView != null) {
                    if (dataVO == null || dataVO.getRows() == null) {
                        if (tag) {
                            return;
                        }
                        mvpView.emptyData();
                        return;
                    }

                    if (page == 1) {
                        mDataVOs.clear();
                    }
                    mDataVOs.addAll(dataVO.getRows());
                    mvpView.updateSelectShiftReport(mDataVOs);

                    currentPage = page;
                    totalPage = (int) Math.ceil(mDataVOs.size() * 1.0 / LIMIT_SIZE);
                }
            }
        });
    }

    public void getNextData() {
        tag = true;
        LogUtil.e("currentPage currentPage ==>>" + currentPage + "\ntotalPage totalPage ==>> " + totalPage);
        //TODO：存在刷新两次的问题，后台未返回总页数或总条目
        if (currentPage > totalPage) {
            mvpView.stopLoadMore();
        }
        getSelectShiftReportList(++currentPage);
    }


    public interface MvpView extends IMvpView {

        void updateSelectShiftReport(ArrayList<SelectShiftReportVO.RowsBean> lists);

        void stopLoadMore();

        void emptyData();
    }
}
