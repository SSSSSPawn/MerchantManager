package com.bec.merchantmanager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bec.merchantmanager.listener.OnProgressChangedListener;

/**
 * Created by admin on 2017/10/17.
 */

public class BECWebView extends WebView {

    private OnProgressChangedListener mOnProgressChangedListener;

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener){
        this.mOnProgressChangedListener = onProgressChangedListener;
    }

    public BECWebView(Context context) {
        super(context);
        init();
    }

    public BECWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        if (isInEditMode()) {
            return;
        }
        WebSettings ws = getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setGeolocationEnabled(true);
        ws.setJavaScriptCanOpenWindowsAutomatically(true);
        ws.setAppCacheEnabled(true);
        ws.setDatabaseEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setGeolocationDatabasePath(getContext().getFilesDir().getPath());
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        ws.setLoadsImagesAutomatically(true);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (mOnProgressChangedListener != null){
            mOnProgressChangedListener.onProgressChanged(l,t);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void setUserAgentString(String ua) {
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " " + ua);
    }
}
