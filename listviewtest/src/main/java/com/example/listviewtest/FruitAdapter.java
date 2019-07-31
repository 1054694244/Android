package com.example.listviewtest;

import android.content.Context;
import android.widget.ArrayAdapter;

public class FruitAdapter extends ArrayAdapter {
    public FruitAdapter(Context context, int resource, int textViewResourceId, Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
