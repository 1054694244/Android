package com.example.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.save_data);
        button.setOnClickListener(view->{
            SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
            editor.putString("name","TOM");
            editor.putInt("age",18);
            editor.putBoolean("marreid",false);
            editor.apply();
        });
        Button button1 = findViewById(R.id.restore_data);
        button1.setOnClickListener(view->{
            SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
            String name = preferences.getString("name","");
            int age = preferences.getInt("age",0);
            boolean married = preferences.getBoolean("marreid",false);
            Log.d(TAG,name);
            Log.d(TAG,age+"");
            Log.d(TAG,married+"");
        });
    }
}
