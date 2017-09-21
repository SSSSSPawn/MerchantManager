package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.constant.StatusKey;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/9/19.
 */

public class UserManagerDetailActivity extends BaseActivity {

    @Bind(R.id.tv_number)
    TextView mTvNumber;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_status)
    TextView mTvStatus;
    @Bind(R.id.tv_role)
    TextView mTvRole;
    @Bind(R.id.tv_custom_number)
    TextView mTvCustomNumber;
    @Bind(R.id.tv_custom_name)
    TextView mTvCustomName;
    @Bind(R.id.tv_code)
    TextView mTvCode;
    @Bind(R.id.tv_found_time)
    TextView mTvFoundTime;
    @Bind(R.id.tv_login_time)
    TextView mTvLoginTime;
    @Bind(R.id.tv_last_login_time)
    TextView mTvLastLoginTime;
    @Bind(R.id.tv_login_ip)
    TextView mTvLoginIp;
    @Bind(R.id.tv_last_login_ip)
    TextView mTvLastLoginIp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        showUserDetail();
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    private void showUserDetail() {
        UserManagerDetailVO.RowsBean rowsBean = (UserManagerDetailVO.RowsBean) getIntent().getSerializableExtra(Intentkey.USER_DETAIL);

        LogUtil.e("==========>>>>" + rowsBean.toString());

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

    /**
     *
     "custId": 21,
     "custName": "亚青",
     "custPhone": "13605154259",
     "lastLoginIp": "222.95.167.98",
     "lastLoginTime": 1505871339959,
     "loginIp": "222.95.167.98",
     "loginTime": 1505872208510,
     "mystatus": 1,
     "realName": "张月仙",
     "recordTime": 1504163353038,
     "roleId": 7,
     "rolePname": "商户管理员",
     "sysId": 3,
     "userId": 83,
     "userIdentity": "320589636987541210",
     "userName": "13814689521",
     "userStatus": 1
     */


}
