package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.LoginVO;
import com.iotek.merchantmanager.net.exception.AppException;
import com.iotek.merchantmanager.view.LoadingDialog;

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
                            mvpView.startHomeActivity();
                        }
                    }
                });
    }


    public interface MvpView extends IMvpView {

        void loginSuccess(String msg);

        void showPasswordError(String msg);

        void showParamsError(String msg);

        void onError(String msg);

        void startHomeActivity();

    }
}
