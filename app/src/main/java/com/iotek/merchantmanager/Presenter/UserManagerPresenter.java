package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.CodeMessageVO;
import com.iotek.merchantmanager.bean.QueryUserVO;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.HttpExecutor;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by admin on 2017/8/29.
 */

public class UserManagerPresenter extends BasePresenter<UserManagerPresenter.MvpView> {


    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<UserManagerDetailVO.RowsBean> mRowsBeen = new ArrayList<>();

    private HashMap<String, String> initParams() {

        HashMap<String, String> paramsMap = new HashMap<>();

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        paramsMap.put("custId", custID + "");
        paramsMap.put("rootId", rootID + "");
        paramsMap.put("uuid", uuID);
        paramsMap.put("mac", mac);

        return paramsMap;

    }

    public void getFirstData(final int page) {

        HashMap<String, String> paramsData = initParams();

        paramsData.put("limit", LIMIT_SIZE + "");
        paramsData.put("page", page + "");
        String paramsJson = gson.toJson(paramsData);

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

    public void getNextData() {
        if (currentPage <= totalPage) {
            getFirstData(++currentPage);
        } else {
            mvpView.stopLoadMore();
        }
    }

    public void userResetPasswd(QueryUserVO queryUserVO) {

        Call<CodeMessageVO> call = mApiService.resetPasswds(queryUserVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(),false) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {

            }
        });

//        HashMap<String, String> paramsData = initParams();
//
//        paramsData.put("userID",userID + "");
//
//        RequestBody body = RequestBody.create(HttpExecutor.MEDIA_TYPE, "");
//
//        Call<CodeMessageVO> call = mApiService.resetPasswd(body);
//
//        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), false) {
//            @Override
//            public void onSuccess(CodeMessageVO codeMessageVO) {
//
//            }
//        });
    }


    public interface MvpView extends IMvpView {

        void updateUserList(ArrayList<UserManagerDetailVO.RowsBean> lists);

        void stopLoadMore();
    }
}
