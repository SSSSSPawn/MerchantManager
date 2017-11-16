package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.ScoreUseQueryVO;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.constant.StatusKey;
import com.bec.merchantmanager.view.AppBar;

import butterknife.Bind;

/**
 * Created by admin on 2017/11/16.
 */

public class VipExchangeDetailActivity extends BaseActivity {


    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.tv_vip_exchange_name) TextView mTvVipExchangeName;

    @Bind(R.id.tv_vip_exchange_hm) TextView mTvVipExchangeHm;

    @Bind(R.id.tv_vip_exchange_bh) TextView mTvVipExchangeBh;

    @Bind(R.id.tv_vip_exchange_gz) TextView mTvVipExchangeGz;

    @Bind(R.id.tv_vip_exchange_fs) TextView mTvVipExchangeFs;

    @Bind(R.id.tv_vip_exchange_sl) TextView mTvVipExchangeSl;

    @Bind(R.id.tv_vip_exchange_good_name) TextView mTvVipExchangeGoodName;

    @Bind(R.id.tv_vip_exchange_je) TextView mTvVipExchangeJe;

    @Bind(R.id.tv_vip_exchange_qjf) TextView mTvVipExchangeQjf;

    @Bind(R.id.tv_vip_exchange_hjf) TextView mTvVipExchangeHjf;

    @Bind(R.id.tv_vip_exchange_date) TextView mTvVipExchangeDate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTextColor(getResources().getColor(R.color.white));
        mAppBar.setTitle("积分兑换详情");

        showDetail();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_vip_exchange;
    }

    private void showDetail(){
        ScoreUseQueryVO.RowsBean rowsBean = (ScoreUseQueryVO.RowsBean) getIntent().getSerializableExtra(Intentkey.VIP_SCORE_EXCHANGE_DETAIL);
        if (rowsBean == null){
            return;
        }

        mTvVipExchangeName.setText(rowsBean.getMembName());
        mTvVipExchangeHm.setText(rowsBean.getUseId());
        mTvVipExchangeBh.setText(rowsBean.getMembTel());
        mTvVipExchangeGz.setText(rowsBean.getRuleNum() + "");
        if (rowsBean.getExchangeMode() == StatusKey.GIFT_CARD){
            mTvVipExchangeFs.setText("礼品券");
        }else {
            mTvVipExchangeFs.setText("现金券");
        }
        mTvVipExchangeSl.setText(rowsBean.getScoreNum() + "");
        mTvVipExchangeGoodName.setText(rowsBean.getGoodsId());
        mTvVipExchangeJe.setText(DateUtils.formatMoney(rowsBean.getVoucher()));
        mTvVipExchangeQjf.setText(rowsBean.getOldScore() + "");
        mTvVipExchangeHjf.setText(rowsBean.getCurScore() + "");
        mTvVipExchangeDate.setText(DateUtils.dateFormat(rowsBean.getRecordTime()));

    }

}
