package controller;

import controller.busca.ControllerBuscaAla;
import controller.busca.ControllerBuscaQuarto;
import model.Ala;
import model.ClasseDadosGravacao;
import model.Quarto;
import utilities.Utilities;
import view.TelaQuarto;
import view.busca.TelaBuscaAla;
import view.busca.TelaBuscaQuarto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCadastroQuarto implements ActionListener {
    public static int codigo;


    TelaQuarto telaQuarto;

    public ControllerCadastroQuarto(TelaQuarto telaQuarto) {
        this.telaQuarto = telaQuarto;
        this.telaQuarto.getAdicionarButton().addActionListener(this);
        this.telaQuarto.getCancelarButton().addActionListener(this);
        this.telaQuarto.getGravarButton().addActionListener(this);
        this.telaQuarto.getBuscarButton().addActionListener(this);
        this.telaQuarto.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaQuarto.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaQuarto.getJPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaQuarto.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaQuarto.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaQuarto.getJPanelDados());
            this.telaQuarto.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaQuarto.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaQuarto.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaQuarto.getJPanelDados());

        } else if (evento.getSource() == this.telaQuarto.getGravarButton()) {

            Quarto quarto = new Quarto();

            quarto.setDescricao(this.telaQuarto.getDescricaoEntrada().getText());

            //nova atribuição
            Ala alaSelecionada = (Ala) this.telaQuarto.getAlaEntrada().getSelectedItem();
            quarto.setAla(alaSelecionada);
            //nova atribuição
            quarto.setStatus("A");


            if (this.telaQuarto.getIdEntrada().getText().equals("")) {
                service.QuartoService.adicionar(quarto);
            } else {
                quarto.setId(Integer.parseInt(this.telaQuarto.getIdEntrada().getText()));
                service.QuartoService.atualizar(quarto);
            }

            Utilities.ativaDesativa(false, this.telaQuarto.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaQuarto.getJPanelDados());

        } else if (evento.getSource() == this.telaQuarto.getBuscarButton()) {
            codigo = 0;

            TelaBuscaQuarto telaBuscaQuarto = new TelaBuscaQuarto();
            ControllerBuscaQuarto controllerBuscaQuarto = new ControllerBuscaQuarto(telaBuscaQuarto);
            telaBuscaQuarto.setSize(500, 500);
            telaBuscaQuarto.setLocationRelativeTo(null);
            telaBuscaQuarto.setVisible(true);

            if (codigo != 0) {

                Quarto quarto = new Quarto();
                quarto = service.QuartoService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaQuarto.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaQuarto.getJPanelDados());

                this.telaQuarto.getIdEntrada().setText(quarto.getId() + "");
                this.telaQuarto.getAlaEntrada().setSelectedItem(quarto.getAla());
                this.telaQuarto.getStatusEntrada().setSelectedItem(quarto.getStatus());
                this.telaQuarto.getDescricaoEntrada().setText(quarto.getDescricao());

                this.telaQuarto.getIdEntrada().setEnabled(false);
                this.telaQuarto.getStatusEntrada().requestFocus();

            } else if (evento.getSource() == this.telaQuarto.getSairButton()) {
                this.telaQuarto.dispose();
            }

        }
    }
}
