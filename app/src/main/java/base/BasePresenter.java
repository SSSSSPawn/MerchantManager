package base;

import android.content.Context;

/**
 * Created by admin on 2017/8/23.
 */

public abstract class BasePresenter<V extends IMvpView> implements  Presenter<V>  {

    protected V mvpView;

    @Override
    public void attachView(V view) {
        mvpView = view;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    protected Context getContext(){

        if (mvpView == null){
            return mvpView.getContext();
        }

        return null;
    }
}
