package activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import Presenter.LoginPresenter;
import base.BaseActivity;
import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class LoginActivity extends BaseActivity implements LoginPresenter.MvpView {

    private LoginPresenter mPresenter = new LoginPresenter();

    @Bind(R.id.btn_login)
    Button mBtnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter.attachView(this);

    }

    @Override
    public void loginSuccess(String msg) {

    }

    @Override
    public void loginError(String msg) {

    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        launch(MainActivity.class);
    }
}
