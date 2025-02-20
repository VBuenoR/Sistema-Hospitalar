package view.busca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;

public class TelaBuscaEnfermeiro extends JDialog {
    private JPanel contentPane;
    private JPanel JPanelTitulo;
    private JPanel JPanelDados;
    private JPanel JPanelFiltros;
    private JTable table1;
    private JTextField textFieldEntradaFiltro;
    private JComboBox comboBoxFiltro;
    private JButton filtrarButton;
    private JButton carregarButton;
    private JButton FecharButton;
    private JScrollPane scrollPane;


    public TelaBuscaEnfermeiro() {
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
        model.addColumn("Sexo");
        model.addColumn("CRE");
        model.addColumn("Login");
        model.addColumn("Senha");
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
       ajustarLarguraColunas(table1);


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

    public JTextField getTextFieldEntradaFiltro() {
        return textFieldEntradaFiltro;
    }

    public JButton getFiltrarButton() {
        return filtrarButton;
    }

    public JComboBox getComboBoxFiltro() {
        return comboBoxFiltro;
    }

    public JButton getCarregarButton() {
        return carregarButton;
    }

    public JButton getFecharButton() {
        return FecharButton;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TelaBuscaEnfermeiro dialog = new TelaBuscaEnfermeiro();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


    public void ajustarLarguraColunas(JTable table) {
        for (int coluna = 0; coluna < table.getColumnCount(); coluna++) {
            TableColumn colunaDaTabela = table.getColumnModel().getColumn(coluna);
            int larguraMaxima = 0;

            // Encontrar a largura máxima de cada célula na coluna
            for (int linha = 0; linha < table.getRowCount(); linha++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(linha, coluna);
                Component componenteCelula = table.prepareRenderer(cellRenderer, linha, coluna);
                larguraMaxima = Math.max(componenteCelula.getPreferredSize().width, larguraMaxima);
            }

            // Considerar também o cabeçalho da coluna
            TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Component componenteCabecalho = headerRenderer.getTableCellRendererComponent(table, table.getColumnName(coluna), false, false, -1, coluna);
            larguraMaxima = Math.max(componenteCabecalho.getPreferredSize().width, larguraMaxima);

            // Adicionar um pequeno espaço extra
            larguraMaxima += 2;

            // Definir a largura preferencial da coluna
            colunaDaTabela.setPreferredWidth(larguraMaxima);
        }
    }

}

