package com.iotek.merchantmanager.app;

import android.app.Application;

import com.facebook.stetho.Stetho;

import iotek.com.merchantmanager.BuildConfig;

/**
 * Created by admin on 2017/8/23.
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (!"release".equals(BuildConfig.BUILD_TYPE)) {
            Stetho.initializeWithDefaults(this);
        }
    }

    public static MyApplication getInstance(){
        return instance;
    }
}
