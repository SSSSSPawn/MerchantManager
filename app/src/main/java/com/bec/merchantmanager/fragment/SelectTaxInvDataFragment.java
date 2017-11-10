package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.SelectTaxInvDataPresenter;
import com.bec.merchantmanager.adapter.SelectTaxInvDataAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.SelectTaxInvDataVO;

import java.util.ArrayList;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/11/4.
 */

public class SelectTaxInvDataFragment extends ListFragment implements SelectTaxInvDataPresenter.MvpView {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    private SelectTaxInvDataAdapter mAdapter;

    private SelectTaxInvDataPresenter mPresenter = new SelectTaxInvDataPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAdapter = new SelectTaxInvDataAdapter();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_select_tax_inv_data;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    public void updateSelectTaxInvData(ArrayList<SelectTaxInvDataVO.RowsBean> lists) {
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            ll_empty.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);
    }

    @Override
    public void onRefresh() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getSelectTaxInvData(1);
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getNextData();
                mSuperRecyclerView.loadMoreComplete();
            }
        }, 1000);
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
    public void emptyData() {
        mSuperRecyclerView.setVisibility(View.GONE);
        ll_empty.setVisibility(View.VISIBLE);
    }
}
