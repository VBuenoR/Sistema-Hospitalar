package controller;

import controller.busca.ControllerBuscaUsuario;
import model.ClasseDadosGravacao;
import model.Usuario;
import utilities.Utilities;
import view.TelaUsuario;
import view.busca.TelaBuscaUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ControllerCadastroUsuario implements ActionListener {

    TelaUsuario telaUsuario;
    public static int codigo;


    public ControllerCadastroUsuario(TelaUsuario telaUsuario) {
        this.telaUsuario = telaUsuario;
        this.telaUsuario.getAdicionarButton().addActionListener(this);
        this.telaUsuario.getCancelarButton().addActionListener(this);
        this.telaUsuario.getGravarButton().addActionListener(this);
        this.telaUsuario.getBuscarButton().addActionListener(this);
        this.telaUsuario.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaUsuario.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaUsuario.getJPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {


        if (evento.getSource() == this.telaUsuario.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaUsuario.getJPanelBotoes());
            Utilities.limpaComponentes(true,this.telaUsuario.getJPanelDados());
            this.telaUsuario.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaUsuario.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaUsuario.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaUsuario.getJPanelDados() );

        } else if (evento.getSource() == this.telaUsuario.getGravarButton()) {

            Usuario usuario = new Usuario();

            usuario.setNomeSocial(this.telaUsuario.getNomeSocialEntrada().getText());
            usuario.setLogin(this.telaUsuario.getLoginEntrada().getText());
            usuario.setSenha(Arrays.toString(this.telaUsuario.getSenhaEntrada().getPassword()));
            usuario.setStatus("A");

            if (this.telaUsuario.getIdEntrada().getText().equals("")) {
                service.UsuarioService.adicionar(usuario);
            } else {
                usuario.setId(Integer.parseInt(this.telaUsuario.getIdEntrada().getText()));
                service.UsuarioService.atualizar(usuario);
            }

            Utilities.ativaDesativa(false, this.telaUsuario.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaUsuario.getJPanelDados());

        } else if (evento.getSource() == this.telaUsuario.getBuscarButton()) {
            codigo = 0;

            TelaBuscaUsuario telaBuscaUsuario = new TelaBuscaUsuario();
            ControllerBuscaUsuario controllerBuscaUsuario = new ControllerBuscaUsuario(telaBuscaUsuario);
            telaBuscaUsuario.setSize(1280, 460);
            telaBuscaUsuario.setLocationRelativeTo(null);
            telaBuscaUsuario.setVisible(true);

            if (codigo != 0) {

                Usuario usuario = new Usuario();
                usuario = service.UsuarioService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaUsuario.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaUsuario.getJPanelDados());

                this.telaUsuario.getIdEntrada().setText(usuario.getId() + "");
                this.telaUsuario.getNomeSocialEntrada().setText(usuario.getNomeSocial());
                this.telaUsuario.getLoginEntrada().setText(usuario.getLogin());
                this.telaUsuario.getSenhaEntrada().setText(usuario.getSenha());
                this.telaUsuario.getStatusEntrada().setSelectedItem(usuario.getStatus());

                this.telaUsuario.getIdEntrada().setEnabled(false);
                this.telaUsuario.getNomeSocialEntrada().requestFocus();
            }

        }else if (evento.getSource() == this.telaUsuario.getSairButton()) {
            this.telaUsuario.dispose();


        }
    }
}
