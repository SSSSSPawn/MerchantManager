package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iotek.merchantmanager.Presenter.AddVipDatumPresenter;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.view.AppBar;
import com.iotek.merchantmanager.view.BaseWheelFragment;
import com.iotek.merchantmanager.view.CommonWheelSelectedDialog;
import com.iotek.merchantmanager.view.CustomDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

import static com.iotek.merchantmanager.constant.CacheKey.CUST_ID;

/**
 * Created by admin on 2017/11/8.
 */

public class AddVipDatumActivity extends BaseActivity implements AddVipDatumPresenter.MvpView {

    @Bind(R.id.appBar) AppBar mAppBar;
    
    @Bind(R.id.et_vip_datum_membTel) EditText mEtVipDatumMembTel;
    
    @Bind(R.id.et_vip_datum_name) EditText mEtVipDatumName;
    
    @Bind(R.id.tv_vip_datum_level) TextView mTvVipDatumLevel;
    
    @Bind(R.id.et_vip_datum_card_id) EditText mEtVipDatumCardId;
    
    @Bind(R.id.tv_vip_datum_pswFlag) TextView mTvVipDatumPswFlag;
    
    @Bind(R.id.et_vip_datum_psw) EditText mEtVipDatumPsw;
    
    @Bind(R.id.tv_vip_datum_sex) TextView mTvVipDatumSex;
    
    @Bind(R.id.tv_vip_datum_birthday) TextView mTvVipDatumBirthday;
    
    @Bind(R.id.et_vip_datum_mail) EditText mEtVipDatumMail;
    
    @Bind(R.id.et_vip_datum_address) EditText mEtVipDatumAddress;
    
    @Bind(R.id.btn_submit) Button mBtnSubmit;
    
    private AddVipDatumPresenter mPresenter = new AddVipDatumPresenter();

    private CustomDatePicker mDatePicker;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);
        
        mAppBar.setTitle("新增会员");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        dateSelected();

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_add_vip_datum;
    }

    @Override
    public void showMsg(String msg) {

    }

    @OnClick({R.id.tv_vip_datum_level, R.id.tv_vip_datum_pswFlag, R.id.tv_vip_datum_sex, R.id.tv_vip_datum_birthday, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_vip_datum_level:
                numberSelected();
                break;
            case R.id.tv_vip_datum_pswFlag:
                passwordTagSelected();
                break;
            case R.id.tv_vip_datum_sex:
                genderSelected();
                break;
            case R.id.tv_vip_datum_birthday:
                mDatePicker.show(mTvVipDatumBirthday.getText().toString());
                break;
            case R.id.btn_submit:
                break;
        }
    }

    private void submitData(){
        long custID = Preference.getLong(CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        String tel = mEtVipDatumMembTel.getText().toString().trim();
        String vipName = mEtVipDatumName.getText().toString().trim();
        String vipLevel = mTvVipDatumLevel.getText().toString();
        String cardId = mEtVipDatumCardId.getText().toString().trim();
        String pswFlag = mTvVipDatumPswFlag.getText().toString();
        String pwd = mEtVipDatumPsw.getText().toString().trim();
        String sex = mTvVipDatumSex.getText().toString();
        String birthday = mTvVipDatumBirthday.getText().toString();
        String mail = mEtVipDatumMail.getText().toString().trim();
        String address = mEtVipDatumAddress.getText().toString().trim();



//        AddVipDatumParamsVO paramsVO = new AddVipDatumParamsVO(custID,rootID,uuID,mac,code,rankLevel,rankDiscount);
//        mPresenter.addVipDatum(paramsVO);

    }

    private void dateSelected() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        mTvVipDatumBirthday.setText(now.split(" ")[0]);

        mDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) {
                mTvVipDatumBirthday.setText(time.split(" ")[0]);
            }
        },"1900-01-01 00:00", now);

        mDatePicker.showSpecificTime(false); // 不显示时和分
        mDatePicker.setIsLoop(false); // 不允许循环滚动

    }

    private void numberSelected() {
        CommonWheelSelectedDialog dialog = CommonWheelSelectedDialog.newInstance(this, null,
                ViewGroup.LayoutParams.WRAP_CONTENT, CommonWheelSelectedDialog.Type.Number);
        dialog.show(getSupportFragmentManager(), "CommonWheelSelectedDialog");
        dialog.setOnSureListener(new BaseWheelFragment.OnSureListener() {
            @Override
            public void doSure(String item) {
                mTvVipDatumLevel.setText(item);
            }
        });
    }

    private void genderSelected() {
        CommonWheelSelectedDialog dialog = CommonWheelSelectedDialog.newInstance(this, null,
                ViewGroup.LayoutParams.WRAP_CONTENT, CommonWheelSelectedDialog.Type.Gender);
        dialog.show(getSupportFragmentManager(), "CommonWheelSelectedDialog");
        dialog.setOnSureListener(new BaseWheelFragment.OnSureListener() {
            @Override
            public void doSure(String item) {
                mTvVipDatumSex.setText(item);
            }
        });
    }

    private void passwordTagSelected() {
        CommonWheelSelectedDialog dialog = CommonWheelSelectedDialog.newInstance(this, null,
                ViewGroup.LayoutParams.WRAP_CONTENT, CommonWheelSelectedDialog.Type.Password);
        dialog.show(getSupportFragmentManager(), "CommonWheelSelectedDialog");
        dialog.setOnSureListener(new BaseWheelFragment.OnSureListener() {
            @Override
            public void doSure(String item) {
                mTvVipDatumPswFlag.setText(item);
            }
        });
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
