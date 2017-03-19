package com.example.shiva.sqlitetut;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shiva on 19/3/17.
 */

public class SqliteDbHelper extends SQLiteOpenHelper{

    public SqliteDbHelper(Context c){
        super(c,"testDb",null,1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS loginTable";
        db.execSQL(query);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE loginTable (username varchar(20) PRIMARY KEY, password TEXT)";
        db.execSQL(query);
    }

    public void insert(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
       /* ContentValues val = new ContentValues();
        val.put("username",name);
        val.put("password",password);

        db.insert("loginTable",null,val);
        */
        db.execSQL("INSERT INTO loginTable values(?,?)",new String[]{name,password});
        db.close();
    }
    public boolean login(String name, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT password from loginTable WHERE username = ?", new String[]{name});
        if (c != null)
            c.moveToFirst();
        if (c.getCount() > 0){
            if(password.equals(c.getString(0))){
                return true;
            }
        }
        return false;
    }

}
