package com.bec.merchantmanager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by admin on 2017/10/21.
 */

public class DataViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mList;

    private FragmentManager fm;

    private String[] titles;

    public DataViewPagerAdapter(FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);

        this.fm = fm;
        this.mList = list;
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
