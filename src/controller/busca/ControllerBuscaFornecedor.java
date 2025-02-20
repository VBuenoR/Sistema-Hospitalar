package controller.busca;

import controller.ControllerCadastroFornecedor;
import model.Fornecedor;
import view.busca.TelaBuscaFornecedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaFornecedor implements ActionListener {
    TelaBuscaFornecedor telaBuscaFornecedor;

    public ControllerBuscaFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;
        this.telaBuscaFornecedor.getCarregarButton().addActionListener(this);
        this.telaBuscaFornecedor.getFecharButton().addActionListener(this);
        this.telaBuscaFornecedor.getFiltrarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaFornecedor.getCarregarButton()) {
            if(this.telaBuscaFornecedor.getTable1().
                    getValueAt(this.telaBuscaFornecedor.getTable1().getSelectedRow(), 15).equals("A")){
                ControllerCadastroFornecedor.codigo = (int) this.telaBuscaFornecedor.getTable1().
                        getValueAt(this.telaBuscaFornecedor.getTable1().getSelectedRow(), 0);

                this.telaBuscaFornecedor.dispose();
            }

        } else if (evento.getSource() == telaBuscaFornecedor.getFiltrarButton()) {

            if(this.telaBuscaFornecedor.getTextField1().getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaFornecedor.getTextField1().requestFocus();
            } else {
                if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    Fornecedor fornecedor = service.FornecedorService.ler(Integer.parseInt(this.telaBuscaFornecedor.getTextField1().getText().trim()));
                    tabela.addRow(new Object[]{
                            fornecedor.getId(),
                            fornecedor.getDataCadastro(),
                            fornecedor.getNome(),
                            fornecedor.getNomeFantasia(),
                            fornecedor.getContato(),
                            fornecedor.getFone1(),
                            fornecedor.getFone2(),
                            fornecedor.getEmail(),
                            fornecedor.getRgInscricaoEstadual(),
                            fornecedor.getCpfCnpj(),
                            fornecedor.getCep(),
                            fornecedor.getCidade(),
                            fornecedor.getBairro(),
                            fornecedor.getLogradouro(),
                            fornecedor.getComplemento(),
                            fornecedor.getStatus()
                    });

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Data de Cadastro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "dataCadastro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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
                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Nome")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "nome")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Nome Fantasia")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "nomeFantasia")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Contato")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "contato")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Telefone 1")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "fone1")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Telefone 2")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "fone2")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Email")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "email")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("RG")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "rgInscricaoEstadual")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("CNPJ")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "cpfCnpj")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("CEP")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "cep")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Cidade")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "cidade")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Bairro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "bairro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Logradouro")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "logradouro")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Complemento")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "complemento")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

                } else if (this.telaBuscaFornecedor.getComboBox1().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Fornecedor objetoAtualDaLista : service.FornecedorService.ler(this.telaBuscaFornecedor.getTextField1().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getDataCadastro(),
                                objetoAtualDaLista.getNome(),
                                objetoAtualDaLista.getNomeFantasia(),
                                objetoAtualDaLista.getContato(),
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

        } else if (evento.getSource() == this.telaBuscaFornecedor.getFecharButton()) {
            this.telaBuscaFornecedor.dispose();
        }
    }
}