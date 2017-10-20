package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.adapter.TradeFormDetailAdapter;
import com.iotek.merchantmanager.base.ListBaseActivity;
import com.iotek.merchantmanager.listener.OnItemClickListener;
import com.iotek.merchantmanager.view.AppBar;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/17.
 */

public class TradeFormDetailActivity extends ListBaseActivity implements OnItemClickListener{

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.ll_empty) LinearLayout mLlEmpty;

    private TradeFormDetailAdapter mAdapter = new TradeFormDetailAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppBar.setTitle("交易详情");
        mAppBar.setTextColor(getResources().getColor(R.color.white));
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void OnItemClick(int position) {

    }
}
