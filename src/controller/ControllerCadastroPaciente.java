package controller;

import controller.busca.ControllerBuscarPaciente;
import model.ClasseDadosGravacao;
import model.Paciente;
import utilities.Utilities;
import view.busca.TelaBuscaPaciente;
import view.TelaPaciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerCadastroPaciente implements ActionListener {

    TelaPaciente telaPaciente;
    public static int codigo;

    public ControllerCadastroPaciente(TelaPaciente telaPaciente) {
        this.telaPaciente = telaPaciente;
        this.telaPaciente.getAdicionarButton().addActionListener(this);
        this.telaPaciente.getCancelarButton().addActionListener(this);
        this.telaPaciente.getGravarButton().addActionListener(this);
        this.telaPaciente.getBuscarButton().addActionListener(this);
        this.telaPaciente.getSairButton().addActionListener(this);


        Utilities.ativaDesativa(false, this.telaPaciente.getJPanelBotoes());
        Utilities.limpaComponentes(false, this.telaPaciente.getJPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaPaciente.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaPaciente.getJPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaPaciente.getJPanelDados());
            SimpleDateFormat data = new SimpleDateFormat("YYYY-MM-dd");
            String currentdate = data.format(new Date());
            telaPaciente.getDataCadastroEntrada().setText(currentdate);
            this.telaPaciente.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaPaciente.getCancelarButton()) {
            utilities.Utilities.ativaDesativa(false, this.telaPaciente.getJPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaPaciente.getJPanelDados());

        } else if (evento.getSource() == this.telaPaciente.getGravarButton()) {

            Paciente paciente = new Paciente();

            paciente.setId(model.ClasseDadosGravacao.listaPaciente.size() + 1);
            paciente.setDataCadastro(this.telaPaciente.getDataCadastroEntrada().getText());
            paciente.setNome(this.telaPaciente.getNomeEntrada().getText());
            paciente.setNomeSocial(this.telaPaciente.getNomeSocialEntrada().getText());
            paciente.setSexo(this.telaPaciente.getSexoEntrada().getSelectedItem() + "");
            paciente.setTipoSanguineo(this.telaPaciente.getTipoSanguineoEntrada().getSelectedItem() + "");
            paciente.setFone1(this.telaPaciente.getTelefone1Entrada().getText());
            paciente.setFone2(this.telaPaciente.getTelefone2Entrada().getText());
            paciente.setEmail(this.telaPaciente.getEmailEntrada().getText());
            paciente.setRgInscricaoEstadual(this.telaPaciente.getRgInscricaoEstaEntrada().getText());
            paciente.setCpfCnpj(this.telaPaciente.getCpfCnpjEntrada().getText());
            paciente.setCep(this.telaPaciente.getCepEntrada().getText());
            paciente.setCidade(this.telaPaciente.getCidadeEntrada().getText());
            paciente.setBairro(this.telaPaciente.getBairroEntrada().getText());
            paciente.setLogradouro(this.telaPaciente.getLogradouroEntrada().getText());
            paciente.setComplemento(this.telaPaciente.getComplementoEntrada().getText());
            paciente.setStatus("A");

            if (this.telaPaciente.getIdEntrada().getText().equals("")) {
                service.PacienteService.adicionar(paciente);
            } else {
                paciente.setId(Integer.parseInt(this.telaPaciente.getIdEntrada().getText()));
                service.PacienteService.atualizar(paciente);
            }

            Utilities.ativaDesativa(false, this.telaPaciente.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaPaciente.getJPanelDados());

        } else if (evento.getSource() == this.telaPaciente.getBuscarButton()) {

            codigo = 0;

            TelaBuscaPaciente telaBuscaPaciente = new TelaBuscaPaciente();
            ControllerBuscarPaciente controllerBuscarPaciente = new ControllerBuscarPaciente(telaBuscaPaciente);
            telaBuscaPaciente.setSize(1280, 460);
            telaBuscaPaciente.setLocationRelativeTo(null);
            telaBuscaPaciente.setVisible(true);

            if (codigo != 0) {

                Paciente paciente = new Paciente();
                paciente = service.PacienteService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaPaciente.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaPaciente.getJPanelDados());

                this.telaPaciente.getIdEntrada().setText(paciente.getId() + "");
                this.telaPaciente.getDataCadastroEntrada().setText(paciente.getDataCadastro());
                this.telaPaciente.getNomeEntrada().setText(paciente.getNome());
                this.telaPaciente.getNomeSocialEntrada().setText(paciente.getNomeSocial());
                this.telaPaciente.getSexoEntrada().setSelectedItem(paciente.getSexo());
                this.telaPaciente.getTipoSanguineoEntrada().setSelectedItem(paciente.getTipoSanguineo());
                this.telaPaciente.getTelefone1Entrada().setText(paciente.getFone1());
                this.telaPaciente.getTelefone2Entrada().setText(paciente.getFone2());
                this.telaPaciente.getEmailEntrada().setText(paciente.getEmail());
                this.telaPaciente.getRgInscricaoEstaEntrada().setText(paciente.getRgInscricaoEstadual());
                this.telaPaciente.getCpfCnpjEntrada().setText(paciente.getCpfCnpj());
                this.telaPaciente.getCepEntrada().setText(paciente.getCep());
                this.telaPaciente.getCidadeEntrada().setText(paciente.getCidade());
                this.telaPaciente.getBairroEntrada().setText(paciente.getBairro());
                this.telaPaciente.getLogradouroEntrada().setText(paciente.getLogradouro());
                this.telaPaciente.getComplementoEntrada().setText(paciente.getComplemento());
                this.telaPaciente.getStatusEntrada().setSelectedItem(paciente.getStatus());


                this.telaPaciente.getIdEntrada().setEnabled(false);
                this.telaPaciente.getNomeSocialEntrada().requestFocus();

            } else if (evento.getSource() == this.telaPaciente.getSairButton()) {
                this.telaPaciente.dispose();
            }
        }
    }
}