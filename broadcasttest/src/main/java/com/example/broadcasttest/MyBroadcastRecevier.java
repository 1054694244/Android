package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastRecevier extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Revevied in MyBroadcastRecevier",Toast.LENGTH_SHORT).show();
        //将此广播截断，后面的广播收不到此消息
        abortBroadcast();
    }
}
