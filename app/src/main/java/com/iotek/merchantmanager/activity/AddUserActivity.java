package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.view.AppBar;
import com.iotek.merchantmanager.view.BottomDialog;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/26.
 */

public class AddUserActivity extends BaseActivity {

    private AppBar mAppBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        mAppBar = (AppBar) findViewById(R.id.appBar);
        mAppBar.setTitle("添加用户");
        mAppBar.setTextColor(getResources().getColor(R.color.white));
        findViewById(R.id.tv_user_role).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BottomDialog(AddUserActivity.this)
                        .builder()
                        .setCanceledOnTouchOutside(true)
                        .setTitle("请选择用户角色")
                        .addSheetItem("商户管理员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        Toast.makeText(AddUserActivity.this, "item" + which, Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .addSheetItem("商户操作员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        Toast.makeText(AddUserActivity.this, "item" + which, Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .addSheetItem("商户营业员", BottomDialog.SheetItemColor.Blue,
                                new BottomDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        Toast.makeText(AddUserActivity.this, "item" + which, Toast.LENGTH_SHORT).show();
                                    }
                                }).show();
            }
        });


    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
