package Projeto;

import java.io.Serializable;

public abstract class Parque extends PontosInteresse implements Serializable {
    private double despesaParque;
    private double custoEntrada;
    private Horario horario;
    private double classificacao;

    public Parque(String nome) {
        super(nome);
    }

    public void inserePreco(double custoEntrada,double despesaParque)
    {
        this.custoEntrada = custoEntrada;
        this.despesaParque = despesaParque;
    }

    public void insereClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    public double getClassificacao() {
        return classificacao;
    }

    @Override
    public double custo(){
        double contador = custoEntrada + despesaParque;
        return custoEntrada;
    }
    @Override
    public String toString(){
        return "Custo Parque :"+custoEntrada+"\nDespesa Extra : "+despesaParque+"\nClassificacao: "+classificacao;
    }
}
