package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.bean.TradeFormParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/9/30.
 */

public class FormsMangerPresenter extends BasePresenter<FormsMangerPresenter.MvpView> {


    private final int LIMIT_SIZE = 20;

    private int currentPage, totalPage;

    private ArrayList<DayTradeFormVO.RowsBean> mRowsBeen = new ArrayList<>();

    public void getDayTradeList(final int page) {
        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        TradeFormParamsVO paramsVO = new TradeFormParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);

        Call<DayTradeFormVO> call = mApiService.getDayTradeForm(paramsVO);
        call.enqueue(new OnResponseListener<DayTradeFormVO>(getContext(), false) {
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
                    mvpView.updateUserList(mRowsBeen);
                    currentPage = page;
                    totalPage = vo.getTotal();
                }


            }
        });
    }

    public void getNextData() {
        if (currentPage < totalPage) {
            getDayTradeList(++currentPage);
        } else {
            mvpView.stopLoadMore();
        }
    }

    public interface MvpView extends IMvpView {

        void updateUserList(ArrayList<DayTradeFormVO.RowsBean> lists);

        void stopLoadMore();
    }

}
