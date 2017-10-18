package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.iotek.merchantmanager.Presenter.LoginPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.Utils.SysUtil;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.params.LoginParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */
public class LoginActivity extends BaseActivity implements LoginPresenter.MvpView {

    @Bind(R.id.et_login_name) EditText mEtLoginName;

    @Bind(R.id.et_login_password) EditText mEtLoginPassword;

    @Bind(R.id.btn_login) Button mBtnLogin;

    private LoginPresenter mPresenter = new LoginPresenter();

    private String sysTime = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mPresenter.getSysTime();
    }

    @Override
    public void loginSuccess(String msg) {
        AppUtils.showToast(msg);
    }

    @Override
    public void showNetError(String msg) {
        AppUtils.showToast(msg);
    }

    @Override
    public void loginError(String msg) {
        AppUtils.showToast(msg);
    }

    @Override
    public void startHomeActivity() {
        launch(MainActivity.class);
    }

    @Override
    public String showSysTime(String time) {
        sysTime = time;
        return time;
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String loginName = mEtLoginName.getText().toString();
        String loginPassword = mEtLoginPassword.getText().toString();

        if (TextUtils.isEmpty(loginName)) {
            AppUtils.showToast("请输入用户名");
            return;
        }

        if (TextUtils.isEmpty(loginPassword)) {
            AppUtils.showToast("请输入密码");
            return;
        }

        String mac = SysUtil.getDeviceId(this);

        String md5Mac = SysUtil.md5(mac);

        Preference.putString(CacheKey.MAC, md5Mac);

        LogUtil.i("====>>>" + md5Mac);

        int versionCode = SysUtil.getVersionCode(this);

        mPresenter.login(new LoginParamsVO(sysTime,md5Mac,loginName,loginPassword,versionCode + ""), true);

    }


    private long exitTime = 0;

    @Override
    public void onBackPressed() {

        if ((System.currentTimeMillis() - exitTime) > 2000) {
            AppUtils.showToast("再按一次返回键退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
