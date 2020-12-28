package Projeto;

import java.io.Serializable;
import java.util.ArrayList;

public class Horario implements Serializable {
    private String horarioEntrada;
    private String horarioSaida;
    private ArrayList<String> diasFechados = new ArrayList<String>();

    public Horario(String horarioEntrada,String horarioSaida) {
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
    }
    public void InsereDias(String dia) {
        diasFechados.add(dia);
    }

    @Override
    public String toString(){
        return "Horario Entrada: "+horarioEntrada+"\nHorario Saida: "+horarioSaida;
    }
}

