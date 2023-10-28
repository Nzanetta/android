package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {



    private static final String NOMBRE_BD = "BD";
    private static final int VERSION_BD=1;
    private static final String TABLA_ARMAS="CREATE TABLE ARMAS(CODIGO TEXT PRIMARY KEY, NOMBRE TEXT, DESCRIPCION TEXT)";

    public BD(@Nullable Context context) {
            super(context,NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL((TABLA_ARMAS));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_ARMAS);
        sqLiteDatabase.execSQL(TABLA_ARMAS);
    }

    public void agregarArmas(String codigo, String nombre, String descripcion){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null) {
            bd.execSQL("INSERT INTO ARMAS VALUES('"+codigo+"','"+nombre+"','"+descripcion+"')");
            bd.close();
        }
    }
}
