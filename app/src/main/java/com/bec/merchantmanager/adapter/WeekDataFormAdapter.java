package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.bean.DayTradeFormVO;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/10/12.
 */

public class WeekDataFormAdapter extends CustomRvAdapter<DayTradeFormVO.RowsBean> {


    @Override
    protected int getLayoutID() {
        return R.layout.week_month_data_list_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, DayTradeFormVO.RowsBean rowsBean) {
        ViewHolder h = (ViewHolder) holder;

        if (rowsBean == null){
            return;
        }

        String reportDay = DateUtils.dateFormatDay(rowsBean.getReportDay());
        h.mTvTradeFormDate.setText(reportDay);

        h.mTvTradeFormName.setText(rowsBean.getCustName());

        h.mTvTradeFormXsMoney.setText(DateUtils.formatMoney(rowsBean.getSaleAmount()));

        h.mTvTradeFormThMoney.setText(DateUtils.formatMoney(rowsBean.getReturnAmount()));

        h.mTvTradeFormYsMoney.setText(DateUtils.formatMoney(rowsBean.getRealAmount()));

        h.mTvTradeFormXsNum.setText((int) rowsBean.getSaleCount() + "");

        h.mTvTradeFormThNum.setText((int) rowsBean.getReturnCount() + "");
    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_trade_form_date) TextView mTvTradeFormDate;

        @Bind(R.id.tv_trade_form_name) TextView mTvTradeFormName;

        @Bind(R.id.tv_trade_form_xs_money) TextView mTvTradeFormXsMoney;

        @Bind(R.id.tv_trade_form_th_money) TextView mTvTradeFormThMoney;

        @Bind(R.id.tv_trade_form_ys_money) TextView mTvTradeFormYsMoney;

        @Bind(R.id.tv_trade_form_xs_num) TextView mTvTradeFormXsNum;

        @Bind(R.id.tv_trade_form_th_num) TextView mTvTradeFormThNum;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
