package com.iotek.merchantmanager.iii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;


/**
 *
 * Created by admin on 2017/8/28.
 */
public abstract class SwipeListAdapter<T> extends BaseSwipeAdapter<SwipeRecyclerViewHolder> {
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
    public SwipeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false));
    }

    @Override
    public void onBindViewHolder(SwipeRecyclerViewHolder holder, final int position) {
        bindData(holder, mList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.OnItemClick(position);
                }
            }
        });
    }

    protected abstract void bindData(SwipeRecyclerViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    protected abstract int getLayoutId();

    protected abstract SwipeRecyclerViewHolder getViewHolder(View itemView);


}
