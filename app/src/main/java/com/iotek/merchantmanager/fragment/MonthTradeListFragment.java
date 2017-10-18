package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.Presenter.MonthTradeFormsPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.adapter.MonthTradeFormAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.MonthTradeFormVO;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/11.
 */

public class MonthTradeListFragment extends ListFragment implements MonthTradeFormsPresenter.MvpView, OnItemClickListener {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.ll_recyclerView) LinearLayout ll_recyclerView;

    private MonthTradeFormAdapter mAdapter;
    private MonthTradeFormsPresenter mPresenter = new MonthTradeFormsPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);
        mAdapter = new MonthTradeFormAdapter();
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_form_list;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getMonthTradeList(1);
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
    public void updateTradeFromList(ArrayList<MonthTradeFormVO.RowsBean> lists) {
        if (lists.size() == 0) {
            ll_recyclerView.setVisibility(View.GONE);
            ll_empty.setVisibility(View.VISIBLE);
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
    public void OnItemClick(int position) {
        //TODO:跳转到报表详情页
        AppUtils.showToast("position position position -->> " + position);
    }
}
