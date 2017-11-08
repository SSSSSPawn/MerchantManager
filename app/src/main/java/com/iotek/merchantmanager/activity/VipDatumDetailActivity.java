package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.VipDatumDataVO;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.constant.StatusKey;
import com.iotek.merchantmanager.view.AppBar;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/11/8.
 */

public class VipDatumDetailActivity extends BaseActivity {

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.tv_vip_datum_detail_name) TextView mTvVipDatumDetailName;

    @Bind(R.id.tv_vip_datum_detail_bh) TextView mTvVipDatumDetailBh;

    @Bind(R.id.tv_vip_datum_detail_kh) TextView mTvVipDatumDetailKh;

    @Bind(R.id.tv_vip_datum_detail_dj) TextView mTvVipDatumDetailDj;

    @Bind(R.id.tv_vip_datum_detail_zk) TextView mTvVipDatumDetailZk;

    @Bind(R.id.tv_vip_datum_detail_password) TextView mTvVipDatumDetailPassword;

    @Bind(R.id.tv_vip_datum_detail_ye) TextView mTvVipDatumDetailYe;

    @Bind(R.id.tv_vip_datum_detail_jf) TextView mTvVipDatumDetailJf;

    @Bind(R.id.tv_vip_datum_detail_code) TextView mTvVipDatumDetailCode;

    @Bind(R.id.tv_vip_datum_detail_zt) TextView mTvVipDatumDetailZt;

    @Bind(R.id.tv_vip_datum_detail_sex) TextView mTvVipDatumDetailSex;

    @Bind(R.id.tv_vip_datum_detail_time) TextView mTvVipDatumDetailTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTitle("会员资料详情");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        showVipDatumDetail();
    }

    private void showVipDatumDetail() {
        VipDatumDataVO.ObjBean objBean = (VipDatumDataVO.ObjBean) getIntent().getSerializableExtra(Intentkey.VIP_DATUM_DETAIL);
        mTvVipDatumDetailName.setText(objBean.getMembName());
        mTvVipDatumDetailBh.setText(objBean.getMembTel());
        mTvVipDatumDetailKh.setText(objBean.getMembNum());
        mTvVipDatumDetailDj.setText(objBean.getLevelName());
        mTvVipDatumDetailZk.setText(objBean.getDiscount());
        if (objBean.getPswFlag() == StatusKey.STATE_NO) {
            mTvVipDatumDetailPassword.setText("未启用");
        } else if (objBean.getPswFlag() == StatusKey.STATE_YES) {
            mTvVipDatumDetailPassword.setText("启用");
        }
        mTvVipDatumDetailYe.setText(DateUtils.formatMoney(objBean.getBalance()));

        mTvVipDatumDetailJf.setText(objBean.getScore() + "");

        mTvVipDatumDetailCode.setText(objBean.getCardId());

        if (objBean.getState() == StatusKey.STATE_NO) {
            mTvVipDatumDetailZt.setText("禁用");
        } else if (objBean.getState() == StatusKey.STATE_YES) {
            mTvVipDatumDetailZt.setText("启用");
        }

        if (objBean.getGender() == StatusKey.FEMALE) {
            mTvVipDatumDetailSex.setText("女");
        } else if (objBean.getGender() == StatusKey.MALE) {
            mTvVipDatumDetailSex.setText("男");
        }

        mTvVipDatumDetailTime.setText(DateUtils.dateFormat(objBean.getRegisterDate()));

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_vip_datum_detail;
    }
}
