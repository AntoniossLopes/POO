package Projeto;

/**
 * Classe Responsavel Pelos Alunos de Licenciatura
 */

import java.io.Serializable;

public class Licenciatura extends Alunos implements Serializable {
    private PontosInteresse hot;
    private String tipoI = "Licenciatura";

    public Licenciatura(String nome, String tipo) {
        super(nome,tipo);
    }

    public String getTipoI() {
        return tipoI;
    }

    public void getHot(PontosInteresse hotPnts) {
        hot = hotPnts;
    }
}
