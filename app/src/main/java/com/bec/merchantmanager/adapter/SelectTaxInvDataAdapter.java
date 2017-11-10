package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.TextView;

import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.bean.SelectTaxInvDataVO;
import com.bec.merchantmanager.constant.StatusKey;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/11/4.
 */

public class SelectTaxInvDataAdapter extends CustomRvAdapter<SelectTaxInvDataVO.RowsBean> {

    @Override
    protected int getLayoutID() {
        return R.layout.select_tax_inv_data_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, SelectTaxInvDataVO.RowsBean rowsBean) {
        ViewHolder h = (ViewHolder) holder;

        if (rowsBean == null){
            return;
        }

        h.mTvSelectTaxInvDataTime.setText(DateUtils.dateFormat(rowsBean.getInvDate()));
        h.mTvSelectTaxInvDataLs.setText(rowsBean.getInvOrderId());
        h.mTvSelectTaxInvDataComp.setText(rowsBean.getCustLname());

        if (rowsBean.getInvStatus() == StatusKey.INV_STATTS_SUCCESS) {
            h.mTvSelectTaxInvDataKpType.setText("成功");
        } else if (rowsBean.getInvStatus() == StatusKey.INV_STATTS_ING) {
            h.mTvSelectTaxInvDataKpType.setText("开票中");
        } else if (rowsBean.getInvStatus() == StatusKey.INV_STATTS_FAIL) {
            h.mTvSelectTaxInvDataKpType.setText("失败");
        }

        if (rowsBean.getMakeInvType() == StatusKey.INV_TYPE_BLUE){
            h.mTvSelectTaxInvDataFpType.setText("蓝票");
        }else if (rowsBean.getMakeInvType() == StatusKey.INV_TYPE_RED){
            h.mTvSelectTaxInvDataFpType.setText("红票");
        }

        h.mTvSelectTaxInvDataName.setText(rowsBean.getPayUnit());
        h.mTvSelectTaxInvDataSe.setText(DateUtils.formatMoney(rowsBean.getSumTaxAmount()));
        h.mTvSelectTaxInvJe.setText(DateUtils.formatMoney(rowsBean.getSumAmount()));
        h.mTvSelectTaxInvCode.setText(rowsBean.getInvCode());
        h.mTvSelectTaxInvNumber.setText(rowsBean.getInvNumber());
        h.mTvSelectTaxInvAllMoney.setText(DateUtils.formatMoney(rowsBean.getSumTotal()));

    }

    class ViewHolder extends RecyclerViewHolder {


        @Bind(R.id.tv_SelectTaxInvData_time) TextView mTvSelectTaxInvDataTime;

        @Bind(R.id.tv_SelectTaxInvData_ls) TextView mTvSelectTaxInvDataLs;

        @Bind(R.id.tv_SelectTaxInvData_comp) TextView mTvSelectTaxInvDataComp;

        @Bind(R.id.tv_SelectTaxInvData_kp_type) TextView mTvSelectTaxInvDataKpType;

        @Bind(R.id.tv_SelectTaxInvData_fp_type) TextView mTvSelectTaxInvDataFpType;

        @Bind(R.id.tv_SelectTaxInvData_name) TextView mTvSelectTaxInvDataName;

        @Bind(R.id.tv_SelectTaxInvData_se) TextView mTvSelectTaxInvDataSe;

        @Bind(R.id.tv_SelectTaxInv_je) TextView mTvSelectTaxInvJe;

        @Bind(R.id.tv_SelectTaxInv_code) TextView mTvSelectTaxInvCode;

        @Bind(R.id.tv_SelectTaxInv_number) TextView mTvSelectTaxInvNumber;

        @Bind(R.id.tv_SelectTaxInv_all_money) TextView mTvSelectTaxInvAllMoney;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
