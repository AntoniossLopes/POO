package Projeto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Login extends JFrame {
    private JLabel labelTitle;
    private JLabel labelUser;
    private JLabel labelCiclo;
    private JTextField textUser;
    private JLabel background;
    private JButton buttonLogin;
    private JComboBox ciclo;
    private JPanel panel;

    public Login() {

        super();

        panel = new JPanel();
        panel.setLayout(null);

        labelTitle = new JLabel("Viagens DEI");
        labelTitle.setFont(new Font("Agency FB", Font.PLAIN, 50));
        labelTitle.setBounds(250, 25, 300, 100);

        labelUser = new JLabel("Nome do Utilizador");
        labelUser.setFont(new Font("Candara", Font.PLAIN, 24));
        labelUser.setBounds(100, 100, 200, 100);

        textUser = new JTextField(20);
        textUser.setBounds(200, 175, 200, 25);

        labelCiclo = new JLabel("Ciclo que frequenta");
        labelCiclo.setFont(new Font("Candara", Font.PLAIN, 24));
        labelCiclo.setBounds(100, 200, 400, 100);

        String[] nCiclos = {"Licenciatura", "Mestrado"};
        ciclo = new JComboBox(nCiclos);
        ciclo.setBounds(200, 275, 200, 25);

        buttonLogin = new JButton("Iniciar");
        buttonLogin.setBounds(250, 350, 200, 25);

        ImageIcon dei = new ImageIcon("DEImg.png");
        background = new JLabel("", dei, JLabel.CENTER);
        background.setBounds(0, 0, 700, 500);


        panel.add(labelTitle);
        panel.add(labelUser);
        panel.add(textUser);
        panel.add(labelCiclo);
        panel.add(ciclo);
        panel.add(buttonLogin);
        panel.add(background);

        buttonLogin.addActionListener(new ButtonLogin());

        this.add(panel);
    }

    private class ButtonLogin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nome = textUser.getText();
                String tipo = (String)ciclo.getSelectedItem();
                System.out.println(nome);
                System.out.println(tipo);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Morreu");
            }
        }
    }

    public static void main(String[] args) {
        Login frame = new Login();
        frame.setTitle("Viagens DEI");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
