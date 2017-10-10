package com.iotek.merchantmanager.listener;

/**
 * Created by admin on 2017/9/22.
 */

public interface OnConfirmListener {

    void onConfirmDel(long userId);

    void onConfirmReset(long userId,long roleId);

    void onItemClick(int position);

}
