package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iotek.merchantmanager.Presenter.DayTradeFormsPresenter;
import com.iotek.merchantmanager.base.BECFragment;
import com.iotek.merchantmanager.bean.DayTradeFormVO;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/11.
 */

public class DayTradeListFragment extends BECFragment implements DayTradeFormsPresenter.MvpView {

    @Bind(R.id.ll_empty)
    LinearLayout ll_empty;

    @Bind(R.id.tv_trade_form_date)
    TextView mTvTradeFormDate;

    private DayTradeFormsPresenter mPresenter = new DayTradeFormsPresenter();

    private ArrayList<DayTradeFormVO.RowsBean> listData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_day_trade_data, null);
        return view;
    }


    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    public void updateUserList(ArrayList<DayTradeFormVO.RowsBean> lists) {

    }

    @Override
    public void stopLoadMore() {

    }

}
