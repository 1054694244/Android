package com.example.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {

    private static final String TAG = "TitleLayout";

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.titile,this);
        Button titleBack = (Button)findViewById(R.id.title_back);
        Button titleEdit = (Button)findViewById(R.id.title_edit);
        Log.d(TAG,titleBack.getClass().getName());
        titleBack.setOnClickListener(view->{
            Log.d(TAG,"123");
            ((Activity)getContext()).finish();
        });
        titleEdit.setOnClickListener(view->{
            Log.d(TAG,"123");
            Toast.makeText(getContext(),"You clicked Edit button",Toast.LENGTH_SHORT).show();
        });
    }
}
