package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.iotek.merchantmanager.adapter.DataViewPagerAdapter;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.fragment.ReturnGoodsDataFragment;
import com.iotek.merchantmanager.fragment.SalesDataFragment;
import com.iotek.merchantmanager.view.AppBar;
import com.iotek.merchantmanager.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/17.
 */

public class TradeFormDetailActivity extends BaseActivity{

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.tabs) PagerSlidingTabStrip mTabStrip;

    @Bind(R.id.viewpager) ViewPager mViewPager;

    private String[] titles = new String[]{"销售数据", "退货数据"};

    private List<Fragment> mFragments = new ArrayList<>();

    private Fragment salesDataFragment,returnGoodsDataFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppBar.setTitle("数据明细");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        initView();
    }

    private void initView(){
        if (salesDataFragment == null){
            salesDataFragment = new SalesDataFragment();
        }
        if (returnGoodsDataFragment == null){
            returnGoodsDataFragment = new ReturnGoodsDataFragment();
        }
        mFragments.add(salesDataFragment);
        mFragments.add(returnGoodsDataFragment);

        mViewPager.setAdapter(new DataViewPagerAdapter(getSupportFragmentManager(),mFragments,titles));

        mTabStrip.setViewPager(mViewPager);

        mViewPager.setCurrentItem(0);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_trade_form_detail;
    }
}
