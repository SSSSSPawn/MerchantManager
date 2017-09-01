package com.iotek.merchantmanager.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.iotek.merchantmanager.Utils.AppUtils;

import butterknife.ButterKnife;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusBarColor));
        }
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


    protected void launch(Class<? extends AppCompatActivity> clazz){
        AppUtils.startActivity(this,clazz);
    }

    protected void launch(Intent intent){
        AppUtils.startActivity(this,intent);
    }

    protected void launch(Class<? extends AppCompatActivity> clazz,Bundle bundle) {
        AppUtils.startActivity(this,clazz,bundle);
    }

}
