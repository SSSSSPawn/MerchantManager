package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bec.merchantmanager.Presenter.AddUserPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.AppUtils;
import com.bec.merchantmanager.Utils.IDCardUtil;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.Utils.VerUtil;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.params.AddUserParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.view.AppBar;
import com.bec.merchantmanager.view.BottomDialog;

import butterknife.Bind;
import butterknife.OnClick;

import static com.bec.merchantmanager.constant.CacheKey.CUST_ID;

/**
 * Created by admin on 2017/9/26.
 */

public class AddUserActivity extends BaseActivity implements AddUserPresenter.MvpView{

    @Bind(R.id.tv_user_role) TextView mTvUserRole;

    @Bind(R.id.et_login_number) EditText mEtLoginNumber;

    @Bind(R.id.et_login_password) EditText mEtLoginPassword;

    @Bind(R.id.et_submit_password) EditText mEtSubmitPassword;

    @Bind(R.id.et_user_name) EditText mEtUserName;

    @Bind(R.id.et_card_id) EditText mEtCardId;

    @Bind(R.id.btn_submit) Button mBtnSubmit;

    @Bind(R.id.appBar) AppBar mAppBar;

    private AddUserPresenter mPresenter = new AddUserPresenter();

    private AddUserParamsVO mParamsVO;

    private long roleId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAppBar.setTitle("添加用户");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

    }

    private void submitData(){

        long custID = Preference.getLong(CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        String role = mTvUserRole.getText().toString();
        String num = mEtLoginNumber.getText().toString().trim();
        String userName = mEtUserName.getText().toString().trim();
        String userIdentity = mEtCardId.getText().toString().trim();
        String userPasswd = mEtLoginPassword.getText().toString().trim();

        String userSubmitPassword = mEtSubmitPassword.getText().toString().trim();

        if (TextUtils.isEmpty(role)) {
            AppUtils.showToast("请选择用户角色");
            return;
        }

        if (TextUtils.isEmpty(num)) {
            AppUtils.showToast("登录账号不能为空");
            return;
        }

        boolean telNumber = VerUtil.isValidTelNumber(num);
        if (!telNumber) {
            AppUtils.showToast("请输入正确的手机号");
            return;
        }

        if (TextUtils.isEmpty(userPasswd)) {
            AppUtils.showToast("登录密码不能为空");
            return;
        }

        if (TextUtils.isEmpty(userSubmitPassword)) {
            AppUtils.showToast("请再次输入登录密码");
            return;
        }

        if (!userPasswd.equals(userSubmitPassword)) {
            AppUtils.showToast("两次输入的密码不一致,请重新输入");
            return;
        }

        if (TextUtils.isEmpty(userName)) {
            AppUtils.showToast("用户姓名不能为空");
            return;
        }

        if (TextUtils.isEmpty(userIdentity)) {
            AppUtils.showToast("身份证号码不能为空");
            return;
        }

        boolean cardValidate = IDCardUtil.iDCardValidate(userIdentity);
        if (!cardValidate) {
            AppUtils.showToast("请输入正确的身份证号码");
            return;
        }

        mParamsVO = new AddUserParamsVO(custID, rootID, uuID, mac, roleId, num, userName, userIdentity, userPasswd);
        mPresenter.userAdd(mParamsVO);

        finish();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_add_user;
    }

    @OnClick({R.id.tv_user_role, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_user_role:
                new BottomDialog(AddUserActivity.this)
                        .builder()
                        .setCanceledOnTouchOutside(true)
                        .setTitle("请选择用户角色")
                        .addSheetItem("商户管理员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        mTvUserRole.setText("商户管理员");
                                        roleId = 7;
                                    }
                                })
                        .addSheetItem("商户操作员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        mTvUserRole.setText("商户操作员");
                                        roleId = 8;
                                    }
                                })
                        .addSheetItem("商户营业员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        mTvUserRole.setText("商户营业员");
                                        roleId = 9;
                                    }
                                }).show();
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

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
