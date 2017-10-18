package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.base.BECFragment;
import com.iotek.merchantmanager.listener.OnTabClickListener;
import com.iotek.merchantmanager.view.TitleTabLayout;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class FormsMangerFragment extends BECFragment {

    public static final String TAG = "报表";

    @Bind(R.id.tab_title) TitleTabLayout mTabTitle;

    private TradeFormFragment mTradeFormFragment = new TradeFormFragment();

    private GoodsFormFragment mGoodsFormFragment = new GoodsFormFragment();

    private boolean isLeft = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabTitle.addLeftTab("交易报表", new OnTabClickListener() {
            @Override
            public void onTabClick() {
                switchFragment(true);
            }
        });

        mTabTitle.addRightTab("商品报表", new OnTabClickListener() {
            @Override
            public void onTabClick() {
                switchFragment(false);
            }
        });

        getChildFragmentManager().beginTransaction().add(R.id.fl_content, mTradeFormFragment).commit();

    }

    private void switchFragment(boolean flag) {
        if (isLeft == flag) {
            return;
        }

        isLeft = flag;

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        Fragment from = mTradeFormFragment;
        Fragment to = mGoodsFormFragment;

        if (isLeft) {
            to = mTradeFormFragment;
            from = mGoodsFormFragment;
        }

        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.fl_content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
