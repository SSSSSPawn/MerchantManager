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

    public void addUser(AddUserParamsVO paramsVO){
        Call<CodeMessageVO> call = mApiService.userAdd(paramsVO);
        call.enqueue(new OnResponseListener<CodeMessageVO>(getContext(),false) {
            @Override
            public void onSuccess(CodeMessageVO codeMessageVO) {

            }
        });
    }


    public interface MvpView extends IMvpView{

    }

}
