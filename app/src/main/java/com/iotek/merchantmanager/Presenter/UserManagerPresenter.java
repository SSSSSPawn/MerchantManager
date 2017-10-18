package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.CodeMessageVO;
import com.iotek.merchantmanager.bean.params.QueryUserParamsVO;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.bean.params.UserParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.net.OnResponseListener;

import java.util.ArrayList;
import java.util.Iterator;

import retrofit2.Call;

/**
 * Created by admin on 2017/8/29.
 */

public class UserManagerPresenter extends BasePresenter<UserManagerPresenter.MvpView> {


    private final int LIMIT_SIZE = 10;


    private int currentPage, totalPage;

    private ArrayList<UserManagerDetailVO.RowsBean> mRowsBeen = new ArrayList<>();

    public void getFirstData(final int page) {

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        QueryUserParamsVO paramsVO =  new QueryUserParamsVO(custID,rootID,uuID,mac,LIMIT_SIZE,page);
        Call<UserManagerDetailVO> call = mApiService.queryUser(paramsVO);
        call.enqueue(new OnResponseListener<UserManagerDetailVO>(getContext(),false) {
            @Override
            public void onSuccess(UserManagerDetailVO userManagerDetailVO) {
                if (mvpView != null) {
                    if (userManagerDetailVO == null || userManagerDetailVO.getRows() == null) {
                        return;
                    }
                    if (page == 1) {
                        mRowsBeen.clear();
                    }
                    mRowsBeen.addAll(userManagerDetailVO.getRows());
                    mvpView.updateUserList(mRowsBeen);
                    currentPage = page;
                    totalPage = (int) Math.ceil(mRowsBeen.size() * 1.0 / LIMIT_SIZE);
                }
            }
        });
    }

    public void getNextData() {
        //TODO：存在刷新两次的问题，后台未返回总页数或总条目
        if (currentPage > totalPage){
            mvpView.stopLoadMore();
        }
        getFirstData(++currentPage);

//        if (currentPage < totalPage) {
//            getFirstData(++currentPage);
//        } else {
//            mvpView.stopLoadMore();
//        }
    }

    public void userResetPassword(final UserParamsVO userParamsVO) {
        Call<CodeMessageVO> call = mApiService.resetPasswds(userParamsVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), false) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {
                if (mvpView != null) {
                    mvpView.showMsg(codeMessageVO.getRspmsg());
                }
            }
        });
    }

    public void userDelete(final UserParamsVO queryUserVO) {
        Call<CodeMessageVO> call = mApiService.userDelete(queryUserVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), true) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {
                if (mvpView != null) {
                    if (CODE_SUCCESS == codeMessageVO.getRspcod()) {
                        long userId = queryUserVO.getUserId();
                        for (Iterator iterator = mRowsBeen.iterator(); iterator.hasNext(); ) {
                            UserManagerDetailVO.RowsBean rowsBean = (UserManagerDetailVO.RowsBean) iterator.next();
                            if (rowsBean.getUserId() == userId) {
                                iterator.remove();
                                mvpView.updateUserList(mRowsBeen);
                            }
                        }
                        mvpView.showMsg(codeMessageVO.getRspmsg());
                    } else {
                        mvpView.showMsg(codeMessageVO.getRspmsg());
                    }
                }
            }
        });
    }

    public interface MvpView extends IMvpView {

        void updateUserList(ArrayList<UserManagerDetailVO.RowsBean> lists);

        void stopLoadMore();

        void showMsg(String msg);
    }
}
