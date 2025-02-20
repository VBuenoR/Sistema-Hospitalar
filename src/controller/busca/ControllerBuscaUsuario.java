package controller.busca;

import controller.ControllerCadastroUsuario;
import model.Usuario;
import view.busca.TelaBuscaUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscaUsuario implements ActionListener {
    TelaBuscaUsuario telaBuscaUsuario = new TelaBuscaUsuario();

    public ControllerBuscaUsuario(TelaBuscaUsuario telaBuscaUsuario) {
        this.telaBuscaUsuario = telaBuscaUsuario;
        this.telaBuscaUsuario.getCarregarButton().addActionListener(this);
        this.telaBuscaUsuario.getFiltrarButton().addActionListener(this);
        this.telaBuscaUsuario.getFecharButton().addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaBuscaUsuario.getCarregarButton()) {
            if(this.telaBuscaUsuario.getTable1().
                    getValueAt(this.telaBuscaUsuario.getTable1().getSelectedRow(), 4).equals("A")){
                ControllerCadastroUsuario.codigo = (int) this.telaBuscaUsuario.getTable1().
                        getValueAt(this.telaBuscaUsuario.getTable1().getSelectedRow(), 0);

                this.telaBuscaUsuario.dispose();
            }

        } else if (evento.getSource() == telaBuscaUsuario.getFiltrarButton()) {

            if(this.telaBuscaUsuario.getTextField1().getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaUsuario.getTextField1().requestFocus();
            } else {
                if (this.telaBuscaUsuario.getComboBox1().getSelectedItem().toString().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getTable1().getModel();
                    tabela.setRowCount(0);
                    Usuario usuario = service.UsuarioService.ler(Integer.parseInt(this.telaBuscaUsuario.getTextField1().getText().trim()));
                    tabela.addRow(new Object[]{
                            usuario.getId(),
                            usuario.getNomeSocial(),
                            usuario.getLogin(),
                            usuario.getSenha(),
                            usuario.getStatus()
                    });

                } else if (this.telaBuscaUsuario.getComboBox1().getSelectedItem().toString().equals("Nome Social")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Usuario objetoAtualDaLista : service.UsuarioService.ler(this.telaBuscaUsuario.getTextField1().getText(), "nomeSocial")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaUsuario.getComboBox1().getSelectedItem().toString().equals("Login")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Usuario objetoAtualDaLista : service.UsuarioService.ler(this.telaBuscaUsuario.getTextField1().getText(), "login")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaUsuario.getComboBox1().getSelectedItem().toString().equals("Senha")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Usuario objetoAtualDaLista : service.UsuarioService.ler(this.telaBuscaUsuario.getTextField1().getText(), "senha")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                } else if (this.telaBuscaUsuario.getComboBox1().getSelectedItem().toString().equals("Status")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getTable1().getModel();
                    tabela.setRowCount(0);
                    for (Usuario objetoAtualDaLista : service.UsuarioService.ler(this.telaBuscaUsuario.getTextField1().getText(), "status")) { // RETRIEVE
                        tabela.addRow(new Object[]{
                                objetoAtualDaLista.getId(),
                                objetoAtualDaLista.getNomeSocial(),
                                objetoAtualDaLista.getLogin(),
                                objetoAtualDaLista.getSenha(),
                                objetoAtualDaLista.getStatus()
                        });
                    }
                }
            }

        } else if (evento.getSource() == this.telaBuscaUsuario.getFecharButton()) {
            this.telaBuscaUsuario.dispose();
        }
    }
}
