package Projeto;

import java.io.Serializable;

/**
 * Classe Abstrata de Alunos
 *
 */

public abstract class Alunos implements Serializable {
    protected  String nome;
    protected  String tipo;

    public Alunos(String nome,String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
    public String getNome()
    {
        return nome;
    }
}
