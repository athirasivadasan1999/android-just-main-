package com.example.insert_view;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="Student_db";
    public static final String TABLE_NAME="Student_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="SURNAME";
    public static final String COL_4="MARKS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLDb) {
        sqLDb.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY,NAME TEXT ,SURNAME TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLDb, int oldVersion, int newVersion) {
        sqLDb.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLDb);

    }

    public boolean insertData(String id, String name, String surname, String marks) {
        SQLiteDatabase sqLDb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result=sqLDb.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
            return true;

    }

    public Cursor getAllData() {
        SQLiteDatabase sqLDb=this.getWritableDatabase();
        Cursor res= sqLDb.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase sqLDb=this.getWritableDatabase();
        return sqLDb.delete(TABLE_NAME,"ID=?",new String[]{id});
    }

    public boolean updateData(String id, String name, String sname, String marks) {
        SQLiteDatabase sqLDb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,sname);
        contentValues.put(COL_4,marks);
        sqLDb.update(TABLE_NAME,contentValues,"ID=?",new String[]{id});
        return true;
    }
}
