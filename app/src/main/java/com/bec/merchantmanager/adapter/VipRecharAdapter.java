package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.bean.MemberTimeVO;

import butterknife.Bind;

/**
 * Created by admin on 2017/11/16.
 */

public class VipRecharAdapter extends CustomRvAdapter<MemberTimeVO.RowsBean> {

    @Override
    protected int getLayoutID() {
        return R.layout.vip_rechar_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, MemberTimeVO.RowsBean rowsBean) {
        ViewHolder h = (ViewHolder) holder;
        h.mTvVipRecharName.setText(rowsBean.getMembName());
        h.mTvVipRecharBh.setText(rowsBean.getMembTel());
        h.mTvVipRecharSp.setText(rowsBean.getGoodsName());
        h.mTvVipRecharTime.setText(rowsBean.getTimes() + "");
        h.mTvVipRecharDate.setText(DateUtils.dateFormat(rowsBean.getRecordTime()));
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_vip_rechar_name)
        TextView mTvVipRecharName;

        @Bind(R.id.tv_vip_rechar_bh)
        TextView mTvVipRecharBh;

        @Bind(R.id.tv_vip_rechar_sp)
        TextView mTvVipRecharSp;

        @Bind(R.id.tv_vip_rechar_time)
        TextView mTvVipRecharTime;

        @Bind(R.id.tv_vip_rechar_date)
        TextView mTvVipRecharDate;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
