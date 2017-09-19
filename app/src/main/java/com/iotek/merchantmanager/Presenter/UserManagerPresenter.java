package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.HttpExecutor;
import com.iotek.merchantmanager.net.OnResponseListener;
import com.iotek.merchantmanager.view.LoadingDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by admin on 2017/8/29.
 */

public class UserManagerPresenter extends BasePresenter<UserManagerPresenter.MvpView> {


    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<UserManagerDetailVO.RowsBean> mRowsBeen = new ArrayList<>();

    public void getFirstData(int page) {

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        queryUser(custID, rootID, uuID, mac, page, false);
    }

    public void getNextData() {
        if (currentPage <= totalPage) {
            getFirstData(++currentPage);
        } else {
            mvpView.stopLoadMore();
        }
    }


    public void queryUser(long custId, long rootId, String uuId, String mac, final int page, boolean showDialog) {

        LoadingDialog dialog = new LoadingDialog(getContext());
        if (showDialog) {
            dialog.show();
        }

        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("custId", custId + "");
        paramsMap.put("rootId", rootId + "");
        paramsMap.put("uuid", uuId);
        paramsMap.put("limit", LIMIT_SIZE + "");
        paramsMap.put("page", page + "");
        paramsMap.put("mac", mac);
        String paramsJson = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(HttpExecutor.MEDIA_TYPE, paramsJson);

        Call<UserManagerDetailVO> call = mApiService.queryUser(body);
        call.enqueue(new OnResponseListener<UserManagerDetailVO>(getContext(), false) {
            @Override
            public void onSuccess(UserManagerDetailVO userManagerVO) {

                if (userManagerVO == null || userManagerVO.getRows() == null) {
                    return;
                }

                if (page == 1) {
                    mRowsBeen.clear();
                }

                mRowsBeen.addAll(userManagerVO.getRows());
                mvpView.updateUserList(mRowsBeen);
                currentPage = page;
                totalPage = userManagerVO.getTotal();
            }
        });
    }


    public interface MvpView extends IMvpView {

        void updateUserList(ArrayList<UserManagerDetailVO.RowsBean> lists);

        void stopLoadMore();
    }
}
