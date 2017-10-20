package com.iotek.merchantmanager.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/20.
 */

public abstract class ListBaseActivity extends BaseActivity implements XRecyclerView.LoadingListener {

    protected XRecyclerView mSuperRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSuperRecyclerView = (XRecyclerView) findViewById(R.id.super_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSuperRecyclerView.setLayoutManager(layoutManager);

        mSuperRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mSuperRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.LineSpinFadeLoader);
        mSuperRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);

        mSuperRecyclerView.setLoadingListener(this);
        mSuperRecyclerView.setAdapter(getAdapter());
        mSuperRecyclerView.refresh();

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_list_base;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    protected abstract RecyclerView.Adapter getAdapter();
}
