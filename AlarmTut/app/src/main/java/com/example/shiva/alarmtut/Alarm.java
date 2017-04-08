package com.example.shiva.alarmtut;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by shiva on 8/4/17.
 */

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Wake up",Toast.LENGTH_LONG).show();
    }
}