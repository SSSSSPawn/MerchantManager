package com.bec.merchantmanager.net;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.bec.merchantmanager.Utils.AppUtils;
import com.bec.merchantmanager.Utils.LogUtil;
import com.bec.merchantmanager.bean.CodeMessageVO;
import com.bec.merchantmanager.view.LoadingDialog;

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
        LogUtil.w("<======>" + response.code());
        dismissDialog();
        if (response.code() == 200) {
            onSuccess(response.body());
        } else if (response.code() == 404) {
            AppUtils.showToast("接口返回 404 数据格式异常 ");
            return;
        } else {
            try {
                String jsonStr = response.errorBody().string();
                LogUtil.w("<----->" + jsonStr);
                if (!TextUtils.isEmpty(jsonStr)) {
                    CodeMessageVO codeMessage = new Gson().fromJson(jsonStr, CodeMessageVO.class);
                    onFailure(codeMessage.getRspcod(), codeMessage.getRspmsg());
                } else {
                    onFailure(response.code(), "接口返回 数据为空 ");
                }

            } catch (IOException e) {
                onFailure(response.code(), "接口返回 数据格式异常 ");
            }
        }
        mContext = null;
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        dismissDialog();
        LogUtil.e("未知错误-" + call.request().toString());
        mContext = null;
    }

    public abstract void onSuccess(T t);

    public void onFailure(int code, String message) {

        AppUtils.showToast(message);

        mContext = null;

    }

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
