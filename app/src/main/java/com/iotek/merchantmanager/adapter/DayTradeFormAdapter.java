package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.bean.DayTradeFormVO;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/12.
 */

public class DayTradeFormAdapter extends CustomRvAdapter<DayTradeFormVO.RowsBean> {


    @Override
    protected int getLayoutID() {
        return R.layout.trade_from_rv_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, DayTradeFormVO.RowsBean rowsBean) {
        ViewHolder h = (ViewHolder) holder;

        String reportDay = DateUtils.dateFormat(rowsBean.getReportDay());
        h.mTvTradeFormDate.setText(reportDay);

        h.mTvTradeFormName.setText(rowsBean.getCustName());

        h.mTvTradeFormXsMoney.setText(rowsBean.getSaleAmount() + "");

        h.mTvTradeFormThMoney.setText(rowsBean.getReturnAmount() + "");

        h.mTvTradeFormYsMoney.setText(rowsBean.getRealAmount() + "");

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
