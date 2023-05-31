package com.marcbaragom.applistacurso.view;

import android.content.SharedPreferences;
import android.hardware.lights.LightState;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.marcbaragom.applistacurso.R;
import com.marcbaragom.applistacurso.controller.PessoaController;
import com.marcbaragom.applistacurso.database.ListaCursoDB;
import com.marcbaragom.applistacurso.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Pessoa pessoa;
    EditText editPrimNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editContato;
    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinaliza;
    PessoaController controller;

    List<Pessoa> dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaCursoDB db = new ListaCursoDB(MainActivity.this);

        controller = new PessoaController(MainActivity.this);

        dados = controller.getListaAlunos();

        /*Pessoa alteracao = dados.get(1);

        alteracao.setPrimeiroNome("ANGELA LUZIA");
        alteracao.setSobreNome("GOMES");
        alteracao.setNomeCurso("GEOLOGIA");
        alteracao.setFoneContato("+55 (85) 987934793");

        controller.alterar(alteracao);
*/
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

        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinaliza = findViewById(R.id.buttonFinaliza);


        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editContato.setText("");
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setNomeCurso(editNomeCurso.getText().toString());
                pessoa.setFoneContato(editContato.getText().toString());

                Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_SHORT).show();

                controller.Salvar(pessoa);

            }
        });

        buttonFinaliza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }


}