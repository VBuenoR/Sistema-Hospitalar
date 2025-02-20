package controller.busca;

import controller.ControllerCadastroLaboratorio;
import model.Laboratorio;
import view.busca.TelaBuscaLaboratorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaLaboratorio implements ActionListener {
    TelaBuscaLaboratorio telaBuscaLaboratorio;

    public ControllerBuscaLaboratorio(TelaBuscaLaboratorio telaBuscaLaboratorio) {
        this.telaBuscaLaboratorio = telaBuscaLaboratorio;

        this.telaBuscaLaboratorio.getCarregarButton().addActionListener(this);
        this.telaBuscaLaboratorio.getFecharButton().addActionListener(this);
        this.telaBuscaLaboratorio.getFiltrarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaLaboratorio.getCarregarButton()) {
            if (this.telaBuscaLaboratorio.getTable1().
                    getValueAt(this.telaBuscaLaboratorio.getTable1().getSelectedRow(), 3).equals("A")) {
                ControllerCadastroLaboratorio.codigo = (int) this.telaBuscaLaboratorio.getTable1().
                        getValueAt(this.telaBuscaLaboratorio.getTable1().getSelectedRow(), 0);
                this.telaBuscaLaboratorio.dispose();
            }

            this.telaBuscaLaboratorio.dispose();

        } else if (evento.getSource() == telaBuscaLaboratorio.getFiltrarButton()) {
            if (this.telaBuscaLaboratorio.getTextFieldEntradaFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaLaboratorio.getTextFieldEntradaFiltro().requestFocus();
            } else {
                if (this.telaBuscaLaboratorio.getComboBoxFiltro().getSelectedItem().equals("ID")){
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getTable1().getModel();
                    tabela.setRowCount(0);
                    Laboratorio laboratorio = service.LaboratorioService.ler(Integer.parseInt(this.telaBuscaLaboratorio.getTextFieldEntradaFiltro().getText()));
                    tabela.addRow(new Object[]{
                            laboratorio.getId(),
                            laboratorio.getNomeFantasia(),
                            laboratorio.getContato(),
                            laboratorio.getStatus()
                    });

                } else if (this.telaBuscaLaboratorio.getComboBoxFiltro().getSelectedItem().equals("Nome Fantasia")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getTable1().getModel();
                    tabela.setRowCount(0);

                    for (Laboratorio objetoAtualDaLista : service.LaboratorioService.ler(this.telaBuscaLaboratorio.getTextFieldEntradaFiltro().getText(), "nomeFantasia")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaLaboratorio.getComboBoxFiltro().getSelectedItem().equals("Contato")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getTable1().getModel();
                    tabela.setRowCount(0);

                    for (Laboratorio objetoAtualDaLista : service.LaboratorioService.ler(this.telaBuscaLaboratorio.getTextFieldEntradaFiltro().getText(), "contato")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaLaboratorio.getComboBoxFiltro().getSelectedItem().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getTable1().getModel();
                    tabela.setRowCount(0);

                    for (Laboratorio objetoAtualDaLista : service.LaboratorioService.ler(this.telaBuscaLaboratorio.getTextFieldEntradaFiltro().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                }
            }

        } else if (evento.getSource() == this.telaBuscaLaboratorio.getFecharButton()) {
            this.telaBuscaLaboratorio.dispose();
        }

    }
}
