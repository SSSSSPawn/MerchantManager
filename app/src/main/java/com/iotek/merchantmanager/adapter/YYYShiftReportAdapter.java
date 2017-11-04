package com.iotek.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.bean.YYYShiftReportVO;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/11/3.
 */

public class YYYShiftReportAdapter extends CustomRvAdapter<YYYShiftReportVO.RowsBean> {


    @Override
    protected int getLayoutID() {
        return R.layout.yyy_shift_report_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, YYYShiftReportVO.RowsBean rowsBean) {
        ViewHolder h = (ViewHolder) holder;

        if (rowsBean == null){
            return;
        }

        h.mTvYyySelShiftCode.setText(rowsBean.getCustId() + "");
        h.mTvYyySelShiftName.setText(rowsBean.getCustName());
        h.mTvYyySelShiftXsMoney.setText(DateUtils.formatMoney(rowsBean.getSaleAmount()));
        h.mTvYyySelShiftThMoney.setText(DateUtils.formatMoney(rowsBean.getReturnAmount()));
        h.mTvYyySelShiftShMoney.setText(DateUtils.formatMoney(rowsBean.getRealAmount()));
        h.mTvYyySelShiftXsNumber.setText(rowsBean.getSaleCount() + "");
        h.mTvYyySelShiftThNumber.setText(rowsBean.getReturnCount() + "");
        h.mTvYyySelShiftManager.setText(rowsBean.getOperName());

    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_yyy_sel_shift_code) TextView mTvYyySelShiftCode;

        @Bind(R.id.tv_yyy_sel_shift_name) TextView mTvYyySelShiftName;

        @Bind(R.id.tv_yyy_sel_shift_xs_money) TextView mTvYyySelShiftXsMoney;

        @Bind(R.id.tv_yyy_sel_shift_th_money) TextView mTvYyySelShiftThMoney;

        @Bind(R.id.tv_yyy_sel_shift_sh_money) TextView mTvYyySelShiftShMoney;

        @Bind(R.id.tv_yyy_sel_shift_xs_number) TextView mTvYyySelShiftXsNumber;

        @Bind(R.id.tv_yyy_sel_shift_th_number) TextView mTvYyySelShiftThNumber;

        @Bind(R.id.tv_yyy_sel_shift_manager) TextView mTvYyySelShiftManager;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
