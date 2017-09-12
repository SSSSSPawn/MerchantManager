package com.iotek.merchantmanager.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Window;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/12.
 */

public class BECDialog extends BaseDialog {

    private boolean noTitle = true;


    public BECDialog(@NonNull Context context) {
        super(context, R.style.Dialog_NullBackground);
        if (noTitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }

    public BECDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        if (noTitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setNoTitle(boolean noTitle) {
        this.noTitle = noTitle;
    }
}
