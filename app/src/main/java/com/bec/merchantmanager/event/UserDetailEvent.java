package com.bec.merchantmanager.event;

import com.bec.merchantmanager.bean.UserManagerDetailVO;

/**
 * Created by admin on 2017/9/19.
 */

public class UserDetailEvent {

    public UserManagerDetailVO.RowsBean mRowsBean;

    public UserDetailEvent(UserManagerDetailVO.RowsBean rowsBean) {
        mRowsBean = rowsBean;
    }

}
