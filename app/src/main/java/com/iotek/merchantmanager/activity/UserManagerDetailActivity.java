package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.event.UserDetailEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    }

    @Override
    protected boolean isBindEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showUserDetail(UserDetailEvent event) {

        LogUtil.e("==========>>>>" + event.mRowsBean.toString());

        if (event != null && event.mRowsBean != null) {
            mTvNumber.setText(event.mRowsBean.getUserName());
            mTvName.setText(event.mRowsBean.getRealName());
            mTvStatus.setText(event.mRowsBean.getMystatus());
            mTvRole.setText(event.mRowsBean.getRolePname());
            mTvCustomNumber.setText(event.mRowsBean.getCustPhone());
            mTvCustomName.setText(event.mRowsBean.getCustName());
            mTvCode.setText(event.mRowsBean.getUserIdentity());
            mTvFoundTime.setText(event.mRowsBean.getRecordTime() + "");
            mTvLoginTime.setText(event.mRowsBean.getLoginTime() + "");
            mTvLastLoginTime.setText(event.mRowsBean.getLastLoginTime() + "");
            mTvLoginIp.setText(event.mRowsBean.getLoginIp());
            mTvLastLoginIp.setText(event.mRowsBean.getLastLoginIp());
        }
    }

    /**
     *
     * {
     "custId": 21,
     "custName": "亚青",
     "custPhone": "13605154259",
     "lastLoginIp": "121.237.61.160",
     "lastLoginTime": 1505801368450,
     "loginIp": "121.237.61.160",
     "loginTime": 1505803954093,
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
     },
     */
}
