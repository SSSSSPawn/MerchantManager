package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.Utils.LogUtil;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.YYYShiftReportVO;
import com.bec.merchantmanager.bean.params.YYYShiftRefortParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/3.
 */

public class YYYShiftReportPresenter extends BasePresenter<YYYShiftReportPresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<YYYShiftReportVO.RowsBean> mDataVOs = new ArrayList<>();

    private boolean tag = false;

    public void getYYYShiftReportList(final int page) {

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        YYYShiftRefortParamsVO paramsVO = new YYYShiftRefortParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);

        Call<YYYShiftReportVO> call = mApiService.yyyShiftReport(paramsVO);
        call.enqueue(new OnResponseListener<YYYShiftReportVO>(getContext(), true) {
            @Override
            public void onSuccess(YYYShiftReportVO dataVO) {
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
                    mvpView.updateYYYShiftReport(mDataVOs);

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
        if (currentPage >= totalPage) {
            mvpView.stopLoadMore();
        }
        getYYYShiftReportList(currentPage++);
    }


    public interface MvpView extends IMvpView {

        void updateYYYShiftReport(ArrayList<YYYShiftReportVO.RowsBean> lists);

        void stopLoadMore();

        void emptyData();
    }
}
