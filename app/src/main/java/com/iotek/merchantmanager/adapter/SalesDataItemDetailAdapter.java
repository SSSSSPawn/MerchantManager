package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.bean.SalesDataItemDetailVO;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/23.
 */

public class SalesDataItemDetailAdapter extends CustomRvAdapter<SalesDataItemDetailVO.RowsBean> {


    @Override
    protected int getLayoutID() {
        return R.layout.sales_data_item_details;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, SalesDataItemDetailVO.RowsBean bean) {
        ViewHolder h = (ViewHolder) holder;

        if (bean == null) {
            return;
        }

        h.mTvOrderId.setText(bean.getOrderId());
        h.mTvGoodsId.setText(bean.getGoodsId());
        h.mTvGoodsName.setText(bean.getGoodsName());
        h.mTvGoodsDj.setText(DateUtils.formatMoney(bean.getGoodsPrice()));
        h.mTvGoodsNum.setText(bean.getGoodsNum() + "");
        h.mTvGoodsMoney.setText(DateUtils.formatMoney(bean.getGoodsAmount()));
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_order_id) TextView mTvOrderId;

        @Bind(R.id.tv_goods_id) TextView mTvGoodsId;

        @Bind(R.id.tv_goods_name) TextView mTvGoodsName;

        @Bind(R.id.tv_goods_dj) TextView mTvGoodsDj;

        @Bind(R.id.tv_goods_num) TextView mTvGoodsNum;

        @Bind(R.id.tv_goods_money) TextView mTvGoodsMoney;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
