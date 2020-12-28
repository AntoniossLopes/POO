package Projeto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * E chamada A calsse leFicheiro de maneira a ler os ficheiros objetos e obter as suas listas ; apos estes processos, chama se a classe que cria o menu
 */

public class Main {
     public static void main(String[] args) throws IOException, ClassNotFoundException {
         leFicheiro d = new leFicheiro();
         d.leObjecto();
         ArrayList<Locais> listaLocais = d.getListaLocais();
         ArrayList<PontosInteresse> listaPontos = d.getListaInt();
         List<Map<String,String>> listaHash = d.getListHasmap();
         System.out.println("TAMANHOO");
         System.out.println(listaHash.size());
         for(int i = 0 ; i < listaLocais.size();i++)
         {
             System.out.println(listaLocais.get(i).toString());
         }

         for(int j = 0; j < listaPontos.size();j++)
         {
             System.out.println(listaPontos.get(j).toString());
         }
         ArrayList<Alunos> listaALunos = d.getObjAlunos();
         for(int i = 0; i < listaALunos.size();i++)
         {
             System.out.println(listaALunos.get(i).nome);
         }
         GUITeste frame = new GUITeste(listaLocais,listaPontos,listaHash,listaALunos);
        frame.setTitle("Viagens DEI");
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
   }
}
