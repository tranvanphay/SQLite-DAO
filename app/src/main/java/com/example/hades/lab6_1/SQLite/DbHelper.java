package com.example.hades.lab6_1.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{
    public DbHelper(Context context) {
        super(context, "quanlysinhvien", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        create table lophoc
        (
        _id integer primary key autoincrement,
        tenlop text
        )
        create table sinhvien(
        _id integer primary key autoincrement,
        tensinhvien text,
        email text,
        _idlop integer
        )
         */
        String sql="create table lophoc"+
        "("+
                "_id integer primary key autoincrement,"+
        "tenlop text"
        +")";
        db.execSQL(sql);
        String sql2="create table sinhvien"+"("+
                "_id integer primary key autoincrement,"+
        "tensinhvien text,"
        +"email text,"
        +"_idlop integer"
        +")";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists lophoc");
        db.execSQL("drop table if exists sinhvien");
        onCreate(db);
    }
}
