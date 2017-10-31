package com.iotek.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.Presenter.WeekMonthDataPresenter;
import com.iotek.merchantmanager.Utils.TimeUtils;
import com.iotek.merchantmanager.activity.TradeFormDetailActivity;
import com.iotek.merchantmanager.adapter.WeekDataFormAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

import static com.iotek.merchantmanager.Utils.TimeUtils.getCurrentMonday;
import static iotek.com.merchantmanager.R.id.ll_empty;

/**
 * Created by admin on 2017/10/31.
 */

public class MonthDataListFragment extends ListFragment implements WeekMonthDataPresenter.MvpView, OnItemClickListener {

    @Bind(ll_empty) LinearLayout mLlEmpty;

    private WeekMonthDataPresenter mPresenter = new WeekMonthDataPresenter();

    private WeekDataFormAdapter mAdapter;

    private ArrayList<DayTradeFormVO.RowsBean> mLists = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAdapter = new WeekDataFormAdapter();

        mAdapter.setOnItemClickListener(this);

    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_week_month_data;
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
                //本月数据
                mPresenter.getWeekMonthDataLists(1, TimeUtils.getMinMonthDate(getCurrentMonday()) + " 00:00:00",
                        TimeUtils.getMaxMonthDate(getCurrentMonday()) + " 23:59:59");
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getNextData(TimeUtils.getMinMonthDate(getCurrentMonday()) + " 00:00:00",
                        TimeUtils.getMaxMonthDate(getCurrentMonday()) + " 23:59:59");
                mSuperRecyclerView.loadMoreComplete();
            }
        }, 1000);
    }


    @Override
    public void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists) {
        mLists = lists;
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            mLlEmpty.setVisibility(View.VISIBLE);
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
    public void emptyData() {
        mSuperRecyclerView.setVisibility(View.GONE);
        mLlEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(getActivity(), TradeFormDetailActivity.class);
        intent.putExtra(Intentkey.SALES_DATA_DATE, mLists.get(position).getReportDay());
        launch(intent);
    }
}
