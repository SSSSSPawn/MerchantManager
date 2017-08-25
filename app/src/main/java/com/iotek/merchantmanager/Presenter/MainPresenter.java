package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;

/**
 * Created by admin on 2017/8/23.
 */

public class MainPresenter extends BasePresenter<MainPresenter.MvpView> {

    public interface MvpView extends IMvpView {
        void setSelectedTab(int position);
    }
}
