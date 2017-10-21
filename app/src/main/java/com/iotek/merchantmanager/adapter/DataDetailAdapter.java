package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iotek.merchantmanager.bean.TradeFormDetailVO;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/17.
 */

public class DataDetailAdapter extends CustomRvAdapter<TradeFormDetailVO.RowsBean> {


    @Override
    protected int getLayoutID() {
        return R.layout.trade_form_detail_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, TradeFormDetailVO.RowsBean rowsBean) {
        ViewHolder h = (ViewHolder) holder;


    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.iv_data_img) ImageView mIvDataImg;

        @Bind(R.id.tv_pay_style) TextView mTvPayStyle;

        @Bind(R.id.tv_sp_name) TextView mTvSpName;

        @Bind(R.id.tv_sp_price) TextView mTvSpPrice;

        @Bind(R.id.tv_sp_number) TextView mTvSpNumber;

        @Bind(R.id.tv_sp_unit_price) TextView mTvSpUnitPrice;

        @Bind(R.id.tv_pay_money) TextView mTvPayMoney;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
