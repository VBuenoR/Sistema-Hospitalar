package controller.busca;

import controller.ControllerCadastroMedicamento;
import controller.ControllerCadastroPaciente;
import model.ClasseDadosGravacao;
import model.Medico;
import model.Paciente;
import view.busca.TelaBuscaPaciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscarPaciente implements ActionListener {

    TelaBuscaPaciente telaBuscaPaciente;

    public ControllerBuscarPaciente(TelaBuscaPaciente telaBuscaPaciente) {
        this.telaBuscaPaciente = telaBuscaPaciente;
        this.telaBuscaPaciente.getCarregarButton().addActionListener(this);
        this.telaBuscaPaciente.getFecharButton().addActionListener(this);
        this.telaBuscaPaciente.getFiltrarButton().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaPaciente.getCarregarButton()) {
            if(this.telaBuscaPaciente.getTable1().
                    getValueAt(this.telaBuscaPaciente.getTable1().getSelectedRow(), 16).equals("A")){
                ControllerCadastroPaciente.codigo = (int) this.telaBuscaPaciente.getTable1().
                        getValueAt(this.telaBuscaPaciente.getTable1().getSelectedRow(), 0);

                this.telaBuscaPaciente.dispose();
            }

            this.telaBuscaPaciente.dispose();

        } else if (evento.getSource() == telaBuscaPaciente.getFiltrarButton()) {

            if(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaPaciente.getTextFieldEntradaFiltro().requestFocus();
            } else {
                if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    Paciente paciente = service.PacienteService.ler(Integer.parseInt(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText().trim()));
                    tabela.addRow(new Object[]{
                            paciente.getId(),
                            paciente.getDataCadastro(),
                            paciente.getNome(),
                            paciente.getNomeSocial(),
                            paciente.getSexo(),
                            paciente.getTipoSanguineo(),
                            paciente.getFone1(),
                            paciente.getFone2(),
                            paciente.getEmail(),
                            paciente.getRgInscricaoEstadual(),
                            paciente.getCpfCnpj(),
                            paciente.getCep(),
                            paciente.getCidade(),
                            paciente.getBairro(),
                            paciente.getLogradouro(),
                            paciente.getComplemento(),
                            paciente.getStatus()
                    });

                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Data de Cadastro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "dataCadastro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Nome")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "nome")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Nome Social")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "nomeSocial")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Sexo")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "sexo")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Telefone 1")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "fone1")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Telefone 2")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "fone2")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Email")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "email")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("RG")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "rgInscricaoEstadual")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("CPF")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "cpfCnpj")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("CEP")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "cep")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Cidade")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "cidade")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Bairro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "bairro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Logradouro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "logradouro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Complemento")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "complemento")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaPaciente.getComboBoxFiltro().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : service.PacienteService.ler(this.telaBuscaPaciente.getTextFieldEntradaFiltro().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getTipoSanguineo(),
                                objetoAtualDaLista.getFone1(),
                                objetoAtualDaLista.getFone2(),
                                objetoAtualDaLista.getEmail(),
                                objetoAtualDaLista.getRgInscricaoEstadual(),
                                objetoAtualDaLista.getCpfCnpj(),
                                objetoAtualDaLista.getCep(),
                                objetoAtualDaLista.getCidade(),
                                objetoAtualDaLista.getBairro(),
                                objetoAtualDaLista.getLogradouro(),
                                objetoAtualDaLista.getComplemento(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                }
            }

        } else if (evento.getSource() == this.telaBuscaPaciente.getFecharButton()) {
            this.telaBuscaPaciente.dispose();
        }
    }
}
