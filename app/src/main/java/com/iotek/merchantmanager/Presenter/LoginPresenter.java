package com.iotek.merchantmanager.Presenter;

import com.google.gson.Gson;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.Utils.SysUtil;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.LoginVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;
import com.iotek.merchantmanager.view.LoadingDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/8/23.
 */

public class LoginPresenter extends BasePresenter<LoginPresenter.MvpView> {

    public void login(String onsiteTime, String mac, String userName, String userPassword, String appverSion, boolean showDialog) {

        final LoadingDialog dialog = new LoadingDialog(getContext());

        if (showDialog) {
            dialog.show();
        }
        Gson gson = new Gson();
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("onsitetime", onsiteTime);
        paramsMap.put("mac", mac);
        paramsMap.put("userName", userName);
        paramsMap.put("userPasswd", userPassword);
        paramsMap.put("appversion", appverSion);
        String paramsJson = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), paramsJson);

        mApiService.login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginVO>() {
                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                        if (mvpView != null) {
                            mvpView.showNetError("网络错误...");
                        }
                    }

                    @Override
                    public void onNext(LoginVO loginVO) {
                        if (mvpView != null) {
                            if (200 == loginVO.getRspcod()) {

                                mvpView.loginSuccess(loginVO.getRspmsg());

                                int custId = loginVO.getObj().getCustId();
                                int rootId = loginVO.getObj().getRootId();
                                String uuid = loginVO.getObj().getUuid();

                                LogUtil.e(custId + "---" + rootId + "--" + uuid);

                                Preference.putInt(CacheKey.CUST_ID, custId);
                                Preference.putInt(CacheKey.ROOT_ID, rootId);
                                Preference.putString(CacheKey.UU_ID, uuid);

                                mvpView.startHomeActivity();

                            } else {
                                mvpView.loginError(loginVO.getRspmsg());
                            }
                        }
                    }
                });
    }

//    public void login(String onsiteTime, String mac, String userName, String userPassword, String appverSion, boolean showDialog) {
//
//        final LoadingDialog dialog = new LoadingDialog(getContext());
//
//        if (showDialog) {
//            dialog.show();
//        }
//        Gson gson = new Gson();
//        Map<String, String> paramsMap = new HashMap<>();
//        paramsMap.put("onsitetime", onsiteTime);
//        paramsMap.put("mac", mac);
//        paramsMap.put("userName", userName);
//        paramsMap.put("userPasswd", userPassword);
//        paramsMap.put("appversion", appverSion);
//        String paramsJson = gson.toJson(paramsMap);
//
//        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), paramsJson);
//        Call<LoginVO> call = mApiService.login(body);
//        call.enqueue(new OnResponseListener<LoginVO>(getContext(), false) {
//            @Override
//            public void onSuccess(LoginVO loginVO) {
//                LoginVO.ObjBean obj = loginVO.getObj();
//                LogUtil.e(obj + "");
//            }
//        });
//
//    }

    public void getSysTime() {
        Call<JSONObject> call = mApiService.getSysTime();
        call.enqueue(new OnResponseListener<JSONObject>(getContext(), false) {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                if (mvpView != null) {
                    try {
                        mvpView.showSysTime(jsonObject.getString("rspmsg"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        mvpView.showSysTime(SysUtil.getDateTime());
                    }
                }
            }
        });
    }


    public interface MvpView extends IMvpView {

        void loginSuccess(String msg);

        void showNetError(String msg);

        void loginError(String msg);

        void startHomeActivity();

        String showSysTime(String time);
    }
}
