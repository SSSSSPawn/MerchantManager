package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bec.merchantmanager.base.BECFragment;
import com.bec.merchantmanager.listener.OnTabClickListener;
import com.bec.merchantmanager.view.TitleTabLayout;

import butterknife.Bind;
import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class MemberManagerFragment extends BECFragment {

    public static final String TAG = "会员";

    @Bind(R.id.tab_title) TitleTabLayout mTabLayout;

    private VipManagerFragment mVipManagerFragment = new VipManagerFragment();

    private VipScoreFragment mVipScoreFragment = new VipScoreFragment();

    private boolean isLeft = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vip, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabLayout.addLeftTab("会员管理", new OnTabClickListener() {
            @Override
            public void onTabClick() {
                switchFragment(true);
            }
        });

        mTabLayout.addRightTab("积分管理", new OnTabClickListener() {
            @Override
            public void onTabClick() {
                switchFragment(false);
            }
        });

        getChildFragmentManager().beginTransaction().add(R.id.fl_content, mVipManagerFragment).commit();
    }

    private void switchFragment(boolean flag) {
        if (isLeft == flag) {
            return;
        }

        isLeft = flag;

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        Fragment from = mVipManagerFragment;
        Fragment to = mVipScoreFragment;

        if (isLeft) {
            to = mVipManagerFragment;
            from = mVipScoreFragment;
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
