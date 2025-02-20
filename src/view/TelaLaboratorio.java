package view;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaLaboratorio extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelBotoes;
    private JTextField dataCadastroEntrada;
    private JTextField idEntrada;
    private JTextField nomeEntrada;
    private JFormattedTextField telefone1Entrada;
    private JFormattedTextField telefone2Entrada;
    private JTextField emailEntrada;
    private JFormattedTextField cpfCnpjEntrada;
    private JTextField rgInscricaoEstaEntrada;
    private JFormattedTextField cepEntrada;
    private JTextField cidadeEntrada;
    private JTextField bairroEntrada;
    private JTextField logradouroEntrada;
    private JTextField complementoEntrada;
    private JTextField nomeFantasiaEntrada;
    private JTextField contatoEntrada;
    private JComboBox statusEntrada;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JButton gravarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public TelaLaboratorio() {
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
               // utilities.Utilities.ativaDesativa(true, JPanelBotoes);
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //utilities.Utilities.ativaDesativa(false, JPanelBotoes);
            }
        });

        gravarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //utilities.Utilities.ativaDesativa(false, JPanelBotoes);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //utilities.Utilities.ativaDesativa(true, JPanelBotoes);
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //dispose();
            }
        });
    }
    //Esse setDataCadastroEntrada, faz com que na tela de cadastro, seja iniciada com a data atual//
    private void setDataCadastroEntrada(){
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        String currentdate = data.format(new Date());
        dataCadastroEntrada.setText(currentdate);
    }

    public JTextField getDataCadastroEntrada() {
        return dataCadastroEntrada;
    }

    public JTextField getIdEntrada() {
        return idEntrada;
    }

    public JTextField getNomeEntrada() {
        return nomeEntrada;
    }

    public JFormattedTextField getTelefone1Entrada() {
        return telefone1Entrada;
    }

    public JFormattedTextField getTelefone2Entrada() {
        return telefone2Entrada;
    }

    public JTextField getEmailEntrada() {
        return emailEntrada;
    }

    public JFormattedTextField getCpfCnpjEntrada() {
        return cpfCnpjEntrada;
    }

    public JTextField getRgInscricaoEstaEntrada() {
        return rgInscricaoEstaEntrada;
    }

    public JFormattedTextField getCepEntrada() {
        return cepEntrada;
    }

    public JTextField getCidadeEntrada() {
        return cidadeEntrada;
    }

    public JTextField getBairroEntrada() {
        return bairroEntrada;
    }

    public JTextField getLogradouroEntrada() {
        return logradouroEntrada;
    }

    public JTextField getComplementoEntrada() {
        return complementoEntrada;
    }

    public JTextField getNomeFantasiaEntrada() {
        return nomeFantasiaEntrada;
    }

    public JTextField getContatoEntrada() {
        return contatoEntrada;
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

    public JButton getButtonOK() {
        return buttonOK;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public JPanel getJPanelBotoes() {
        return JPanelBotoes;
    }

    public JPanel getJPanelDados() {
        return JPanelDados;
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
        TelaLaboratorio dialog = new TelaLaboratorio();
        dialog.setSize(300, 400);
        dialog.setDataCadastroEntrada();
        dialog.setTitle("Cadastrar Laboratorio");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
