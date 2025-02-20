package view;

import dao.AlaDAO;
import dao.QuartoDAO;
import model.Ala;
import model.Quarto;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.*;
import java.util.List;

public class TelaQuarto extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelBotoes;
    private JTextField idEntrada;
    private JComboBox alaEntrada;
    private JTextArea descricaoEntrada;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JButton gravarButton;
    private JButton buscarButton;
    private JButton sairButton;
    private JComboBox statusEntrada;

    public TelaQuarto() {
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

        alaEntrada.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                AlaDAO alaDAO = new AlaDAO();
                List<Ala> listaAlas = alaDAO.retrieve();

                for (Ala ala : listaAlas) {
                    alaEntrada.addItem(ala);
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
        gravarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegar os dados do formulário
                Ala alaSelecionada = (Ala) alaEntrada.getSelectedItem();
                String status = (String) statusEntrada.getSelectedItem();
                String descricao = descricaoEntrada.getText();

                // Criar um novo Quarto
                Quarto novoQuarto = new Quarto();
                novoQuarto.setAla(alaSelecionada);
                novoQuarto.setStatus(status);
                novoQuarto.setDescricao(descricao);

                // Salvar no banco de dados
                QuartoDAO quartoDAO = new QuartoDAO();
                quartoDAO.create(novoQuarto);

                // Desativar botões após gravação
                utilities.Utilities.ativaDesativa(false, JPanelBotoes);

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

    public JPanel getJPanelTitulo() {
        return JPanelTitulo;
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

    public JComboBox getAlaEntrada() {
        return alaEntrada;
    }

    public JTextArea getDescricaoEntrada() {
        return descricaoEntrada;
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
        TelaQuarto dialog = new TelaQuarto();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
