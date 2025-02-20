package view.busca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class TelaBuscaFornecedor extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelFiltros;
    private JTable table1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton filtrarButton;
    private JButton carregarButton;
    private JButton fecharButton;
    private JScrollPane scrollPane;


    public TelaBuscaFornecedor() {
        setContentPane(contentPane);
        setModal(true);


        if (table1.getColumnModel().getColumnCount() > 0) {
            //table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Data de Cadastro");
        model.addColumn("Nome");
        model.addColumn("Nome Social");
        model.addColumn("Contato");
        model.addColumn("Telefone 1");
        model.addColumn("Telefone 2");
        model.addColumn("Email");
        model.addColumn("RG");
        model.addColumn("CPF");
        model.addColumn("CEP");
        model.addColumn("Cidade");
        model.addColumn("Bairro");
        model.addColumn("Logradouro");
        model.addColumn("Complemento");
        model.addColumn("Status");



        table1.setModel(model);
        //ajustarLarguraColunas(table1);


        // Colocar a JTable em um JScrollPane para exibir os cabeçalhos
        scrollPane = new JScrollPane(table1);
        table1.getAutoResizeMode();

        // Adicionar o JScrollPane ao JPanel de dados
        JPanelDados.setLayout(new BoxLayout(JPanelDados, BoxLayout.Y_AXIS));
        JPanelDados.add(scrollPane);




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
    }

    public JTable getTable1() {
        return table1;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JButton getFiltrarButton() {
        return filtrarButton;
    }

    public JButton getCarregarButton() {
        return carregarButton;
    }

    public JButton getFecharButton() {
        return fecharButton;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TelaBuscaFornecedor dialog = new TelaBuscaFornecedor();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
