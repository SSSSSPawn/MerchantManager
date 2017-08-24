package com.iotek.merchantmanager.base;

/**
 * Created by admin on 2017/8/23.
 */

public interface Presenter<V> {

    void attachView(V view);

    void detachView();
}
