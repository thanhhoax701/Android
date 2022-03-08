package com.example.b5_tranthanhhoa_b1908387;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long value = intent.getLongExtra("new value", -10) + 10;
        Toast toast = Toast.makeText(context, "Broadcast Receiver catch an Intent"
                + " \n" + "The value is stored in the Intent is "
                + String.valueOf(value), Toast.LENGTH_LONG);
        toast.show();
    }

}
