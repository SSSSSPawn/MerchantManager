package com.bec.merchantmanager.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;

import com.bec.merchantmanager.base.BECDialog;

import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/9/13.
 */

public class LoadingDialog extends BECDialog {


    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_loading);
    }

    public static LoadingDialog show(Context context) {
        LoadingDialog dialog = new LoadingDialog(context);

        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dialog;
    }
}
