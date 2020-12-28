package Projeto;

import java.io.Serializable;

/**
 * Super CLasse dos REstantes Pontos de Interesse
 */

public class PontosInteresse implements Serializable {

    private static final long serialVersionID = 42L;
    protected String nome;
    protected Horario horario;
    protected int pontuacao = 0;
    private String tipoI = "PontoInteresse";

    public String getTipoI() {
        return tipoI;
    }

    public PontosInteresse(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void insereHorario(Horario horario) {
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void inserePontuacao(int Pontuacao) {
        this.pontuacao += Pontuacao;
    }

    public double custo() {
        return 0;
    }

    public static PontosInteresse[] maisVotados(PontosInteresse[] listap){
        PontosInteresse[] maisVotos = new PontosInteresse[3];
        for(PontosInteresse pntsInt : listap){
            if(maisVotos[0] == null || pntsInt.pontuacao > maisVotos[0].pontuacao){
                maisVotos[2] = maisVotos[1];
                maisVotos[1] = maisVotos[0];
                maisVotos[0] = pntsInt;
            }
            else if(maisVotos[1] == null || pntsInt.pontuacao > maisVotos[1].pontuacao){
                maisVotos[2] = maisVotos[1];
                maisVotos[1] = pntsInt;
            }
            else if(maisVotos[2] == null || pntsInt.pontuacao > maisVotos[2].pontuacao){
                maisVotos[2] = pntsInt;
            }
        }
        return maisVotos;
    }

    public String toString()
    {
        return "Nome do Ponto: "+nome+"\n"+horario.toString();
    }
}
