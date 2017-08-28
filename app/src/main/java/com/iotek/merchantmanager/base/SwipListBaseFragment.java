package com.iotek.merchantmanager.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/28.
 */

public abstract class SwipListBaseFragment extends BaseFragment implements SwipeItemClickListener {

    @Bind(R.id.recycler_view)
    SwipeMenuRecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, LayoutInflater.from(getContext()).inflate(getLayout(), container, false));
        return LayoutInflater.from(getContext()).inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(getLayoutManager());

        mRecyclerView.setAdapter(getAdapter());

        mRecyclerView.setSwipeItemClickListener(this);

    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    protected int getLayout() {
        return R.layout.fragment_list;
    }

    @Override
    public void onItemClick(View itemView, int position) {

    }

    protected abstract RecyclerView.Adapter getAdapter();

}
