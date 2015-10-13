package com.mastercard.android.widget;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.mastercard.android.R;

public class ConnectButton extends Button {

    private FragmentManager fragmentManager;

    public ConnectButton(Context context, AttributeSet attr) {
        super(context, attr);
        setBackgroundResource(R.drawable.mp_connect);
    }

    public void setFragmentManager(FragmentManager supportFragmentManager) {
        fragmentManager = supportFragmentManager;
        setOnClickListener(new LoginClickListener(fragmentManager));
    }

    private class LoginClickListener implements OnClickListener {

        private final FragmentManager manager;

        public LoginClickListener(FragmentManager current) {
            manager = current;
        }

        @Override
        public void onClick(View v) {
            DialogAuth dialog = new DialogAuth();
            dialog.setCancelable(true);
            dialog.show(manager.beginTransaction(), "dialog");
        }
    }
}
