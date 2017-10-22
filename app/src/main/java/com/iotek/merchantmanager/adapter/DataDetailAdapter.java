package com.iotek.merchantmanager.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.bean.TradeDataVO;
import com.iotek.merchantmanager.constant.StatusKey;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/17.
 */

public class DataDetailAdapter extends CustomRvAdapter<TradeDataVO> {


    @Override
    protected int getLayoutID() {
        return R.layout.trade_form_detail_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, TradeDataVO dataVO) {
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

        h.mTvSpName.setText(dataVO.getGoodsName());
        h.mTvSpNumber.setText(dataVO.getGoodsNum() + "");
        h.mTvSpUnitPrice.setText(DateUtils.formatMoney(dataVO.getGoodsPrice()));
        h.mTvPayMoney.setText(DateUtils.formatMoney(dataVO.getGoodsAmount()));

    }

    class ViewHolder extends RecyclerViewHolder {

        @Bind(R.id.iv_data_img) ImageView mIvDataImg;

        @Bind(R.id.tv_pay_style) TextView mTvPayStyle;

        @Bind(R.id.tv_sp_name) TextView mTvSpName;

        @Bind(R.id.tv_sp_num) TextView mTvSpNumber;

        @Bind(R.id.tv_sp_unit_price) TextView mTvSpUnitPrice;

        @Bind(R.id.tv_pay_money) TextView mTvPayMoney;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
