package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.bec.merchantmanager.R;
import com.bec.merchantmanager.bean.ScoreUseQueryVO;

import butterknife.Bind;

/**
 * Created by admin on 2017/11/16.
 */

public class VipScoreExchangeAdapter extends CustomRvAdapter<ScoreUseQueryVO.RowsBean> {


    @Override
    protected int getLayoutID() {
        return R.layout.vip_exchange_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, ScoreUseQueryVO.RowsBean scoreUseQueryVO) {
        ViewHolder h = (ViewHolder) holder;
        h.mTvVipExchangeName.setText(scoreUseQueryVO.getMembName());
        h.mTvVipExchangeBh.setText(scoreUseQueryVO.getMembTel());
        h.mTvVipExchangeSl.setText(scoreUseQueryVO.getScoreNum() + "");
        h.mTvVipExchangeGoods.setText(scoreUseQueryVO.getGoodsId());
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_vip_exchange_name) TextView mTvVipExchangeName;

        @Bind(R.id.tv_vip_exchange_bh) TextView mTvVipExchangeBh;

        @Bind(R.id.tv_vip_exchange_sl) TextView mTvVipExchangeSl;

        @Bind(R.id.tv_vip_exchange_goods) TextView mTvVipExchangeGoods;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
