package com.iotek.merchantmanager.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.listener.OnLoadMoreListener;
import com.iotek.merchantmanager.view.DividerDecoration;
import com.iotek.merchantmanager.view.SuperRecyclerView;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/28.
 */

public abstract class SwipListBaseFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener ,OnLoadMoreListener{


    @Bind(R.id.super_recycler_view)
    SuperRecyclerView super_recycler_view;

    private boolean isAutoRefresh = true;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(getLayout(),null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        super_recycler_view.setLayoutManager(getLayoutManager());

        if (hasDivider()) {
            super_recycler_view.addItemDecoration(new DividerDecoration(getContext()));
        }

        super_recycler_view.setAdapter(getAdapter());

        super_recycler_view.setOnRefreshListener(this);
        if (canLoadMore()) {
            super_recycler_view.setOnLoadMoreListener(this);
        }
        if (isAutoRefresh) {
            startRefresh();
        }
    }

    protected int getLayout(){
        return R.layout.fragment_list;
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    protected boolean hasDivider() {
        return true;
    }

    public void setAutoRefresh(boolean autoRefresh) {
        isAutoRefresh = autoRefresh;
    }

    protected void startRefresh() {
        super_recycler_view.startRefresh();
    }

    protected boolean canLoadMore() {
        return true;
    }

    protected abstract RecyclerView.Adapter getAdapter();

    @Override
    public void onLoadMore(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {

    }

    @Override
    public void onRefresh() {

    }

    public void onError() {
        stopRefresh();
        stopLoadMore();
    }

    public void stopRefresh() {
        super_recycler_view.setRefreshing(false);
    }

    public void stopLoadMore() {
        super_recycler_view.hideMoreProgress();
    }
}
