package com.bec.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.SalesDataPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.activity.SalesItemDataDetailActivity;
import com.bec.merchantmanager.adapter.DataDetailAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.SalesDataDetailVO;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.constant.StatusKey;
import com.bec.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by admin on 2017/10/21.
 */

public class ReturnGoodsDataFragment extends ListFragment implements SalesDataPresenter.MvpView, OnItemClickListener {

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
    public void OnItemClick(int position) {
        String orderId = mList.get(position).getOriOrderId();
        Intent intent = new Intent(getActivity(), SalesItemDataDetailActivity.class);
        intent.putExtra(Intentkey.ORDER_ID, orderId);
        launch(intent);
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
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getDaySalesDataList(1, StatusKey.RETURN_GOODS_DATA, formatDay + " 00:00:00", formatDay + " 23:59:59");
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

    @Override
    protected void onFragmentFirstVisible() {

    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {

    }
}
