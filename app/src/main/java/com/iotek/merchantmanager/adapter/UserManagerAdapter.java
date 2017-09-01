package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.iotek.merchantmanager.bean.UserManagerVO;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/1.
 */

public class UserManagerAdapter extends CustomRvAdapter<UserManagerVO> {

    @Override
    protected int getLayoutID() {
        return R.layout.user_rv_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new UserManagerAdapter.ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, UserManagerVO userManagerVO) {

        UserManagerAdapter.ViewHolder h = (ViewHolder) holder;

        h.mTvName.setText(userManagerVO.getTv_number());
        h.mTvNumber.setText(userManagerVO.getTv_name());
        h.mTvRole.setText(userManagerVO.getTv_role());
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_name)
        TextView mTvName;
        @Bind(R.id.tv_number)
        TextView mTvNumber;
        @Bind(R.id.tv_role)
        TextView mTvRole;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
