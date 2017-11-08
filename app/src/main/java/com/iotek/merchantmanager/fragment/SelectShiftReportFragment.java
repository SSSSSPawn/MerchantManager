package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.Presenter.SelectShiftReportPresenter;
import com.iotek.merchantmanager.adapter.SelectShiftReportAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.SelectShiftReportVO;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/11/2.
 */

public class SelectShiftReportFragment extends ListFragment implements SelectShiftReportPresenter.MvpView ,OnItemClickListener{

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    private SelectShiftReportPresenter mPresenter = new SelectShiftReportPresenter();

    private SelectShiftReportAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAdapter = new SelectShiftReportAdapter();

        mAdapter.setOnItemClickListener(this);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sel_shift_report;
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
                mPresenter.getSelectShiftReportList(1);
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
    public void updateSelectShiftReport(ArrayList<SelectShiftReportVO.RowsBean> lists) {
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

    @Override
    public void OnItemClick(int position) {
        //TODO:交接班明细数据
       // launch(SelectShiftReportDetailActivity.class);
    }
}
