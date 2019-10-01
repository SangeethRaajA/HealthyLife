package com.example.madproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class BSQLiteHelper extends SQLiteOpenHelper {

    public BSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String height, String weight, String ans){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO BMI VALUES (NULL, ?, ?, ?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, height);
        statement.bindString(3, weight);
        statement.bindString(4, ans);


        statement.executeInsert();
    }

    public void updateData(String name, int id ) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE BMI SET name = ? WHERE id=? ";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
//        statement.bindString(2, height);
//        statement.bindString(3, weight);
//        statement.bindString(4, ans);
        statement.bindDouble(2, (double)id);

        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM BMI WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

