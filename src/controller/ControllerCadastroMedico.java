package controller;

import controller.busca.ControllerBuscaEnfermeiro;
import controller.busca.ControllerBuscaMedico;
import model.ClasseDadosGravacao;
import model.Enfermeira;
import model.Medico;
import utilities.Utilities;
import view.TelaMedico;
import view.busca.TelaBuscaEnfermeiro;
import view.busca.TelaBuscaMedico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ControllerCadastroMedico implements ActionListener {

    TelaMedico telaMedico;
    public static int codigo;

    public ControllerCadastroMedico(TelaMedico telaMedico) {
        this.telaMedico = telaMedico;
        this.telaMedico.getAdicionarButton().addActionListener(this);
        this.telaMedico.getCancelarButton().addActionListener(this);
        this.telaMedico.getGravarButton().addActionListener(this);
        this.telaMedico.getBuscarButton().addActionListener(this);
        this.telaMedico.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaMedico.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaMedico.getJPanelDados());
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaMedico.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaMedico.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaMedico.getJPanelDados());
            SimpleDateFormat data = new SimpleDateFormat("YYYY-MM-dd");
            String currentdate = data.format(new Date());
            telaMedico.getDataCadastroEntrada().setText(currentdate);
            this.telaMedico.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaMedico.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaMedico.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaMedico.getJPanelDados());

        } else if (evento.getSource() == this.telaMedico.getGravarButton()) {

            Medico medico = new Medico();

            medico.setDataCadastro(this.telaMedico.getDataCadastroEntrada().getText());
            medico.setCrm(this.telaMedico.getCrmEntrada().getText());
            medico.setSenha(this.telaMedico.getSenhaEntrada().getPassword() + "");
            medico.setLogin(this.telaMedico.getLoginEntrada().getText());
            medico.setNomeSocial(this.telaMedico.getNomeSocialEntrada().getText());
            medico.setSexo(this.telaMedico.getComboBoxSexoEntrada().getSelectedItem().toString());
            medico.setNome(this.telaMedico.getNomeEntrada().getText());
            medico.setBairro(this.telaMedico.getBairroEntrada().getText());
            medico.setCidade(this.telaMedico.getCidadeEntrada().getText());
            medico.setCep(this.telaMedico.getCepEntrada().getText());
            medico.setBairro(this.telaMedico.getBairroEntrada().getText());
            medico.setComplemento(this.telaMedico.getComplementoEntrada().getText());
            medico.setLogradouro(this.telaMedico.getLogradouroEntrada().getText());
            medico.setFone1(this.telaMedico.getTelefone1Entrada().getText());
            medico.setFone2(this.telaMedico.getTelefone2Entrada().getText());
            medico.setEmail(this.telaMedico.getEmailEntrada().getText());
            medico.setCpfCnpj(this.telaMedico.getCpfCnpjEntrada().getText());
            medico.setRgInscricaoEstadual(this.telaMedico.getRgInscricaoEstaEntrada().getText());
            medico.setStatus("A");

            if (this.telaMedico.getIdEntrada().getText().equals("")) {
                service.MedicoService.adicionar(medico);
            } else {
                medico.setId(Integer.parseInt(this.telaMedico.getIdEntrada().getText()));
                service.MedicoService.atualizar(medico);
            }

            Utilities.ativaDesativa(true, this.telaMedico.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaMedico.getJPanelDados());

        } else if (evento.getSource() == this.telaMedico.getBuscarButton()) {
            codigo = 0;

            TelaBuscaMedico telaBuscaMedico = new TelaBuscaMedico();
            ControllerBuscaMedico controllerBuscaMedico = new ControllerBuscaMedico(telaBuscaMedico);
            telaBuscaMedico.setSize(1500, 768);
            telaBuscaMedico.setLocationRelativeTo(null);
            telaBuscaMedico.setVisible(true);

            if (codigo != 0) {

                Medico medico = new Medico();
                medico = service.MedicoService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaMedico.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaMedico.getJPanelDados());

                this.telaMedico.getIdEntrada().setText(medico.getId() + "");
                this.telaMedico.getDataCadastroEntrada().setText(medico.getDataCadastro());
                this.telaMedico.getNomeEntrada().setText(medico.getNome());
                this.telaMedico.getNomeSocialEntrada().setText(medico.getNomeSocial());
                this.telaMedico.getComboBoxSexoEntrada().setSelectedItem(medico.getSexo());
                this.telaMedico.getCrmEntrada().setText(medico.getCrm());
                this.telaMedico.getLoginEntrada().setText(medico.getLogin());
                this.telaMedico.getSenhaEntrada().setText(medico.getSenha());
                this.telaMedico.getTelefone1Entrada().setText(medico.getFone1());
                this.telaMedico.getTelefone2Entrada().setText(medico.getFone2());
                this.telaMedico.getEmailEntrada().setText(medico.getEmail());
                this.telaMedico.getRgInscricaoEstaEntrada().setText(medico.getRgInscricaoEstadual());
                this.telaMedico.getCpfCnpjEntrada().setText(medico.getCpfCnpj());
                this.telaMedico.getCepEntrada().setText(medico.getCep());
                this.telaMedico.getCidadeEntrada().setText(medico.getCidade());
                this.telaMedico.getBairroEntrada().setText(medico.getBairro());
                this.telaMedico.getLogradouroEntrada().setText(medico.getLogradouro());
                this.telaMedico.getComplementoEntrada().setText(medico.getComplemento());
                this.telaMedico.getStatusEntrada().setSelectedItem(medico.getStatus());

                this.telaMedico.getIdEntrada().setEnabled(false);
                this.telaMedico.getNomeEntrada().requestFocus();

            } else if (evento.getSource() == this.telaMedico.getSairButton()) {
                this.telaMedico.dispose();
            }

        }
    }
}
