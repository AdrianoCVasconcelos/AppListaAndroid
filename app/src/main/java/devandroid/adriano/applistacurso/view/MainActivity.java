package devandroid.adriano.applistacurso.view;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import devandroid.adriano.applistacurso.R;
import devandroid.adriano.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Adriano");
        pessoa.setSobreNome("Vasconcelos");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("85 9999 1234");

        Log.i("pooAndroid",pessoa.toString());

    }
}