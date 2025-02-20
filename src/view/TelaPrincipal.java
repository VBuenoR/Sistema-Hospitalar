package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JPanel panel1;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelBotoes;
    private JButton pacienteButton;
    private JButton usuarioButton;
    private JButton medicoButton;
    private JButton enfermeiroButton;
    private JButton farmaceuticoButton;
    private JButton fornecedorButton;
    private JButton laboratorioButton;
    private JButton acompanhanteButton;

    public TelaPrincipal() {
        setTitle("Tela Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1 = new JPanel(new GridLayout(5, 6));  // Ajuste o número de linhas e colunas conforme necessarily
        add(panel1);
        panel1.add(JPanelTitulo);
        panel1.add(JPanelDados);
        panel1.add(JPanelBotoes);
        panel1.add(pacienteButton);
        panel1.add(usuarioButton);
        panel1.add(medicoButton);
        panel1.add(enfermeiroButton);
        panel1.add(farmaceuticoButton);
        panel1.add(fornecedorButton);
        panel1.add(laboratorioButton);
        panel1.add(acompanhanteButton);



        pacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaMedico telaMedico = new TelaMedico();
                telaMedico.setSize(1000, 500);
                telaMedico.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaPrincipal.setVisible(true);

    }
}
