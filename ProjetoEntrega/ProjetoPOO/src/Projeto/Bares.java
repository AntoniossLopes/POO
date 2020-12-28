package Projeto;

import java.io.Serializable;

/**
 * Classe Responsavel Pelos Bares
 */

public class Bares extends PontosInteresse implements Serializable {
    private double classificacao;
    private double despesa;
    private String tipoI = "Bar";

    /**
     * Para Iniacializar
     * @param nome = insere o nome do bar
     */

    public Bares(String nome) {
        super(nome);
    }

    public void insereClassificacao(double classificacao)
    {
        this.classificacao = classificacao;
    }

    public double getClassificacao(){
        return classificacao;
    }

    public void insereDespesa(double despesa) {
        this.despesa = despesa;
    }

    @Override
    public String getTipoI() {
        return tipoI;
    }

    @Override
    public double custo() {
        return despesa;
    }

    @Override
    public String toString(){
        return"Nome: "+super.nome+"\nClassificacao: "+classificacao+"\nDespesa: "+despesa+"\n"+horario.toString();
    }
}
