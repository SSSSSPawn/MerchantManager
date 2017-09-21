package com.iotek.merchantmanager.net;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import iotek.com.merchantmanager.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/9/12.
 */

public class HttpExecutor {

    private static HttpExecutor instance = new HttpExecutor();

    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json;charset=UTF-8");

    public static final String API_URL = BuildConfig.API_URL;

    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s

    private ApiService mApiService;

    private OkHttpClient mClient = new OkHttpClient();

    private HttpExecutor() {
        if (BuildConfig.DEBUG) {
            mClient = mClient.newBuilder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(new CustomInterceptor())
                    .build();
        } else {
            mClient = mClient.newBuilder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(new CustomInterceptor())
                    .build();
        }


        mApiService = new Retrofit.Builder().baseUrl(API_URL)
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

    class CustomInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            request = request.newBuilder()
                    .addHeader("Content-type", "application/json;charset=UTF-8")
                    .build();

            Response response = chain.proceed(request);

//            Request request = chain.request();
//            Request.Builder requestBuilder = request.newBuilder();
//            RequestBody formBody = new FormBody.Builder()
//                    .add("custId", CacheKey.CUST_ID)
//                    .add("rootId",CacheKey.ROOT_ID)
//                    .add("uuid",CacheKey.UU_ID)
//                    .add("mac",CacheKey.MAC)
//                    .build();
//            Gson gson = new Gson();
//            String paramsJson = gson.toJson(request.body());
//
//            request = requestBuilder
//                    .post(RequestBody.create(MEDIA_TYPE,paramsJson))
//                    .build();
//
//            Response response = chain.proceed(request);

            return response;
        }
    }

}
