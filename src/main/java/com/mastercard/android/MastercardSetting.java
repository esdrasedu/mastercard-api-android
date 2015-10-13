package com.mastercard.android;

import android.net.Uri.Builder;
import android.text.TextUtils;

public class MastercardSetting {

    private boolean sandbox;
    private String app_key;
    private LightboxSetting lightboxSetting;

    public MastercardSetting(boolean _sandbox, String _app_key) {
        sandbox = _sandbox;
        app_key = _app_key;
    }

    public MastercardSetting(boolean _sandbox, String _app_key, LightboxSetting _lightboxSetting) {
        sandbox = _sandbox;
        app_key = _app_key;
        lightboxSetting = _lightboxSetting;
    }

    public String getUrlLightbox() {
        Builder builder = new Builder();
        builder.scheme("https");
        if(sandbox){
            builder.authority("sandbox.masterpass.com");
        } else {
            builder.authority("api.masterpass.com");
        }
        builder.appendPath("lightbox")
                .appendPath("version213")
                .appendPath("Switch")
                .appendPath("index.html");

        if (lightboxSetting.consumerWalletId != null){
            builder.appendQueryParameter("consumerWalletId", lightboxSetting.consumerWalletId);
        }

        if (lightboxSetting.merchantCheckoutId != null){
            builder.appendQueryParameter("merchantCheckoutId", lightboxSetting.merchantCheckoutId);
        }

        if (lightboxSetting.merchantCheckoutId != null){
            builder.appendQueryParameter("merchantCheckoutId", lightboxSetting.merchantCheckoutId);
        }

        if (lightboxSetting.walletName != null){
            builder.appendQueryParameter("walletName", lightboxSetting.walletName);
        }

        if (lightboxSetting.requestedDataType != null && lightboxSetting.requestedDataType.size() > 0 ){
            for ( String type : lightboxSetting.requestedDataType ) {
                builder.appendQueryParameter("requestedDataType[]", type);
            }
        }

        if (lightboxSetting.shippingLocationProfile != null && lightboxSetting.shippingLocationProfile.size() > 0 ){
            builder.appendQueryParameter("shippingLocationProfile", TextUtils.join(",", lightboxSetting.shippingLocationProfile));
        }

        builder.appendQueryParameter("requestToken", app_key)
            .appendQueryParameter("requestPairing", "true")
            .appendQueryParameter("pairingRequestToken", app_key);
        return builder.build().toString();
    }

    public void setLightboxSetting(LightboxSetting _lightboxSetting) {
        lightboxSetting = _lightboxSetting;
    }

}