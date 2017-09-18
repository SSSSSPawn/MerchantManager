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

    public static void putInt(String key,int value){
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public static void getString(String key) {
        sPreferences.getString(key, "");
    }

    public static void getString(String key, String defValue) {
        sPreferences.getString(key, defValue);
    }

    public static void getInt(String key){
        sPreferences.getInt(key,-1);
    }

    public static void getInt(String key,int defValue){
        sPreferences.getInt(key,defValue);
    }
}
