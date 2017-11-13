package com.bec.merchantmanager.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bec.merchantmanager.R;
import com.bec.merchantmanager.bean.ScoreExchangeQueryVO;
import com.bec.merchantmanager.constant.StatusKey;

import butterknife.Bind;

/**
 * Created by admin on 2017/11/13.
 */

public class VipScoreRuleAdapter extends CustomRvAdapter<ScoreExchangeQueryVO.RowsBean> {

    @Override
    protected int getLayoutID() {
        return R.layout.vip_score_rule_item;
    }

    @Override
    protected RecyclerViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, ScoreExchangeQueryVO.RowsBean rowsBean) {

        ViewHolder h = (ViewHolder) holder;

        if (rowsBean == null) {
            return;
        }

        h.mTvVipScoreRuleBh.setText(rowsBean.getRuleNum());
        if (rowsBean.getExchangeMode() == StatusKey.GIFT_CARD) {
            h.mTvVipScoreRuleFs.setText("兑换礼品券");
        } else if (rowsBean.getExchangeMode() == StatusKey.CASH_TICKET) {
            h.mTvVipScoreRuleFs.setText("现金券");
        }

        h.mTvVipScoreRuleSl.setText(rowsBean.getScoreNum() + "");
        h.mTvVipScoreRuleName.setText(rowsBean.getGoodsId());

    }


    class ViewHolder extends RecyclerViewHolder{

        @Bind(R.id.tv_vip_score_rule_bh) TextView mTvVipScoreRuleBh;

        @Bind(R.id.tv_vip_score_rule_fs) TextView mTvVipScoreRuleFs;

        @Bind(R.id.tv_vip_score_rule_sl) TextView mTvVipScoreRuleSl;

        @Bind(R.id.tv_vip_score_rule_name) TextView mTvVipScoreRuleName;

        @Bind(R.id.ll_vip_score_rule_detail) LinearLayout mLlVipScoreRuleDetail;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
