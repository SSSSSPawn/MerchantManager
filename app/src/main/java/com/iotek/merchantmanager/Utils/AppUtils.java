package com.iotek.merchantmanager.Utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.iotek.merchantmanager.app.MyApplication;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class AppUtils {

    public static void showToast(String txt) {
        Toast.makeText(MyApplication.getInstance().getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
    }

    public static void startActivity(Context context, Class<? extends AppCompatActivity> clazz) {
        startActivity(context, clazz, null);
    }

    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Class<? extends AppCompatActivity> clazz, Bundle bundle) {
        Intent intent = new Intent(context, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public static StateListDrawable getSelectListDrawable(int normal, int selected) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_selected}, MyApplication.getInstance().getResources().getDrawable(selected));
        drawable.addState(new int[]{}, MyApplication.getInstance().getResources().getDrawable(normal));
        return drawable;
    }

    public static View getCustomTextTabView(Context context, String name) {
        TextView view = (TextView) LayoutInflater.from(context).inflate(R.layout.view_tab_text, null);
        view.setText(name);
        return view;
    }

    public static View getCustomTextTabView(Context context, String name, int txtColor) {
        TextView view = (TextView) LayoutInflater.from(context).inflate(R.layout.view_tab_text, null);
        view.setText(name);
        view.setTextColor(txtColor);
        return view;
    }

}
