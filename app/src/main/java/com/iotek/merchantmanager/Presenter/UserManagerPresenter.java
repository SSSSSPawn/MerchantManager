package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.CodeMessageVO;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.bean.UserParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.HttpExecutor;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.iotek.merchantmanager.constant.CacheKey.CUST_ID;

/**
 * Created by admin on 2017/8/29.
 */

public class UserManagerPresenter extends BasePresenter<UserManagerPresenter.MvpView> {


    private final int LIMIT_SIZE = 10;

    private int currentPage, totalPage;

    private ArrayList<UserManagerDetailVO.RowsBean> mRowsBeen = new ArrayList<>();


    public void getFirstData(final int page) {

        Map<String, String> paramsMap = new HashMap<>();

        long custID = Preference.getLong(CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        paramsMap.put("custId", custID + "");
        paramsMap.put("rootId", rootID + "");
        paramsMap.put("uuid", uuID);
        paramsMap.put("mac", mac);
        paramsMap.put("limit", LIMIT_SIZE + "");
        paramsMap.put("page", page + "");

        String paramsJson = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(HttpExecutor.MEDIA_TYPE, paramsJson);

        Call<UserManagerDetailVO> call = mApiService.queryUser(body);
        call.enqueue(new OnResponseListener<UserManagerDetailVO>(getContext(), false) {
            @Override
            public void onSuccess(UserManagerDetailVO userManagerVO) {

                LogUtil.e("userManagerVO---->>>" + userManagerVO.toString());

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
        if (currentPage < totalPage) {
            getFirstData(++currentPage);
        } else {
            mvpView.stopLoadMore();
        }
    }

    public void userResetPassword(long userId,long roleId) {

        Map<String, String> paramsMap = new HashMap<>();

        long custID = Preference.getLong(CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        paramsMap.put("custId", custID + "");
        paramsMap.put("rootId", rootID + "");
        paramsMap.put("uuid", uuID);
        paramsMap.put("mac", mac);
        paramsMap.put("userId", userId + "");
        paramsMap.put("roleId", roleId + "");

        String paramsJson = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(HttpExecutor.MEDIA_TYPE, paramsJson);

        mApiService.resetPasswds(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CodeMessageVO>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CodeMessageVO codeMessageVO) {
                        LogUtil.e("codeMessageVO---------->>> -->>" + codeMessageVO.toString());

                        if (codeMessageVO == null) {
                            return;
                        }

                        if ("200".equals(codeMessageVO.getCode())) {
                            mvpView.showSuccess(codeMessageVO.getMessage());
                        } else {
                            mvpView.showError(codeMessageVO.getMessage());
                        }
                    }
                });

//        Call<CodeMessageVO> call = mApiService.resetPasswds(userParamsVO);
//        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), false) {
//            @Override
//            public void onSuccess(CodeMessageVO codeMessageVO) {
//
//                LogUtil.e("codeMessageVO---------->>> -->>" + codeMessageVO.toString());
//
//                if (codeMessageVO == null) {
//                    return;
//                }
//
//                if ("200".equals(codeMessageVO.getCode())) {
//                    mvpView.showSuccess(codeMessageVO.getMessage());
//                } else {
//                    mvpView.showError(codeMessageVO.getMessage());
//                }
//
//            }
//        });
    }

    public void userDelete(UserParamsVO queryUserVO) {
        Call<CodeMessageVO> call = mApiService.userDelete(queryUserVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), false) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {

                LogUtil.e("codeMessageVO---------->>>" + codeMessageVO.toString());

                if (codeMessageVO == null) {
                    return;
                }

                if ("200".equals(codeMessageVO.getCode())) {
                    mvpView.showSuccess(codeMessageVO.getMessage());
                } else {
                    mvpView.showError(codeMessageVO.getMessage());
                }
            }
        });
    }


    public interface MvpView extends IMvpView {

        void updateUserList(ArrayList<UserManagerDetailVO.RowsBean> lists);

        void stopLoadMore();

        void showSuccess(String msg);

        void showError(String msg);
    }
}
