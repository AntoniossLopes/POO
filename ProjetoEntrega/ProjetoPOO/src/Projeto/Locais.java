package Projeto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Responsavel Pela criacao dos Locais
 */

public class Locais implements Serializable {

    private static final long serialVersionID = 42L;
    private String nome;
    private int distancia;
    private int pontuacao = 0;
    private ArrayList<PontosInteresse> listap = new ArrayList<>();

    public Locais(String nome, int distancia) {
        this.nome = nome;
        this.distancia = distancia;
    }

    public void inserePonto(PontosInteresse pontos) {
        listap.add(pontos);
    }

    public void inserePontuacao(int pontuacao){
        this.pontuacao += pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<PontosInteresse> getListap() {
        return listap;
    }

    public double despesaTotal(){
        int i ;
        double custotal = 0;
        for(i = 0; i < listap.size();i++) {
            custotal += listap.get(i).custo();
        }
        return custotal;
    }

    public int getDistancia(){
        return distancia;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    @Override
    public String toString(){
        return "Nome Cidade: "+nome+" Distancia: "+distancia ;
    }
}
