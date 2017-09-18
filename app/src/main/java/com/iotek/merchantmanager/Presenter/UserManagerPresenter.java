package com.iotek.merchantmanager.Presenter;

import com.google.gson.Gson;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.base.BasePresenter;
import com.iotek.merchantmanager.base.IMvpView;
import com.iotek.merchantmanager.bean.UserManagerVO;
import com.iotek.merchantmanager.net.HttpExecutor;
import com.iotek.merchantmanager.net.OnResponseListener;
import com.iotek.merchantmanager.view.LoadingDialog;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by admin on 2017/8/29.
 */

public class UserManagerPresenter extends BasePresenter<UserManagerPresenter.MvpView> {


    private final int LIMIT_SIZE = 10;

    private int currentPage = 1;


    public void queryUser(long custId, long rootId, String uuId, int page, boolean showDialog) {

        LoadingDialog dialog = new LoadingDialog(getContext());
        if (showDialog) {
            dialog.show();
        }

        Gson gson = new Gson();
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("custId", custId + "");
        paramsMap.put("rootId", rootId + "");
        paramsMap.put("uuid", uuId);
        paramsMap.put("limit", LIMIT_SIZE + "");
        paramsMap.put("page", page + "");
        String paramsJson = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(HttpExecutor.MEDIA_TYPE, paramsJson);
        Call<UserManagerVO> call = mApiService.queryUser(body);
        call.enqueue(new OnResponseListener<UserManagerVO>(getContext(),true) {
            @Override
            public void onSuccess(UserManagerVO userManagerVO) {
                LogUtil.e("=====>>>>" + userManagerVO.toString());
            }
        });

    }


    public interface MvpView extends IMvpView {

    }
}
