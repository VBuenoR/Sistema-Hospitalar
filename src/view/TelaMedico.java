package view;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaMedico extends JDialog {
    private JPanel contentPane;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JPanel JPanelBotoes;
    private JButton gravarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JTextField idEntrada;
    private JTextField nomeEntrada;
    private JFormattedTextField telefone1Entrada;
    private JFormattedTextField telefone2Entrada;
    private JTextField emailEntrada;
    private JFormattedTextField cpfCnpjEntrada;
    private JTextField rgInscricaoEstaEntrada;
    private JTextField dataCadastroEntrada;
    private JFormattedTextField cepEntrada;
    private JTextField cidadeEntrada;
    private JTextField bairroEntrada;
    private JTextField logradouroEntrada;
    private JLabel Complemento;
    private JTextField ComplementoEntrada;
    private JTextField crmEntrada;
    private JTextField nomeSocialEntrada;
    private JTextField loginEntrada;
    private JPasswordField SenhaEntrada;
    private JComboBox comboBoxSexoEntrada;
    private JComboBox statusEntrada;


    public TelaMedico() {
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }



    //Esse setDataCadastroEntrada, faz com que na tela de cadastro, seja iniciada com a data atual//
    private void setDataCadastroEntrada(){
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        String currentdate = data.format(new Date());
        dataCadastroEntrada.setText(currentdate);
    }

    public JComboBox getComboBoxSexoEntrada() {
        return comboBoxSexoEntrada;
    }

    public JButton getAdicionarButton() {
        return adicionarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JPanel getJPanelBotoes() {
        return JPanelBotoes;
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

    public JTextField getDataCadastroEntrada() {
        return dataCadastroEntrada;
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
        return ComplementoEntrada;
    }

    public JTextField getCrmEntrada() {
        return crmEntrada;
    }

    public JTextField getLoginEntrada() {
        return loginEntrada;
    }

    public JTextField getNomeSocialEntrada() {
        return nomeSocialEntrada;
    }

    public JPasswordField getSenhaEntrada() {
        return SenhaEntrada;
    }

    public JComboBox getStatusEntrada() {
        return statusEntrada;
    }

    public static void main(String[] args) {
        TelaMedico dialog = new TelaMedico();
        dialog.setSize(300, 400);
        dialog.setTitle("Cadastrar Modelo");
        dialog.setDataCadastroEntrada();
        dialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }


}
