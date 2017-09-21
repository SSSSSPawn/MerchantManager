package com.iotek.merchantmanager.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/21.
 */

public abstract class CustomRvSwipeAdapter<T> extends RecyclerSwipeAdapter<RecyclerViewHolder> {

    protected ArrayList<T> mList;

    private OnItemClickListener mOnItemClickListener;

    public void setDataList(ArrayList<T> list) {
        mList = list;
        notifyDataSetChanged();
    }

    public ArrayList<T> getDataList() {
        return mList == null ? new ArrayList<T>() : mList;
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public T getItem(int position) {
        return mList == null ? null : mList.get(position);
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          return getViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, final int position) {

        bindData(viewHolder, mList.get(position),position);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.OnItemClick(position);
                }
            }
        });

    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.recyclerview_swipe;
    }

    protected abstract void bindData(RecyclerViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    protected abstract int getLayoutId();

    protected abstract RecyclerViewHolder getViewHolder(View itemView);
}
