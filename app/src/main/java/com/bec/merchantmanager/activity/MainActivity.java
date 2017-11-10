package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bec.merchantmanager.Presenter.MainPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.base.BECFragment;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.TabMenus;
import com.bec.merchantmanager.fragment.FormsMangerFragment;
import com.bec.merchantmanager.fragment.MemberManagerFragment;
import com.bec.merchantmanager.fragment.SHManagerFragment;
import com.bec.merchantmanager.fragment.SWMangerFragment;
import com.bec.merchantmanager.fragment.UserOperateManagerFragment;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainPresenter.MvpView, TabLayout.OnTabSelectedListener {

    @Bind(R.id.tab_menu)
    TabLayout mTabMenu;

    private TabMenus[] TAB_MENUS = null;

    private int mCurrentPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initMenu();

        mTabMenu.setTabMode(TabLayout.MODE_FIXED);

        mTabMenu.setOnTabSelectedListener(this);

        mTabMenu.setSelectedTabIndicatorHeight(0);//隐藏指示条

        for (int i = 0; i < TAB_MENUS.length; i++) {
            mTabMenu.addTab(mTabMenu.newTab().setCustomView(getTabView(i)));
        }

        setSelectedTab(mCurrentPosition);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    private void initMenu() {
        TAB_MENUS = new TabMenus[]{
                new TabMenus(UserOperateManagerFragment.TAG, R.drawable.user_normal, R.drawable.user_selected, findFragment(UserOperateManagerFragment.class, UserOperateManagerFragment.TAG)),
                new TabMenus(FormsMangerFragment.TAG, R.drawable.form_normal, R.drawable.form_selected, findFragment(FormsMangerFragment.class, FormsMangerFragment.TAG)),
                new TabMenus(SHManagerFragment.TAG, R.drawable.sh_normal, R.drawable.sh_selected, findFragment(SHManagerFragment.class, SHManagerFragment.TAG)),
                new TabMenus(MemberManagerFragment.TAG, R.drawable.vip_normal, R.drawable.vip_selected, findFragment(MemberManagerFragment.class, MemberManagerFragment.TAG)),
                new TabMenus(SWMangerFragment.TAG, R.drawable.sw_normal, R.drawable.sw_selected, findFragment(SWMangerFragment.class, SWMangerFragment.TAG))
        };
    }

    private <T extends BECFragment> T findFragment(Class<T> clazz, String tag) {
        T fragment = (T) getSupportFragmentManager().findFragmentByTag(tag);
        try {
            return fragment == null ? clazz.newInstance() : fragment;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main_tab, null);
        ((TextView) view.findViewById(R.id.tv_name)).setText(TAB_MENUS[position].name);
        ((ImageView) view.findViewById(R.id.iv_icon)).setImageDrawable(TAB_MENUS[position].icon);
        return view;
    }

    private void switchFragment(int position) {
        BECFragment to = TAB_MENUS[position].mFragment;
        if (position == mCurrentPosition) {
            if (!to.isVisible()) {
                displayFragment(to);
            }
            return;
        }
        BECFragment from = TAB_MENUS[mCurrentPosition].mFragment;
        mCurrentPosition = position;
        getSupportFragmentManager().beginTransaction().hide(from).commit();
        displayFragment(to);
    }

    private void displayFragment(BECFragment fragment) {
        String tag = TAB_MENUS[mCurrentPosition].name;
        if (fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().show(fragment).commit();
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.content, fragment, tag).commit();
        }
    }

    @Override
    public void setSelectedTab(int position) {
        mTabMenu.getTabAt(position).select();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switchFragment(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
