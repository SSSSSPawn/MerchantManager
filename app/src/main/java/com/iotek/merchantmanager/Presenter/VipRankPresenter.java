package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.QueryMembLevelVO;
import com.iotek.merchantmanager.bean.params.QueryMembLevelParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/6.
 */

public class VipRankPresenter extends BasePresenter<VipRankPresenter.MvpView> {


    private final int LIMIT_SIZE = 10;


    private int currentPage, totalPage;

    private ArrayList<QueryMembLevelVO.RowsBean> mRowsBeen = new ArrayList<>();

    private boolean tag = false;


    public void getVipRankData(final int page) {
        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        QueryMembLevelParamsVO paramsVO = new QueryMembLevelParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);
        Call<QueryMembLevelVO> call = mApiService.queryMembLevel(paramsVO);
        call.enqueue(new OnResponseListener<QueryMembLevelVO>(getContext(), true) {
            @Override
            public void onSuccess(QueryMembLevelVO vo) {
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
                    mvpView.updateVipRankList(mRowsBeen);
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
        getVipRankData(++currentPage);
    }


    public interface MvpView extends IMvpView {

        void updateVipRankList(ArrayList<QueryMembLevelVO.RowsBean> lists);

        void stopLoadMore();

        void emptyData();
    }
}
