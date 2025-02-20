package controller.busca;

import controller.ControllerCadastroFarmaceutico;
import model.Farmaceutico;
import view.busca.TelaBuscaFarmaceutico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaFarmaceutico implements ActionListener {
    TelaBuscaFarmaceutico telaBuscaFarmaceutico;

    public ControllerBuscaFarmaceutico(TelaBuscaFarmaceutico telaBuscaFarmaceutico) {
        this.telaBuscaFarmaceutico = telaBuscaFarmaceutico;
        this.telaBuscaFarmaceutico.getCarregarButton().addActionListener(this);
        this.telaBuscaFarmaceutico.getFiltrarButton().addActionListener(this);
        this.telaBuscaFarmaceutico.getFecharButton().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaFarmaceutico.getCarregarButton()) {
            if(this.telaBuscaFarmaceutico.getTable1().
                    getValueAt(this.telaBuscaFarmaceutico.getTable1().getSelectedRow(), 18).equals("A")){
                ControllerCadastroFarmaceutico.codigo = (int) this.telaBuscaFarmaceutico.getTable1().
                        getValueAt(this.telaBuscaFarmaceutico.getTable1().getSelectedRow(), 0);

                this.telaBuscaFarmaceutico.dispose();
            }

        } else if (evento.getSource() == telaBuscaFarmaceutico.getFiltrarButton()) {

            if(this.telaBuscaFarmaceutico.getTextField1().getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaFarmaceutico.getTextField1().requestFocus();
            } else {
                if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    Farmaceutico farmaceutico = service.FarmaceuticoService.ler(Integer.parseInt(this.telaBuscaFarmaceutico.getTextField1().getText().trim()));
                    tabela.addRow(new Object[]{
                            farmaceutico.getId(),
                            farmaceutico.getDataCadastro(),
                            farmaceutico.getNome(),
                            farmaceutico.getNomeSocial(),
                            farmaceutico.getSexo(),
                            farmaceutico.getCrf(),
                            farmaceutico.getLogin(),
                            farmaceutico.getSenha(),
                            farmaceutico.getFone1(),
                            farmaceutico.getFone2(),
                            farmaceutico.getEmail(),
                            farmaceutico.getRgInscricaoEstadual(),
                            farmaceutico.getCpfCnpj(),
                            farmaceutico.getCep(),
                            farmaceutico.getCidade(),
                            farmaceutico.getBairro(),
                            farmaceutico.getLogradouro(),
                            farmaceutico.getComplemento(),
                            farmaceutico.getStatus()
                    });

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Data de Cadastro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "dataCadastro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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
                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Nome")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "nome")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Nome Social")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "nomeSocial")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Sexo")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "sexo")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("CRF")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "crf")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Login")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "login")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Senha")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "senha")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Telefone 1")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "fone1")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Telefone 2")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "fone2")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Email")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "email")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("RG")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "rgInscricaoEstadual")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("CPF")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "cpfCnpj")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("CEP")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "cep")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Cidade")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "cidade")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Bairro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "bairro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Logradouro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "logradouro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Complemento")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "complemento")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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

                } else if (this.telaBuscaFarmaceutico.getComboBox1().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.FarmaceuticoService.ler(this.telaBuscaFarmaceutico.getTextField1().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getSexo(),
                                objetoAtualDaLista.getCrf(),
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
        } else if (evento.getSource() == this.telaBuscaFarmaceutico.getFecharButton()) {
            this.telaBuscaFarmaceutico.dispose();
        }
    }
}