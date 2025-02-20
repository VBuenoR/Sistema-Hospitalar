package controller;

import controller.busca.ControllerBuscaLeito;
import controller.busca.ControllerBuscaQuarto;
import model.Ala;
import model.ClasseDadosGravacao;
import model.Leito;
import model.Quarto;
import utilities.Utilities;
import view.busca.TelaBuscaLeito;
import view.TelaLeito;
import view.busca.TelaBuscaQuarto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCadastroLeito implements ActionListener {
    public static int codigo;

    TelaLeito telaLeito;


    public ControllerCadastroLeito(TelaLeito telaLeito) {
        this.telaLeito = telaLeito;
        this.telaLeito.getAdicionarButton().addActionListener(this);
        this.telaLeito.getCancelarButton().addActionListener(this);
        this.telaLeito.getGravarButton().addActionListener(this);
        this.telaLeito.getBuscarButton().addActionListener(this);
        this.telaLeito.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaLeito.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaLeito.getJPanelDados());

        this.telaLeito.getComboBoxQuarto().removeAllItems();
        for(Quarto itemAtualDaLista : ClasseDadosGravacao.listaQuarto){
            this.telaLeito.getComboBoxQuarto().addItem(itemAtualDaLista.getDescricao());
        }

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaLeito.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaLeito.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaLeito.getJPanelDados());
            this.telaLeito.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaLeito.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaLeito.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaLeito.getJPanelDados());

        } else if (evento.getSource() == this.telaLeito.getGravarButton()) {

            Leito leito = new Leito();

            leito.setDescricao(this.telaLeito.getDescricaoEntrada().getText());

            //nova atribuição
            Quarto quartoSelecionado = (Quarto) this.telaLeito.getComboBoxQuarto().getSelectedItem();
            leito.setQuarto(quartoSelecionado);
            //nova atribuição
            leito.setStatus("A");


            if (this.telaLeito.getIdEntrada().getText().equals("")) {
                service.LeitoService.adicionar(leito);
            } else {
                leito.setId(Integer.parseInt(this.telaLeito.getIdEntrada().getText()));
                service.LeitoService.atualizar(leito);
            }

            Utilities.ativaDesativa(false, this.telaLeito.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaLeito.getJPanelDados());

        } else if (evento.getSource() == this.telaLeito.getBuscarButton()) {
            codigo = 0;

            TelaBuscaLeito telaBuscaLeito = new TelaBuscaLeito();
            ControllerBuscaLeito controllerBuscaQuarto = new ControllerBuscaLeito(telaBuscaLeito);
            telaBuscaLeito.setSize(500, 500);
            telaBuscaLeito.setLocationRelativeTo(null);
            telaBuscaLeito.setVisible(true);

            if (codigo != 0) {

                Leito leito = new Leito();
                leito = service.LeitoService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaLeito.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaLeito.getJPanelDados());

                this.telaLeito.getIdEntrada().setText(telaLeito.getIdEntrada() + "");
                this.telaLeito.getComboBoxQuarto().setSelectedItem(leito.getQuarto());
                this.telaLeito.getStatusEntrada().setSelectedItem(leito.getStatus());
                this.telaLeito.getDescricaoEntrada().setText(leito.getDescricao());

                this.telaLeito.getIdEntrada().setEnabled(false);
                this.telaLeito.getStatusEntrada().requestFocus();

            } else if (evento.getSource() == this.telaLeito.getSairButton()) {
                this.telaLeito.dispose();
            }

        }
    }
}