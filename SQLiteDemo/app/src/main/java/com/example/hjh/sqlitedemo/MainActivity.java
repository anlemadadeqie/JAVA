package com.example.hjh.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DatabaseHelper(this, DataBaseDetail.DATABASE_NAME, null, DataBaseDetail.DATABASE_VERSION);

    }

    //创建数据库
    public void createDatabase(View view){

        helper.getWritableDatabase();
    }

    public void addData(View view){

        db = helper.getWritableDatabase();
        ContentValues contentvalue = new ContentValues();
        contentvalue.put("name","hjh");
        db.insert(DataBaseDetail.TABLE_NAME, null, contentvalue);
        Log.d("tag","添加成功");
        db.close();

    }

    public void deleteData(View view){

        db = helper.getReadableDatabase();
        db.delete(DataBaseDetail.TABLE_NAME, null, null);
        Log.d("tag","删除成功");
        db.close();

    }

    public void queryData(View view){

        db = helper.getReadableDatabase();
        Cursor cursor = db.query(DataBaseDetail.TABLE_NAME, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do {

                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Log.d("id", "id is" + id);
                Log.d("name", "name is" + name);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

    }

    public void updateData(View view){

        db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "hahah");
        db.update(DataBaseDetail.TABLE_NAME, values, "name = ?", new String[]{"hjh"});
        Log.d("tag","更新成功");
        db.close();

    }
}
