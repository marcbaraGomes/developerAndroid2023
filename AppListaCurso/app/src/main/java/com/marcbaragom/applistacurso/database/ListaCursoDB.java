package com.marcbaragom.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ListaCursoDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "listacurso.db";
    public static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;


    public ListaCursoDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTableAluno = "CREATE TABLE TBALUNO( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "PRIMEIRO_NOME TEXT, " +
                "SOBRENOME TEXT, " +
                "NOME_CURSO TEXT, " +
                "FONE_CONTATO TEXT )";

        db.execSQL(sqlTableAluno);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela,
                             ContentValues dados){

        db.insert(tabela, null, dados);
    }
}
