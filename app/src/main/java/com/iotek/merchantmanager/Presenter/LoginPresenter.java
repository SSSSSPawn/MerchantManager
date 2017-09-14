package com.iotek.merchantmanager.Presenter;

import com.google.gson.JsonObject;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.SysUtil;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.LoginVO;
import com.iotek.merchantmanager.net.exception.AppException;
import com.iotek.merchantmanager.view.LoadingDialog;

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

        mApiService.login(onsiteTime, mac, userName, userPassword, appverSion)
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
                            if (e instanceof AppException) {
                                if ("205".equals(((AppException) e).getCode())) {
                                    mvpView.showPasswordError(e.getMessage());
                                } else if ("400".equals(((AppException) e).getCode())) {
                                    mvpView.showParamsError(e.getMessage());
                                } else {
                                    mvpView.onError("系统异常 " + e.getMessage());
                                }
                            }
                        } else {
                            mvpView.onError("系统异常 " + e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(LoginVO loginVO) {
                        if (mvpView != null) {
                            mvpView.loginSuccess(loginVO.getRspmsg());
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
                    } else {
                        mvpView.showSysTime(SysUtil.getDateTime());
                    }
                } else {
                    mvpView.showSysTime(SysUtil.getDateTime());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                LogUtil.e("连接服务器失败" + t.getMessage());
                if (mvpView != null) {
                    mvpView.showSysTime(SysUtil.getDateTime());
                }
            }
        });
    }


    public interface MvpView extends IMvpView {

        void loginSuccess(String msg);

        void showPasswordError(String msg);

        void showParamsError(String msg);

        void onError(String msg);

        String showSysTime(String time);
    }
}
