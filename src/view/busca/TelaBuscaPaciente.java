package view.busca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class TelaBuscaPaciente extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelFiltros;
    private JTable table1;
    private JTextField textFieldEntradaFiltro;
    private JComboBox comboBoxFiltro;
    private JButton filtrarButton;
    private JButton carregarButton;
    private JButton fecharButton;
    private JScrollPane scrollPane;


    public TelaBuscaPaciente() {
        contentPane.setSize(1950,720);
        setContentPane(contentPane);
        setModal(true);

        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setWidth(30);
            table1.getColumnModel().getColumn(1).setWidth(380);
            table1.getColumnModel().getColumn(2).setMaxWidth(150);
            table1.getColumnModel().getColumn(3).setMaxWidth(60);
            table1.getColumnModel().getColumn(4).setMaxWidth(60);
        }
        table1.revalidate();


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Data de Cadastro");
        model.addColumn("Nome");
        model.addColumn("Nome Social");
        model.addColumn("Sexo");
        model.addColumn("Tipo Sanguineo");
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

        // Colocar a JTable em um JScrollPane para exibir os cabeçalhos
        scrollPane = new JScrollPane(table1);

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

    public JButton getFecharButton() {
        return fecharButton;
    }

    public JButton getCarregarButton() {
        return carregarButton;
    }

    public JButton getFiltrarButton() {
        return filtrarButton;
    }

    public JComboBox getComboBoxFiltro() {
        return comboBoxFiltro;
    }

    public JTextField getTextFieldEntradaFiltro() {
        return textFieldEntradaFiltro;
    }

    public JTable getTable1() {
        return table1;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TelaBuscaPaciente dialog = new TelaBuscaPaciente();
        dialog.setSize(1980,720);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
