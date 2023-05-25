package devandroid.adriano.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.adriano.applistacurso.model.Curso;


public class CursoController {

        private List listCursos;

        public List getListaDeCursos() {

            listCursos = new ArrayList<Curso>();

            listCursos.add(new Curso("Java"));
            listCursos.add(new Curso("HTML"));
            listCursos.add(new Curso("C#"));
            listCursos.add(new Curso("Python"));
            listCursos.add(new Curso("PHP"));
            listCursos.add(new Curso("Java EE"));
            listCursos.add(new Curso("Kotlin"));
            listCursos.add(new Curso("Visual Basic"));

        return null;
    }
        public ArrayList<String> dadosParaSpinner(){

            ArrayList <String> dados = new ArrayList<>();

            for (int i = 0; i< getListaDeCursos().size();i++ ) {
                Curso Objeto = (Curso) getListaDeCursos().get(i);
                dados.add(Objeto.getNomeCursoDesejado());
            }
            return dados;
        }

    }
