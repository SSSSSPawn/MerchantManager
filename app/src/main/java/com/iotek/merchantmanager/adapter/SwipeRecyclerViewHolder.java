package com.iotek.merchantmanager.adapter;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by w.gs on 2016/3/9.
 */
public class SwipeRecyclerViewHolder extends BaseSwipeAdapter.BaseSwipeableViewHolder {

    public SwipeRecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
