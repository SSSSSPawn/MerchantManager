package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.TabMenus;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/10.
 */

public abstract class BECTabActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{

    @Bind(R.id.tab_menu) TabLayout mTabMenu;

    protected int mCurrentPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTabMenu.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabMenu.setOnTabSelectedListener(this);
        mTabMenu.setSelectedTabIndicatorColor(getIndicatorColor());

        for (int i = 0 ;i<getTabMenu().length;i++){
            mTabMenu.addTab(mTabMenu.newTab().setCustomView(getTabView(i)));
        }

        setSelectedTab(mCurrentPosition);
        getSupportFragmentManager().beginTransaction().add(R.id.content, getTabMenu()[mCurrentPosition].mFragment).commit();

    }

    protected void setSelectedTab(int position){
        mTabMenu.getTabAt(position).select();
        switchFragment(position);
    }

    private void switchFragment(int position) {
        if (position == mCurrentPosition) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment to = getTabMenu()[position].mFragment;
        Fragment from = getTabMenu()[mCurrentPosition].mFragment;
        mCurrentPosition = position;

        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }

    protected int getIndicatorColor(){
        return getResources().getColor(R.color.becPrimaryBlue);
    }

    protected View getTabView(int position){
        return AppUtils.getCustomTextTabView(this,getTabMenu()[position].name);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_bec_tab;
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
