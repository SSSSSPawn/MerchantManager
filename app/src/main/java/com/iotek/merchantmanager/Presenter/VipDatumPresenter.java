package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.VipDatumDataVO;
import com.iotek.merchantmanager.bean.params.QueryAllMembParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by admin on 2017/11/7.
 */

public class VipDatumPresenter extends BasePresenter<VipDatumPresenter.MvpView> {

    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<VipDatumDataVO.ObjBean> mRowsBeen = new ArrayList<>();

    private boolean tag = false;


    public void getVipDatumData(final int page) {

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        QueryAllMembParamsVO paramsVO = new QueryAllMembParamsVO(custID, rootID, uuID, mac, LIMIT_SIZE, page);
        Call<VipDatumDataVO> call = mApiService.queryAllMemb(paramsVO);
        call.enqueue(new OnResponseListener<VipDatumDataVO>(getContext(), true) {
            @Override
            public void onSuccess(VipDatumDataVO vo) {
                if (mvpView != null) {
                    if (vo == null || vo.getObj() == null) {
                        if (tag) {
                            return;
                        }
                        mvpView.emptyData();
                        return;
                    }
                    if (page == 1) {
                        mRowsBeen.clear();
                    }
                    mRowsBeen.addAll(vo.getObj());
                    mvpView.updateVipDatumDataList(mRowsBeen);
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

        getVipDatumData(++currentPage);
    }


    public interface MvpView extends IMvpView {

        void updateVipDatumDataList(ArrayList<VipDatumDataVO.ObjBean> lists);

        void emptyData();

        void stopLoadMore();
    }
}
