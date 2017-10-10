package com.iotek.merchantmanager.Presenter;

import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.AddUserParamsVO;
import com.iotek.merchantmanager.bean.CodeMessageVO;
import com.iotek.merchantmanager.net.OnResponseListener;

import retrofit2.Call;

/**
 * Created by admin on 2017/9/28.
 */

public class AddUserPresenter extends BasePresenter<AddUserPresenter.MvpView> {

    public void userAdd(AddUserParamsVO paramsVO) {
        Call<CodeMessageVO> call = mApiService.userAdd(paramsVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(), true) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {
                if (mvpView != null) {
                    mvpView.showMsg(codeMessageVO.getRspmsg());
                }
            }
        });
    }


    public interface MvpView extends IMvpView{
        void showMsg(String msg);
    }

}
