package view.busca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class TelaBuscaUsuario extends JDialog {
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



    public TelaBuscaUsuario() {
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
        model.addColumn("Nome Social");
        model.addColumn("Login");
        model.addColumn("Senha");
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

    public JTextField getTextField1() {
        return textField1;
    }

    public JTable getTable1() {
        return table1;
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
        TelaBuscaUsuario dialog = new TelaBuscaUsuario();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
