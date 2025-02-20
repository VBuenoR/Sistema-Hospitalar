package controller.busca;


import controller.ControllerCadastroMedico;
import model.Medico;
import view.busca.TelaBuscaMedico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaMedico implements ActionListener {
    TelaBuscaMedico telaBuscaMedico;

    public ControllerBuscaMedico(TelaBuscaMedico telaBuscaMedico) {
        this.telaBuscaMedico = telaBuscaMedico;
        this.telaBuscaMedico.getCarregarButton().addActionListener(this);
        this.telaBuscaMedico.getFiltrarButton().addActionListener(this);
        this.telaBuscaMedico.getFecharButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaMedico.getCarregarButton()) {
            if(this.telaBuscaMedico.getTable1().
                    getValueAt(this.telaBuscaMedico.getTable1().getSelectedRow(), 18).equals("A")){
                ControllerCadastroMedico.codigo = (int) this.telaBuscaMedico.getTable1().
                        getValueAt(this.telaBuscaMedico.getTable1().getSelectedRow(), 0);

                this.telaBuscaMedico.dispose();
            }

        } else if (evento.getSource() == telaBuscaMedico.getFiltrarButton()) {

            if(this.telaBuscaMedico.getTextField1().getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaMedico.getTextField1().requestFocus();
            } else {
                if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    Medico medico = service.MedicoService.ler(Integer.parseInt(this.telaBuscaMedico.getTextField1().getText().trim()));
                    tabela.addRow(new Object[]{
                            medico.getId(),
                            medico.getDataCadastro(),
                            medico.getNome(),
                            medico.getNomeSocial(),
                            medico.getSexo(),
                            medico.getCrm(),
                            medico.getLogin(),
                            medico.getSenha(),
                            medico.getFone1(),
                            medico.getFone2(),
                            medico.getEmail(),
                            medico.getRgInscricaoEstadual(),
                            medico.getCpfCnpj(),
                            medico.getCep(),
                            medico.getCidade(),
                            medico.getBairro(),
                            medico.getLogradouro(),
                            medico.getComplemento(),
                            medico.getStatus()
                    });

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Data de Cadastro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "dataCadastro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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
                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Nome")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "nome")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Nome Social")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "nomeSocial")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Sexo")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "sexo")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("CRM")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "crm")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Login")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "login")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Senha")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "senha")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Telefone 1")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "fone1")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Telefone 2")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "fone2")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Email")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "email")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("RG")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "rgInscricaoEstadual")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("CPF")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "cpfCnpj")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("CEP")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "cep")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Cidade")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "cidade")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Bairro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "bairro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Logradouro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "logradouro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Complemento")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "complemento")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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

                } else if (this.telaBuscaMedico.getComboBox1().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.MedicoService.ler(this.telaBuscaMedico.getTextField1().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrm(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
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
        } else if (evento.getSource() == this.telaBuscaMedico.getFecharButton()) {
            this.telaBuscaMedico.dispose();
        }
    }
}
