package com.iotek.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.iotek.merchantmanager.Presenter.VipRankPresenter;
import com.iotek.merchantmanager.activity.AddVipRankActivity;
import com.iotek.merchantmanager.activity.ModifyVipRankInfoActivity;
import com.iotek.merchantmanager.adapter.VipRankAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.QueryMembLevelVO;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

import static iotek.com.merchantmanager.R.id.ll_empty;

/**
 * Created by admin on 2017/11/6.
 */

public class VipRankFragment extends ListFragment implements VipRankPresenter.MvpView {

    @Bind(ll_empty) LinearLayout mLayout;

    @Bind(R.id.fab_add) FloatingActionButton mFabMenuAdd;

    private VipRankAdapter mAdapter;

    private VipRankPresenter mPresenter = new VipRankPresenter();

    private ArrayList<QueryMembLevelVO.RowsBean> mList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mAdapter = new VipRankAdapter();
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(getActivity(),ModifyVipRankInfoActivity.class);
                QueryMembLevelVO.RowsBean bean = mList.get(position);
                int level = bean.getMembLevel();
                String levelName = bean.getLevelName();
                String discount = bean.getDiscount();
                String uid = bean.getUid();
                intent.putExtra("membLevel",level);
                intent.putExtra("levelName",levelName);
                intent.putExtra("discount",discount);
                intent.putExtra("uid",uid);
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
        return R.layout.fragment_vip_rank;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    public void updateVipRankList(ArrayList<QueryMembLevelVO.RowsBean> lists) {
        mList = lists;
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            mLayout.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getVipRankData(1);
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
        mLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.fab_add)
    public void onViewClicked() {
       launch(AddVipRankActivity.class);
    }
}
