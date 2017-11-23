package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bec.merchantmanager.Presenter.VipDatumDetailPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.AppUtils;
import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.CodeMessageVO;
import com.bec.merchantmanager.bean.VipDatumDataVO;
import com.bec.merchantmanager.bean.params.MembMoneyResetParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.constant.StatusKey;
import com.bec.merchantmanager.view.AppBar;
import com.bec.merchantmanager.view.CustomDialog;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by admin on 2017/11/8.
 */

public class VipDatumDetailActivity extends BaseActivity implements VipDatumDetailPresenter.MvpView{

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

    @Bind(R.id.btn_membMoneyReset) Button BtnMembMoneyReset;

    private VipDatumDetailPresenter mPresenter = new VipDatumDetailPresenter();

    private VipDatumDataVO.ObjBean objBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAppBar.setTitle("会员资料详情");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        objBean = (VipDatumDataVO.ObjBean) getIntent().getSerializableExtra(Intentkey.VIP_DATUM_DETAIL);

        showVipDatumDetail();
    }

    private void showVipDatumDetail() {
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

    @OnClick(R.id.btn_membMoneyReset)
    public void onViewClicked() {
        final CustomDialog dialog = new CustomDialog(this);
        dialog.setOkButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                String uid = objBean.getUid();

                long custID = Preference.getLong(CacheKey.CUST_ID);
                long rootID = Preference.getLong(CacheKey.ROOT_ID);
                String uuID = Preference.getString(CacheKey.UU_ID);
                String mac = Preference.getString(CacheKey.MAC);

                MembMoneyResetParamsVO paramsVO = new MembMoneyResetParamsVO(custID,rootID,mac,uuID,uid);

                mPresenter.membMoneyResetData(paramsVO);
            }
        });
        dialog.show("提示信息","确定将会员的余额和积分归零吗?");
        dialog.setMessageSize(16);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_vip_datum_detail;
    }

    @Override
    public void showMsg(CodeMessageVO msg) {
        if (msg.getRspcod() == 200) {
            mTvVipDatumDetailYe.setText(DateUtils.formatMoney(0));
            mTvVipDatumDetailJf.setText("0");
        }
        AppUtils.showToast(msg.getRspmsg());
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
