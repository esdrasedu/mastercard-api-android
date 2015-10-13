package com.mastercard.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.mastercard.android.Mastercard;
import com.mastercard.android.R;

public class ConnectButton extends Button {

    public ConnectButton(Context context, AttributeSet attr) {
        super(context, attr);
        setBackgroundResource(R.drawable.mp_connect);
    }

    public void setSetting() {
        setOnClickListener(new LoginClickListener());
    }

    private class LoginClickListener implements OnClickListener {


        public LoginClickListener() {

        }

        @Override
        public void onClick(View v) {
            DialogAuth dialog = new DialogAuth();
            dialog.setCancelable(true);
            dialog.show(Mastercard.getFragmentManager().beginTransaction(), "dialog");
        }
    }
}
