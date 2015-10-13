package com.mastercard.android;

import java.util.ArrayList;

public class LightboxSetting {

    public String consumerWalletId;
    public String merchantCheckoutId;
    public ArrayList<String> requestedDataType;
    public String walletName;
    public ArrayList shippingLocationProfile;

    public LightboxSetting(String consumerWalletId, String merchantCheckoutId, String walletName, ArrayList<String> requestedDataType, ArrayList shippingLocationProfile) {
        this.consumerWalletId = consumerWalletId;
        this.merchantCheckoutId = merchantCheckoutId;
        this.requestedDataType = requestedDataType;
        this.walletName = walletName;
        this.shippingLocationProfile = shippingLocationProfile;
    }

    public LightboxSetting(String consumerWalletId, String merchantCheckoutId, String walletName, ArrayList<String> requestedDataType) {
        this.consumerWalletId = consumerWalletId;
        this.merchantCheckoutId = merchantCheckoutId;
        this.requestedDataType = requestedDataType;
        this.walletName = walletName;
    }

    public LightboxSetting(String consumerWalletId, String merchantCheckoutId, String walletName) {
        this.consumerWalletId = consumerWalletId;
        this.merchantCheckoutId = merchantCheckoutId;
        this.walletName = walletName;
    }

    public LightboxSetting(String consumerWalletId, String merchantCheckoutId) {
        this.consumerWalletId = consumerWalletId;
        this.merchantCheckoutId = merchantCheckoutId;
    }

}
