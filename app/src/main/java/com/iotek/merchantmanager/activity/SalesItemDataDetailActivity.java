package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iotek.merchantmanager.Presenter.SalesItemDetailPresenter;
import com.iotek.merchantmanager.adapter.SalesDataItemDetailAdapter;
import com.iotek.merchantmanager.base.ListBaseActivity;
import com.iotek.merchantmanager.bean.SalesDataItemDetailVO;
import com.iotek.merchantmanager.constant.Intentkey;

import java.util.ArrayList;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/23.
 */

public class SalesItemDataDetailActivity extends ListBaseActivity implements SalesItemDetailPresenter.MvpView {

    private SalesDataItemDetailAdapter mAdapter;

    private SalesItemDetailPresenter mPresenter = new SalesItemDetailPresenter();

    private String orderId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        mPresenter.attachView(this);
        mAdapter = new SalesDataItemDetailAdapter();
        orderId = getIntent().getStringExtra(Intentkey.ORDER_ID);

        super.onCreate(savedInstanceState);

        mAppBar.setTitle("交易详情");
        mAppBar.setTextColor(getResources().getColor(R.color.white));
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getSalesItemDataList(1, orderId);
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getNextData(orderId);
                mSuperRecyclerView.loadMoreComplete();
            }
        }, 1000);
    }

    @Override
    public void updateSalesItemDataList(ArrayList<SalesDataItemDetailVO.RowsBean> lists) {
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            mLinearLayout.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);
    }

    @Override
    public void stopLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSuperRecyclerView.setNoMore(true);
            }
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
