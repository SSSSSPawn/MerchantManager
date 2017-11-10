package com.bec.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.VipDatumPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.activity.AddVipDatumActivity;
import com.bec.merchantmanager.activity.EditVipDatumActivity;
import com.bec.merchantmanager.activity.VipDatumDetailActivity;
import com.bec.merchantmanager.adapter.VipDatumAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.VipDatumDataVO;
import com.bec.merchantmanager.constant.Intentkey;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by admin on 2017/11/6.
 */
public class VipDatumFragment extends ListFragment implements VipDatumPresenter.MvpView {

    @Bind(R.id.ll_empty) LinearLayout mLayout;

    @Bind(R.id.fab_add) FloatingActionButton mFloatingActionButton;

    private VipDatumAdapter mAdapter;

    private VipDatumPresenter mPresenter = new VipDatumPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);
        mAdapter = new VipDatumAdapter();

        mAdapter.setDeleteOnItemClickListener(new VipDatumAdapter.OnDeleteItemClickListener() {
            @Override
            public void onDeleteItemClick(int position) {
                Intent intent = new Intent(getActivity(), EditVipDatumActivity.class);
                intent.putExtra(Intentkey.VIP_DATUM_DETAIL, mAdapter.getDataList().get(position));
                launch(intent);
            }

            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), VipDatumDetailActivity.class);
                intent.putExtra(Intentkey.VIP_DATUM_DETAIL, mAdapter.getDataList().get(position));
                launch(intent);
            }
        });
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vip_datum;
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
                mPresenter.getVipDatumData(1);
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
    public void updateVipDatumDataList(ArrayList<VipDatumDataVO.ObjBean> lists) {
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            mLayout.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);
    }

    @Override
    public void emptyData() {
        mSuperRecyclerView.setVisibility(View.GONE);
        mLayout.setVisibility(View.VISIBLE);
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

    @OnClick(R.id.fab_add)
    public void onViewClicked() {
        launch(AddVipDatumActivity.class);
    }
}
