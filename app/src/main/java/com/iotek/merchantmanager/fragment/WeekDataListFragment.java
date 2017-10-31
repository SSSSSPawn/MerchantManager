package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.Presenter.WeekMonthDataPresenter;
import com.iotek.merchantmanager.Utils.TimeUtils;
import com.iotek.merchantmanager.adapter.WeekDataFormAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

import static com.iotek.merchantmanager.Utils.TimeUtils.getCurrentMonday;
import static iotek.com.merchantmanager.R.id.ll_empty;

/**
 * Created by admin on 2017/10/31.
 */

public class WeekDataListFragment extends ListFragment implements WeekMonthDataPresenter.MvpView, OnItemClickListener {


    @Bind(ll_empty)
    LinearLayout mLlEmpty;

    private WeekMonthDataPresenter mPresenter = new WeekMonthDataPresenter();

    private WeekDataFormAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAdapter = new WeekDataFormAdapter();
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
                //本周数据
                mPresenter.getWeekMonthDataLists(1, getCurrentMonday() + " 00:00:00", TimeUtils.getPreviousSunday() + " 23:59:59");
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getNextData(getCurrentMonday() + " 00:00:00",
                        TimeUtils.getPreviousSunday() + " 23:59:59");
                mSuperRecyclerView.loadMoreComplete();
            }
        }, 1000);
    }

    @Override
    public void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists) {
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

    }
}
