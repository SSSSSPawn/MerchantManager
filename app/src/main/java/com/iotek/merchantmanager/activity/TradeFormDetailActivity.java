package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.adapter.TradeFormDetailAdapter;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.view.AppBar;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/17.
 */

public class TradeFormDetailActivity extends BaseActivity {

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.super_recycler_view) XRecyclerView mSuperRecyclerView;

    @Bind(R.id.ll_empty) LinearLayout mLlEmpty;

    private TradeFormDetailAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTitle("报表详情");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        mAdapter = new TradeFormDetailAdapter();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_trade_form_detail;
    }
}
