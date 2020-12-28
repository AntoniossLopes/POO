package Projeto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;

/**
 * Classe que Cria a Janela Dedicada aos Alunos de Licenciatura
 *
 */

public class GUITeste2 extends JFrame {
    private JPanel panel;
    private JLabel labelLocal1, labelLocal2, labelLocal3, labelPnts1, labelPnts2, labelPnts3, labelHot, background, labelViaUser, labelSatisfaz, labelLocalPnts;
    private JComboBox comboLocal1, comboLocal2, comboLocal3, comboHot, comboLocalInfo, comboPntsIntInfo;
    private JButton buttonClear, buttonEscolhe,buttonSair, buttonGerar, buttonAdd, buttonInfo, buttonHot, buttonAddInfo;
    private ArrayList<Locais> listaLocais;
    private JScrollPane scroll;
    private ImageIcon dei;
    private JTextArea infomais;
    private double maximo;
    private Licenciatura pessoa;
    private ArrayList<PontosInteresse> listaInt;
    private String[] pt1;
    private String[] pt2;
    private String[] pt3;
    private String[] ptInfo;
    private JList listaViagens, listaPnts1, listaPnts2, listaPnts3, listaSatisfaz;
    private ArrayList<Viagem> ViagensDoidonas = new ArrayList<>();
    private ArrayList<Viagem> ViagensdeConhecimnento = new ArrayList<>();
    private List<Map<String,String>> listaHash = new ArrayList<>();
    private ArrayList<Alunos> listaAlunos = new ArrayList<>();
    private String hot;

    /**
     *
     * @param listaLocais = lista obitda no ficheiro objeto
     * @param maximo = maximo atribuido no ecra de login pelo user
     * @param pessoa = a classe Licenciatura com dados do user, nome, e tipo
     * @param listaInt = lista com todos Pontos Interesse
     * @param listaHash = lista com Dicionario que vai ser usado para obter as distancias entre locais
     * @param objAlunos = Lista de Alunos lida do ficheiro Objeto
     */

