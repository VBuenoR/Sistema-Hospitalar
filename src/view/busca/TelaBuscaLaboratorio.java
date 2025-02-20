package view.busca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class TelaBuscaLaboratorio extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JpanelFiltros;
    private JTable table1;
    private JComboBox comboBoxFiltro;
    private JTextField textFieldEntradaFiltro;
    private JButton filtrarButton;
    private JButton fecharButton;
    private JButton carregarButton;
    private JScrollPane scrollPane;


    public TelaBuscaLaboratorio() {
        setContentPane(contentPane);
        setModal(true);

        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            // Ai voce pode escolher
            table1.getColumnModel().getColumn(0).setWidth(0);
        }


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome Fantasia");
        model.addColumn("Contato");
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public JButton getCarregarButton() {
        return carregarButton;
    }

    public JButton getFecharButton() {
        return fecharButton;
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

    public JPanel getJpanelFiltros() {
        return JpanelFiltros;
    }

    public JPanel getJPanelDados() {
        return JPanelDados;
    }

    public JPanel getJPanelTitulo() {
        return JPanelTitulo;
    }


    public static void main(String[] args) {
        TelaBuscaLaboratorio dialog = new TelaBuscaLaboratorio();
        dialog.setSize(1000,500);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
