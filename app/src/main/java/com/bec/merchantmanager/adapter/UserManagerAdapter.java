package com.bec.merchantmanager.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bec.merchantmanager.bean.UserManagerDetailVO;
import com.bec.merchantmanager.listener.OnConfirmListener;
import com.bec.merchantmanager.view.CustomDialog;
import com.bec.merchantmanager.view.SwipeMenuLayout;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/9/1.
 */

public class UserManagerAdapter extends CustomRvAdapter<UserManagerDetailVO.RowsBean> {

    private OnConfirmListener mListener;

    public void setOnConfirmListener(OnConfirmListener listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.user_rv_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(final RecyclerViewHolder holder, final UserManagerDetailVO.RowsBean rowsBean) {
        ViewHolder h = (ViewHolder) holder;

        final Context context = h.itemView.getContext();

        if (rowsBean == null){
            return;
        }

        h.mTvName.setText(rowsBean.getRealName());
        h.mTvNumber.setText(rowsBean.getUserName());
        h.mTvRole.setText(rowsBean.getRolePname());

        h.ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(holder.getAdapterPosition() - 1);
            }
        });

        h.mItemRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CustomDialog dialog = new CustomDialog(context);
                dialog.setOkButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        if (mListener != null) {
                            ((SwipeMenuLayout) holder.itemView).quickClose();
                            mListener.onConfirmDel(rowsBean.getUserId());
                        }
                    }
                });
                dialog.show("提示信息","确定删除该用户?");
            }
        });

        h.mItemRightUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CustomDialog dialog = new CustomDialog(context);
                dialog.setOkButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        if (mListener != null) {
                            mListener.onConfirmReset(rowsBean.getUserId(), rowsBean.getRoleId());
                        }
                    }
                });
                dialog.show("提示信息","确定重置密码吗?");
            }
        });
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.ll_item) LinearLayout ll_item;

        @Bind(R.id.tv_name) TextView mTvName;

        @Bind(R.id.tv_number) TextView mTvNumber;

        @Bind(R.id.tv_role) TextView mTvRole;

        @Bind(R.id.item_right) RelativeLayout mItemRight;

        @Bind(R.id.item_right_update) RelativeLayout mItemRightUpdate;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
