package com.marcbaragom.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.marcbaragom.applistacurso.model.Pessoa;

public class PessoaController {

    public PessoaController() {
    }

    @NonNull
    @Override
    public String toString() {
        
        Log.i("Controller_MVC", super.toString());
        return super.toString();
    }

    public void Salvar(Pessoa pessoa) {
        Log.i("Controller_MVC", "Salvo: "+pessoa.toString());
    }
}
