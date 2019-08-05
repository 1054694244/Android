package com.example.broadcasttest2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button offline = findViewById(R.id.force_offline);
        offline.setOnClickListener(view->{
            Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
            sendBroadcast(intent);
        });
    }
}
