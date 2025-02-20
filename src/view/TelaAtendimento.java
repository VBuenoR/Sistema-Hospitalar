package view;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaAtendimento extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelBotoes;
    private JTextField idEntrada;
    private JTextField dataHoraEntrada;
    private JTextField usuarioEntrada;
    private JTextField medicoEntrada;
    private JTextField enfermeiroEntrada;
    private JTextField pacienteEntrada;
    private JTextField pressaoEntrada;
    private JTextField temperaturaEntrada;
    private JTextField bpmEntrada;
    private JTextField oximetriaEntrada;
    private JTextArea historicoDoencasEntrada;
    private JTextArea alergiasEntrada;
    private JTextArea medicacoesEmUsoEntrada;
    private JTextArea anamneseEntrada;
    private JTextField tipoAtendimentoEntrada;
    private JTextField classificacaoEntrada;
    private JTextArea observacoesEntrada;
    private JTextField statusEntrada;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JButton gravarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public TelaAtendimento() {
        setContentPane(contentPane);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilities.Utilities.ativaDesativa(true, JPanelBotoes);
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilities.Utilities.ativaDesativa(false, JPanelBotoes);
            }
        });

        gravarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilities.Utilities.ativaDesativa(false, JPanelBotoes);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilities.Utilities.ativaDesativa(true, JPanelBotoes);
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    private void setdataHoraEntrada(){
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy | hh:mm");
        String currentdate = data.format(new Date());
        dataHoraEntrada.setText(currentdate);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TelaAtendimento dialog = new TelaAtendimento();
        dialog.setSize(300, 400);
        dialog.setTitle("Atendimento");
        dialog.setdataHoraEntrada();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
