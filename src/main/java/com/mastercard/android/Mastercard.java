package com.mastercard.android;

import android.support.v4.app.FragmentManager;

public class Mastercard {

    private static FragmentManager fragmentManager;
    private static MastercardSetting mastercardSetting;

    private Mastercard() {
    }

    public static void setFragmentManager( FragmentManager _fragmentManager ) {
        fragmentManager = _fragmentManager;
    }

    public static FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public static void setMastercardSetting( MastercardSetting _mastercardSetting ) {
        mastercardSetting = _mastercardSetting;
    }

    public static MastercardSetting getMastercardSetting() {
        return mastercardSetting;
    }

}