    public GUITeste2(ArrayList<Locais> listaLocais, double maximo, Licenciatura pessoa, ArrayList<PontosInteresse> listaInt, List<Map<String,String>> listaHash,ArrayList<Alunos> objAlunos) {
        super();

        this.pessoa = pessoa;
        this.listaLocais = listaLocais;
        this.maximo = maximo;
        this.listaInt = listaInt;
        this.listaHash = listaHash;
        this.listaAlunos = objAlunos;

        int tamanho = listaLocais.size();
        String[] lc = new String[tamanho];
        for (int i = 0; i < listaLocais.size(); i++) {
            lc[i] =listaLocais.get(i).getPontuacao()+":"+listaLocais.get(i).getNome();
        }
        Arrays.sort(lc,Comparator.reverseOrder());

        labelLocal1 = new JLabel("1º Local");
        labelLocal1.setFont(new Font("Agency FB", Font.PLAIN, 40));
        labelLocal1.setBounds(370, 10, 300, 100);

        comboLocal1 = new JComboBox(lc);
        comboLocal1.setBounds(370, 100, 100, 25);

        labelLocal2 = new JLabel("2º Local");
        labelLocal2.setFont(new Font("Agency FB", Font.PLAIN, 40));
        labelLocal2.setBounds(700, 10, 300, 100);

        comboLocal2 = new JComboBox(lc);
        comboLocal2.setBounds(700, 100, 100, 25);

        labelLocal3 = new JLabel("3º Local");
        labelLocal3.setFont(new Font("Agency FB", Font.PLAIN, 40));
        labelLocal3.setBounds(990, 10, 300, 100);

        comboLocal3 = new JComboBox(lc);
        comboLocal3.setBounds(990, 100, 100, 25);

        labelPnts1 = new JLabel("Pontos de Interesse");
        labelPnts1.setFont(new Font("Agency FB", Font.PLAIN, 30));
        labelPnts1.setBounds(110, 180, 300, 100);

        listaPnts1 = new JList();
        listaPnts1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPnts1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaPnts1.setBounds(125, 255, 150, 75);

        labelPnts2 = new JLabel("Pontos de Interesse");
        labelPnts2.setFont(new Font("Agency FB", Font.PLAIN, 30));
        labelPnts2.setBounds(510, 180, 300, 100);

        listaPnts2 = new JList();
        listaPnts2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPnts2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaPnts2.setBounds(525, 255, 150, 75);

        labelPnts3 = new JLabel("Pontos de Interesse");
        labelPnts3.setFont(new Font("Agency FB", Font.PLAIN, 30));
        labelPnts3.setBounds(910, 180, 300, 100);

        listaPnts3 = new JList();
        listaPnts3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPnts3.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaPnts3.setBounds(925, 255, 150, 75);

        labelHot = new JLabel("Ponto Hot");
        labelHot.setFont(new Font("Agency FB", Font.PLAIN, 40));
        labelHot.setBounds(50, 10, 300, 100);


        int tamanhoHot = listaInt.size();
        String[] pontos = new String[tamanhoHot];
        for (int i = 0; i < tamanhoHot; i++) {
            pontos[i] =listaInt.get(i).getPontuacao()+":"+listaInt.get(i).getNome();
        }

        comboHot = new JComboBox(pontos);
        comboHot.setBounds(70, 100, 150, 25);

        labelViaUser = new JLabel("Sua Viagem");
        labelViaUser.setFont(new Font("Agency FB", Font.PLAIN, 30));
        labelViaUser.setBounds(100, 300, 300, 100);

        labelSatisfaz = new JLabel("Informações da Viagem");
        labelSatisfaz.setFont(new Font("Agency FB", Font.PLAIN, 30));
        labelSatisfaz.setBounds(510, 300, 300, 100);

        labelLocalPnts = new JLabel("Locais e Pontos");
        labelLocalPnts.setFont(new Font("Agency FB", Font.PLAIN, 30));
        labelLocalPnts.setBounds(940, 375, 300, 100);

        comboLocalInfo = new JComboBox(lc);
        comboLocalInfo.setBounds(940, 450, 150, 25);

        comboPntsIntInfo = new JComboBox();
        comboPntsIntInfo.setBounds(940, 500, 150, 25);

        listaViagens = new JList();
        listaViagens.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaViagens.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaViagens.setBounds(25, 375, 350, 200);

        //listaSatisfaz = new JList();
        //listaSatisfaz.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //listaSatisfaz.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //listaSatisfaz.setBounds(500, 375, 350, 200);

        infomais = new JTextArea();
        infomais.setFont(infomais.getFont().deriveFont(10));
        //infomais.setBounds(500, 375, 350, 200);
        infomais.setEditable(false);
        scroll = new JScrollPane(infomais);
        scroll.setBounds(500,375,350,200);

        buttonEscolhe = new JButton("Escolhe Viagem");
        buttonEscolhe.setBounds(475,610,125,25);

        buttonGerar = new JButton("Gerar Viagem");
        buttonGerar.setBounds(600, 610, 125, 25);

        buttonSair = new JButton("SAIR");
        buttonSair.setBounds(725, 610, 125, 25);

        buttonAdd = new JButton("Adicionar");
        buttonAdd.setBounds(550, 160, 100, 25);

        buttonHot = new JButton("Hot");
        buttonHot.setBounds(90, 160, 100, 25);

        buttonInfo = new JButton("INFO");
        buttonInfo.setBounds(940, 550, 100, 25);

        buttonAddInfo = new JButton("Info Viagem");
        buttonAddInfo.setBounds(50,610,150,25);

        buttonClear = new JButton("Clear Lista");
        buttonClear.setBounds(200,610,150,25);


        dei = new ImageIcon("DEImg.png");
        background = new JLabel("", dei, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        panel = new JPanel();
        panel.setLayout(null);
        panel.add(labelLocal1);
        panel.add(comboLocal1);
        panel.add(labelLocal2);
        panel.add(comboLocal2);
        panel.add(labelLocal3);
        panel.add(comboLocal3);
        panel.add(labelPnts1);
        panel.add(listaPnts1);
        panel.add(labelPnts2);
        panel.add(listaPnts2);
        panel.add(labelPnts3);
        panel.add(listaPnts3);
        panel.add(labelHot);
        panel.add(comboHot);
        panel.add(labelViaUser);
        panel.add(labelSatisfaz);
        panel.add(labelLocalPnts);
        panel.add(comboLocalInfo);
        panel.add(comboPntsIntInfo);
        panel.add(listaViagens);
        panel.add(scroll);
        panel.add(buttonGerar);
        panel.add(buttonSair);
        panel.add(buttonAdd);
        panel.add(buttonHot);
        panel.add(buttonInfo);
        panel.add(buttonAddInfo);
        panel.add(buttonEscolhe);
        panel.add(buttonClear);
        panel.add(background);

        comboLocalInfo.addActionListener(new ComboInfoListener());
        buttonAddInfo.addActionListener(new ButtonAddInfoListener());
        buttonAdd.addActionListener(new LocaisListener());
        buttonGerar.addActionListener(new geraViagens());
        buttonSair.addActionListener(new buttonSairListener());
        buttonInfo.addActionListener(new buttonInfoListener());
        buttonHot.addActionListener(new hotListener());
        buttonClear.addActionListener(new clearListener());
        buttonEscolhe.addActionListener(new escolheListener());

        this.add(panel);
    }

    private class ButtonAddInfoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String viagem1 = (String) listaViagens.getSelectedValue();
            System.out.println(viagem1);
            System.out.println(maximo);

            infomais.setText("");

            DefaultListModel<String>  model = new DefaultListModel<>();
            StringBuilder informacao = new StringBuilder();

            for(int i = 0 ; i < ViagensDoidonas.size(); i++)
            {
                StringBuilder aux = new StringBuilder();
                aux.append(ViagensDoidonas.get(i).getNome()+" "+ViagensDoidonas.get(i).getCustoTotal());
                if(aux.toString().equals(viagem1))
                {
                    StringBuilder novo = new StringBuilder();
                    novo.append("Custo Total da Viagem: "+ViagensDoidonas.get(i).getCustoTotal());
                    infomais.append(novo.toString()+"\n"+"\n");
                    ArrayList<Locais> auxLocais = ViagensDoidonas.get(i).getListaLocais();
                    for(int x = 0 ; x < auxLocais.size();x++)
                    {
                        infomais.append(auxLocais.get(x).toString()+"\n"+"\n");
                        ArrayList<PontosInteresse> auxInteresse = auxLocais.get(x).getListap();
                        for(int j = 0; j < auxInteresse.size();j++)
                        {
                            infomais.append(auxInteresse.get(j).toString()+"\n"+"\n");
                        }
                    }
                }
            }
            for(int i = 0 ; i < ViagensdeConhecimnento.size(); i++)
            {
                StringBuilder aux = new StringBuilder();
                aux.append(ViagensdeConhecimnento.get(i).getNome()+" "+ViagensdeConhecimnento.get(i).getCustoTotal());
                if(aux.toString().equals(viagem1))
                {
                    ArrayList<Locais> auxLocais = ViagensdeConhecimnento.get(i).getListaLocais();
                    for(int x = 0 ; x < auxLocais.size();x++)
                    {
                        infomais.append(auxLocais.get(x).toString()+"\n"+"\n");
                        model.addElement(auxLocais.get(x).toString());
                        ArrayList<PontosInteresse> auxInteresse = auxLocais.get(x).getListap();
                        for(int j = 0; j < auxInteresse.size();j++)
                        {
                            infomais.append(auxInteresse.get(j).toString()+"\n"+"\n");

                        }
                    }
                }
            }
        }
    }

    private class escolheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String viagem1 = (String) listaViagens.getSelectedValue();
            System.out.println(viagem1);
            System.out.println(maximo);

            for(int i = 0; i < ViagensDoidonas.size();i++)
            {
                StringBuilder aux = new StringBuilder();
                aux.append(ViagensDoidonas.get(i).getNome() + " " + ViagensDoidonas.get(i).getCustoTotal());
                if (aux.toString().equals(viagem1)) {
                    ArrayList<Locais> auxLocais = ViagensDoidonas.get(i).getListaLocais();
                    for (int x = 0; x < auxLocais.size(); x++) {
                        for(int k = 0 ; k < listaLocais.size(); k++)
                        {
                            if(auxLocais.get(x).getNome().equals(listaLocais.get(k).getNome()))
                            {
                                listaLocais.get(k).inserePontuacao(1);
                                ArrayList<PontosInteresse> auxInt = auxLocais.get(x).getListap();
                                {
                                    for(int j = 0 ; j < auxInt.size();j++)
                                    {
                                        adiciona(auxInt.get(j));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < ViagensdeConhecimnento.size();i++) {
                StringBuilder aux = new StringBuilder();
                aux.append(ViagensdeConhecimnento.get(i).getNome() + " " + ViagensdeConhecimnento.get(i).getCustoTotal());
                if (aux.toString().equals(viagem1)) {
                    ArrayList<Locais> auxLocais = ViagensdeConhecimnento.get(i).getListaLocais();
                    for (int x = 0; x < auxLocais.size(); x++) {
                        for (int k = 0; k < listaLocais.size(); k++) {
                            if (auxLocais.get(x).getNome().equals(listaLocais.get(k).getNome())) {
                                listaLocais.get(k).inserePontuacao(1);
                                ArrayList<PontosInteresse> auxInt = auxLocais.get(x).getListap();
                                {
                                    for (int j = 0; j < auxInt.size(); j++) {
                                        adiciona(auxInt.get(j));
                                    }
                                }
                            }
                        }
                    }
                }
            }


            for (int i = 0; i < ViagensDoidonas.size(); i++) {
                StringBuilder aux = new StringBuilder();
                aux.append(ViagensDoidonas.get(i).getNome() + " " + ViagensDoidonas.get(i).getCustoTotal());
                if (aux.toString().equals(viagem1)) {
                    File f = new File("ViagemGerada.txt");

                    try {
                        FileWriter fw = new FileWriter(f);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(viagem1);
                        bw.newLine();
                        StringBuilder novo = new StringBuilder();
                        novo.append("Custo Total da Viagem: " + ViagensDoidonas.get(i).getCustoTotal());
                        bw.write(novo.toString());
                        bw.newLine();
                        ArrayList<Locais> auxLocais = ViagensDoidonas.get(i).getListaLocais();
                        for (int x = 0; x < auxLocais.size(); x++) {
                            bw.write(auxLocais.get(x).toString() + "\n" + "\n");
                            bw.newLine();
                            ArrayList<PontosInteresse> auxInteresse = auxLocais.get(x).getListap();
                            for (int j = 0; j < auxInteresse.size(); j++) {
                                bw.write(auxInteresse.get(j).toString() + "\n" + "\n");
                                bw.newLine();
                            }
                        }
                        bw.close();
                    } catch (IOException ex) {
                        System.out.println("ERROU");
                    }
                }
            }
            for (int i = 0; i < ViagensdeConhecimnento.size(); i++) {
                StringBuilder aux = new StringBuilder();
                aux.append(ViagensdeConhecimnento.get(i).getNome() + " " + ViagensdeConhecimnento.get(i).getCustoTotal());
                if (aux.toString().equals(viagem1)) {
                    File f = new File("ViagemGerada.txt");

                    try {
                        FileWriter fw = new FileWriter(f);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(viagem1);
                        bw.newLine();
                        StringBuilder novo = new StringBuilder();
                        novo.append("Custo Total da Viagem: " + ViagensdeConhecimnento.get(i).getCustoTotal());
                        bw.write(novo.toString());
                        bw.newLine();
                        ArrayList<Locais> auxLocais = ViagensdeConhecimnento.get(i).getListaLocais();
                        for (int x = 0; x < auxLocais.size(); x++) {
                            bw.write(auxLocais.get(x).toString() + "\n" + "\n");
                            bw.newLine();
                            ArrayList<PontosInteresse> auxInteresse = auxLocais.get(x).getListap();
                            for (int j = 0; j < auxInteresse.size(); j++) {
                                bw.write(auxInteresse.get(j).toString() + "\n" + "\n");
                                bw.newLine();
                            }
                        }
                        bw.close();
                    } catch (IOException ex) {
                        System.out.println("ERROU");
                    }
                }
            }
        }
    }

    private class buttonInfoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pontosInfo = (String) comboPntsIntInfo.getSelectedItem();
            String[] pontos = pontosInfo.split(":");
            for (int i = 0; i < listaInt.size(); i++) {
                if (listaInt.get(i).getNome().equals(pontos[1])) {
                    JOptionPane.showMessageDialog(null, listaInt.get(i).toString(), "Informação do Ponto de Interesse", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private class ComboInfoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String locaisInfo = (String) comboLocalInfo.getSelectedItem();
            String[] local = locaisInfo.split(":");
            for (int i = 0; i < listaLocais.size(); i++) {
                if (local[1].equals(listaLocais.get(i).getNome())) {
                    ArrayList<PontosInteresse> auxInfo = listaLocais.get(i).getListap();
                    ptInfo = new String[auxInfo.size()];
                    for (int j = 0; j < auxInfo.size(); j++) {
                        ptInfo[j] =(auxInfo.get(j).getPontuacao()+":"+ auxInfo.get(j).nome);
                        System.out.println(ptInfo[j]);
                    }
                    DefaultComboBoxModel cbInfo = new DefaultComboBoxModel(ptInfo);
                    comboPntsIntInfo.setModel(cbInfo);
                }
            }
        }
    }

    private class hotListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hotPonto = (String) comboHot.getSelectedItem();
            String [] hotp = hotPonto.split(":");
            for (int i = 0; i < listaInt.size(); i++) {
                if (listaInt.get(i).nome.equals(hotPonto)) {
                    pessoa.getHot(listaInt.get(i));
                    listaInt.get(i).inserePontuacao(2);
                    hot = hotp[1];
                    for(int j = 0 ; j < listaLocais.size();j++)
                    {
                        ArrayList<PontosInteresse> aux = listaLocais.get(j).getListap();
                        for(int k = 0; k < aux.size(); k++)
                        {
                            if(aux.get(k).getNome().equals(hotp[1]))
                            {
                                aux.get(k).inserePontuacao(1);
                            }
                        }
                    }
                }
            }
        }
    }

    private class clearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ViagensDoidonas.clear();
            ViagensdeConhecimnento.clear();
            DefaultComboBoxModel novo = new DefaultComboBoxModel();
            listaViagens.setModel(novo);
        }
    }

    private class buttonSairListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                listaAlunos.add(pessoa);
                leFicheiro d = new leFicheiro();
                d.escreveObjeto(listaLocais, listaInt, listaHash,listaAlunos);
                System.exit(0);
            }
        }

    private class geraViagens implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listaViagens.clearSelection();
            String Locais1 = (String) comboLocal1.getSelectedItem();
            String Locais2 = (String) comboLocal2.getSelectedItem();
            String Locais3 = (String) comboLocal3.getSelectedItem();
            String pnts1 = (String) listaPnts1.getSelectedValue();
            String pnts2 = (String) listaPnts2.getSelectedValue();
            String pnts3 = (String) listaPnts3.getSelectedValue();
            String hotPonto = (String) comboHot.getSelectedItem();
            System.out.println(Locais1);
            System.out.println(Locais2);
            System.out.println(Locais3);
            System.out.println(pnts1);
            System.out.println(pnts2);
            System.out.println(pnts3);
            System.out.println(hotPonto);
            System.out.println(maximo);
            ViagensDiversao(Locais1,Locais2,Locais3,pnts1,pnts2,pnts3,hotPonto);
            ViagensConhecimento(Locais1,Locais2,Locais3,pnts1,pnts2,pnts3,hotPonto);

            int tamanho1 = ViagensDoidonas.size();
            int tamanho2 = ViagensdeConhecimnento.size();

            String[] Viagens = new String[tamanho1+tamanho2];

            DefaultListModel<String>  model = new DefaultListModel<>();
            for(int i = 0; i < ViagensDoidonas.size(); i++)
            {
                StringBuilder viagensD = new StringBuilder();
                viagensD.append(ViagensDoidonas.get(i).getNome()+" "+ViagensDoidonas.get(i).getCustoTotal());
                Viagens[i] = viagensD.toString();
            }
            for(int i = 0; i < ViagensdeConhecimnento.size(); i++)
            {
                StringBuilder viagensC = new StringBuilder();
                viagensC.append(ViagensdeConhecimnento.get(i).getNome()+" "+ViagensdeConhecimnento.get(i).getCustoTotal());
                Viagens[i+3] = viagensC.toString();
            }
            DefaultComboBoxModel vg1 = new DefaultComboBoxModel(Viagens);
            listaViagens.setModel(vg1);
        }
    }

    private class LocaisListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String Locais1 = (String) comboLocal1.getSelectedItem();
            String Locais2 = (String) comboLocal2.getSelectedItem();
            String Locais3 = (String) comboLocal3.getSelectedItem();
            String[] loc1 = Locais1.split(":");
            String[] loc2 = Locais2.split(":");
            String[] loc3 = Locais3.split(":");
            for (int i = 0; i < listaLocais.size(); i++) {
                if (loc1[1].equals(listaLocais.get(i).getNome())) {
                    ArrayList<PontosInteresse> aux = listaLocais.get(i).getListap();
                    pt1 = new String[aux.size()];
                    for (int j = 0; j < aux.size(); j++) {
                        pt1[j] = aux.get(j).pontuacao+":"+aux.get(j).nome;
                        System.out.println(pt1[j]);
                    }
                    DefaultComboBoxModel cb1 = new DefaultComboBoxModel(pt1);
                    listaPnts1.setModel(cb1);
                } else if (loc2[1].equals(listaLocais.get(i).getNome())) {
                    ArrayList<PontosInteresse> aux = listaLocais.get(i).getListap();
                    pt2 = new String[aux.size()];
                    for (int j = 0; j < aux.size(); j++) {
                        pt2[j] = aux.get(j).pontuacao+":"+aux.get(j).nome;
                        System.out.println(pt2[j]);
                    }
                    DefaultComboBoxModel cb2 = new DefaultComboBoxModel(pt2);
                    listaPnts2.setModel(cb2);
                } else if (loc3[1].equals(listaLocais.get(i).getNome())) {
                    ArrayList<PontosInteresse> aux = listaLocais.get(i).getListap();
                    pt3 = new String[aux.size()];
                    for (int j = 0; j < aux.size(); j++) {
                        pt3[j] = aux.get(j).pontuacao+":"+aux.get(j).nome;
                        System.out.println(pt3[j]);
                    }
                    DefaultComboBoxModel cb3 = new DefaultComboBoxModel(pt3);
                    listaPnts3.setModel(cb3);
                }
            }
        }
    }

    /**
     *
     * @param Loc1  = 1 Locado EScolhdio
     * @param Loc2  = 2 Locado Escolhido
     * @param Loc3 = 3 Local Escolhido
     * @param P1 = 1 Ponto Interesse
     * @param P2  = 2 Ponto Interesse
     * @param P3 = 3 Ponto Interesse
     * @param hot1 = ponto Hot
     *             Funcao tem como ojetivo gerar 3 tipo de viagens
     */

    private void ViagensDiversao(String Loc1, String Loc2, String Loc3, String P1, String P2, String P3, String hot1) {
        String[]lc1 = Loc1.split(":");
        String[]lc2 =Loc2.split(":");
        String[]lc3 =Loc3.split(":");
        String[]p1 =P1.split(":");
        String[]p2 =P2.split(":");
        String[]p3 = P3.split(":");
        String[]ht1 =hot1.split(":");
        String Local1 = lc1[1];
        System.out.println(Local1);
        String Local2 = lc2[1];
        System.out.println(Local2);
        String Local3 = lc3[1];
        System.out.println(Local3);
        String PontoI1 = p1[1];

        String PontoI2 = p2[1];
        String PontoI3 = p3[1];
        String hot = ht1[1];
        for (int i = 1; i < 4; i++) {
            if (i == 1) {
                Viagem nova1 = new Viagem("Exemplo Diversao 1");
                double custo1= 0;
                for (int j = 0; j < listaLocais.size(); j++) {
                    if (listaLocais.get(j).getNome().equals(Local1)) {
                        int distancia1 = 0;
                        System.out.println(listaHash.size());
                        System.out.println("TAMANHO");
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals("Coimbra"))
                            {
                                distancia1 = Integer.parseInt(listaHash.get(z).get(Local1)) ;
                                custo1 += (double)(distancia1)*0.5;
                                System.out.println(distancia1);
                            }
                        }
                        System.out.println(distancia1);
                        Locais novoLocal1 = new Locais(listaLocais.get(j).getNome(), distancia1);
                        ArrayList<PontosInteresse> auxlocal1 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal1.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal1.get(k).getTipoI().equals("Museu") &&   !auxlocal1.get(k).equals(hot)){
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo1 += auxlocal1.get(k).custo();
                                System.out.println("custo"+custo1);
                            }
                            if (auxlocal1.get(k).getNome().equals(hot) && custo1 < maximo) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo1 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).getNome().equals(PontoI1)  && custo1 < maximo && !PontoI1.equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo1 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).custo() == 0 && !auxlocal1.get(k).getNome().equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                            }
                        }
                        nova1.insereLocal(novoLocal1);
                    }
                    if (listaLocais.get(j).getNome().equals(Local2)) {
                        int distancia2 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local1))
                            {
                                distancia2 = Integer.parseInt(listaHash.get(z).get(Local2));
                                custo1 += (double)(distancia2) * 0.5;
                                System.out.println(distancia2);
                            }
                        }
                        Locais novoLocal2 = new Locais(listaLocais.get(j).getNome(), distancia2);
                        ArrayList<PontosInteresse> auxlocal2 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal2.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal2.get(k).getNome().equals(hot) && custo1 < maximo) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                custo1 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getNome().equals(PontoI2) && custo1 < maximo && !PontoI2.equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                custo1 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).custo() == 0 && !auxlocal2.get(k).getNome().equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                            }
                        }
                        nova1.insereLocal(novoLocal2);
                    }
                    if (listaLocais.get(j).getNome().equals(Local3)) {
                        int distancia3 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local2))
                            {
                                distancia3 = Integer.parseInt(listaHash.get(z).get(Local3)) ;
                                custo1 += ((double)distancia3 * 0.5);
                                System.out.println(distancia3);
                            }
                        }
                        Locais novoLocal3 = new Locais(listaLocais.get(j).getNome(), distancia3);
                        ArrayList<PontosInteresse> auxlocal3 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal3.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal3.get(k).getNome().equals(hot) && custo1 < maximo) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                custo1 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).getNome().equals(PontoI3) && custo1 < maximo && !PontoI3.equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                custo1 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).custo() == 0 && !auxlocal3.get(k).getNome().equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                            }
                        }
                        nova1.insereLocal(novoLocal3);
                    }
                }
                System.out.println("DONE1");
                nova1.insereCustoTotal(custo1);
                System.out.println("O CUSTO E : "+custo1);
                ViagensDoidonas.add(nova1);
            }
            if (i == 2) {
                Viagem nova2 = new Viagem("Exemplo Diversao 2");
                double custo2 = 0;
                for (int j = 0; j < listaLocais.size(); j++) {
                    if (listaLocais.get(j).getNome().equals(Local1)) {
                        int distancia1 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals("Coimbra"))
                            {
                                distancia1 = Integer.parseInt(listaHash.get(z).get(Local1)) ;
                                custo2 += (double)(distancia1*0.5);
                                System.out.println(distancia1);
                            }
                        }
                        Locais novoLocal1 = new Locais(listaLocais.get(j).getNome(), distancia1);
                        ArrayList<PontosInteresse> auxlocal1 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal1.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal1.get(k).getNome().equals(hot) && custo2 < maximo) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo2 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).getNome().equals(PontoI1) && custo2 < maximo && !PontoI1.equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo2 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).custo() == 0 && !auxlocal1.get(k).getNome().equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                            }
                        }
                        nova2.insereLocal(novoLocal1);
                    }
                    if (listaLocais.get(j).getNome().equals(Local2)) {
                        int distancia2 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local1))
                            {
                                distancia2 = Integer.parseInt(listaHash.get(z).get(Local2)) ;
                                custo2 += (double)(distancia2*0.5);
                                System.out.println(distancia2);
                            }
                        }
                        Locais novoLocal2 = new Locais(listaLocais.get(j).getNome(), distancia2);
                        ArrayList<PontosInteresse> auxlocal2 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal2.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal2.get(k).getNome().equals(hot) && custo2 < maximo) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                                custo2 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getTipoI().equals("Museu") && !auxlocal2.get(k).equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                                custo2 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getNome().equals(PontoI2) && custo2 < maximo && !PontoI2.equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                                custo2 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).custo() == 0 && !auxlocal2.get(k).getNome().equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                            }
                        }
                        nova2.insereLocal(novoLocal2);
                    }
                    if (listaLocais.get(j).getNome().equals(Local3)) {
                        int distancia3 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local2))
                            {
                                distancia3 = Integer.parseInt(listaHash.get(z).get(Local3)) ;
                                custo2 += (double)(distancia3*0.5);
                                System.out.println(distancia3);
                            }
                        }
                        Locais novoLocal3 = new Locais(listaLocais.get(j).getNome(), distancia3);
                        ArrayList<PontosInteresse> auxlocal3 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal3.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal3.get(k).getNome().equals(hot) && custo2 < maximo) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                                custo2 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).getNome().equals(PontoI3) && custo2 < maximo && !PontoI3.equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                                custo2 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).custo() == 0 && !auxlocal3.get(k).getNome().equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                            }
                        }
                        nova2.insereLocal(novoLocal3);
                    }
                }
                System.out.println("DONE2");
                nova2.insereCustoTotal(custo2);
                System.out.println("O CUSTO E : "+custo2);
                ViagensDoidonas.add(nova2);
            }
            if (i == 3) {
                Viagem nova3 = new Viagem("Exemplo Diversao 3");
                double custo3 = 0;
                for (int j = 0; j < listaLocais.size(); j++) {
                    if (listaLocais.get(j).getNome().equals(Local1)) {
                        int distancia1 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals("Coimbra"))
                            {
                                distancia1 = Integer.parseInt(listaHash.get(z).get(Local1)) ;
                                custo3 += (double)(distancia1*0.5);
                                System.out.println(distancia1);
                            }
                        }
                        Locais novoLocal1 = new Locais(listaLocais.get(j).getNome(), distancia1);
                        ArrayList<PontosInteresse> auxlocal1 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal1.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal1.get(k).getNome().equals(hot) && custo3 < maximo) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo3 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).getNome().equals(PontoI1) && custo3 < maximo && !PontoI1.equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo3 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).custo() == 0 && !auxlocal1.get(k).getNome().equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                            }
                        }
                        nova3.insereLocal(novoLocal1);
                    }
                    if (listaLocais.get(j).getNome().equals(Local2)) {
                        int distancia2 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local1))
                            {
                                distancia2 = Integer.parseInt(listaHash.get(z).get(Local2)) ;
                                custo3 += (double)(distancia2*0.5);
                                System.out.println(distancia2);
                            }
                        }
                        Locais novoLocal2 = new Locais(listaLocais.get(j).getNome(), distancia2);
                        ArrayList<PontosInteresse> auxlocal2 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal2.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal2.get(k).getNome().equals(hot) && custo3 < maximo) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                                custo3 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getNome().equals(PontoI2) && custo3 < maximo && !PontoI2.equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                                custo3 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).custo() == 0 && !auxlocal2.get(k).getNome().equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                            }
                        }
                        nova3.insereLocal(novoLocal2);
                    }
                    if (listaLocais.get(j).getNome().equals(Local3)) {
                        int distancia3 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local2))
                            {
                                distancia3 = Integer.parseInt(listaHash.get(z).get(Local3)) ;
                                custo3 += (double)(distancia3*0.5);
                                System.out.println(distancia3);
                            }
                        }
                        Locais novoLocal3 = new Locais(listaLocais.get(j).getNome(), distancia3);
                        ArrayList<PontosInteresse> auxlocal3 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal3.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal3.get(k).getNome().equals(hot) && custo3 < maximo) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                                custo3 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).getNome().equals(PontoI3) && custo3 < maximo && !PontoI3.equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                                custo3 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).custo() == 0 && !auxlocal3.get(k).getNome().equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                            }
                            if (auxlocal3.get(k).getTipoI().equals("Museu") && !auxlocal3.get(k).equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                                custo3 += auxlocal3.get(k).custo();
                            }
                        }
                        nova3.insereLocal(novoLocal3);
                    }
                }
                System.out.println("DONE3");
                System.out.println("O CUSTO E : "+custo3);
                nova3.insereCustoTotal(custo3);
                ViagensDoidonas.add(nova3);
            }
        }
    }

    /**
     *
     * @param Loc1  = 1 Locado EScolhdio
     * @param Loc2  = 2 Locado Escolhido
     * @param Loc3 = 3 Local Escolhido
     * @param P1 = 1 Ponto Interesse
     * @param P2  = 2 Ponto Interesse
     * @param P3 = 3 Ponto Interesse
     * @param hot1 = ponto Hot
     *             Funcao tem como ojetivo gerar 3 tipo de viagens
     */

    private void ViagensConhecimento(String Loc1, String Loc2, String Loc3, String P1, String P2, String P3, String hot1) {
        String[]lc1 = Loc1.split(":");
        String[]lc2 =Loc2.split(":");
        String[]lc3 =Loc3.split(":");
        String[]p1 =P1.split(":");
        String[]p2 =P2.split(":");
        String[]p3 = P3.split(":");
        String[]ht1 =hot1.split(":");
        String Local1 = lc1[1];
        String Local2 = lc2[1];
        String Local3 = lc3[1];
        String PontoI1 = p1[1];
        String PontoI2 = p2[1];
        String PontoI3 = p3[1];
        String hot = ht1[1];
        for (int i = 1; i < 4; i++) {
            if (i == 1) {
                Viagem nova1 = new Viagem("Exemplo instrutivo 1");
                double custo1 = 0;
                for (int j = 0; j < listaLocais.size(); j++) {
                    if (listaLocais.get(j).getNome().equals(Local1)) {
                        int distancia1 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals("Coimbra"))
                            {
                                distancia1 = Integer.parseInt(listaHash.get(z).get(Local1)) ;
                                custo1 += (double)(distancia1*0.5);
                            }
                        }
                        Locais novoLocal1 = new Locais(listaLocais.get(j).getNome(), distancia1);
                        ArrayList<PontosInteresse> auxlocal1 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal1.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal1.get(k).getTipoI().equals("Museu")) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo1 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).getNome().equals(hot) && custo1 < maximo ) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo1 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).getNome().equals(PontoI1) && custo1 < maximo && !PontoI1.equals(hot)) {
                                    novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                                custo1 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).custo() == 0 && !auxlocal1.get(k).getNome().equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                System.out.println(auxlocal1.get(k).toString());
                            }
                        }
                        nova1.insereLocal(novoLocal1);
                    }
                    if (listaLocais.get(j).getNome().equals(Local2)) {
                        int distancia2 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local1))
                            {
                                distancia2 = Integer.parseInt(listaHash.get(z).get(Local2)) ;
                                custo1 += (double)(distancia2*0.5);
                            }
                        }
                        Locais novoLocal2 = new Locais(listaLocais.get(j).getNome(), distancia2);
                        ArrayList<PontosInteresse> auxlocal2 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal2.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal2.get(k).getTipoI().equals("Museu")) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                                custo1 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getNome().equals(hot) && custo1 < maximo) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                                custo1 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getNome().equals(PontoI2) && custo1 < maximo && !PontoI2.equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                                custo1 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).custo() == 0 && !auxlocal2.get(k).getNome().equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                System.out.println(auxlocal2.get(k).toString());
                            }
                        }
                        nova1.insereLocal(novoLocal2);
                    }
                    if (listaLocais.get(j).getNome().equals(Local3)) {
                        int distancia3 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local2))
                            {
                                distancia3 = Integer.parseInt(listaHash.get(z).get(Local3)) ;
                                custo1 += (double)(distancia3*0.5);
                            }
                        }
                        Locais novoLocal3 = new Locais(listaLocais.get(j).getNome(), distancia3);
                        ArrayList<PontosInteresse> auxlocal3 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal3.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal3.get(k).getNome().equals(hot) && custo1 < maximo) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                                custo1 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).getNome().equals(PontoI3) && custo1 < maximo && !PontoI3.equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                                custo1 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).custo() == 0 && !auxlocal3.get(k).getNome().equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                System.out.println(auxlocal3.get(k).toString());
                            }
                        }
                        nova1.insereLocal(novoLocal3);
                    }
                }
                nova1.insereCustoTotal(custo1);
                ViagensdeConhecimnento.add(nova1);
            }
            if (i == 2) {
                Viagem nova2 = new Viagem("Exemplo instrutivo 2");
                double custo2 = 0;
                for (int j = 0; j < listaLocais.size(); j++) {
                    if (listaLocais.get(j).getNome().equals(Local1)) {
                        int distancia1 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals("Coimbra"))
                            {
                                distancia1 = Integer.parseInt(listaHash.get(z).get(Local1)) ;
                                custo2 += (double)(distancia1*0.5);
                            }
                        }
                        Locais novoLocal1 = new Locais(listaLocais.get(j).getNome(),distancia1 );
                        ArrayList<PontosInteresse> auxlocal1 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal1.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal1.get(k).getNome().equals(hot) && custo2 < maximo) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                custo2 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).getNome().equals(PontoI1) && custo2 < maximo && !PontoI1.equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                custo2 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).custo() == 0 && !auxlocal1.get(k).getNome().equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                            }
                        }
                        nova2.insereLocal(novoLocal1);
                    }
                    if (listaLocais.get(j).getNome().equals(Local2)) {
                        int distancia2 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local1))
                            {
                                distancia2 = Integer.parseInt(listaHash.get(z).get(Local2)) ;
                                custo2 += (double)(distancia2*0.5);
                            }
                        }
                        Locais novoLocal2 = new Locais(listaLocais.get(j).getNome(), distancia2);
                        ArrayList<PontosInteresse> auxlocal2 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal2.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal2.get(k).getNome().equals(hot) && custo2 < maximo) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                custo2 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getTipoI().equals("Museu") && !auxlocal2.get(k).getNome().equals(hot) ) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                custo2 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getNome().equals(PontoI2) && custo2 < maximo && !PontoI2.equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                custo2 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).custo() == 0 && !auxlocal2.get(k).getNome().equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                            }
                        }
                        nova2.insereLocal(novoLocal2);
                    }
                    if (listaLocais.get(j).getNome().equals(Local3)) {
                        int distancia3 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local2))
                            {
                                distancia3 = Integer.parseInt(listaHash.get(z).get(Local3)) ;
                                custo2 += (double)(distancia3*0.5);
                            }
                        }
                        Locais novoLocal3 = new Locais(listaLocais.get(j).getNome(), distancia3);
                        ArrayList<PontosInteresse> auxlocal3 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal3.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal3.get(k).getTipoI().equals("Museu") && !auxlocal3.get(k).getNome().equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                custo2 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).getNome().equals(hot) && custo2 < maximo) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                custo2 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).getNome().equals(PontoI3) && custo2 < maximo && !PontoI3.equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                custo2 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).custo() == 0 && !auxlocal3.get(k).getNome().equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                            }
                        }
                        nova2.insereLocal(novoLocal3);
                    }
                }
                nova2.insereCustoTotal(custo2);
                ViagensdeConhecimnento.add(nova2);
            }
            if (i == 3) {
                Viagem nova3 = new Viagem("Exemplo Instrutivo 3");
                double custo3 = 0;
                for (int j = 0; j < listaLocais.size(); j++) {
                    if (listaLocais.get(j).getNome().equals(Local1)) {
                        int distancia1 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals("Coimbra"))
                            {
                                distancia1 = Integer.parseInt(listaHash.get(z).get(Local1)) ;
                                custo3 += (double)(distancia1*0.5);
                            }
                        }
                        Locais novoLocal1 = new Locais(listaLocais.get(j).getNome(), distancia1);
                        ArrayList<PontosInteresse> auxlocal1 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal1.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal1.get(k).getTipoI().equals("Museu") && !auxlocal1.get(k).getNome().equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                custo3 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).getNome().equals(hot) && custo3 < maximo) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                custo3 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).getNome().equals(PontoI1) && custo3 < maximo && !PontoI1.equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                                custo3 += auxlocal1.get(k).custo();
                            }
                            if (auxlocal1.get(k).custo() == 0 && !auxlocal1.get(k).getNome().equals(hot)) {
                                novoLocal1.inserePonto(auxlocal1.get(k));
                            }
                        }
                        nova3.insereLocal(novoLocal1);
                    }
                    if (listaLocais.get(j).getNome().equals(Local2)) {
                        int distancia2 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local1)) {
                                distancia2 = Integer.parseInt(listaHash.get(z).get(Local2));
                                custo3 += (double)(distancia2*0.5);
                            }
                        }
                        Locais novoLocal2 = new Locais(listaLocais.get(j).getNome(), distancia2);
                        ArrayList<PontosInteresse> auxlocal2 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal2.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal2.get(k).getNome().equals(hot) && custo3 < maximo) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                custo3 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getTipoI().equals("Museu") && !auxlocal2.get(k).getNome().equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                custo3 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).getNome().equals(PontoI2) && custo3 < maximo && !PontoI2.equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                                custo3 += auxlocal2.get(k).custo();
                            }
                            if (auxlocal2.get(k).custo() == 0 && !auxlocal2.get(k).getNome().equals(hot)) {
                                novoLocal2.inserePonto(auxlocal2.get(k));
                            }
                        }
                        nova3.insereLocal(novoLocal2);
                    }
                    if (listaLocais.get(j).getNome().equals(Local3)) {
                        int distancia3 = 0;
                        for(int z = 0; z < listaHash.size();z++)
                        {
                            if(listaHash.get(z).get("ID").equals(Local2))
                            {
                                distancia3 = Integer.parseInt(listaHash.get(z).get(Local3)) ;
                                custo3 += (double)(distancia3*0.5);
                            }
                        }
                        Locais novoLocal3 = new Locais(listaLocais.get(j).getNome(), distancia3);
                        ArrayList<PontosInteresse> auxlocal3 = listaLocais.get(j).getListap();
                        int tamanho = auxlocal3.size();
                        for (int k = 0; k < tamanho; k++) {
                            if (auxlocal3.get(k).getTipoI().equals("Museu") && !auxlocal3.get(k).getNome().equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                custo3 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).getNome().equals(hot) && custo3 < maximo) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                custo3 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).getNome().equals(PontoI3) && custo3 < maximo && !PontoI3.equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                                custo3 += auxlocal3.get(k).custo();
                            }
                            if (auxlocal3.get(k).custo() == 0 && !auxlocal3.get(k).getNome().equals(hot)) {
                                novoLocal3.inserePonto(auxlocal3.get(k));
                            }
                        }
                        nova3.insereLocal(novoLocal3);
                    }
                }
                nova3.insereCustoTotal(custo3);
                ViagensdeConhecimnento.add(nova3);
            }
        }
    }

    private void adiciona(PontosInteresse Pi)
    {
        for(int i = 0 ; i < listaInt.size();i++)
        {
            if(Pi.getNome().equals(listaInt.get(i).getNome()))
            {
                listaInt.get(i).inserePontuacao(1);
            }
        }
    }
}

