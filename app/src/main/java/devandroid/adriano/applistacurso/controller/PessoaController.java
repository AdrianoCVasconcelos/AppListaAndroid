package devandroid.adriano.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.adriano.applistacurso.model.Pessoa;
import devandroid.adriano.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override


    public String toString() {

        Log.d("MVC_Controlle", "Controller Iniciada...");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();
        Log.d("MVC_Controlle", "Salvo..." + pessoa.toString());
    }

    public Pessoa buscar(Pessoa pessoa) {

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "na"));
        pessoa.setSobreNome(preferences.getString("sobreNome", "na"));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", "na"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "na"));

        return pessoa;
    }

    public void limpar() {

        listaVip.clear();
        listaVip.apply();
    }
}
