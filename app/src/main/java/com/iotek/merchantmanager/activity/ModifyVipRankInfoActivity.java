package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iotek.merchantmanager.Presenter.ModifyVipRankInfoPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.params.MembLevelEditParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.view.AppBar;
import com.iotek.merchantmanager.view.BaseWheelFragment;
import com.iotek.merchantmanager.view.CommonWheelSelectedDialog;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

import static com.iotek.merchantmanager.constant.CacheKey.CUST_ID;

/**
 * Created by admin on 2017/11/7.
 */

public class ModifyVipRankInfoActivity extends BaseActivity implements ModifyVipRankInfoPresenter.MvpView{

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.tv_vip_rank_code) TextView mTvVipRankCode;

    @Bind(R.id.et_vip_rank_level) EditText mEtVipRankLevel;

    @Bind(R.id.et_vip_rank_discount) EditText mEtVipRankDiscount;

    @Bind(R.id.btn_submit) Button mBtnSubmit;

    private ModifyVipRankInfoPresenter mPresenter = new ModifyVipRankInfoPresenter();

    private String uid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppBar.setTitle("修改会员信息");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        mPresenter.attachView(this);

        int membLevel = getIntent().getIntExtra("membLevel", -1);
        String levelName = getIntent().getStringExtra("levelName");
        String discount = getIntent().getStringExtra("discount");
        uid = getIntent().getStringExtra("uid");


        mTvVipRankCode.setText(membLevel + "");
        mEtVipRankLevel.setText(levelName);
        mEtVipRankDiscount.setText(discount);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_modify_vip_rank_info;
    }

    @OnClick({R.id.btn_submit,R.id.tv_vip_rank_code})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_submit:
                submitData();
                break;
            case R.id.tv_vip_rank_code:
               // numberSelected();
                break;
        }
    }

    private void numberSelected() {
        CommonWheelSelectedDialog dialog = CommonWheelSelectedDialog.newInstance(this, null,
                ViewGroup.LayoutParams.WRAP_CONTENT, CommonWheelSelectedDialog.Type.Number);
        dialog.show(getSupportFragmentManager(), "CommonWheelSelectedDialog_age");
        dialog.setOnSureListener(new BaseWheelFragment.OnSureListener() {
            @Override
            public void doSure(String item) {
                mTvVipRankCode.setText(item);
            }
        });
    }

    private void submitData(){
        long custID = Preference.getLong(CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        String rankCode = mTvVipRankCode.getText().toString();
        String rankLevel = mEtVipRankLevel.getText().toString().trim();
        String rankDiscount = mEtVipRankDiscount.getText().toString().trim();


        if (TextUtils.isEmpty(rankCode)) {
            AppUtils.showToast("请选择会员等级编号");
            return;
        }

        int code = Integer.valueOf(rankCode);

        if (TextUtils.isEmpty(rankLevel)) {
            AppUtils.showToast("等级名称不能为空");
            return;
        }

        if (TextUtils.isEmpty(rankDiscount)) {
            AppUtils.showToast("优惠折扣不能为空");
            return;
        }

        MembLevelEditParamsVO paramsVO = new MembLevelEditParamsVO(custID,rootID,uuID,mac,code,rankLevel,rankDiscount,uid);
        mPresenter.modifyVipRankInfo(paramsVO);

    }

    @Override
    public void showMsg(String msg) {
        AppUtils.showToast(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
