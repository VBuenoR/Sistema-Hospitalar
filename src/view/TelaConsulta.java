package view;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaConsulta extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelBotoes;
    private JPanel JPanelDados;
    private JPanel JPanelTitulo;
    private JTextField idEntrada;
    private JTextField dataHoraEntrada;
    private JTextArea anamneseEntrada;
    private JTextArea diagnosticoEntrada;
    private JTextField responsavelEntrada;
    private JTextArea prescricaoEntrada;
    private JTextArea observacoesEntrada;
    private JTextField statusEntrada;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JButton gravarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public TelaConsulta() {
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
        TelaConsulta dialog = new TelaConsulta();
        dialog.setdataHoraEntrada();
        dialog.setTitle("Consulta");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
