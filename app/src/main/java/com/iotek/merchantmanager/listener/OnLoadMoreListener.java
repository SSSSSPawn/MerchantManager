package com.iotek.merchantmanager.listener;

public interface OnLoadMoreListener {
    /**
     * @param overallItemsCount
     * @param itemsBeforeMore
     * @param maxLastVisiblePosition for staggered grid this is max of all spans
     */
    void onLoadMore(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition);
}