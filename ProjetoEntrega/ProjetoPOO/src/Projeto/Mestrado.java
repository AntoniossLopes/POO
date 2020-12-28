package Projeto;

import java.io.Serializable;

/**
 * Clasee REesponsavel pelos Alunos de Mestrado
 */

public class Mestrado extends Alunos implements Serializable {
    private String evitar;
    private String tipoI = "Mestrado";

    public Mestrado(String nome, String tipo) {
        super(nome,tipo);
    }

    public void insereEvitar(String evitar) {
        this.evitar = evitar;
    }

    public String getTipoI() {
        return tipoI;
    }

    @Override
    public String getNome()
    {
        return super.nome;
    }

    public String getEvitar() {
        return evitar;
    }
}

