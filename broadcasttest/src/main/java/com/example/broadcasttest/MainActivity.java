package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {


    private IntentFilter intentFilter;

    private NetWorkChangeReceiver networkChangeReceiver;

    private LocalRecevier localRecevier;

    private LocalBroadcastManager localBroadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetWorkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);*/
        /*Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(view->{
            Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
            //标准广播
            //sendBroadcast(intent);
            //有序广播
            sendOrderedBroadcast(intent,null);
        });*/
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(view->{
            Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
            localBroadcastManager.sendBroadcast(intent);
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        localRecevier = new LocalRecevier();
        //注册本地广播监听器
        localBroadcastManager.registerReceiver(localRecevier,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //（全局）静态广播
        //unregisterReceiver(networkChangeReceiver);
        //本地广播
        localBroadcastManager.unregisterReceiver(localRecevier);
    }

    class NetWorkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
            }


        }
    }


    class LocalRecevier extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"REVICE LOCAL BROADCAST",Toast.LENGTH_SHORT).show();
        }
    }

}
