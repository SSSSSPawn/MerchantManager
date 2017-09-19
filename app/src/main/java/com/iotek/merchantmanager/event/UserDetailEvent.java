package com.iotek.merchantmanager.event;

import com.iotek.merchantmanager.bean.UserManagerDetailVO;

/**
 * Created by admin on 2017/9/19.
 */

public class UserDetailEvent {

    public UserManagerDetailVO.RowsBean mRowsBean;

    public UserDetailEvent(UserManagerDetailVO.RowsBean rowsBean) {
        mRowsBean = rowsBean;
    }

}
