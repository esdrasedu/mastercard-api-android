package com.mastercard.android.widget;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mastercard.android.Mastercard;
import com.mastercard.android.R;

public class DialogAuth extends DialogFragment {

    private WebView web;

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        web.loadUrl(Mastercard.getMastercardSetting().getUrlLightbox());
        web.setWebViewClient(new WebViewClientAuth());
        web.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.oauth, container, false);
        web = (WebView) view.findViewById(R.id.oauth);
        return view;
    }

    private class WebViewClientAuth extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("access_token=")) {
                return true;
            }
            return false;
        }
    }
}
