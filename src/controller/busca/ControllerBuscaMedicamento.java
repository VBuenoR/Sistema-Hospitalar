package controller.busca;

import controller.ControllerCadastroMedicamento;
import model.Medicamento;
import service.MedicamentoService;
import view.busca.TelaBuscaMedicamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaMedicamento implements ActionListener {

    TelaBuscaMedicamento telaBuscaMedicamento;

    public ControllerBuscaMedicamento(TelaBuscaMedicamento telabuscamedicamento) {
        this.telaBuscaMedicamento = telabuscamedicamento;

        this.telaBuscaMedicamento.getCarregarButton().addActionListener(this);
        this.telaBuscaMedicamento.getFecharButton().addActionListener(this);
        this.telaBuscaMedicamento.getFiltrarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaMedicamento.getCarregarButton()) {


            if(this.telaBuscaMedicamento.getTable1().
                    getValueAt(this.telaBuscaMedicamento.getTable1().getSelectedRow(), 1).equals("A")){
                ControllerCadastroMedicamento.codigo = (int) this.telaBuscaMedicamento.getTable1().
                        getValueAt(this.telaBuscaMedicamento.getTable1().getSelectedRow(), 0);

                this.telaBuscaMedicamento.dispose();
            }

        } else if (evento.getSource() == telaBuscaMedicamento.getFiltrarButton()) {

            if (this.telaBuscaMedicamento.getTextFieldEntradaFIltro().getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaMedicamento.getTextFieldEntradaFIltro().requestFocus();
            } else {

                if (this.telaBuscaMedicamento.getComboBoxFiltro().getSelectedItem().equals("ID")){
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getTable1().getModel();
                    tabela.setRowCount(0);
                    Medicamento medicamento = service.MedicamentoService.ler(Integer.parseInt(this.telaBuscaMedicamento.getTextFieldEntradaFIltro().getText()));
                    tabela.addRow(new Object[]{
                            medicamento.getId(),
                            medicamento.getStatus(),
                            medicamento.getPrincipioAtivo(),
                            medicamento.getQtdMinima(),
                            medicamento.getDescricaoMedicamento()
                    });

                }else if (this.telaBuscaMedicamento.getComboBoxFiltro().getSelectedItem().equals("Status")){
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medicamento objetoAtualDaLista : service.MedicamentoService.ler(this.telaBuscaMedicamento.getTextFieldEntradaFIltro().getText(), "Status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getPrincipioAtivo(),
                                objetoAtualDaLista.getQtdMinima(),
                                objetoAtualDaLista.getDescricaoMedicamento()
                        });
                    }
                }else if (this.telaBuscaMedicamento.getComboBoxFiltro().getSelectedItem().equals("Descrição")){
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medicamento objetoAtualDaLista : service.MedicamentoService.ler(this.telaBuscaMedicamento.getTextFieldEntradaFIltro().getText(), "descricaoMedicamento")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getPrincipioAtivo(),
                                objetoAtualDaLista.getQtdMinima(),
                                objetoAtualDaLista.getDescricaoMedicamento()
                        });
                    }

                }else if (this.telaBuscaMedicamento.getComboBoxFiltro().getSelectedItem().equals("Principio Ativo")){
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medicamento objetoAtualDaLista : service.MedicamentoService.ler(this.telaBuscaMedicamento.getTextFieldEntradaFIltro().getText(), "principioAtivo")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getPrincipioAtivo(),
                                objetoAtualDaLista.getQtdMinima(),
                                objetoAtualDaLista.getDescricaoMedicamento()
                        });
                    }
                }else if (this.telaBuscaMedicamento.getComboBoxFiltro().getSelectedItem().equals("Quantidade Mínima")){
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medicamento objetoAtualDaLista : service.MedicamentoService.ler(this.telaBuscaMedicamento.getTextFieldEntradaFIltro().getText(), "QtdMinima")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getStatus(),
                                objetoAtualDaLista.getPrincipioAtivo(),
                                objetoAtualDaLista.getQtdMinima(),
                                objetoAtualDaLista.getDescricaoMedicamento()
                        });
                    }
                }

            }

        } else if (evento.getSource() == this.telaBuscaMedicamento.getFecharButton()) {
            this.telaBuscaMedicamento.dispose();
        }
    }
}
