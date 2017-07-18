package com.example.hjh.sqlitedemo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by hjh on 2017/7/13.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context mycontext;


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mycontext = context;
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table "+DataBaseDetail.TABLE_NAME
                +"(id integer primary key autoincrement," +
                "name text)";
        db.execSQL(sql);
        Toast.makeText(mycontext,"create database success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
