package com.crg.testtransaction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by crg on 2016/3/12.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{
    public static final String CREATE_BOOK = "create table book ("
            + "id integer primary key autoincrement,"
            + "author text, "
            + "price real, "
            + "pages integer, "
            + "name text "
            + "category_id integer)";

    public static final String CREATE_CATEGORY = "create table category ("
            + "id integer primary key autoincrement,"
            + "category_name text, "
            + "category_code integer) ";

    private Context mContext;


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "create success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Toast.makeText(mContext, "onUpgrade success", Toast.LENGTH_SHORT).show();

        switch (oldVersion){
            case 1:
                db.execSQL("CREATE_CATEGORY");

                Log.d("MainActivity", "onUpgrade 2");
            case 2:
                db.execSQL("alter table book add column category_id integer");

                Log.d("MainActivity", "onUpgrade 3");
            default:
        }
    }
}
