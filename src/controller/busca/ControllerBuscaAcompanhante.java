package controller.busca;

import controller.ControllerCadastroAcompanhante;

import model.Acompanhante;
import model.ClasseDadosGravacao;
import view.busca.TelaBuscaAcompanhante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaAcompanhante implements ActionListener {

    TelaBuscaAcompanhante telaBuscaAcompanhante;

    public ControllerBuscaAcompanhante(TelaBuscaAcompanhante telaBuscaAcompanhante) {
        this.telaBuscaAcompanhante = telaBuscaAcompanhante;
        this.telaBuscaAcompanhante.getCarregarButton().addActionListener(this);
        this.telaBuscaAcompanhante.getFecharButton().addActionListener(this);
        this.telaBuscaAcompanhante.getFiltrarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaAcompanhante.getCarregarButton()) {
            if (this.telaBuscaAcompanhante.getTable1().
                    getValueAt(this.telaBuscaAcompanhante.getTable1().getSelectedRow(), 5).equals("A")) {
                ControllerCadastroAcompanhante.codigo = (int) this.telaBuscaAcompanhante.getTable1().
                        getValueAt(this.telaBuscaAcompanhante.getTable1().getSelectedRow(), 0);

                this.telaBuscaAcompanhante.dispose();
            }

        } else if (evento.getSource() == telaBuscaAcompanhante.getFiltrarButton()) {

            if (this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().requestFocus();
            } else {
                if (this.telaBuscaAcompanhante.getComboBoxFiltro().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getTable1().getModel();
                    tabela.setRowCount(0);
                    Acompanhante acompanhante = service.AcompanhanteService.ler(Integer.parseInt(this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().getText().trim()));
                    tabela.addRow(new Object[]{
                            acompanhante.getId(),
                            acompanhante.getNome(),
                            acompanhante.getCpf(),
                            acompanhante.getFone(),
                            acompanhante.getEmail(),
                            acompanhante.getStatus(),
                            acompanhante.getGrauParentesco()
                    });

                } else if (this.telaBuscaAcompanhante.getComboBoxFiltro().getSelectedItem().toString().equals("Nome")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.AcompanhanteService.ler(this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().getText(), "nome")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getCpf(),
                                objetoAtualDaLista.getFone(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getGrauParentesco()
                        });
                    }
                } else if (this.telaBuscaAcompanhante.getComboBoxFiltro().getSelectedItem().toString().equals("Cpf")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.AcompanhanteService.ler(this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().getText(), "cpf")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getCpf(),
                                objetoAtualDaLista.getFone(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getGrauParentesco()
                        });
                    }

                } else if (this.telaBuscaAcompanhante.getComboBoxFiltro().getSelectedItem().toString().equals("Fone")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.AcompanhanteService.ler(this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().getText(), "fone")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getCpf(),
                                objetoAtualDaLista.getFone(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getGrauParentesco()
                        });
                    }

                } else if (this.telaBuscaAcompanhante.getComboBoxFiltro().getSelectedItem().toString().equals("Email")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.AcompanhanteService.ler(this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().getText(), "email")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getCpf(),
                                objetoAtualDaLista.getFone(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getGrauParentesco()
                        });
                    }

                } else if (this.telaBuscaAcompanhante.getComboBoxFiltro().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.AcompanhanteService.ler(this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getCpf(),
                                objetoAtualDaLista.getFone(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getGrauParentesco()
                        });
                    }

                } else if (this.telaBuscaAcompanhante.getComboBoxFiltro().getSelectedItem().toString().equals("Grau Parentesco")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.AcompanhanteService.ler(this.telaBuscaAcompanhante.getTextFieldEntradaFiltro().getText(), "grauParentesco")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getCpf(),
                                objetoAtualDaLista.getFone(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getGrauParentesco()
                        });
                    }

                }
            }
        } else if (evento.getSource() == this.telaBuscaAcompanhante.getFecharButton()) {
            this.telaBuscaAcompanhante.dispose();

        }
    }
}
