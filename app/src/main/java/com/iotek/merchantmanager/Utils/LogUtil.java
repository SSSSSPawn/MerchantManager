package com.iotek.merchantmanager.Utils;

import android.util.Log;

import iotek.com.merchantmanager.BuildConfig;

/**
 * Created by admin on 2017/8/25.
 */

public class LogUtil {

    public static final boolean isDebug = BuildConfig.DEBUG;
    public static final String TAG = "APP_MerchantManager";

    public static void d(String message) {
        if (isDebug) {
            Log.d(TAG, message);
        }
    }

    public static void e(String message) {
        if (isDebug) {
            Log.e(TAG, message);
        }
    }

    public static void i(String message) {
        if (isDebug) {
            Log.i(TAG, message);
        }
    }

    public static void w(String message) {
        if (isDebug) {
            Log.w(TAG, message);
        }
    }
}
