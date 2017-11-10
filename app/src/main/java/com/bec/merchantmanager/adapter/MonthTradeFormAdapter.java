package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.bean.MonthTradeFormVO;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/10/16.
 */

public class MonthTradeFormAdapter extends CustomRvAdapter<MonthTradeFormVO.RowsBean> {

    @Override
    protected int getLayoutID() {
        return R.layout.month_trade_from_rv_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, MonthTradeFormVO.RowsBean rowsBean) {
        ViewHolder h = (ViewHolder) holder;

        if (rowsBean == null){
            return;
        }

        h.mTvTradeFormName.setText(rowsBean.getCustName());

        String month = DateUtils.dateFormatMonth(rowsBean.getReportMonth());

        h.mTvTradeFormMonth.setText(month);

        h.mTvTradeFormXsMoney.setText(DateUtils.formatMoney(rowsBean.getSaleAmount()));

        h.mTvTradeFormThMoney.setText(DateUtils.formatMoney(rowsBean.getReturnAmount()));

        h.mTvTradeFormSsMoney.setText(DateUtils.formatMoney(rowsBean.getRealAmount()));

        h.mTvTradeFormXsNum.setText(rowsBean.getSaleCount() + "");

        h.mTvTradeFormThNum.setText(rowsBean.getReturnCount() + "");

        h.mTvTradeFormCb.setText(DateUtils.formatMoney(rowsBean.getCost()));

        h.mTvTradeFormLr.setText(DateUtils.formatMoney(rowsBean.getCouponAmount()));
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_trade_form_name) TextView mTvTradeFormName;

        @Bind(R.id.tv_trade_form_month) TextView mTvTradeFormMonth;

        @Bind(R.id.tv_trade_form_xs_money) TextView mTvTradeFormXsMoney;

        @Bind(R.id.tv_trade_form_th_money) TextView mTvTradeFormThMoney;

        @Bind(R.id.tv_trade_form_ss_money) TextView mTvTradeFormSsMoney;

        @Bind(R.id.tv_trade_form_xs_num) TextView mTvTradeFormXsNum;

        @Bind(R.id.tv_trade_form_th_num) TextView mTvTradeFormThNum;

        @Bind(R.id.tv_trade_form_cb) TextView mTvTradeFormCb;

        @Bind(R.id.tv_trade_form_lr) TextView mTvTradeFormLr;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
