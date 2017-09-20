package com.iotek.merchantmanager.ooo;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2017/9/20.
 */

public class RV extends RecyclerSwipeAdapter<RV.SimpleViewHolder>{


    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder viewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return 0;
    }

    @Override
    public void notifyDatasetChanged() {

    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {


        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
    }



}
