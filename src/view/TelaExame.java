package view;

import javax.swing.*;
import java.awt.event.*;

public class TelaExame extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelBotoes;
    private JTextField idEntrada;
    private JTextField nomeExameEntrada;
    private JTextField tipoExameEntrada;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JButton gravarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JComboBox statusEntrada;
    private JButton buttonOK;
    private JButton buttonCancel;

    public TelaExame() {
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public JPanel getJPanelDados() {
        return JPanelDados;
    }

    public JPanel getJPanelBotoes() {
        return JPanelBotoes;
    }

    public JTextField getIdEntrada() {
        return idEntrada;
    }

    public JTextField getNomeExameEntrada() {
        return nomeExameEntrada;
    }

    public JTextField getTipoExameEntrada() {
        return tipoExameEntrada;
    }

    public JButton getAdicionarButton() {
        return adicionarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JButton getGravarButton() {
        return gravarButton;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public JButton getSairButton() {
        return sairButton;
    }

    public JComboBox getStatusEntrada() {
        return statusEntrada;
    }

    public static void main(String[] args) {
        TelaExame dialog = new TelaExame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
