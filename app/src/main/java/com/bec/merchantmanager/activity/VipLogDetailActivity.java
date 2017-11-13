package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.VipLogVO;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.constant.StatusKey;
import com.bec.merchantmanager.view.AppBar;

import butterknife.Bind;

/**
 * Created by admin on 2017/11/13.
 */

public class VipLogDetailActivity extends BaseActivity {

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.tv_vip_log_name) TextView mTvVipLogName;

    @Bind(R.id.tv_vip_log_bh) TextView mTvVipLogBh;

    @Bind(R.id.tv_vip_log_lx) TextView mTvVipLogLx;

    @Bind(R.id.tv_vip_log_sp) TextView mTvVipLogSp;

    @Bind(R.id.tv_vip_log_time) TextView mTvVipLogTime;

    @Bind(R.id.tv_vip_log_je) TextView mTvVipLogJe;

    @Bind(R.id.tv_vip_log_dq) TextView mTvVipLogDq;

    @Bind(R.id.tv_vip_log_fj) TextView mTvVipLogFj;

    @Bind(R.id.tv_vip_log_type) TextView mTvVipLogType;

    @Bind(R.id.tv_vip_log_yg) TextView mTvVipLogYg;

    @Bind(R.id.tv_vip_log_date) TextView mTvVipLogDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTitle("会员日志详情");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        showVipLogDetail();

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_vip_log_detail;
    }

    private void showVipLogDetail() {

        VipLogVO.RowsBean logVO = (VipLogVO.RowsBean) getIntent().getSerializableExtra(Intentkey.VIP_LOG_DETAIL);

        if (logVO == null) {
            return;
        }

        mTvVipLogName.setText(logVO.getMembName());
        mTvVipLogBh.setText(logVO.getMembTel());
        switch (logVO.getOperType()) {
            case StatusKey.REGISTRE:
                mTvVipLogLx.setText("注册");
                break;
            case StatusKey.RECHARGING:
                mTvVipLogLx.setText("充值");
                break;
            case StatusKey.EXPENSE:
                mTvVipLogLx.setText("消费");
                break;
            case StatusKey.NON_USE:
                mTvVipLogLx.setText("停用");
                break;
            case StatusKey.INVOCATION:
                mTvVipLogLx.setText("启用");
                break;
            case StatusKey.CANCELING:
                mTvVipLogLx.setText("注销");
                break;
            case StatusKey.SUFFICIENT_TIME:
                mTvVipLogLx.setText("充次");
                break;
            case StatusKey.SPENDS_THE_TIME:
                mTvVipLogLx.setText("消费次");
                break;
            case StatusKey.MEMBERS_DISCOUNT:
                mTvVipLogLx.setText("会员卡打折消费");
                break;
            case StatusKey.RETURNED_GOODS:
                mTvVipLogLx.setText("退货");
                break;
            case StatusKey.INTERGRAL_NULLING:
                mTvVipLogLx.setText("积分归零");
                break;
            default:
                mTvVipLogLx.setText("操作类型未知");
                break;
        }

        mTvVipLogSp.setText("");
        mTvVipLogTime.setText(logVO.getOperTimes() + "");
        mTvVipLogJe.setText(DateUtils.formatMoney(logVO.getOperBalance()));
        mTvVipLogDq.setText(DateUtils.formatMoney(logVO.getBalance()));
        mTvVipLogFj.setText(DateUtils.formatMoney(logVO.getAddBalance()));
        mTvVipLogType.setText(logVO.getProdName());
        mTvVipLogYg.setText(logVO.getOperName());
        mTvVipLogDate.setText(DateUtils.dateFormat(logVO.getRecordTime()));
    }
}
