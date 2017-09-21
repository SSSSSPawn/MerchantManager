package com.iotek.merchantmanager.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.view.CustomDialog;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/1.
 */

public class UserManagerAdapter extends CustomRvSwipeAdapter<UserManagerDetailVO.RowsBean> {


    @Override
    protected void bindData(RecyclerViewHolder holder, UserManagerDetailVO.RowsBean rowsBean, int position) {
        ViewHolder h = (ViewHolder) holder;

        final Context context = h.itemView.getContext();

        h.mTvName.setText(rowsBean.getRealName());
        h.mTvNumber.setText(rowsBean.getUserName());
        h.mTvRole.setText(rowsBean.getRolePname());

        mItemManger.bind(holder.itemView, position);

        h.mItemRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CustomDialog dialog = new CustomDialog(context);
                dialog.setOkButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        AppUtils.showToast("删除成功 ");
                    }
                });
                dialog.setMessageSize(18);
                dialog.show("确定删除该用户?");
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
                        AppUtils.showToast("重置密码成功,新密码为账号后八位");
                    }
                });
                dialog.setMessageSize(18);
                dialog.show("确定重置密码吗?");
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_rv_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_name)
        TextView mTvName;
        @Bind(R.id.tv_number)
        TextView mTvNumber;
        @Bind(R.id.tv_role)
        TextView mTvRole;
        @Bind(R.id.item_right)
        RelativeLayout mItemRight;
        @Bind(R.id.item_right_update)
        RelativeLayout mItemRightUpdate;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
