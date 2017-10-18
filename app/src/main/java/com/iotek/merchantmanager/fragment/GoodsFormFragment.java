package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.bean.TabMenus;

/**
 * Created by admin on 2017/10/11.
 */

public class GoodsFormFragment extends BECTabFragment {

    private TabMenus[] TAB_MENU = {
            new TabMenus("商品库存报表", new KcGoodsListFragment()),
            new TabMenus("商品出入库报表", new CrkGoodsListFragment())
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected TabMenus[] getTabMenu() {
        return TAB_MENU;
    }
}
