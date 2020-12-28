package Projeto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Viagem {
    private String nome;
    private ArrayList<Locais> listaLocais = new ArrayList<>();
    private ArrayList<PontosInteresse> listaPontos = new ArrayList<>();
    private ArrayList<Alunos> listaAlunos = new ArrayList<>();
    private double custoTotal;

    public Viagem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void insereCustoTotal(double custoTotal)
    {
        this.custoTotal = custoTotal;
    }

    public void insereLocal(Locais local) {
        listaLocais.add(local);
    }

    public void inserePonto(PontosInteresse pontosInteresse) {
        listaPontos.add(pontosInteresse);
    }

    public ArrayList<Locais> getListaLocais() {
        return listaLocais;
    }

    public ArrayList<PontosInteresse> getListaPontos() {
        return listaPontos;
    }

    public void insereAluno(Alunos aluno) {
        listaAlunos.add(aluno);
    }

    public void imprimeViagem(){
        System.out.println("Locais a visitar :");
        for(int i = 0 ; i < listaLocais.size();i++)
            System.out.println(" "+listaLocais.get(i).toString());
        System.out.printf("Pontos de Interesse Selecionados: ");
        for(int i = 0; i < listaPontos.size();i++)
            System.out.println(" "+listaPontos.get(i).nome);
    }
}