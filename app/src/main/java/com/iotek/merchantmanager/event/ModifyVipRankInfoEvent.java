package com.iotek.merchantmanager.event;

import com.iotek.merchantmanager.bean.QueryMembLevelVO;

/**
 * Created by admin on 2017/11/7.
 */

public class ModifyVipRankInfoEvent {


    public QueryMembLevelVO.RowsBean mRowsBean;

    public ModifyVipRankInfoEvent(QueryMembLevelVO.RowsBean rowsBean) {
        mRowsBean = rowsBean;
    }

    public QueryMembLevelVO.RowsBean getRowsBean() {
        return mRowsBean;
    }

    public void setRowsBean(QueryMembLevelVO.RowsBean rowsBean) {
        mRowsBean = rowsBean;
    }
}
