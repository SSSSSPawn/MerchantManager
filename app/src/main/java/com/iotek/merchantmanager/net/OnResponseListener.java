package com.iotek.merchantmanager.net;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import com.iotek.merchantmanager.view.LoadingDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/9/14.
 */

public class OnResponseListener<T> implements Callback<T> {

    private Context mContext;

    private LoadingDialog mLoadingDialog;

    private boolean isShowDialog;


    public OnResponseListener(Context context) {
        this(context,true);
    }

    public OnResponseListener(Context context, boolean isShow) {
        mContext = context;
        isShowDialog = isShow;
        mLoadingDialog = LoadingDialog.show(context);
        if (isShowDialog && context != null) {
            mLoadingDialog = new LoadingDialog(context);
        }
    }

    public boolean isShowDialog() {
        return isShowDialog;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public void dismissDialog() {
        if (mLoadingDialog != null && mContext != null && mLoadingDialog.isShowing()){
            if (mContext instanceof Activity){
                Activity activity = (Activity) mContext;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
                    if (activity.isDestroyed()){
                        mLoadingDialog = null;
                    }else {
                        mLoadingDialog.dismiss();
                    }
                }else {
                    mLoadingDialog.dismiss();
                }
            }else {
                mLoadingDialog.dismiss();
            }
        }
    }
}
