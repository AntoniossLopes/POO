package Projeto;

import java.io.Serializable;
import java.util.ArrayList;

public class Cultural extends Parque implements Serializable {
    private String tipo;
    private String tipoI = "Parque Cultural";
    public Cultural(String nome,String tipo) {
        super(nome);
        this.tipo = tipo ;
    }

    @Override
    public String getTipoI() {
        return tipoI;
    }

    @Override
    public String toString(){
        double custo = super.custo() ;
        return "Nome: "+nome+"\nTipo de Parque Cultural: "+this.tipo+"\nPreco: "+custo+"\n" ;
    }

}
