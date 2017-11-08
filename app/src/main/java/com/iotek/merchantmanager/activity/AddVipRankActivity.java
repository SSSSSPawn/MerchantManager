package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iotek.merchantmanager.Presenter.AddVipRankPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.params.AddVipRankParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.view.AppBar;
import com.iotek.merchantmanager.view.BaseWheelFragment;
import com.iotek.merchantmanager.view.CommonWheelSelectedDialog;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

import static com.iotek.merchantmanager.constant.CacheKey.CUST_ID;

/**
 * Created by admin on 2017/11/6.
 */

public class AddVipRankActivity extends BaseActivity implements AddVipRankPresenter.MvpView{

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.tv_vip_rank_code) TextView mTvVipRankCode;

    @Bind(R.id.et_vip_rank_level) EditText mEtVipRankLevel;

    @Bind(R.id.et_vip_rank_discount) EditText mEtVipRankDiscount;

    @Bind(R.id.btn_submit) Button mBtnSubmit;

    private AddVipRankPresenter mPresenter = new AddVipRankPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mAppBar.setTitle("新增会员等级");
        mAppBar.setTextColor(getResources().getColor(R.color.white));
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_vip_rank;
    }

    @OnClick({R.id.tv_vip_rank_code, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_vip_rank_code:
                numberSelected();
                break;
            case R.id.btn_submit:
                submitData();
                break;
        }
    }

    @Override
    public void showMsg(String msg) {
        AppUtils.showToast(msg);
    }

    private void numberSelected() {
        CommonWheelSelectedDialog dialog = CommonWheelSelectedDialog.newInstance(this, null,
                ViewGroup.LayoutParams.WRAP_CONTENT, CommonWheelSelectedDialog.Type.Number);
        dialog.show(getSupportFragmentManager(), "CommonWheelSelectedDialog");
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

        AddVipRankParamsVO paramsVO = new AddVipRankParamsVO(custID,rootID,uuID,mac,code,rankLevel,rankDiscount);
        mPresenter.addVipRank(paramsVO);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
