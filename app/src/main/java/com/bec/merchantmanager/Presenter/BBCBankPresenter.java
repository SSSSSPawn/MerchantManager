package com.bec.merchantmanager.Presenter;

import com.bec.merchantmanager.base.BasePresenter;
import com.bec.merchantmanager.base.IMvpView;
import com.bec.merchantmanager.bean.BBCBankVO;
import com.bec.merchantmanager.net.HttpExecutor;
import com.bec.merchantmanager.net.OnResponseListener;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by admin on 2017/10/17.
 */

public class BBCBankPresenter extends BasePresenter<BBCBankPresenter.MvpView> {

    public void gotoBBC() {
        Map<String, Long> params = new HashMap<>();
        params.put("custId", (long) 3);

        String paramsJson = gson.toJson(params);

        RequestBody body = RequestBody.create(HttpExecutor.MEDIA_TYPE, paramsJson);

        Call<BBCBankVO> call = mApiService.redirectToPingAn(body);
        call.enqueue(new OnResponseListener<BBCBankVO>(getContext(), true) {
            @Override
            public void onSuccess(BBCBankVO vo) {
                if (mvpView != null) {
                    mvpView.getBankUrl(vo.getObj());
                }
            }
        });
    }


    public interface MvpView extends IMvpView {

        void getBankUrl(String url);

    }
}
