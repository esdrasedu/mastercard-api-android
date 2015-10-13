package com.mastercard.android.widget;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mastercard.android.R;

public class DialogAuth extends DialogFragment {

    private WebView web;

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("sandbox.masterpass.com")
                .appendPath("lightbox")
                .appendPath("version213")
                .appendPath("Switch")
                .appendPath("index.html")
                .appendQueryParameter("consumerWalletId", "id_consumer")
                .appendQueryParameter("merchantCheckoutId",  "id_merchant")
                .appendQueryParameter("requestedDataType[]", "CARD")
                .appendQueryParameter("requestedDataType[]", "PROFILE")
                .appendQueryParameter("requestedDataType[]", "ADDRESS")
                .appendQueryParameter("requestPairing", "true")
                .appendQueryParameter("requestToken", "414d4b76787a5a7358524d6a45307635327732455365413d")
                .appendQueryParameter("walletName", "name")
                //.appendQueryParameter("shippingLocationProfile", "NAmerica,SAmerica")
                .appendQueryParameter("pairingRequestToken", "414d4b76787a5a7358524d6a45307635327732455365413d");
        web.loadUrl(builder.build().toString());
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
