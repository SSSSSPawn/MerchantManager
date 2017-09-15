package com.iotek.merchantmanager.Presenter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.SysUtil;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.LoginVO;
import com.iotek.merchantmanager.view.LoadingDialog;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
                            mvpView.loginSuccess(loginVO.getRspmsg());
                            if (200 == loginVO.getRspcod()) {
                                LogUtil.e(loginVO.getObj().toString());
                            }
                        }
                    }
                });
    }

    public void getSysTime() {
        Call<JsonObject> call = mApiService.getSysTime();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    if (mvpView != null) {
                        mvpView.showSysTime(response.body().get("rspmsg") + "");
                    }
                } else {
                    mvpView.showSysTime(SysUtil.getDateTime());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                LogUtil.e("连接失败  " + t.getMessage());
                if (mvpView != null) {
                    mvpView.showSysTime(SysUtil.getDateTime());
                }
            }
        });
    }


    public interface MvpView extends IMvpView {

        void loginSuccess(String msg);

        void showNetError(String msg);

        String showSysTime(String time);
    }
}
