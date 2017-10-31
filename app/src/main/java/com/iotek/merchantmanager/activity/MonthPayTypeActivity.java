package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mikephil.charting.charts.PieChart;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.view.AppBar;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/31.
 */

public class MonthPayTypeActivity extends BaseActivity {

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.pie_chart) PieChart mPieChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTitle("月支付占比");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_month_pay_type;
    }
}
