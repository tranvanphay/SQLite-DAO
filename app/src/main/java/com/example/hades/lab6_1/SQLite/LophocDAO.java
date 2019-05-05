package com.example.hades.lab6_1.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hades.lab6_1.SQLite.DbHelper;
import com.example.hades.lab6_1.model.Lophoc;

import java.util.ArrayList;

public class LophocDAO {
    SQLiteDatabase db;
    DbHelper helper;
    public LophocDAO(Context c){
        helper=new DbHelper(c);
    }
    public void themLopHoc(Lophoc lh){
        db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("tenlop",lh.tenlop );
        db.insert("lophoc",null,values);

    }
    public ArrayList<Lophoc> xemLophoc(){
        db=helper.getReadableDatabase();
        ArrayList<Lophoc> ds= new ArrayList<Lophoc>();
        Cursor c= db.query("lophoc",null,null,null,null,null,null);
        if (c.moveToFirst())
        {
            do{
                int _id=c.getInt(0);
                String tenlop=c.getString(1);
                Lophoc lh=new Lophoc(_id,tenlop);
                ds.add(lh);
            }while (c.moveToNext());

        }
        return ds;
    }
}
