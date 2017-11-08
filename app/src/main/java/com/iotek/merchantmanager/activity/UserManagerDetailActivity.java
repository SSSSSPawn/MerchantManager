package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.constant.StatusKey;
import com.iotek.merchantmanager.view.AppBar;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/19.
 */

public class UserManagerDetailActivity extends BaseActivity {

    @Bind(R.id.tv_number) TextView mTvNumber;

    @Bind(R.id.tv_name) TextView mTvName;

    @Bind(R.id.tv_status) TextView mTvStatus;

    @Bind(R.id.tv_role) TextView mTvRole;

    @Bind(R.id.tv_custom_number) TextView mTvCustomNumber;

    @Bind(R.id.tv_custom_name) TextView mTvCustomName;

    @Bind(R.id.tv_code) TextView mTvCode;

    @Bind(R.id.tv_found_time) TextView mTvFoundTime;

    @Bind(R.id.tv_login_time) TextView mTvLoginTime;

    @Bind(R.id.tv_last_login_time) TextView mTvLastLoginTime;

    @Bind(R.id.tv_login_ip) TextView mTvLoginIp;

    @Bind(R.id.tv_last_login_ip) TextView mTvLastLoginIp;

    @Bind(R.id.appBar) AppBar mAppBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAppBar.setTitle("操作员详情");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        showUserDetail();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_user_detail;
    }

    private void showUserDetail() {
        UserManagerDetailVO.RowsBean rowsBean = (UserManagerDetailVO.RowsBean) getIntent().getSerializableExtra(Intentkey.USER_DETAIL);

        if (!TextUtils.isEmpty(rowsBean.toString())) {
            mTvNumber.setText(rowsBean.getUserName());
            mTvName.setText(rowsBean.getRealName());
            if (StatusKey.NORMAL_CODE.equals(rowsBean.getMystatus())) {
                mTvStatus.setText(StatusKey.NORMAL);
            }
            mTvRole.setText(rowsBean.getRolePname());
            mTvCustomNumber.setText(rowsBean.getCustPhone());
            mTvCustomName.setText(rowsBean.getCustName());
            mTvCode.setText(rowsBean.getUserIdentity());
            mTvFoundTime.setText(DateUtils.dateFormat(rowsBean.getRecordTime()));
            mTvLoginTime.setText(DateUtils.dateFormat(rowsBean.getLastLoginTime()));
            mTvLastLoginTime.setText(DateUtils.dateFormat(rowsBean.getLoginTime()));
            mTvLoginIp.setText(rowsBean.getLoginIp());
            mTvLastLoginIp.setText(rowsBean.getLastLoginIp());
        }
    }
}
