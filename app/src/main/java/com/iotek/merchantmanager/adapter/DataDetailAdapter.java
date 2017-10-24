package com.iotek.merchantmanager.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.bean.SalesDataDetailVO;
import com.iotek.merchantmanager.constant.StatusKey;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/17.
 */

public class DataDetailAdapter extends CustomRvAdapter<SalesDataDetailVO.RowsBean> {


    @Override
    protected int getLayoutID() {
        return R.layout.trade_form_detail_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, SalesDataDetailVO.RowsBean dataVO) {
        ViewHolder h = (ViewHolder) holder;
        Context context = h.itemView.getContext();

        if (dataVO == null) {
            return;
        }

        if (StatusKey.WX_TYPE == dataVO.getPayType1()) {
            h.mIvDataImg.setImageDrawable(context.getResources().getDrawable(R.drawable.wx));
            h.mTvPayStyle.setText("微信支付");
        } else if (StatusKey.ZFB_TYPE == dataVO.getPayType1()) {
            h.mIvDataImg.setImageDrawable(context.getResources().getDrawable(R.drawable.zfb));
            h.mTvPayStyle.setText("支付宝支付");
        } else if (StatusKey.XJ_TYPE == dataVO.getPayType1()) {
            h.mIvDataImg.setImageDrawable(context.getResources().getDrawable(R.drawable.xj));
            h.mTvPayStyle.setText("现金支付");
        } else {
            h.mIvDataImg.setImageDrawable(context.getResources().getDrawable(R.drawable.qt));
            h.mTvPayStyle.setText("其他方式支付");
        }

        h.tv_time.setText(DateUtils.dateFormat(dataVO.getSaleTime()));

        if (dataVO.getOrderType() == StatusKey.SALES_DATA){
            h.tv_pay_type.setText("正常销售");
        }else {
            h.tv_pay_type.setText("退货");
        }

        h.tv_cashier.setText(dataVO.getCashier());

        h.tv_sales_time.setText(DateUtils.dateFormatDay(dataVO.getSaleTime()));

        h.tv_oriAmount.setText(DateUtils.formatMoney(dataVO.getOriAmount()));

        h.mTvPayMoney.setText(DateUtils.formatMoney(dataVO.getReceiveAmount()));

    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.tv_time) TextView tv_time;

        @Bind(R.id.iv_data_img) ImageView mIvDataImg;

        @Bind(R.id.tv_pay_style) TextView mTvPayStyle;

        @Bind(R.id.tv_pay_type) TextView tv_pay_type;

        @Bind(R.id.tv_cashier) TextView tv_cashier;

        @Bind(R.id.tv_sales_time) TextView tv_sales_time;

        @Bind(R.id.tv_oriAmount) TextView tv_oriAmount;

        @Bind(R.id.tv_pay_money) TextView mTvPayMoney;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
