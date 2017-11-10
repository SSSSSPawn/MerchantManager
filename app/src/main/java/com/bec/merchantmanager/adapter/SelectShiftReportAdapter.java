package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.bean.SelectShiftReportVO;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/11/2.
 */

public class SelectShiftReportAdapter extends CustomRvAdapter<SelectShiftReportVO.RowsBean> {


    @Override
    protected int getLayoutID() {
        return R.layout.sel_shift_report_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, SelectShiftReportVO.RowsBean rowsBean) {

        ViewHolder h = (ViewHolder) holder;

        if (rowsBean == null){
            return;
        }

        h.mTvSelShiftTime.setText(DateUtils.dateFormat(rowsBean.getShiftEndTime()));
        h.mTvSelShiftName.setText(rowsBean.getCustName());
        h.mTvSelShiftDh.setText(rowsBean.getShiftId());
        h.mTvSelShiftLastTime.setText(DateUtils.dateFormat(rowsBean.getShiftStartTime()));
        h.mTvSelShiftXsMoney.setText(DateUtils.formatMoney(rowsBean.getSaleAmount()));
        h.mTvSelShiftThMoney.setText(DateUtils.formatMoney(rowsBean.getReturnAmount()));
        h.mTvSelShiftYhqMoney.setText(DateUtils.formatMoney(rowsBean.getCouponAmount()));
        h.mTvSelShiftShMoney.setText(DateUtils.formatMoney(rowsBean.getRealAmount()));
        h.mTvSelShiftXsNumber.setText(rowsBean.getSaleCount() + "");
        h.mTvSelShiftThNumber.setText(rowsBean.getReturnCount() + "");
        h.mTvSelShiftManager.setText(rowsBean.getOperName());
    }


    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_sel_shift_time) TextView mTvSelShiftTime;

        @Bind(R.id.tv_sel_shift_name) TextView mTvSelShiftName;

        @Bind(R.id.tv_sel_shift_dh) TextView mTvSelShiftDh;

        @Bind(R.id.tv_sel_shift_last_time) TextView mTvSelShiftLastTime;

        @Bind(R.id.tv_sel_shift_xs_money) TextView mTvSelShiftXsMoney;

        @Bind(R.id.tv_sel_shift_th_money) TextView mTvSelShiftThMoney;

        @Bind(R.id.tv_sel_shift_yhq_money) TextView mTvSelShiftYhqMoney;

        @Bind(R.id.tv_sel_shift_sh_money) TextView mTvSelShiftShMoney;

        @Bind(R.id.tv_sel_shift_xs_number) TextView mTvSelShiftXsNumber;

        @Bind(R.id.tv_sel_shift_th_number) TextView mTvSelShiftThNumber;

        @Bind(R.id.tv_sel_shift_manager) TextView mTvSelShiftManager;

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
}
