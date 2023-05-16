package devandroid.adriano.applistacurso.view;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.adriano.applistacurso.R;
import devandroid.adriano.applistacurso.controller.PessoaController;
import devandroid.adriano.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";

    PessoaController controller;
    Pessoa pessoa;

    EditText txtNomeAluno;
    EditText txtSobrenomeAluno;
    EditText txtTelefoneAluno;
    EditText txtCursoDesejado;

    Button btnlimpar;
    Button btnsalvar;
    Button btnfinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        SharedPreferences.Editor listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Adriano");
        pessoa.setSobreNome("Vasconcelos");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("85 9999 1234");

        txtNomeAluno = findViewById(R.id.txtNomeAluno);
        txtSobrenomeAluno = findViewById(R.id.txtSobrenomeAluno);
        txtCursoDesejado = findViewById(R.id.txtCursoDesejado);
        txtTelefoneAluno = findViewById(R.id.txtTelefoneAluno);

        btnfinalizar = findViewById(R.id.btnfinalizar);
        btnlimpar= findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);

        txtNomeAluno.setText(pessoa.getPrimeiroNome());
        txtSobrenomeAluno.setText(pessoa.getSobreNome());
        txtCursoDesejado.setText(pessoa.getCursoDesejado());
        txtTelefoneAluno.setText(pessoa.getTelefoneContato());

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNomeAluno.setText("");
                txtSobrenomeAluno.setText("");
                txtCursoDesejado.setText("");
                txtTelefoneAluno.setText("");
            }
        });
        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Volte Sempre",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(txtNomeAluno.getText().toString());
                pessoa.setSobreNome(txtSobrenomeAluno.getText().toString());
                pessoa.setCursoDesejado(txtCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(txtTelefoneAluno.getText().toString());

                Toast.makeText(MainActivity.this,"Salvo"+ pessoa.toString(),Toast.LENGTH_LONG).show();

                listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome",pessoa.getSobreNome());
                listaVip.putString("nomeCurso",pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
                listaVip.apply();

                controller.salvar(pessoa);
            }
        });

        Log.i("pooAndroid",pessoa.toString());

    }
}