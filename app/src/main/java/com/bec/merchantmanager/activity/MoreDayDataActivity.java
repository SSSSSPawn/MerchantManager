package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.MoreDayDataPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.adapter.DayTradeFormAdapter;
import com.bec.merchantmanager.base.ListBaseActivity;
import com.bec.merchantmanager.bean.DayTradeFormVO;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by admin on 2017/11/21.
 */

public class MoreDayDataActivity extends ListBaseActivity implements MoreDayDataPresenter.MvpView {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.ib_chart) ImageButton ib_chart;

    private DayTradeFormAdapter mAdapter;

    private MoreDayDataPresenter mPresenter = new MoreDayDataPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter.attachView(this);
        mAdapter = new DayTradeFormAdapter();

        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_more_day_data;
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
                mPresenter.getDayTradeList(1);
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
    public void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists) {
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            ll_empty.setVisibility(View.VISIBLE);
            return;
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

    @OnClick(R.id.iv_no)
    public void onViewClicked() {

    }
}
