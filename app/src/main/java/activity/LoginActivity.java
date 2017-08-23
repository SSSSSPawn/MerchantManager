package activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import Presenter.LoginPresenter;
import base.BaseActivity;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class LoginActivity extends BaseActivity implements LoginPresenter.MvpView {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    public void loginSuccess(String msg) {

    }

    @Override
    public void loginError(String msg) {

    }
}
