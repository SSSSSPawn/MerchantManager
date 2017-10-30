package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.fragment.HistoryDataTypeFragment;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/30.
 */

public class HistoryListDataActivity extends BaseActivity {

    private HistoryDataTypeFragment mHistoryDataTypeFragment = new HistoryDataTypeFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, mHistoryDataTypeFragment).commit();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_empty_container;
    }
}
