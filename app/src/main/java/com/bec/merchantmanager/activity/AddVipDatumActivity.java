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

import com.bec.merchantmanager.Presenter.AddVipDatumPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.AppUtils;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.Utils.VerUtil;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.params.AddVipDatumParamsVO;
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

import static com.bec.merchantmanager.constant.CacheKey.CUST_ID;

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

    @Bind(R.id.ll_password) LinearLayout mLayoutPassword;
    
    @Bind(R.id.tv_vip_datum_sex) TextView mTvVipDatumSex;
    
    @Bind(R.id.tv_vip_datum_birthday) TextView mTvVipDatumBirthday;
    
    @Bind(R.id.et_vip_datum_mail) EditText mEtVipDatumMail;
    
    @Bind(R.id.et_vip_datum_address) EditText mEtVipDatumAddress;
    
    @Bind(R.id.btn_submit) Button mBtnSubmit;
    
    private AddVipDatumPresenter mPresenter = new AddVipDatumPresenter();

    private CustomDatePicker mDatePicker;

    private int pwdIsShow;

    private int sexFlag;


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
        AppUtils.showToast(msg);
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
                submitData();
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

        if (TextUtils.isEmpty(tel)){
            AppUtils.showToast("账号不能为空");
            return;
        }

        boolean telNumber = VerUtil.isValidTelNumber(tel);
        if (!telNumber) {
            AppUtils.showToast("请输入正确的手机号");
            return;
        }

        if (TextUtils.isEmpty(vipName)){
            AppUtils.showToast("会员姓名不能为空");
            return;
        }

        if (TextUtils.isEmpty(vipLevel)){
            AppUtils.showToast("请选择会员等级");
            return;
        }

        int code = Integer.valueOf(vipLevel);

//        if (TextUtils.isEmpty(cardId)){
//            AppUtils.showToast("请输入身份证号码");
//        }
//
//        boolean cardValidate = IDCardUtil.iDCardValidate(cardId);
//        if (!cardValidate) {
//            AppUtils.showToast("身份证号码格式不正确，请重新输入");
//            return;
//        }

        if (TextUtils.isEmpty(pswFlag)) {
            AppUtils.showToast("请选择是否启用密码");
            return;
        }

        if (TextUtils.isEmpty(sex)) {
            AppUtils.showToast("请选择性别");
            return;
        }

//        if (TextUtils.isEmpty(mail)){
//            AppUtils.showToast("请输入邮箱");
//            return;
//        }
//
//        boolean checkEmail = VerUtil.checkEmail(mail);
//        if (!checkEmail){
//            AppUtils.showToast("请输入正确的邮箱");
//            return;
//        }
//
//        if (TextUtils.isEmpty(address)){
//            AppUtils.showToast("请输入地址");
//            return;
//        }


        AddVipDatumParamsVO paramsVO ;

        if (mLayoutPassword.getVisibility() == View.VISIBLE) {
            if (TextUtils.isEmpty(pwd)) {
                AppUtils.showToast("请输入六位数字密码");
                return;
            }
            paramsVO = new AddVipDatumParamsVO(custID, rootID, uuID, mac, tel, code , vipName, pwdIsShow, pwd, sexFlag);

        } else {
            paramsVO = new AddVipDatumParamsVO(custID, rootID, uuID, mac, tel, code, vipName, pwdIsShow, sexFlag);
        }

        mPresenter.addVipDatum(paramsVO);

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
        });

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
                if (item.equals("男")) {
                    sexFlag = 1;
                } else {
                    sexFlag = 0;
                }
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
                if (item.equals("免密")) {
                    pwdIsShow = 0;
                    mLayoutPassword.setVisibility(View.GONE);
                } else {
                    pwdIsShow = 1;
                    mLayoutPassword.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
