package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.bean.VipDatumDataVO;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/11/7.
 */

public class VipDatumAdapter extends CustomRvAdapter<VipDatumDataVO.ObjBean> {

    private OnDeleteItemClickListener mOnItemClickListener;

    public void setDeleteOnItemClickListener(OnDeleteItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    @Override
    protected int getLayoutID() {
        return R.layout.fragment_vip_datum_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(final RecyclerViewHolder holder, VipDatumDataVO.ObjBean objBean) {

        ViewHolder h = (ViewHolder) holder;

        if (objBean == null) {
            return;
        }

        h.mTvVipDatumName.setText(objBean.getMembName());
        h.mTvVipDatumBh.setText(objBean.getMembTel());
        h.mTvVipDatumDj.setText(objBean.getLevelName());
        h.mTvVipDatumYe.setText(DateUtils.formatMoney(objBean.getBalance()));
        h.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener!= null){
                    mOnItemClickListener.onItemClick(holder.getAdapterPosition() - 1);
                }
            }
        });
        h.mItemRightUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onDeleteItemClick(holder.getAdapterPosition() - 1);
                }
            }
        });
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.ll_item) LinearLayout mLinearLayout;

        @Bind(R.id.tv_vip_datum_name) TextView mTvVipDatumName;

        @Bind(R.id.tv_vip_datum_bh) TextView mTvVipDatumBh;

        @Bind(R.id.tv_vip_datum_dj) TextView mTvVipDatumDj;

        @Bind(R.id.tv_vip_datum_ye) TextView mTvVipDatumYe;

        @Bind(R.id.item_right_update) RelativeLayout mItemRightUpdate;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


    public interface OnDeleteItemClickListener {

        void onDeleteItemClick(int position);

        void onItemClick(int position);
    }
}
