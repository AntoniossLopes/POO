package Projeto;

import java.io.Serializable;
import java.util.ArrayList;

public class Diversao extends Parque implements Serializable {
    private double despesaExtra;
    private String tema;

    public Diversao(String nome,String tema)
    {
        super(nome);
        this.tema = tema;
    }
}
