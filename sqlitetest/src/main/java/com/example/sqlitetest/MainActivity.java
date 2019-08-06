package com.example.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(MainActivity.this,"BookStore.db",null,3);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view->{
            dbHelper.getWritableDatabase();
        });
        Button addDATA = findViewById(R.id.add_data);
        addDATA.setOnClickListener(view->{
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            //开始组装第一条数据
            values.put("name","The DA Cinci Code");
            values.put("author","Dan Brown");
            values.put("pages",256);
            values.put("price",17.12);
            db.insert("book",null,values);
            values.clear();
            values.put("name","Chen Zhi Chao");
            values.put("author","Dan superSkr");
            values.put("pages",777);
            values.put("price",157.12);
            db.insert("book",null,values);
        });
        Button updateDate = findViewById(R.id.update_data);
        updateDate.setOnClickListener(view->{
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("price",1111.12);
            db.update("book",values,"name=?",new String[]{"Chen Zhi Chao"});
        });
        Button deleteData = findViewById(R.id.delete_data);
        deleteData.setOnClickListener(view->{
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("book","pages>?",new String[]{"500"});
        });
        Button queryData = findViewById(R.id.query_data);
        queryData.setOnClickListener(view->{
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            //查询表中所有的数据
            Cursor cursor = db.query("book",null,null,null,null,null,null);
            if (cursor.moveToFirst()){
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String author = cursor.getString(cursor.getColumnIndex("author"));
                    String pages = cursor.getString(cursor.getColumnIndex("pages"));
                    String price = cursor.getString(cursor.getColumnIndex("price"));
                    Log.d(TAG,name);
                    Log.d(TAG,author);
                    Log.d(TAG,pages);
                    Log.d(TAG,price);
                }while (cursor.moveToNext());
            }

        });
    }
}
