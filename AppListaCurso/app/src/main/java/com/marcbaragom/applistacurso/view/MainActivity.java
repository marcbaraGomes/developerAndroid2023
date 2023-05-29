package com.marcbaragom.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.marcbaragom.applistacurso.R;
import com.marcbaragom.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    private Pessoa pessoa;
    EditText editPrimNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editContato;
    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinaliza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Lucas Nathan");
        pessoa.setSobreNome("Gomes");
        pessoa.setNomeCurso("Engenharia da Computação");
        pessoa.setFoneContato("+55 (85) 989652582");

        editPrimNome = findViewById(R.id.editPrimNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editContato = findViewById(R.id.editContato);

        editPrimNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getNomeCurso());
        editContato.setText(pessoa.getFoneContato());



    }
}