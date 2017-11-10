package com.bec.merchantmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bec.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

/**
 *
 * Created by wei sun on 2017/8/28.
 */

public abstract class CustomRvAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<T> mList;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setDataList(ArrayList<T> dataList) {
        this.mList = dataList;
        notifyDataSetChanged();
    }

    public ArrayList<T> getDataList() {
        return mList == null ? new ArrayList<T>() : mList;
    }

    public T getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutID(), parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        bindData(holder, mList.get(position));

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.OnItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    protected abstract int getLayoutID();

    protected abstract RecyclerViewHolder getViewHolder(View itemView);

    protected abstract void bindData(RecyclerViewHolder holder, T t);
}
