package com.iotek.merchantmanager.Presenter;

import android.text.TextUtils;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.CodeMessageVO;
import com.iotek.merchantmanager.bean.LoginParamsVO;
import com.iotek.merchantmanager.bean.LoginVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;
import com.iotek.merchantmanager.view.LoadingDialog;

import retrofit2.Call;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/8/23.
 */

public class LoginPresenter extends BasePresenter<LoginPresenter.MvpView> {


    public void login(LoginParamsVO paramsVO, boolean showDialog) {

        final LoadingDialog dialog = new LoadingDialog(getContext());

        if (showDialog) {
            dialog.show();
        }

        mApiService.login(paramsVO)
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
                            LogUtil.e("error error error ==>" + e.getMessage());
                            mvpView.showNetError("登录失败...");
                        }
                    }

                    @Override
                    public void onNext(LoginVO loginVO) {
                        if (mvpView != null) {
                            if (CODE_SUCCESS == loginVO.getRspcod()) {
                                int custId = loginVO.getObj().getCustId();
                                int rootId = loginVO.getObj().getRootId();
                                String uuid = loginVO.getObj().getUuid();

                                LogUtil.e(custId + "---" + rootId + "---" + uuid);

                                Preference.putLong(CacheKey.CUST_ID, custId);
                                Preference.putLong(CacheKey.ROOT_ID, rootId);
                                Preference.putString(CacheKey.UU_ID, uuid);

                                mvpView.loginSuccess(loginVO.getRspmsg());
                                mvpView.startHomeActivity();

                            } else {
                                mvpView.loginError(loginVO.getRspmsg());
                            }
                        }
                    }
                });
    }

    public void getSysTime() {
        Call<CodeMessageVO> call = mApiService.getSysTime();
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), false) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {
                if (mvpView != null) {
                    String stTime = codeMessageVO.getRspmsg();
                    if (!TextUtils.isEmpty(stTime)) {
                        LogUtil.e("time time time ===>>>" + stTime);
                        mvpView.showSysTime(stTime);
                    } else {
                        mvpView.showSysTime(DateUtils.getSysDateTime());
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
