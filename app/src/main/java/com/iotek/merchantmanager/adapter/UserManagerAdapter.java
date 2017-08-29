package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/28.
 */

public class UserManagerAdapter extends CustomRvAdapter<String> {

    @Override
    protected int getLayoutID() {
        return R.layout.test_list;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, String s) {
        UserManagerAdapter.ViewHolder h = (ViewHolder) holder;
        if (s == null){
            return;
        }

        h.mTvTest.setText(s);
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_test)
        TextView mTvTest;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

/*    @Override
    protected int getLayoutID() {
        return R.layout.user_rv_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, UserManagerVO userManagerVO) {

        UserManagerAdapter.ViewHolder h = (ViewHolder) holder;

        if (userManagerVO == null){
            return;
        }

        //TODO:逻辑处理

    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_number)
        TextView mTvNumber;
        @Bind(R.id.tv_name)
        TextView mTvName;
        @Bind(R.id.tv_status)
        TextView mTvStatus;
        @Bind(R.id.tv_role)
        TextView mTvRole;
        @Bind(R.id.tv_custom_number)
        TextView mTvCustomNumber;
        @Bind(R.id.tv_custom_name)
        TextView mTvCustomName;
        @Bind(R.id.tv_code)
        TextView mTvCode;
        @Bind(R.id.tv_found_time)
        TextView mTvFoundTime;
        @Bind(R.id.tv_login_time)
        TextView mTvLoginTime;
        @Bind(R.id.tv_last_login_time)
        TextView mTvLastLoginTime;
        @Bind(R.id.tv_login_ip)
        TextView mTvLoginIp;
        @Bind(R.id.tv_last_login_ip)
        TextView mTvLastLoginIp;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }*/
}
