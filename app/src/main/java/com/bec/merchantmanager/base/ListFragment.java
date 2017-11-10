package com.bec.merchantmanager.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public abstract class ListFragment extends BECFragment implements XRecyclerView.LoadingListener {

//    @Bind(R.id.super_recycler_view)
//    protected XRecyclerView mSuperRecyclerView;

    protected XRecyclerView mSuperRecyclerView;

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(getLayoutId(), null);
        mSuperRecyclerView = (XRecyclerView) rootView.findViewById(R.id.super_recycler_view);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);

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
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    protected abstract RecyclerView.Adapter getAdapter();

    protected abstract int getLayoutId();

}
