package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.bean.params.TradeFormParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;
import com.iotek.merchantmanager.view.LoadingDialog;

import java.util.ArrayList;

import retrofit2.Call;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/10/25.
 */

public class HistoryDataPresenter extends BasePresenter<HistoryDataPresenter.MvpView> {

    private final int LIMIT_SIZE = Integer.MAX_VALUE;

    private int currentPage, totalPage;

    private ArrayList<DayTradeFormVO.RowsBean> mRowsBeen = new ArrayList<>();

    public void getDayTradeLists(final int page, String sTime, String eTime) {
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

    public void getDayTradeList(final int page,String sTime,String eTime,boolean showDialog) {

        final LoadingDialog dialog = new LoadingDialog(getContext());

        if (showDialog) {
            dialog.show();
        }

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        TradeFormParamsVO paramsVO = new TradeFormParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page,sTime,eTime);

         mApiService.getDayTradeForms(paramsVO)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Subscriber<DayTradeFormVO>() {
                     @Override
                     public void onCompleted() {
                         dialog.dismiss();
                     }

                     @Override
                     public void onError(Throwable e) {
                         LogUtil.e("onError onError onError ---》" + e.getMessage());
                     }

                     @Override
                     public void onNext(DayTradeFormVO vo) {
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


    public interface MvpView extends IMvpView {

        void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists);

    }
}
