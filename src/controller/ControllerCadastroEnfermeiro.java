package controller;

import controller.busca.ControllerBuscaEnfermeiro;
import controller.busca.ControllerBuscarPaciente;
import model.ClasseDadosGravacao;
import model.Enfermeira;
import model.Paciente;
import utilities.Utilities;
import view.TelaEnfermeira;
import view.busca.TelaBuscaEnfermeiro;
import view.busca.TelaBuscaPaciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ControllerCadastroEnfermeiro implements ActionListener {

    TelaEnfermeira telaEnfermeira;
    public static int codigo;

    public ControllerCadastroEnfermeiro(TelaEnfermeira telaEnfermeira) {
        this.telaEnfermeira = telaEnfermeira;
        this.telaEnfermeira.getAdicionarButton().addActionListener(this);
        this.telaEnfermeira.getCancelarButton().addActionListener(this);
        this.telaEnfermeira.getGravarButton().addActionListener(this);
        this.telaEnfermeira.getBuscarButton().addActionListener(this);
        this.telaEnfermeira.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaEnfermeira.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaEnfermeira.getJPanelDados());

    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaEnfermeira.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaEnfermeira.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaEnfermeira.getJPanelDados());
            SimpleDateFormat data = new SimpleDateFormat("YYYY-MM-dd");
            String currentdate = data.format(new Date());
            telaEnfermeira.getDataCadastroEntrada().setText(currentdate);
            this.telaEnfermeira.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaEnfermeira.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaEnfermeira.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaEnfermeira.getJPanelDados());

        } else if (evento.getSource() == this.telaEnfermeira.getGravarButton()) {

            Enfermeira enfermeira = new Enfermeira();

            enfermeira.setDataCadastro(this.telaEnfermeira.getDataCadastroEntrada().getText());
            enfermeira.setNome(this.telaEnfermeira.getNomeEntrada().getText());
            enfermeira.setNomeSocial(this.telaEnfermeira.getNomeSocialEntrada().getText());
            enfermeira.setSexo(this.telaEnfermeira.getComboBoxSexoEntrada().getSelectedItem().toString());
            enfermeira.setCre(this.telaEnfermeira.getCreEntrada().getText());
            enfermeira.setLogin(this.telaEnfermeira.getLoginEntrada().getText());
            enfermeira.setSenha(Arrays.toString(this.telaEnfermeira.getSenhaEntrada().getPassword()));
            enfermeira.setFone1(this.telaEnfermeira.getTelefone1Entrada().getText());
            enfermeira.setFone2(this.telaEnfermeira.getTelefone2Entrada().getText());
            enfermeira.setEmail(this.telaEnfermeira.getEmailEntrada().getText());
            enfermeira.setRgInscricaoEstadual(this.telaEnfermeira.getRgInscricaoEstaEntrada().getText());
            enfermeira.setCpfCnpj(this.telaEnfermeira.getCpfCnpjEntrada().getText());
            enfermeira.setCep(this.telaEnfermeira.getCepEntrada().getText());
            enfermeira.setCidade(this.telaEnfermeira.getCidadeEntrada().getText());
            enfermeira.setBairro(this.telaEnfermeira.getBairroEntrada().getText());
            enfermeira.setLogradouro(this.telaEnfermeira.getLogradouroEntrada().getText());
            enfermeira.setComplemento(this.telaEnfermeira.getComplementoEntrada().getText());
            enfermeira.setStatus("A");

            if (this.telaEnfermeira.getIdEntrada().getText().equals("")) {
                service.EnfermeiroService.adicionar(enfermeira);
            } else {
                enfermeira.setId(Integer.parseInt(this.telaEnfermeira.getIdEntrada().getText()));
                service.EnfermeiroService.atualizar(enfermeira);
            }

            Utilities.ativaDesativa(false, this.telaEnfermeira.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaEnfermeira.getJPanelDados());

        } else if (evento.getSource() == this.telaEnfermeira.getBuscarButton()) {

            codigo = 0;

            TelaBuscaEnfermeiro telaBuscaEnfermeiro = new TelaBuscaEnfermeiro();
            ControllerBuscaEnfermeiro controllerBuscaEnfermeiro = new ControllerBuscaEnfermeiro(telaBuscaEnfermeiro);
            telaBuscaEnfermeiro.setSize(1500, 768);
            telaBuscaEnfermeiro.setLocationRelativeTo(null);
            telaBuscaEnfermeiro.setVisible(true);

            if (codigo != 0) {

                Enfermeira enfermeira = new Enfermeira();
                enfermeira = service.EnfermeiroService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaEnfermeira.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaEnfermeira.getJPanelDados());

                this.telaEnfermeira.getIdEntrada().setText(enfermeira.getId() + "");
                this.telaEnfermeira.getDataCadastroEntrada().setText(enfermeira.getDataCadastro());
                this.telaEnfermeira.getNomeEntrada().setText(enfermeira.getNome());
                this.telaEnfermeira.getNomeSocialEntrada().setText(enfermeira.getNomeSocial());
                this.telaEnfermeira.getComboBoxSexoEntrada().setSelectedItem(enfermeira.getSexo());
                this.telaEnfermeira.getCreEntrada().setText(enfermeira.getCre());
                this.telaEnfermeira.getLoginEntrada().setText(enfermeira.getLogin());
                this.telaEnfermeira.getSenhaEntrada().setText(enfermeira.getSenha());
                this.telaEnfermeira.getTelefone1Entrada().setText(enfermeira.getFone1());
                this.telaEnfermeira.getTelefone2Entrada().setText(enfermeira.getFone2());
                this.telaEnfermeira.getEmailEntrada().setText(enfermeira.getEmail());
                this.telaEnfermeira.getRgInscricaoEstaEntrada().setText(enfermeira.getRgInscricaoEstadual());
                this.telaEnfermeira.getCpfCnpjEntrada().setText(enfermeira.getCpfCnpj());
                this.telaEnfermeira.getCepEntrada().setText(enfermeira.getCep());
                this.telaEnfermeira.getCidadeEntrada().setText(enfermeira.getCidade());
                this.telaEnfermeira.getBairroEntrada().setText(enfermeira.getBairro());
                this.telaEnfermeira.getLogradouroEntrada().setText(enfermeira.getLogradouro());
                this.telaEnfermeira.getComplementoEntrada().setText(enfermeira.getComplemento());
                this.telaEnfermeira.getStatusEntrada().setSelectedItem(enfermeira.getStatus());


                this.telaEnfermeira.getIdEntrada().setEnabled(false);
                this.telaEnfermeira.getNomeSocialEntrada().requestFocus();


            } else if (evento.getSource() == this.telaEnfermeira.getSairButton()) {
                this.telaEnfermeira.dispose();
            }

        }
    }
}
