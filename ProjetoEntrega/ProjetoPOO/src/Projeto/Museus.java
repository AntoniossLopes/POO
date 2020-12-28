package Projeto;

import java.io.Serializable;

/**
 * CLasse Resposavel Pela Criacao de Museus
 */

public class Museus extends PontosInteresse implements Serializable {
    private String tema;
    private double custoEntrada;
    private String tipoI = "Museu";

    public Museus(String nome, String tema) {
        super(nome);
        this.tema = tema;
    }

    @Override
    public String getTipoI() {
        return tipoI;
    }

    public void insereCusto(double custoEntrada) {
        this.custoEntrada = custoEntrada;
    }
    @Override
    public double custo() {
        return custoEntrada;
    }

    @Override
    public String toString(){
        return "Tipo: "+tipoI+"\nNome: "+super.nome+"\nTema: "+tema+"\nCusto Entrada: "+custoEntrada+"\n"+super.horario.toString();
    }
}
