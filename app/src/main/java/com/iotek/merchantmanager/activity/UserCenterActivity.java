package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.view.AppBar;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/17.
 */

public class UserCenterActivity extends BaseActivity {

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.ll_bbc) LinearLayout mLlBbc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTitle("个人中心");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_user_center;
    }


    @OnClick(R.id.ll_bbc)
    public void onViewClicked() {
        launch(BBCBankActivity.class);
    }

}