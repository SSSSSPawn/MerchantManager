package com.iotek.merchantmanager.Utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.iotek.merchantmanager.app.MyApplication;

/**
 * Created by admin on 2017/9/18.
 */

public class Preference {

    public static SharedPreferences sPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());

    public static void putString(String key, String value) {
        SharedPreferences.Editor edit = sPreferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public static void getString(String key) {
        sPreferences.getString(key, "");
    }

    public static void getString(String key, String defValue) {
        sPreferences.getString(key, defValue);
    }
}
