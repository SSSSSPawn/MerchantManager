package Presenter;

import base.BasePresenter;
import base.IMvpView;

/**
 * Created by admin on 2017/8/23.
 */

public class LoginPresenter extends BasePresenter<LoginPresenter.MvpView>{

    public void login(String name,String password){

        //TODO:登陆逻辑处理
    }


    public interface MvpView extends IMvpView{

        void loginSuccess(String msg);

        void loginError(String msg);
    }
}
