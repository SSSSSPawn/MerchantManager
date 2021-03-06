package com.bec.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.MonthTradeFormsPresenter;
import com.bec.merchantmanager.activity.MonthPayTypeActivity;
import com.bec.merchantmanager.adapter.MonthTradeFormAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.MonthTradeFormVO;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/10/11.
 */

public class MonthTradeListFragment extends ListFragment implements MonthTradeFormsPresenter.MvpView, OnItemClickListener {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.ll_recyclerView) LinearLayout ll_recyclerView;

    private MonthTradeFormAdapter mAdapter;
    private MonthTradeFormsPresenter mPresenter = new MonthTradeFormsPresenter();

    private ArrayList<MonthTradeFormVO.RowsBean> mList = new ArrayList<>();

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
        mList = lists;
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
        Intent intent = new Intent(getActivity(),MonthPayTypeActivity.class);
        intent.putExtra(Intentkey.MONTH_DATA,mList.get(position).getReportMonth());
        launch(intent);
    }
}
