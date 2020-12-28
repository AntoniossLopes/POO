package Projeto;

import java.io.Serializable;
import java.util.ArrayList;

/***
 * Classe Responsavel Por Criar Parques Aquaticos
 */

public class Aquatico extends Diversao implements Serializable {
    private int piscinas;
    private double extra;
    private ArrayList<String> listaEquipamentos = new ArrayList<>();
    private boolean espetaculos;
    private double custoEntrada;
    private String tipoI = "Parque Aquatico";

    /**
     * Recebe com paramentros de inicacao
     * @param nome = nome do Parques
     * @param tipo = o tipo neste caso Aquatico
     */

    public Aquatico(String nome, String tipo)
    {
        super(nome,tipo);
    }

    public void insereEquipamento(String equipamento){
        listaEquipamentos.add(equipamento);
    }

    public void existenciaEspetaculos(boolean verificacao)
    {
        this.espetaculos = verificacao;
    }

    public void insereExtra(double extra) {
        this.extra = extra;
    }

    public void insereCustod(double custoEntrada){this.custoEntrada=custoEntrada;}

    @Override
    public String getTipoI() {
        return tipoI;
    }

    @Override
    public double custo(){
        double custo = extra + custoEntrada;
        return custo;
    }

    @Override
    public String toString(){
        String aux;
        if(espetaculos == true)
        {
            aux = "Existe.";
        }
        else
            aux = "Nao.";
        return "Nome: "+super.nome+"Tipo : Aquatico\nEspetaculos: "+aux+"\nDespesas: "+custo();
    }


}
