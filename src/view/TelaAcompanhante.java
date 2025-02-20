package view;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;

public class TelaAcompanhante extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelBotoes;
    private JTextField idEntrada;
    private JFormattedTextField cpfEntrada;
    private JTextField nomeEntrada;
    private JTextField grauParentescoEntrada;
    private JFormattedTextField telefoneEntrada;
    private JTextField emailEntrada;
    private JComboBox statusEntrada;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JButton gravarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public TelaAcompanhante() {
        setContentPane(contentPane);
        setModal(true);


        //Formatação para cpf
        try {
            MaskFormatter cpfFormatter = new MaskFormatter("***.***.***-**");
            cpfFormatter.setPlaceholderCharacter('*');
            cpfEntrada.setFormatterFactory(new DefaultFormatterFactory(cpfFormatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //formatação para telefone 1
        try {
            MaskFormatter telefone1Formatter = new MaskFormatter("(**) * ****-****");
            telefone1Formatter.setPlaceholderCharacter('*');
            telefoneEntrada.setFormatterFactory(new DefaultFormatterFactory(telefone1Formatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }

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

    public JPanel getJPanelBotoes() {
        return JPanelBotoes;
    }

    public JTextField getIdEntrada() {
        return idEntrada;
    }

    public JFormattedTextField getCpfEntrada() {
        return cpfEntrada;
    }

    public JTextField getNomeEntrada() {
        return nomeEntrada;
    }

    public JTextField getGrauParentescoEntrada() {
        return grauParentescoEntrada;
    }

    public JFormattedTextField getTelefoneEntrada() {
        return telefoneEntrada;
    }

    public JTextField getEmailEntrada() {
        return emailEntrada;
    }

    public JComboBox getStatusEntrada() {
        return statusEntrada;
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

    public JPanel getJPanelDados() {
        return JPanelDados;
    }

    public static void main(String[] args) {
        TelaAcompanhante dialog = new TelaAcompanhante();
        dialog.setSize(300, 400);
        dialog.setTitle("Cadastrar Acompanhante");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
