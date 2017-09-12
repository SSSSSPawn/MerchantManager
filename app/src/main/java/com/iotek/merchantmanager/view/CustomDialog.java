package com.iotek.merchantmanager.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.iotek.merchantmanager.base.BECDialog;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/12.
 */

public class CustomDialog extends BECDialog {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_message)
    TextView mTvMessage;
    @Bind(R.id.btn_ok)
    Button mBtnOk;
    @Bind(R.id.btn_cancel)
    Button mBtnCancel;

    public CustomDialog(@NonNull Context context) {
        super(context);
        setNoTitle(false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_alert);
        setCancelButton(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public void setCancelButton(View.OnClickListener listener) {
        mBtnCancel.setOnClickListener(listener);
    }

    public void setCancelButton(String text,View.OnClickListener listener) {
        mBtnCancel.setText(text);
        mBtnCancel.setOnClickListener(listener);
    }

    public void setOkButton(View.OnClickListener listener){
        mBtnOk.setOnClickListener(listener);
    }
    public void setOkButton(String text,View.OnClickListener listener){
        mBtnOk.setText(text);
        mBtnOk.setOnClickListener(listener);
    }

    public void show(String text,String message){
        mTvTitle.setText(text);
        mTvMessage.setText(message);
        super.show();
    }

    public void show(String message){
        mTvTitle.setVisibility(View.GONE);
        mTvMessage.setText(message);
        super.show();
    }

    public void setMessageSize(int size){
        mTvMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void hideCancelButton(){
        mBtnCancel.setVisibility(View.GONE);
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
