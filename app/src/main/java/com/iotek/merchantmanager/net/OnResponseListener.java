package com.iotek.merchantmanager.net;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.bean.CodeMessageVO;
import com.iotek.merchantmanager.view.LoadingDialog;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by w.gs on 2016/1/19.
 */
public abstract class OnResponseListener<T> implements retrofit2.Callback<T> {

    protected Context mContext;

    private LoadingDialog mLoadingDialog;

    private boolean showLoadingDialog;

    public OnResponseListener(Context context, boolean show) {
        mContext = context;
        showLoadingDialog = show;
        if (show && context != null) {
            mLoadingDialog = LoadingDialog.show(context);
        }
    }

    public boolean isShowLoadingDialog() {
        return showLoadingDialog;
    }

    public OnResponseListener(Context context) {
        this(context, true);
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        dismissDialog();
        LogUtil.w("<======>" + response.code());
        if (response.code() == 200) {
            onSuccess(response.body());
        } else {
            try {
                String jsonStr = response.errorBody().string();
                LogUtil.w("<----->" + jsonStr);
                if (!TextUtils.isEmpty(jsonStr)) {
                    CodeMessageVO codeMessage = new Gson().fromJson(jsonStr, CodeMessageVO.class);
                    AppUtils.showToast(codeMessage.getMessage());
                } else {
                    LogUtil.w(response.code() + "------" + jsonStr);
                    AppUtils.showToast("数据为空  ");
                }

            } catch (IOException e) {
                LogUtil.w(response.code() + "");
                AppUtils.showToast("数据格式异常  ");
            }

        }
        mContext = null;
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        dismissDialog();
        LogUtil.e("未知错误-" + call.request().url().toString());
        mContext = null;
    }

    public abstract void onSuccess(T t);

    public void dismissDialog() {
        if (mLoadingDialog != null && mContext != null && mLoadingDialog.isShowing()) {
            if (mContext instanceof Activity) {
                Activity activity = (Activity) mContext;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    if (activity.isDestroyed()) {
                        mLoadingDialog = null;
                    } else {
                        mLoadingDialog.dismiss();
                    }
                } else {
                    mLoadingDialog.dismiss();
                }
            } else {
                mLoadingDialog.dismiss();
            }
        }
    }
}
