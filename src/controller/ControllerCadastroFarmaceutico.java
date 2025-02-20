package controller;

import controller.busca.ControllerBuscaEnfermeiro;
import controller.busca.ControllerBuscaFarmaceutico;
import model.ClasseDadosGravacao;
import model.Enfermeira;
import model.Farmaceutico;
import utilities.Utilities;
import view.TelaFarmaceutico;
import view.busca.TelaBuscaEnfermeiro;
import view.busca.TelaBuscaFarmaceutico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ControllerCadastroFarmaceutico implements ActionListener {

    TelaFarmaceutico telaFarmaceutico;
    public static int codigo;


    public ControllerCadastroFarmaceutico(TelaFarmaceutico telaFarmaceutico) {
        this.telaFarmaceutico = telaFarmaceutico;

        this.telaFarmaceutico.getAdicionarButton().addActionListener(this);
        this.telaFarmaceutico.getCancelarButton().addActionListener(this);
        this.telaFarmaceutico.getGravarButton().addActionListener(this);
        this.telaFarmaceutico.getBuscarButton().addActionListener(this);
        this.telaFarmaceutico.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaFarmaceutico.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaFarmaceutico.getJPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaFarmaceutico.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaFarmaceutico.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaFarmaceutico.getJPanelDados());
            SimpleDateFormat data = new SimpleDateFormat("YYYY-MM-dd");
            String currentdate = data.format(new Date());
            telaFarmaceutico.getDataCadastroEntrada().setText(currentdate);
            this.telaFarmaceutico.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaFarmaceutico.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaFarmaceutico.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaFarmaceutico.getJPanelDados());

        } else if (evento.getSource() == this.telaFarmaceutico.getGravarButton()) {

            Farmaceutico farmaceutico = new Farmaceutico();

            farmaceutico.setDataCadastro(this.telaFarmaceutico.getDataCadastroEntrada().getText());
            farmaceutico.setCrf(this.telaFarmaceutico.getCrfEntrada().getText());
            farmaceutico.setSenha(Arrays.toString(this.telaFarmaceutico.getSenhaEntrada().getPassword()));
            farmaceutico.setLogin(this.telaFarmaceutico.getLoginEntrada().getText());
            farmaceutico.setNomeSocial(this.telaFarmaceutico.getLoginEntrada().getText());
            farmaceutico.setSexo(this.telaFarmaceutico.getComboBoxSexoEntrada().getSelectedItem().toString());
            farmaceutico.setNome(this.telaFarmaceutico.getNomeEntrada().getText());
            farmaceutico.setBairro(this.telaFarmaceutico.getBairroEntrada().getText());
            farmaceutico.setCidade(this.telaFarmaceutico.getCidadeEntrada().getText());
            farmaceutico.setCep(this.telaFarmaceutico.getCepEntrada().getText());
            farmaceutico.setComplemento(this.telaFarmaceutico.getComplementoEntrada().getText());
            farmaceutico.setLogradouro(this.telaFarmaceutico.getLogradouroEntrada().getText());
            farmaceutico.setFone1(this.telaFarmaceutico.getTelefone1Entrada().getText());
            farmaceutico.setFone2(this.telaFarmaceutico.getTelefone2Entrada().getText());
            farmaceutico.setEmail(this.telaFarmaceutico.getEmailEntrada().getText());
            farmaceutico.setCpfCnpj(this.telaFarmaceutico.getCpfCnpjEntrada().getText());
            farmaceutico.setRgInscricaoEstadual(this.telaFarmaceutico.getRgInscricaoEstaEntrada().getText());
            farmaceutico.setStatus("A");

            if (this.telaFarmaceutico.getIdEntrada().getText().equals("")) {
                service.FarmaceuticoService.adicionar(farmaceutico);
            } else {
                farmaceutico.setId(Integer.parseInt(this.telaFarmaceutico.getIdEntrada().getText()));
                service.FarmaceuticoService.atualizar(farmaceutico);
            }

            Utilities.ativaDesativa(false, this.telaFarmaceutico.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaFarmaceutico.getJPanelDados());

        } else if (evento.getSource() == this.telaFarmaceutico.getBuscarButton()) {
            codigo = 0;

            TelaBuscaFarmaceutico telaBuscaFarmaceutico = new TelaBuscaFarmaceutico();
            ControllerBuscaFarmaceutico controllerBuscaFarmaceutico = new ControllerBuscaFarmaceutico(telaBuscaFarmaceutico);
            telaBuscaFarmaceutico.setSize(1500, 900);
            telaBuscaFarmaceutico.setLocationRelativeTo(null);
            telaBuscaFarmaceutico.setVisible(true);

            if (codigo != 0) {

                Farmaceutico farmaceutico = new Farmaceutico();
                farmaceutico = service.FarmaceuticoService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaFarmaceutico.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaFarmaceutico.getJPanelDados());

                this.telaFarmaceutico.getIdEntrada().setText(farmaceutico.getId() + "");
                this.telaFarmaceutico.getDataCadastroEntrada().setText(farmaceutico.getDataCadastro());
                this.telaFarmaceutico.getNomeEntrada().setText(farmaceutico.getNome());
                this.telaFarmaceutico.getNomeSocialEntrada().setText(farmaceutico.getNomeSocial());
                this.telaFarmaceutico.getComboBoxSexoEntrada().setSelectedItem(farmaceutico.getSexo());
                this.telaFarmaceutico.getCrfEntrada().setText(farmaceutico.getCrf());
                this.telaFarmaceutico.getLoginEntrada().setText(farmaceutico.getLogin());
                this.telaFarmaceutico.getSenhaEntrada().setText(farmaceutico.getSenha());
                this.telaFarmaceutico.getTelefone1Entrada().setText(farmaceutico.getFone1());
                this.telaFarmaceutico.getTelefone2Entrada().setText(farmaceutico.getFone2());
                this.telaFarmaceutico.getEmailEntrada().setText(farmaceutico.getEmail());
                this.telaFarmaceutico.getRgInscricaoEstaEntrada().setText(farmaceutico.getRgInscricaoEstadual());
                this.telaFarmaceutico.getCpfCnpjEntrada().setText(farmaceutico.getCpfCnpj());
                this.telaFarmaceutico.getCepEntrada().setText(farmaceutico.getCep());
                this.telaFarmaceutico.getCidadeEntrada().setText(farmaceutico.getCidade());
                this.telaFarmaceutico.getBairroEntrada().setText(farmaceutico.getBairro());
                this.telaFarmaceutico.getLogradouroEntrada().setText(farmaceutico.getLogradouro());
                this.telaFarmaceutico.getComplementoEntrada().setText(farmaceutico.getComplemento());
                this.telaFarmaceutico.getStatusEntrada().setSelectedItem(farmaceutico.getStatus());


                this.telaFarmaceutico.getIdEntrada().setEnabled(false);
                this.telaFarmaceutico.getNomeSocialEntrada().requestFocus();


            } else if (evento.getSource() == this.telaFarmaceutico.getSairButton()) {
                this.telaFarmaceutico.dispose();
            }

        }
    }
}
