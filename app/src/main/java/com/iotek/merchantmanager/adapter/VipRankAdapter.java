package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.bean.QueryMembLevelVO;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/11/6.
 */

public class VipRankAdapter extends CustomRvAdapter<QueryMembLevelVO.RowsBean> {


    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_vip_rank_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(final RecyclerViewHolder holder, QueryMembLevelVO.RowsBean rowsBean) {

        ViewHolder h = (ViewHolder) holder;

        if (rowsBean == null){
            return;
        }

        h.mTvVipRankItemTime.setText(DateUtils.dateFormat(rowsBean.getRecordTime()));
        h.mTvVipRankItemBh.setText(rowsBean.getMembLevel() + "");
        h.mTvVipRankItemName.setText(rowsBean.getLevelName());
        h.mTvVipRankItemZk.setText(rowsBean.getDiscount());

        h.mItemRightUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.OnItemClick(holder.getAdapterPosition() - 1);
                }
            }
        });
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_vip_rank_item_time) TextView mTvVipRankItemTime;

        @Bind(R.id.tv_vip_rank_item_bh) TextView mTvVipRankItemBh;

        @Bind(R.id.tv_vip_rank_item_name) TextView mTvVipRankItemName;

        @Bind(R.id.tv_vip_rank_item_zk) TextView mTvVipRankItemZk;

        @Bind(R.id.item_right_update) RelativeLayout mItemRightUpdate;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
