package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bec.merchantmanager.base.BECFragment;

/**
 * Created by admin on 2017/8/23.
 */

public class SHManagerFragment extends BECFragment {

    public static final String TAG = "商户";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected boolean isBindEventBus() {
        return false;
    }

}
