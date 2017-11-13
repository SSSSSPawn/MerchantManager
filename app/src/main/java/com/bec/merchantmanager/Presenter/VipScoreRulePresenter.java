package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.ScoreExchangeQueryVO;
import com.bec.merchantmanager.bean.params.ScoreExchangeParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/13.
 */

public class VipScoreRulePresenter extends BasePresenter<VipScoreRulePresenter.MvpView> {


    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<ScoreExchangeQueryVO.RowsBean> mRowsBeen = new ArrayList<>();

    private boolean tag = false;


    public void getVipScoreRuleData(final int page) {
        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        ScoreExchangeParamsVO paramsVO = new ScoreExchangeParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);
        Call<ScoreExchangeQueryVO> call = mApiService.scoreExchangeQuery(paramsVO);
        call.enqueue(new OnResponseListener<ScoreExchangeQueryVO>(getContext(), true) {
            @Override
            public void onSuccess(ScoreExchangeQueryVO vo) {
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
                    mvpView.updateVipScoreRuleList(mRowsBeen);
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
        getVipScoreRuleData(++currentPage);

    }


    public interface MvpView extends IMvpView {

        void updateVipScoreRuleList(ArrayList<ScoreExchangeQueryVO.RowsBean> lists);

        void stopLoadMore();

        void emptyData();
    }


}
