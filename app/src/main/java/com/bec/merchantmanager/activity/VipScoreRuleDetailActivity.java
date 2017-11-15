package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.ScoreExchangeQueryVO;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.constant.StatusKey;
import com.bec.merchantmanager.view.AppBar;

import butterknife.Bind;

/**
 * Created by admin on 2017/11/14.
 */

public class VipScoreRuleDetailActivity extends BaseActivity {

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.tv_vip_score_rule_bh) TextView mTvVipScoreRuleBh;

    @Bind(R.id.tv_vip_score_rule_fs) TextView mTvVipScoreRuleFs;

    @Bind(R.id.tv_vip_score_rule_sl) TextView mTvVipScoreRuleSl;

    @Bind(R.id.tv_vip_score_rule_name) TextView mTvVipScoreRuleName;

    @Bind(R.id.tv_vip_score_rule_je) TextView mTvVipScoreRuleJe;

    @Bind(R.id.tv_vip_score_rule_start_time) TextView mTvVipScoreRuleStartTime;

    @Bind(R.id.tv_vip_score_rule_end_time) TextView mTvVipScoreRuleEndTime;

    @Bind(R.id.tv_vip_score_rule_lr_time) TextView mTvVipScoreRuleLrTime;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTextColor(getResources().getColor(R.color.white));
        mAppBar.setTitle("积分规则详情");

        showDetail();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_vip_rule_detail;
    }

    private void showDetail() {
        ScoreExchangeQueryVO.RowsBean rowsBean = (ScoreExchangeQueryVO.RowsBean) getIntent().getSerializableExtra(Intentkey.VIP_SCORE_RULE_DETAIL);
        if (rowsBean == null) {
            return;
        }
        mTvVipScoreRuleBh.setText(rowsBean.getRuleNum());
        if (rowsBean.getExchangeMode() == StatusKey.GIFT_CARD) {
            mTvVipScoreRuleFs.setText("兑换礼品券");
        } else if (rowsBean.getExchangeMode() == StatusKey.CASH_TICKET) {
            mTvVipScoreRuleFs.setText("现金券");
        }
        mTvVipScoreRuleSl.setText(rowsBean.getScoreNum() + "");
        mTvVipScoreRuleName.setText(rowsBean.getGoodsId());
        mTvVipScoreRuleJe.setText(DateUtils.formatMoney(rowsBean.getVoucher()));
        mTvVipScoreRuleStartTime.setText(DateUtils.dateFormat(rowsBean.getBeginDate()));
        mTvVipScoreRuleEndTime.setText(DateUtils.dateFormat(rowsBean.getEndDate()));
        mTvVipScoreRuleLrTime.setText(DateUtils.dateFormat(rowsBean.getRecordTime()));
    }
}
