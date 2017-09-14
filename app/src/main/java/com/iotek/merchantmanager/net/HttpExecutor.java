package com.iotek.merchantmanager.net;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import iotek.com.merchantmanager.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/9/12.
 */

public class HttpExecutor {

    private static HttpExecutor instance = new HttpExecutor();

    public static final String DEV_API_URL = BuildConfig.API_URL;

    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s

    private ApiService mApiService;

    private OkHttpClient mClient = new OkHttpClient();

    private HttpExecutor() {

        if (BuildConfig.DEBUG) {
            mClient = mClient.newBuilder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .addInterceptor(new HttpLoggingInterceptor())
                    //TODO:拦截器
                    .build();
        } else {
            mClient = mClient.newBuilder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    //TODO:拦截器
                    .build();
        }


        mApiService = new Retrofit.Builder().baseUrl(DEV_API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mClient)
                .build()
                .create(ApiService.class);
    }

    public static HttpExecutor getInstance() {
        return instance;
    }

    public ApiService getApiService() {
        return mApiService;
    }

}
