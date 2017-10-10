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
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void putInt(String key, int value) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void putLong(String key, long value) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static String getString(String key) {
        return sPreferences.getString(key, "");
    }

    public static String getString(String key, String defValue) {
        return sPreferences.getString(key, defValue);
    }

    public static int getInt(String key) {
        return sPreferences.getInt(key, -1);
    }

    public static int getInt(String key, int defValue) {
        return sPreferences.getInt(key, defValue);
    }

    public static long getLong(String key) {
        return sPreferences.getLong(key, -1);
    }

    public static long getLong(String key, long defValue) {
        return sPreferences.getLong(key, defValue);
    }
}
