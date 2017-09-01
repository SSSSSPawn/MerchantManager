package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.Presenter.UserManagerPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.BaseFragment;
import com.iotek.merchantmanager.bean.UserManagerVO;
import com.iotek.merchantmanager.listener.OnItemClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends BaseFragment implements OnItemClickListener {

    public static final String TAG = "用户";

    private UserManagerPresenter mPresenter = new UserManagerPresenter();

    private XRecyclerView mSuperRecyclerView;

    private int times = 0;

    private ArrayList<UserManagerVO> mUserManagerVOs;

    private UserManagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mSuperRecyclerView = (XRecyclerView) view.findViewById(R.id.super_recycler_view);
        mAdapter = new UserManagerAdapter();
        mUserManagerVOs = new ArrayList<>();

        mSuperRecyclerView.setLoadingListener(this);
        mAdapter.setOnItemClickListener(this);

    }

    @Override
    public void onRefresh() {
        times = 0;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mUserManagerVOs.clear();
                for (int i = 0; i < 15; i++) {
                    mUserManagerVOs.add(new UserManagerVO("0x001" + i, "菜10" + i, "管理员" + i + "号1"));
                }
                mAdapter.setDataList(mUserManagerVOs);
                mSuperRecyclerView.refreshComplete();
            }

        }, 1000);
    }

    @Override
    public void onLoadMore() {
        if (times < 2) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    for (int i = 16; i < 25; i++) {
                        mUserManagerVOs.add(new UserManagerVO("0x002" + i, "菜10" + i, "管理员" + i + "号2"));
                    }
                    mSuperRecyclerView.loadMoreComplete();
                    mAdapter.notifyDataSetChanged();
                }
            }, 1000);
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    for (int i = 25; i < 40; i++) {
                        mUserManagerVOs.add(new UserManagerVO("0x003" + i, "菜10" + i, "管理员" + i + "号3"));
                    }
                    mSuperRecyclerView.setNoMore(true);
                    mAdapter.notifyDataSetChanged();
                }
            }, 1000);
        }
        times++;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void OnItemClick(int position) {
        AppUtils.showToast("pos = " + position);
    }
}
