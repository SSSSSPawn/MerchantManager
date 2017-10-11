package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.base.BECFragment;
import com.iotek.merchantmanager.bean.TabMenus;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/10.
 */

public abstract class BECTabFragment extends BECFragment implements TabLayout.OnTabSelectedListener {

    @Bind(R.id.tab_menu) TabLayout mTabMenu;

    protected int mCurrentPosition = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bec_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabMenu.setTabMode(TabLayout.MODE_FIXED);
        mTabMenu.setOnTabSelectedListener(this);
        mTabMenu.setSelectedTabIndicatorColor(getIndicatorColor());

        for (int i = 0; i < getTabMenu().length; i++) {
            mTabMenu.addTab(mTabMenu.newTab().setCustomView(getTabView(i)));
        }

        setSelectedTab(mCurrentPosition);
        getChildFragmentManager().beginTransaction().add(R.id.fl_content, getTabMenu()[mCurrentPosition].mFragment).commit();

    }

    protected void setSelectedTab(int position) {
        mTabMenu.getTabAt(position).select();
        switchFragment(position);
    }

    private void switchFragment(int position) {
        if (position == mCurrentPosition) {
            return;
        }
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        Fragment to = getTabMenu()[position].mFragment;
        Fragment from = getTabMenu()[mCurrentPosition].mFragment;
        mCurrentPosition = position;

        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.fl_content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }

    protected int getIndicatorColor() {
        return getResources().getColor(R.color.becPrimaryBlue);
    }

    protected View getTabView(int position) {
        return AppUtils.getCustomTextTabView(getActivity(), getTabMenu()[position].name);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        setSelectedTab(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    protected abstract TabMenus[] getTabMenu();

}
