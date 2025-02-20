package controller.busca;

import controller.ControllerCadastroAla;
import controller.ControllerCadastroLeito;
import controller.ControllerCadastroQuarto;
import model.Ala;
import model.ClasseDadosGravacao;
import model.Leito;
import model.Quarto;
import view.busca.TelaBuscaQuarto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaQuarto implements ActionListener {
    TelaBuscaQuarto telaBuscaQuarto;

    public ControllerBuscaQuarto(TelaBuscaQuarto telaBuscaQuarto) {
        this.telaBuscaQuarto = telaBuscaQuarto;
        this.telaBuscaQuarto.getCarregarButton().addActionListener(this);
        this.telaBuscaQuarto.getFecharButton().addActionListener(this);
        this.telaBuscaQuarto.getFiltrarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaQuarto.getCarregarButton()) {
            if (this.telaBuscaQuarto.getTable1().
                    getValueAt(this.telaBuscaQuarto.getTable1().getSelectedRow(), 5).equals("A")) {
                ControllerCadastroQuarto.codigo = (int) this.telaBuscaQuarto.getTable1().
                        getValueAt(this.telaBuscaQuarto.getTable1().getSelectedRow(), 0);

                this.telaBuscaQuarto.dispose();
            }

        } else if (evento.getSource() == telaBuscaQuarto.getFiltrarButton()) {

            if (this.telaBuscaQuarto.getTextFieldEntradaFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaQuarto.getTextFieldEntradaFiltro().requestFocus();
            } else {
                if (this.telaBuscaQuarto.getComboBoxFiltro().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getTable1().getModel();
                    tabela.setRowCount(0);
                    Quarto quarto = service.QuartoService.ler(Integer.parseInt(this.telaBuscaQuarto.getTextFieldEntradaFiltro().getText().trim()));
                    tabela.addRow(new Object[]{
                            quarto.getId(),
                            quarto.getAla(),
                            quarto.getStatus(),
                            quarto.getDescricao()
                    });

                } else if (this.telaBuscaQuarto.getComboBoxFiltro().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Quarto objetoAtualDaLista : service.QuartoService.ler(this.telaBuscaQuarto.getTextFieldEntradaFiltro().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getAla(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getDescricao()
                        });
                    }
                } else if (this.telaBuscaQuarto.getComboBoxFiltro().getSelectedItem().toString().equals("Descrição")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Quarto objetoAtualDaLista : service.QuartoService.ler(this.telaBuscaQuarto.getTextFieldEntradaFiltro().getText(), "descricao")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getAla(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getDescricao()
                        });
                    }
                } else if (this.telaBuscaQuarto.getComboBoxFiltro().getSelectedItem().toString().equals("Ala")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Quarto objetoAtualDaLista : service.QuartoService.ler(this.telaBuscaQuarto.getTextFieldEntradaFiltro().getText(), "ala_id")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getAla(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getDescricao()
                        });
                    }
                }
            }

        } else if (evento.getSource() == this.telaBuscaQuarto.getFecharButton()) {
            this.telaBuscaQuarto.dispose();
        }

    }
}
