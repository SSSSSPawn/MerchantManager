package com.bec.merchantmanager.bean;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by admin on 2017/9/1.
 */

public class BaseBean implements Serializable {

    @Override
    public String toString() {
        return new Gson().toString();
    }
}
