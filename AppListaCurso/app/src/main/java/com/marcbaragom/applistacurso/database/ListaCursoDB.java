package com.marcbaragom.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.marcbaragom.applistacurso.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

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

    public void removeObjeto(String tabela, String whereClause ,String[] dadosArgs){

        db.delete(tabela, whereClause, dadosArgs);

    }

    public List<Pessoa> listarAlunos(){
        List<Pessoa> lista = new ArrayList<>();

        Pessoa registro;

        String querySql = "Select * from TBALUNO";

        cursor = db.rawQuery(querySql, null);

        if (cursor.moveToFirst()){
            do {
                registro = new Pessoa();
                registro.setId(cursor.getInt(0));
                registro.setPrimeiroNome(cursor.getString(1));
                registro.setSobreNome(cursor.getString(2));
                registro.setNomeCurso(cursor.getString(3));
                registro.setFoneContato(cursor.getString(4));

                lista.add(registro);

            }while (cursor.moveToNext());

        }else{

        }

        return lista;
    }
}
