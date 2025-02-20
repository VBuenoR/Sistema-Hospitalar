package controller.busca;

import controller.ControllerCadastroAla;
import controller.ControllerCadastroLaboratorio;
import model.Ala;
import model.ClasseDadosGravacao;
import model.Laboratorio;
import view.busca.TelaBuscaAla;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaAla implements ActionListener {
    TelaBuscaAla telaBuscaAla;

    public ControllerBuscaAla(TelaBuscaAla telaBuscaAla) {
        this.telaBuscaAla = telaBuscaAla;

        this.telaBuscaAla.getCarregarButton().addActionListener(this);
        this.telaBuscaAla.getFecharButton().addActionListener(this);
        this.telaBuscaAla.getFiltrarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaAla.getCarregarButton()) {
            if (this.telaBuscaAla.getTable1().
                    getValueAt(this.telaBuscaAla.getTable1().getSelectedRow(), 2).equals("A")) {
                ControllerCadastroAla.codigo = (int) this.telaBuscaAla.getTable1().
                        getValueAt(this.telaBuscaAla.getTable1().getSelectedRow(), 0);

                this.telaBuscaAla.dispose();
            }

        } else if (evento.getSource() == telaBuscaAla.getFiltrarButton()) {

            if (this.telaBuscaAla.getTextFieldEntradaFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaAla.getTextFieldEntradaFiltro().requestFocus();
            } else {
                if (this.telaBuscaAla.getComboBoxFiltro().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getTable1().getModel();
                    tabela.setRowCount(0);
                    Ala ala = service.AlaService.ler(Integer.parseInt(this.telaBuscaAla.getTextFieldEntradaFiltro().getText().trim()));
                    tabela.addRow(new Object[]{
                            ala.getId(),
                            ala.getStatus(),
                            ala.getDescricao()
                    });

                } else if (this.telaBuscaAla.getComboBoxFiltro().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Ala objetoAtualDaLista : service.AlaService.ler(this.telaBuscaAla.getTextFieldEntradaFiltro().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getDescricao()
                        });
                    }
                } else if (this.telaBuscaAla.getComboBoxFiltro().getSelectedItem().toString().equals("Descrição")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Ala objetoAtualDaLista : service.AlaService.ler(this.telaBuscaAla.getTextFieldEntradaFiltro().getText(), "descricao")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getDescricao()
                        });
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaAla.getFecharButton()) {
            this.telaBuscaAla.dispose();
        }

    }
}
