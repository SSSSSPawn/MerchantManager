package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.bean.TradeFormDetailVO;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/17.
 */

public class TradeFormDetailAdapter extends CustomRvAdapter<TradeFormDetailVO.RowsBean> {

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

        if (rowsBean == null){
            return;
        }

        String day = DateUtils.dateFormatDay(rowsBean.getReportDay());
        h.mTvTradeFormDate.setText(day);

        h.mTvTradeFormFs.setText(rowsBean.getTypeName());

        h.mTvTradeFormZf.setText(DateUtils.formatMoney(rowsBean.getSaleAmount()));

        h.mTvTradeFormTh.setText(DateUtils.formatMoney(rowsBean.getReturnAmount()));

    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_trade_form_date) TextView mTvTradeFormDate;

        @Bind(R.id.tv_trade_form_fs) TextView mTvTradeFormFs;

        @Bind(R.id.tv_trade_form_zf) TextView mTvTradeFormZf;

        @Bind(R.id.tv_trade_form_th) TextView mTvTradeFormTh;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
