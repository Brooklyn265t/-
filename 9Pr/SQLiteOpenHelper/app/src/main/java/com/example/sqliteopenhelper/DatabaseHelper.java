package com.example.sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "catstore.db";
    private static final  int SCHEMA = 1; // версия БД
    static final String TABLE = "cats"; // название таблицы в БД
    //имена столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_YEAR = "year";
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, SCHEMA);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE cats (" + COLUMN_ID
                + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                +"TEXT," + COLUMN_YEAR + " INTEGER);");
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME + ") VALUES ('Tom', 2016);");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE);
        onCreate(db);
    }
}