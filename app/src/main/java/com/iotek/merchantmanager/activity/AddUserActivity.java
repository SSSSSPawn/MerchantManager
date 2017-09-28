package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.view.AppBar;
import com.iotek.merchantmanager.view.BottomDialog;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/26.
 */

public class AddUserActivity extends BaseActivity {

    @Bind(R.id.tv_user_role) TextView mTvUserRole;

    @Bind(R.id.et_login_number) EditText mEtLoginNumber;

    @Bind(R.id.et_login_password) EditText mEtLoginPassword;

    @Bind(R.id.et_submit_password) EditText mEtSubmitPassword;

    @Bind(R.id.et_user_name) EditText mEtUserName;

    @Bind(R.id.et_card_id) EditText mEtCardId;

    @Bind(R.id.btn_submit) Button mBtnSubmit;

    @Bind(R.id.appBar) AppBar mAppBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTitle("添加用户");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_add_user;
    }

    @OnClick({R.id.tv_user_role, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_user_role:
                new BottomDialog(AddUserActivity.this)
                        .builder()
                        .setCanceledOnTouchOutside(true)
                        .setTitle("请选择用户角色")
                        .addSheetItem("商户管理员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        mTvUserRole.setText("商户管理员");
                                    }
                                })
                        .addSheetItem("商户操作员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        mTvUserRole.setText("商户操作员");
                                    }
                                })
                        .addSheetItem("商户营业员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        mTvUserRole.setText("商户营业员");
                                    }
                                }).show();
                break;
            case R.id.btn_submit:
                break;
        }
    }
}
