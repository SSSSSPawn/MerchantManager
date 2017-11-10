package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;

/**
 * Created by admin on 2017/8/23.
 */

public class MainPresenter extends BasePresenter<MainPresenter.MvpView> {

    public interface MvpView extends IMvpView {
        void setSelectedTab(int position);
    }
}
