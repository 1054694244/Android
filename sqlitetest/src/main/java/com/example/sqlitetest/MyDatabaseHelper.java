package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table book ("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text)";


    public static final String CREATE_CATEGORY = "create table category("
            +"id integer primary key autoincrement,"
            +"category_name text,"
            +"category_code integer)";


    private Context mContent;

    public MyDatabaseHelper(Context mContent,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(mContent,name,factory,version);
        this.mContent = mContent;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("NIHAO","NIBUHAO");
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("NIHAO","NIHAO");
        db.execSQL("drop table if exists book");
        db.execSQL("drop table if exists category");
        onCreate(db);
    }
}
