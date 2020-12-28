/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Classe Responsavel Por criar Menu De Login e Estabelecer Liagacao com Os restantes Menus
 */

//Login inicial
public class GUITeste extends JFrame{
    private JPanel panel;
    private JLabel labelTitle,labelUser,labelCiclo,labelSaldo,background;
    private JTextField textUser,textSaldo;
    private JComboBox ciclo;
    private JButton buttonLogin;
    private ImageIcon dei;
    private ArrayList<Locais> listaLocais;
    private ArrayList<PontosInteresse> listaInt;
    private  List<Map<String,String>> listaHash;
    private ArrayList<Alunos> objAlunos = new ArrayList<>();
   /* public static void main(String[] args){
        GUITeste frame = new GUITeste();
        frame.setTitle("Viagens DEI");
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }*/
    
    //Inner class
    private class ButtonLoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(textUser.getText().trim().isEmpty() || textSaldo.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Parametros por preencher","ERRO",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String nome = textUser.getText();
                    String tipo = (String)ciclo.getSelectedItem();
                    String orcamento = textSaldo.getText();
                    double saldo = Double.parseDouble(orcamento);
                    if(tipo.equals("Mestrado"))
                    {
                        Mestrado novo = new Mestrado(nome,tipo);
                        System.out.println("Mestrado");
                        GUITeste3 frame = new GUITeste3(listaLocais,saldo,novo,listaInt,listaHash,objAlunos);
                        frame.setTitle("Viagens DEI");
                        frame.setSize(1280,720);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);

                    }
                    else if(tipo.equals("Licenciatura"))
                    {
                        Licenciatura novo = new Licenciatura(nome,tipo);
                        System.out.println("Feito");
                        GUITeste2 frame = new GUITeste2(listaLocais,saldo,novo,listaInt,listaHash,objAlunos);
                        frame.setTitle("Viagens DEI");
                        frame.setSize(1280,720);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                }
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Estás todo cego","ERRO",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public GUITeste(ArrayList<Locais> listaLocais, ArrayList<PontosInteresse> listaInt, List<Map<String,String>> listaHash,ArrayList<Alunos> objAlunos){
        super();
        this.listaInt = listaInt;
        this.listaLocais = listaLocais;
        this.listaHash = listaHash;
        this.objAlunos = objAlunos;
        
        labelTitle = new JLabel("Viagens DEI");
        labelTitle.setFont(new Font("Agency FB",Font.BOLD,75));
        labelTitle.setBounds(500,10,300,100);

        labelUser = new JLabel("Nome do Utilizador");
        labelUser.setFont(new Font("Candara",Font.PLAIN,40));
        labelUser.setBounds(200,150,600,100);
        
        textUser = new JTextField(20);
        textUser.setBounds(700,190,200,25);
        
        labelCiclo = new JLabel("Ciclo que frequenta");
        labelCiclo.setFont(new Font("Candara",Font.PLAIN,40));
        labelCiclo.setBounds(200,250,600,100);

        String[] nCiclos = {"Licenciatura","Mestrado"};
        ciclo = new JComboBox(nCiclos);
        ciclo.setBounds(700,290,200,25);
        
        labelSaldo = new JLabel("Orçamento máximo");
        labelSaldo.setFont(new Font("Candara",Font.PLAIN,40));
        labelSaldo.setBounds(200,350,600,100);
        
        textSaldo = new JTextField(20);
        textSaldo.setBounds(700,390,200,25);
        
        buttonLogin = new JButton("Iniciar");
        buttonLogin.setBounds(500,550,200,25);
        
        dei = new ImageIcon("DEImg.png");
        background = new JLabel("",dei,JLabel.CENTER);
        background.setBounds(0,0,1280,720);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(labelTitle);
        panel.add(labelUser);
        panel.add(textUser);
        panel.add(labelCiclo);
        panel.add(ciclo);
        panel.add(labelSaldo);
        panel.add(textSaldo);
        panel.add(buttonLogin);
        panel.add(background);
        
        buttonLogin.addActionListener(new ButtonLoginListener());
        
        this.add(panel);
    }
}
