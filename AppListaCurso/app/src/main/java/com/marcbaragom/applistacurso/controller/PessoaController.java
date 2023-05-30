package com.marcbaragom.applistacurso.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.marcbaragom.applistacurso.database.ListaCursoDB;
import com.marcbaragom.applistacurso.model.Pessoa;

import java.util.List;

public class PessoaController extends ListaCursoDB {

    public static final String NOME_PREFERENCES = "pref_listvar";
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public PessoaController(Activity activity) {
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        
        Log.i("Controller_MVC", super.toString());
        return super.toString();
    }

    public void Salvar(Pessoa pessoa) {

        //Salvar no Arquivo de Preferências
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("nomeCurso", pessoa.getNomeCurso());
        listaVip.putString("foneContato", pessoa.getFoneContato());

        listaVip.apply();

        //Salvar no Banco de Dados SQLite
        ContentValues dados= new ContentValues();
        dados.put("PRIMEIRO_NOME", pessoa.getPrimeiroNome());
        dados.put("SOBRENOME", pessoa.getSobreNome());
        dados.put("NOME_CURSO", pessoa.getNomeCurso());
        dados.put("FONE_CONTATO", pessoa.getFoneContato());

        salvarObjeto("TBALUNO", dados);

        //Salvar no Log
        Log.i("Controller_MVC", "Salvo: "+pessoa.toString());
    }

    public List<Pessoa> getListaAlunos(){
        return listarAlunos();
    }

}
