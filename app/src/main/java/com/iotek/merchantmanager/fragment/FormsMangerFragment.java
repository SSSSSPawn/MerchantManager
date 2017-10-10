package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.Presenter.FormsMangerPresenter;
import com.iotek.merchantmanager.base.BECFragment;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class FormsMangerFragment extends BECFragment implements FormsMangerPresenter.MvpView{

    public static final String TAG = "报表";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
