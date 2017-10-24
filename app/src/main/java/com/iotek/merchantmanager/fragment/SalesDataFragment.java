package com.iotek.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.Presenter.SalesDataPresenter;
import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.activity.SalesItemDataDetailActivity;
import com.iotek.merchantmanager.adapter.DataDetailAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.SalesDataDetailVO;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.constant.StatusKey;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/21.
 */

public class SalesDataFragment extends ListFragment implements SalesDataPresenter.MvpView, OnItemClickListener {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    private SalesDataPresenter mPresenter = new SalesDataPresenter();

    private DataDetailAdapter mAdapter;

    private String formatDay;

    private ArrayList<SalesDataDetailVO.RowsBean> mList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);
        mAdapter = new DataDetailAdapter();
        mAdapter.setOnItemClickListener(this);

        long date = getActivity().getIntent().getLongExtra(Intentkey.SALES_DATA_DATE, -1);
        formatDay = DateUtils.dateFormatDay(date);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sales_data_list;
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
                mPresenter.getDaySalesDataList(1, StatusKey.SALES_DATA, formatDay + " 00:00:00", formatDay + " 23:59:59");
                //mPresenter.getDaySalesDataList(1, StatusKey.SALES_DATA, "2017-10-11 00:00:00", "2017-10-11 23:59:59");
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getNextData(StatusKey.SALES_DATA, formatDay + " 00:00:00", formatDay + " 23:59:59");
                //mPresenter.getNextData(StatusKey.SALES_DATA, "2017-10-11 00:00:00", "2017-10-11 23:59:59");
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void updateSalesDataList(ArrayList<SalesDataDetailVO.RowsBean> lists) {
        mList = lists;
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
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
        String orderId = mList.get(position).getOrderId();
        LogUtil.e("sales data orderId ==>>" + orderId);
        Intent intent = new Intent(getActivity(), SalesItemDataDetailActivity.class);
        intent.putExtra(Intentkey.ORDER_ID,orderId);
        launch(intent);
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
    }
}
