package Projeto;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class leFicheiro {
    private ArrayList<Alunos> listaA = new ArrayList<>();
    private ArrayList<PontosInteresse> listaP = new ArrayList<>();
    private ArrayList<Locais> listaL = new ArrayList<>();
    private List<Map<String,String>> list = new ArrayList<>();
    private ArrayList<Locais> listaLocais = new ArrayList<>();
    private ArrayList<PontosInteresse> listaInt = new ArrayList<>();
    private List<Map<String,String>> listHasmap = new ArrayList<>();
    private ArrayList<Alunos> listaAlunos = new ArrayList<>();
    private ArrayList<Alunos> objAlunos = new ArrayList<>();

    public void lerFicheiro() {
        File f = new File("base.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                    String[] cidade = line.split(",");
                    Locais novoLocal;
                    String a = cidade[0];
                    if (a.equals("L")) {
                        String dist = cidade[2];
                        int distancia = Integer.parseInt(dist);
                        int pontuacaoC = Integer.parseInt(cidade[3]);
                        novoLocal = new Locais(cidade[1], distancia);
                        novoLocal.inserePontuacao(pontuacaoC);
                        String nextLine = br.readLine();
                        String[] universidade = nextLine.split(",");
                        Universidades novaUni;
                        String U = universidade[0];
                        if (U.equals("U")) {
                            novaUni = new Universidades(universidade[1]);
                            int pontuacaoU = Integer.parseInt(universidade[2]);
                            novaUni.inserePontuacao(pontuacaoU);
                            Horario novoHorario;
                            String skipLine = br.readLine();
                            System.out.println(skipLine);
                            String[] horarios = skipLine.split(" ");
                            if (horarios[0].equals("Horario")) {
                                String horarioEntrada = horarios[1];
                                String horarioSaida = horarios[2];
                                novoHorario = new Horario(horarioEntrada, horarioSaida);
                                String[] fechados = horarios[3].split(",");
                                for (int i = 0; i < fechados.length; i++) {
                                    novoHorario.InsereDias(fechados[i]);
                                }
                                novaUni.insereHorario(novoHorario);
                            }
                            String aux = br.readLine();
                            if (aux.equals("Cursos")) {
                                String skip = br.readLine();
                                String[] cursos = skip.split(",");
                                for (int i = 0; i < cursos.length; i++) {
                                    Curso adiciona = new Curso(cursos[i]);
                                    novaUni.insereCursos(adiciona);
                                }
                            }
                            novoLocal.inserePonto(novaUni);
                            listaP.add(novaUni);
                            System.out.println(novaUni.toString());

                        }
                        String museus = br.readLine();
                        String[] Museu = museus.split(",");
                        if (Museu[0].equals("M")) {
                            Museus novoMuseu;
                            String temas = br.readLine();
                            String[] Tema = temas.split(",");
                            if(Tema[0].equals("Tema"))
                            {  novoMuseu = new Museus(Museu[1],Tema[1]);
                                int pontuacaoM = Integer.parseInt(Museu[2]);
                                novoMuseu.inserePontuacao(pontuacaoM);
                                String leHora = br.readLine();
                                System.out.println(leHora);
                                String[] horarios = leHora.split(" ");
                                if (horarios[0].equals("Horario")) {
                                    Horario novoHorario;
                                    String horarioEntrada = horarios[1];
                                    String horarioSaida = horarios[2];
                                    novoHorario = new Horario(horarioEntrada, horarioSaida);
                                    String[] fechados = horarios[3].split(",");
                                    for (int i = 0; i < fechados.length; i++) {
                                        novoHorario.InsereDias(fechados[i]);
                                    }
                                    novoMuseu.insereHorario(novoHorario);
                                }
                                String lepaga = br.readLine();
                                String[] pagar = lepaga.split(" ");
                                double preco = Double.parseDouble(pagar[1]);
                                novoMuseu.insereCusto(preco);
                                novoLocal.inserePonto(novoMuseu);
                                listaP.add(novoMuseu);
                                System.out.println(novoMuseu.toString());
                            }
                        }
                        String lerBar = br.readLine();
                        String[] Bar = lerBar.split(",");
                        if(Bar[0].equals("B"))
                        {
                            Bares novoBar = new Bares(Bar[1]);
                            int pontuacaoB = Integer.parseInt(Bar[2]);
                            novoBar.inserePontuacao(pontuacaoB);
                            String lerClassificacao = br.readLine();
                            String[] Classificacao = lerClassificacao.split(" ");
                            double classi = Double.parseDouble(Classificacao[1]);
                            novoBar.insereClassificacao(classi);
                            String lerHoras = br.readLine();
                            String[] horarios = lerHoras.split(" ");
                            if (horarios[0].equals("Horario")) {
                                Horario novoH;
                                String horarioE = horarios[1];
                                String horarioS = horarios[2];
                                novoH = new Horario(horarioE, horarioS);
                                String[] fechados = horarios[3].split(",");
                                for (int i = 0; i < fechados.length; i++) {
                                    novoH.InsereDias(fechados[i]);
                                }
                                novoBar.insereHorario(novoH);
                            }
                            String lerExtra = br.readLine();
                            String[] Extra = lerExtra.split(" ");
                            double despesa = Double.parseDouble(Extra[1]);
                            novoBar.insereDespesa(despesa);
                            novoLocal.inserePonto(novoBar);
                            listaP.add(novoBar);
                            System.out.println(novoBar.toString());
                        }
                        String LerParques = br.readLine();
                        String[] parques = LerParques.split(",");
                        if(parques[0].equals("P"))
                        {
                            String lerTemas = br.readLine();
                            String[] tema = lerTemas.split(" ");
                            if(tema[1].equals("Aquatico"))
                            {
                                int pontuacaoA = Integer.parseInt(parques[2]);
                                Aquatico novoAquatico = new Aquatico(parques[1],tema[1]);
                                novoAquatico.inserePontuacao(pontuacaoA);
                                String lerHorarios = br.readLine();
                                String[] horarios = lerHorarios.split(" ");
                                if (horarios[0].equals("Horario")) {
                                    Horario novoH;
                                    String horarioE = horarios[1];
                                    String horarioS = horarios[2];
                                    novoH = new Horario(horarioE, horarioS);
                                    String[] fechados = horarios[3].split(",");
                                    for (int i = 0; i < fechados.length; i++) {
                                        novoH.InsereDias(fechados[i]);
                                    }
                                    novoAquatico.insereHorario(novoH);
                                }
                                String lerEntrada = br.readLine();
                                String[] entrada = lerEntrada.split(" ");
                                Double precoEntrada = Double.parseDouble(entrada[1]);
                                String lerExtra = br.readLine();
                                String[] extra = lerExtra.split(" ");
                                double precoExtra = Double.parseDouble(extra[1]);
                                novoAquatico.insereCustod(precoEntrada);
                                novoAquatico.insereExtra(precoExtra);
                                String leEspetaculo = br.readLine();
                                String[] espetaculos = leEspetaculo.split(",");
                                if(espetaculos[0].equals("Espetaculos"))
                                {
                                    boolean aux = Boolean.parseBoolean(espetaculos[1]);
                                    novoAquatico.existenciaEspetaculos(aux);
                                }
                                String leEquipamentos = br.readLine();
                                String[] equipamentos = leEquipamentos.split(",");
                                if(equipamentos[0].equals("Equipamentos"))
                                {
                                    for(int i = 1; i < equipamentos.length;i++)
                                    {
                                        novoAquatico.insereEquipamento(equipamentos[i]);
                                    }
                                }
                                novoLocal.inserePonto(novoAquatico);
                                listaP.add(novoAquatico);
                                System.out.println(novoAquatico.toString());
                            }
                            else{
                                int pontuacaoCu = Integer.parseInt(parques[2]);
                                Cultural novoParque = new Cultural(parques[1],tema[1]);
                                novoParque.inserePontuacao(pontuacaoCu);
                                String lerHorario = br.readLine();
                                String[] horarios = lerHorario.split(" ");
                                if (horarios[0].equals("Horario")) {
                                    Horario novoH;
                                    String horarioE = horarios[1];
                                    String horarioS = horarios[2];
                                    novoH = new Horario(horarioE, horarioS);
                                    String[] fechados = horarios[3].split(",");
                                    for (int i = 0; i < fechados.length; i++) {
                                        novoH.InsereDias(fechados[i]);
                                    }
                                    novoParque.insereHorario(novoH);
                                }
                                String leEntrada = br.readLine();
                                String[] entrada = leEntrada.split(" ");
                                Double precoEntrada = Double.parseDouble(entrada[1]);
                                String leExtra = br.readLine();
                                String[] extra = leExtra.split(" ");
                                double precoExtra = Double.parseDouble(extra[1]);
                                novoParque.inserePreco(precoEntrada,precoExtra);
                                novoLocal.inserePonto(novoParque);
                                listaP.add(novoParque);
                                System.out.println(novoParque.toString());
                            }
                            listaL.add(novoLocal);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void lerDistancias() {
        int contador = listaL.size();
        File f = new File("distancias.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    Map<String,String> mMap = new HashMap<>();
                    String id = "ID";
                    String[] lista =line.split(", ");
                    mMap.put(id,lista[0]);
                    System.out.println("ID: "+lista[0]);
                    String[] distancias = lista[1].split(",");
                    for(int i = 0;i < contador ; i++)
                    {
                        String[] dados = distancias[i].split(" ");
                        if(dados[0].equals("Rio"))
                        {
                            String nome = dados[0]+" "+dados[1]+" "+dados[2] ;
                            String distancia = dados[3];
                            mMap.put(nome,distancia);
                            System.out.println("NOME:"+nome+" DISTANCIA: "+distancia);
                        }
                        else {
                            String nome = dados[0];
                            String distancia = dados[1];
                            System.out.println("Nome: "+nome+" Distancia: "+distancia);
                            mMap.put(nome, distancia);
                        }
                    }
                    list.add(mMap);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Alunos> getObjAlunos() {
        return objAlunos;
    }

    public ArrayList<Locais> getListaL() {
        return listaL;
    }

    public List<Map<String, String>> getListHasmap() {
        return listHasmap;
    }

    public ArrayList<PontosInteresse> getListaInt() {
        return listaInt;
    }

    public void escreveObjeto(ArrayList<Locais> lista, ArrayList<PontosInteresse> listaInt, List<Map<String,String>> list,ArrayList<Alunos> lista_Alunos) {

        try {
            FileOutputStream fos = new FileOutputStream("baseObjeto.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(lista);
            oos.writeObject(listaInt);
            oos.writeObject(list);
            oos.writeObject(lista_Alunos);
            oos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void leObjecto() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("baseObjeto.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        listaLocais =  (ArrayList<Locais>)ois.readObject();
        listaInt = (ArrayList<PontosInteresse>)ois.readObject();
        listHasmap = (List<Map<String,String>>)ois.readObject();
        objAlunos = (ArrayList<Alunos>)ois.readObject();

        fis.close();
        ois.close();

    }

    public ArrayList<Alunos> getListaA() {
        return listaA;
    }

    public ArrayList<PontosInteresse> getListaP() {
        return listaP;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    public ArrayList<Locais> getListaLocais() {
        return listaLocais;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        leFicheiro d = new leFicheiro();
        d.lerFicheiro();
        d.lerDistancias();
        ArrayList<Locais> lista = d.getListaL();
        ArrayList<Alunos> alunosLista = new ArrayList<>() ;
        Licenciatura novo = new Licenciatura("Alberto","Licenceciatura");
        alunosLista.add(novo);
        System.out.println("OMGF");
        ArrayList<PontosInteresse> listaInt = d.getListaP();
        for(int i = 0; i < listaInt.size();i++)
        {
            System.out.println(listaInt.get(i).toString());
        }
        List <Map<String,String>> listH = d.getList();
        System.out.println(listH.size());
        d.escreveObjeto(lista,listaInt,listH,alunosLista);
        d.leObjecto();

    }
}
