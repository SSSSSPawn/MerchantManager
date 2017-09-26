package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.iotek.merchantmanager.base.BaseActivity;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/26.
 */

public class AddUserActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
