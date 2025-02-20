package controller.busca;

import controller.ControllerCadastroLeito;
import controller.ControllerCadastroQuarto;
import model.ClasseDadosGravacao;
import model.Leito;
import model.Quarto;
import view.busca.TelaBuscaLeito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaLeito implements ActionListener {
    TelaBuscaLeito telaBuscaLeito;

    public ControllerBuscaLeito(TelaBuscaLeito telaBuscaLeito) {
        this.telaBuscaLeito = telaBuscaLeito;
        this.telaBuscaLeito.getCarregarButton().addActionListener(this);
        this.telaBuscaLeito.getFecharButton().addActionListener(this);
        this.telaBuscaLeito.getFiltrarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaLeito.getCarregarButton()) {
            if (this.telaBuscaLeito.getTable1().
                    getValueAt(this.telaBuscaLeito.getTable1().getSelectedRow(), 5).equals("A")) {
                ControllerCadastroLeito.codigo = (int) this.telaBuscaLeito.getTable1().
                        getValueAt(this.telaBuscaLeito.getTable1().getSelectedRow(), 0);

                this.telaBuscaLeito.dispose();
            }

        } else if (evento.getSource() == telaBuscaLeito.getFiltrarButton()) {

            if (this.telaBuscaLeito.getTextFieldEntradaFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaLeito.getTextFieldEntradaFiltro().requestFocus();
            } else {
                if (this.telaBuscaLeito.getComboBoxFiltro().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getTable1().getModel();
                    tabela.setRowCount(0);
                    Leito leito = service.LeitoService.ler(Integer.parseInt(this.telaBuscaLeito.getTextFieldEntradaFiltro().getText().trim()));
                    tabela.addRow(new Object[]{
                            leito.getId(),
                            leito.getQuarto(),
                            leito.getStatus(),
                            leito.getDescricao()
                    });

                } else if (this.telaBuscaLeito.getComboBoxFiltro().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Leito objetoAtualDaLista : service.LeitoService.ler(this.telaBuscaLeito.getTextFieldEntradaFiltro().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getQuarto(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getDescricao()
                        });
                    }
                } else if (this.telaBuscaLeito.getComboBoxFiltro().getSelectedItem().toString().equals("Descrição")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Leito objetoAtualDaLista : service.LeitoService.ler(this.telaBuscaLeito.getTextFieldEntradaFiltro().getText(), "descricao")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getQuarto(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getDescricao()
                        });
                    }
                } else if (this.telaBuscaLeito.getComboBoxFiltro().getSelectedItem().toString().equals("Quarto")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Leito objetoAtualDaLista : service.LeitoService.ler(this.telaBuscaLeito.getTextFieldEntradaFiltro().getText(), "quarto_id")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getQuarto(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getDescricao()
                        });
                    }
                }
            }

        } else if (evento.getSource() == this.telaBuscaLeito.getFecharButton()) {
            this.telaBuscaLeito.dispose();
        }

    }
}
