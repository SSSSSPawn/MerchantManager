package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.bec.merchantmanager.R;
import com.bec.merchantmanager.bean.VipLogVO;
import com.bec.merchantmanager.constant.StatusKey;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/12.
 */

public class VipLogAdapter extends CustomRvAdapter<VipLogVO.RowsBean> {

    @Override
    protected int getLayoutID() {
        return R.layout.vip_log_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, VipLogVO.RowsBean rowsBean) {

        ViewHolder h = (ViewHolder) holder;
        if (rowsBean == null){
            return;
        }
        h.mTvVipLogName.setText(rowsBean.getMembName());
        h.mTvVipLogBh.setText(rowsBean.getMembTel());

        switch (rowsBean.getOperType()) {
            case StatusKey.REGISTRE:
                h.mTvVipLogLx.setText("注册");
                break;
            case StatusKey.RECHARGING:
                h.mTvVipLogLx.setText("充值");
                break;
            case StatusKey.EXPENSE:
                h.mTvVipLogLx.setText("消费");
                break;
            case StatusKey.NON_USE:
                h.mTvVipLogLx.setText("停用");
                break;
            case StatusKey.INVOCATION:
                h.mTvVipLogLx.setText("启用");
                break;
            case StatusKey.CANCELING:
                h.mTvVipLogLx.setText("注销");
                break;
            case StatusKey.SUFFICIENT_TIME:
                h.mTvVipLogLx.setText("充次");
                break;
            case StatusKey.SPENDS_THE_TIME:
                h.mTvVipLogLx.setText("消费次");
                break;
            case StatusKey.MEMBERS_DISCOUNT:
                h.mTvVipLogLx.setText("会员卡打折消费");
                break;
            case StatusKey.RETURNED_GOODS:
                h.mTvVipLogLx.setText("退货");
                break;
            case StatusKey.INTERGRAL_NULLING:
                h.mTvVipLogLx.setText("积分归零");
                break;
            default:
                h.mTvVipLogLx.setText("操作类型未知");
                break;
        }

        h.mTvVipLogYg.setText(rowsBean.getOperName());
    }


    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_vip_log_name) TextView mTvVipLogName;

        @Bind(R.id.tv_vip_log_bh) TextView mTvVipLogBh;

        @Bind(R.id.tv_vip_log_lx) TextView mTvVipLogLx;

        @Bind(R.id.tv_vip_log_yg) TextView mTvVipLogYg;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
