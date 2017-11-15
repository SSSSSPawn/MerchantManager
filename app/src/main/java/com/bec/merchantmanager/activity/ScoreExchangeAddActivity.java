package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bec.merchantmanager.Presenter.ScoreExchangeAddPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.AppUtils;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.Utils.VerUtil;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.params.ScoreExchangeAddParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.view.AppBar;
import com.bec.merchantmanager.view.BaseWheelFragment;
import com.bec.merchantmanager.view.CommonWheelSelectedDialog;
import com.bec.merchantmanager.view.CustomDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by admin on 2017/11/14.
 */

public class ScoreExchangeAddActivity extends BaseActivity implements ScoreExchangeAddPresenter.MvpView{


    @Bind(R.id.appBar) AppBar mAppBar;
    @Bind(R.id.et_vip_score_bh) EditText mEtVipScoreBh;
    @Bind(R.id.et_vip_score_jf) EditText mEtVipScoreJf;
    @Bind(R.id.et_vip_score_fs) TextView mEtVipScoreFs;
    @Bind(R.id.ll_vip_score_name) LinearLayout ll_vip_score_name;
    @Bind(R.id.tv_vip_score_name) TextView tv_vip_score_name;
    @Bind(R.id.et_vip_score_name) EditText et_vip_score_name;
    @Bind(R.id.et_vip_score_start_time) TextView mEtVipScoreStartTime;
    @Bind(R.id.et_vip_score_end_time) TextView mEtVipScoreEndTime;
    @Bind(R.id.btn_submit) Button mBtnSubmit;

    private CustomDatePicker mStartDatePicker,mEndDatePicker;

    private ScoreExchangeAddPresenter mPresenter = new ScoreExchangeAddPresenter();

    private int mExchangeMode = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAppBar.setTextColor(getResources().getColor(R.color.white));
        mAppBar.setTitle("新增兑换规则");

        startDateSelected();
        endDateSelected();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_add_score_exchange;
    }

    @OnClick({R.id.et_vip_score_fs, R.id.et_vip_score_start_time, R.id.et_vip_score_end_time, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_vip_score_fs:
                exchangeSelected();
                break;
            case R.id.et_vip_score_start_time:
                mStartDatePicker.show(mEtVipScoreStartTime.getText().toString());
                break;
            case R.id.et_vip_score_end_time:
                mEndDatePicker.show(mEtVipScoreEndTime.getText().toString());
                break;
            case R.id.btn_submit:
                submitData();
                break;
        }
    }

    private void submitData() {
        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        String vipScoreBh = mEtVipScoreBh.getText().toString().trim();
        String vipScoreJf = mEtVipScoreJf.getText().toString().trim();
        String vipScoreFs = mEtVipScoreFs.getText().toString();
        String name = et_vip_score_name.getText().toString().trim();
        String startTiem = mEtVipScoreStartTime.getText().toString();
        String endTime = mEtVipScoreEndTime.getText().toString();


        if (TextUtils.isEmpty(vipScoreBh)) {
            AppUtils.showToast("请输入规则编号");
            return;
        }
        if (!VerUtil.isNumeric(vipScoreBh)){
            AppUtils.showToast("输入有误,编号只能为正整数");
            return;
        }

        if (TextUtils.isEmpty(vipScoreJf)) {
            AppUtils.showToast("请输入兑换的所需积分");
            return;
        }

        if (!VerUtil.isNumeric(vipScoreJf)){
            AppUtils.showToast("输入有误,积分只能为正整数");
            return;
        }

        int intVipScoreJf = Integer.valueOf(vipScoreJf);

        if (TextUtils.isEmpty(vipScoreFs)) {
            AppUtils.showToast("请选择兑换方式");
            return;
        }

        ScoreExchangeAddParamsVO paramsVO = null;

        if (vipScoreFs.equals("礼品券")) {
            if (TextUtils.isEmpty(name)) {
                AppUtils.showToast("请输入礼品名称");
                return;
            }
            paramsVO = new ScoreExchangeAddParamsVO(custID, rootID, uuID, mac, vipScoreBh, intVipScoreJf, mExchangeMode, name, startTiem, endTime);
        } else {
            if (TextUtils.isEmpty(name)) {
                AppUtils.showToast("请输入现金券金额");
                return;
            }
            if (!VerUtil.isNumericc(name)) {
                AppUtils.showToast("现金券金额只能输入数字,请重新输入");
                return;
            }
            double voucher = Double.valueOf(name);
            paramsVO = new ScoreExchangeAddParamsVO(custID, rootID, uuID, mac, vipScoreBh, intVipScoreJf, mExchangeMode, voucher, startTiem, endTime);
        }

        mPresenter.scoreExchangeAdd(paramsVO);

    }


    private void exchangeSelected() {
        CommonWheelSelectedDialog dialog = CommonWheelSelectedDialog.newInstance(this, null,
                ViewGroup.LayoutParams.WRAP_CONTENT, CommonWheelSelectedDialog.Type.ExchangeMode);
        dialog.show(getSupportFragmentManager(), "CommonWheelSelectedDialog");
        dialog.setOnSureListener(new BaseWheelFragment.OnSureListener() {
            @Override
            public void doSure(String item) {
                mEtVipScoreFs.setText(item);
                if (item.equals("礼品券")) {
                    ll_vip_score_name.setVisibility(View.VISIBLE);
                    tv_vip_score_name.setText("礼品名称");
                    mExchangeMode = 1;
                } else {
                    ll_vip_score_name.setVisibility(View.VISIBLE);
                    tv_vip_score_name.setText("现金券金额");
                    mExchangeMode = 2;
                }
            }
        });
    }

    private void startDateSelected() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        mEtVipScoreStartTime.setText(now.split(" ")[0]);

        mStartDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) {
                mEtVipScoreStartTime.setText(time.split(" ")[0]);
            }
        });

        mStartDatePicker.showSpecificTime(false); // 不显示时和分
        mStartDatePicker.setIsLoop(false); // 不允许循环滚动
    }

    private void endDateSelected() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        mEtVipScoreEndTime.setText(now.split(" ")[0]);

        mEndDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) {
                mEtVipScoreEndTime.setText(time.split(" ")[0]);
            }
        });

        mEndDatePicker.showSpecificTime(false); // 不显示时和分
        mEndDatePicker.setIsLoop(false); // 不允许循环滚动
    }

    @Override
    public void showMsg(String msg) {
        AppUtils.showToast(msg);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
