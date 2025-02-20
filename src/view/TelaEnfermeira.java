package view;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaEnfermeira extends JDialog {
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
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JFormattedTextField cpfCnpjEntrada;
    private JTextField rgInscricaoEstaEntrada;
    private JFormattedTextField cepEntrada;
    private JTextField cidadeEntrada;
    private JTextField bairroEntrada;
    private JTextField logradouroEntrada;
    private JTextField complementoEntrada;
    private JTextField creEntrada;
    private JTextField nomeSocialEntrada;
    private JTextField loginEntrada;
    private JPasswordField senhaEntrada;
    private JButton gravarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JComboBox comboBoxSexoEntrada;
    private JComboBox statusEntrada;

    public TelaEnfermeira() {
        setContentPane(contentPane);
        setModal(true);

        //Formatação para cpf
        try {
            MaskFormatter cpfFormatter = new MaskFormatter("***.***.***-**");
            cpfFormatter.setPlaceholderCharacter('*');
            cpfCnpjEntrada.setFormatterFactory(new DefaultFormatterFactory(cpfFormatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //formatação para telefone 1
        try {
            MaskFormatter telefone1Formatter = new MaskFormatter("(**) * ****-****");
            telefone1Formatter.setPlaceholderCharacter('*');
            telefone1Entrada.setFormatterFactory(new DefaultFormatterFactory(telefone1Formatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //formatação para telefone 2
        try {
            MaskFormatter telefone2Formatter = new MaskFormatter("(**) * ****-****");
            telefone2Formatter.setPlaceholderCharacter('*');
            telefone2Entrada.setFormatterFactory(new DefaultFormatterFactory(telefone2Formatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //formatação para cep
        try {
            MaskFormatter cepFormatter = new MaskFormatter("*****-***");
            cepFormatter.setPlaceholderCharacter('*');
            cepEntrada.setFormatterFactory(new DefaultFormatterFactory(cepFormatter));
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

        idEntrada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

    }


    //Esse setDataCadastroEntrada, faz com que na tela de cadastro, seja iniciada com a data atual//
    private void setDataCadastroEntrada(){
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        String currentdate = data.format(new Date());
        dataCadastroEntrada.setText(currentdate);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public JComboBox getComboBoxSexoEntrada() {
        return comboBoxSexoEntrada;
    }

    public JPanel getJPanelDados() {
        return JPanelDados;
    }

    public JPanel getJPanelBotoes() {
        return JPanelBotoes;
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

    public JButton getAdicionarButton() {
        return adicionarButton;
    }

    public JFormattedTextField getCpfCnpjEntrada() {
        return cpfCnpjEntrada;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JTextField getRgInscricaoEstaEntrada() {
        return rgInscricaoEstaEntrada;
    }

    public JTextField getCidadeEntrada() {
        return cidadeEntrada;
    }

    public JFormattedTextField getCepEntrada() {
        return cepEntrada;
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

    public JTextField getCreEntrada() {
        return creEntrada;
    }

    public JTextField getNomeSocialEntrada() {
        return nomeSocialEntrada;
    }

    public JTextField getLoginEntrada() {
        return loginEntrada;
    }

    public JPasswordField getSenhaEntrada() {
        return senhaEntrada;
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
        TelaEnfermeira dialog = new TelaEnfermeira();
        dialog.setDataCadastroEntrada();
        dialog.setSize(300, 400);
        dialog.setTitle("Cadastrar Enfermeira");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
