package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bec.merchantmanager.Presenter.BBCBankPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.view.BECWebView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by admin on 2017/10/17.
 */

public class BBCBankActivity extends BaseActivity implements BBCBankPresenter.MvpView {


    @Bind(R.id.web_view)
    BECWebView mWebView;

    @Bind(R.id.tv_app_title) TextView mTvAppTitle;

    @Bind(R.id.view_refresh) ImageButton mViewRefresh;

    private BBCBankPresenter mPresenter = new BBCBankPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTvAppTitle.setText("平安理财");

        mPresenter.attachView(this);
        mPresenter.gotoBBC();
    }


    private void loadBBCUrl(String url) {
        mWebView.loadUrl(url);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void getBankUrl(String url) {
        loadBBCUrl(url);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_bbc_bank;
    }


    @Override
    protected void onDestroy() {
        clear();
        mPresenter.detachView();
        super.onDestroy();

    }

    @OnClick(R.id.view_refresh)
    public void onViewClicked() {
        mWebView.reload();
    }

    private void clear() {
        mWebView.loadUrl("about:blank");// 将页面置为空白 防止下次进入WEBVIEW先显示历史界面再加载当前页面的问题
        mWebView.clearCache(true);
        mWebView.clearHistory();
    }
}
