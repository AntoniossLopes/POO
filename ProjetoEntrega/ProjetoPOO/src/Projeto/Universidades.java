package Projeto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Responsavel Pela Criacao Das Universidades
 */

public class Universidades extends PontosInteresse implements Serializable {
    private ArrayList<Curso> lista = new ArrayList<>();
    private String tipoI = "Universidade";
    public Universidades(String nome) {
        super(nome);
    }
    public void insereCursos(Curso curso) {
        lista.add(curso);
    }
    @Override
    public double custo() {
        return 0;
    }

    @Override
    public String getTipoI() {
        return tipoI;
    }

    @Override
    public String toString(){
        return "Tipo: "+tipoI+"\nNome: "+super.nome+"\n"+super.horario.toString();
    }
}
