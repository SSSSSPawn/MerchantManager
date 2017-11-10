package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.YYYShiftReportPresenter;
import com.bec.merchantmanager.adapter.YYYShiftReportAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.YYYShiftReportVO;

import java.util.ArrayList;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/11/3.
 */

public class YYYShiftReportFragment extends ListFragment implements YYYShiftReportPresenter.MvpView {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    private YYYShiftReportAdapter mAdapter;

    private YYYShiftReportPresenter mPresenter = new YYYShiftReportPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAdapter = new YYYShiftReportAdapter();
    }

    @Override

    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yyy_shift_report;
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
                mPresenter.getYYYShiftReportList(1);
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
    public void updateYYYShiftReport(ArrayList<YYYShiftReportVO.RowsBean> lists) {
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
    public void emptyData() {
        mSuperRecyclerView.setVisibility(View.GONE);
        ll_empty.setVisibility(View.VISIBLE);
    }
}
