package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.bean.UserManagerVO;
import com.iotek.merchantmanager.listener.OnConfirmListener;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/28.
 */

public class UserManagerAdapter extends SwipeListAdapter<UserManagerVO> {


    private OnConfirmListener mListener;


    public void setOnSwipeViewClickListener(OnConfirmListener listener) {
        mListener = listener;
    }

    @Override
    protected void bindData(SwipeRecyclerViewHolder holder, UserManagerVO userManagerVO) {

        ViewHolder h = (ViewHolder) holder;
        if (userManagerVO == null) {
            return;
        }
        h.mTvCode.setText("123");
        h.mTvCustomName.setText("1234");
        h.mTvFoundTime.setText("sf");
        h.mTvLastLoginIp.setText("234234");
        h.mTvLoginIp.setText("4852852852");
        h.mTvName.setText("阿嘎");
        h.mTvStatus.setText("呃呃呃");
        h.mTvRole.setText("管理员");

        h.mItemRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.showToast("TEST");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_rv_swip_item;
    }

    @Override
    protected SwipeRecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }


    class ViewHolder extends SwipeRecyclerViewHolder {

        @Bind(R.id.item_right)
        RelativeLayout mItemRight;
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
    }
}
