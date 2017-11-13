package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.VipLogVO;
import com.bec.merchantmanager.bean.params.VipLogParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/13.
 */

public class VipLogPresenter extends BasePresenter<VipLogPresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<VipLogVO.RowsBean> mRowsBeen = new ArrayList<>();

    private boolean tag = false;


    public void getVipLogData(final int page) {
        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        VipLogParamsVO paramsVO = new VipLogParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);
        Call<VipLogVO> call = mApiService.membDetailQuery(paramsVO);
        call.enqueue(new OnResponseListener<VipLogVO>(getContext(), true) {
            @Override
            public void onSuccess(VipLogVO vo) {
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
                    mvpView.updateVipLogList(mRowsBeen);
                    currentPage = page;
                    totalPage = (int) Math.ceil(mRowsBeen.size() * 1.0 / LIMIT_SIZE);
                }
            }
        });
    }

    public void getNextData() {

        tag = true;

        if (currentPage > totalPage) {
            mvpView.stopLoadMore();
        }
        getVipLogData(++currentPage);
    }


    public interface MvpView extends IMvpView {

        void updateVipLogList(ArrayList<VipLogVO.RowsBean> lists);

        void stopLoadMore();

        void emptyData();
    }

}
