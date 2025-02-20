package controller.busca;

import controller.ControllerCadastroEnfermeiro;
import model.Enfermeira;
import view.busca.TelaBuscaEnfermeiro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaEnfermeiro implements ActionListener {
    TelaBuscaEnfermeiro telaBuscaEnfermeiro;

    public ControllerBuscaEnfermeiro(TelaBuscaEnfermeiro telaBuscaEnfermeiro) {
        this.telaBuscaEnfermeiro = telaBuscaEnfermeiro;
        this.telaBuscaEnfermeiro.getCarregarButton().addActionListener(this);
        this.telaBuscaEnfermeiro.getFiltrarButton().addActionListener(this);
        this.telaBuscaEnfermeiro.getFecharButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaEnfermeiro.getCarregarButton()) {
            if(this.telaBuscaEnfermeiro.getTable1().
                    getValueAt(this.telaBuscaEnfermeiro.getTable1().getSelectedRow(), 18).equals("A")){
                ControllerCadastroEnfermeiro.codigo = (int) this.telaBuscaEnfermeiro.getTable1().
                        getValueAt(this.telaBuscaEnfermeiro.getTable1().getSelectedRow(), 0);

                this.telaBuscaEnfermeiro.dispose();
            }

        } else if (evento.getSource() == telaBuscaEnfermeiro.getFiltrarButton()) {

            if(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().requestFocus();
            } else {
                if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    Enfermeira enfermeira = service.EnfermeiroService.ler(Integer.parseInt(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText().trim()));
                    tabela.addRow(new Object[]{
                            enfermeira.getId(),
                            enfermeira.getDataCadastro(),
                            enfermeira.getNome(),
                            enfermeira.getNomeSocial(),
                            enfermeira.getSexo(),
                            enfermeira.getCre(),
                            enfermeira.getLogin(),
                            enfermeira.getSenha(),
                            enfermeira.getFone1(),
                            enfermeira.getFone2(),
                            enfermeira.getEmail(),
                            enfermeira.getRgInscricaoEstadual(),
                            enfermeira.getCpfCnpj(),
                            enfermeira.getCep(),
                            enfermeira.getCidade(),
                            enfermeira.getBairro(),
                            enfermeira.getLogradouro(),
                            enfermeira.getComplemento(),
                            enfermeira.getStatus()
                    });

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Data de Cadastro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "dataCadastro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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
                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Nome")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "nome")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Nome Social")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "nomeSocial")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Sexo")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "sexo")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("CRE")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "crm")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Login")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "login")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Senha")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "senha")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Telefone 1")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "fone1")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Telefone 2")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "fone2")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Email")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "email")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("RG")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "rgInscricaoEstadual")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("CPF")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "cpfCnpj")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("CEP")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "cep")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Cidade")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "cidade")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Bairro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "bairro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Logradouro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "logradouro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Complemento")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "complemento")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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

                } else if (this.telaBuscaEnfermeiro.getComboBoxFiltro().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Enfermeira objetoAtualDaLista : service.EnfermeiroService.ler(this.telaBuscaEnfermeiro.getTextFieldEntradaFiltro().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCre(),
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
        } else if (evento.getSource() == this.telaBuscaEnfermeiro.getFecharButton()) {
            this.telaBuscaEnfermeiro.dispose();
        }
    }
}

