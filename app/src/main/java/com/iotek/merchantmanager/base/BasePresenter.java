package com.iotek.merchantmanager.base;

import android.content.Context;

import com.google.gson.Gson;
import com.iotek.merchantmanager.net.ApiService;
import com.iotek.merchantmanager.net.HttpExecutor;

/**
 * Created by admin on 2017/8/23.
 */

public abstract class BasePresenter<V extends IMvpView> implements  Presenter<V>  {

    protected V mvpView;

    protected ApiService mApiService = HttpExecutor.getInstance().getApiService();

    protected Gson gson = new Gson();

    @Override
    public void attachView(V view) {
        mvpView = view;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    protected Context getContext(){

        if (mvpView != null){
            return mvpView.getContext();
        }

        return null;
    }
}
