package controller;

import controller.busca.ControllerBuscaAla;
import model.Ala;
import utilities.Utilities;
import view.TelaAla;
import view.busca.TelaBuscaAla;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCadastroAla implements ActionListener {


    TelaAla telaAla;
    public static int codigo;


    public ControllerCadastroAla(TelaAla telaAla) {
        this.telaAla = telaAla;
        this.telaAla.getAdicionarButton().addActionListener(this);
        this.telaAla.getCancelarButton().addActionListener(this);
        this.telaAla.getGravarButton().addActionListener(this);
        this.telaAla.getBuscarButton().addActionListener(this);
        this.telaAla.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaAla.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaAla.getJpanelDados());

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaAla.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaAla.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaAla.getJpanelDados());
            this.telaAla.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaAla.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaAla.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaAla.getJpanelDados());

        } else if (evento.getSource() == this.telaAla.getGravarButton()) {

            Ala ala = new Ala();

            ala.setDescricao(this.telaAla.getDescricaoEntrada().getText());
            ala.setStatus("A");

            if (this.telaAla.getIdEntrada().getText().equals("")) {
                service.AlaService.adicionar(ala);
            } else {
                ala.setId(Integer.parseInt(this.telaAla.getIdEntrada().getText()));
                service.AlaService.atualizar(ala);
            }

            Utilities.ativaDesativa(false, this.telaAla.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaAla.getJpanelDados());

        } else if (evento.getSource() == this.telaAla.getBuscarButton()) {
            codigo = 0;

            TelaBuscaAla telaBuscaAla = new TelaBuscaAla();
            ControllerBuscaAla controllerBuscaAla = new ControllerBuscaAla(telaBuscaAla);
            telaBuscaAla.setSize(500, 500);
            telaBuscaAla.setLocationRelativeTo(null);
            telaBuscaAla.setVisible(true);

            if (codigo != 0) {

                Ala ala = new Ala();
                ala = service.AlaService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaAla.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaAla.getJpanelDados());

                this.telaAla.getIdEntrada().setText(ala.getId() + "");
                this.telaAla.getStatusEntrada().setSelectedItem(ala.getStatus());
                this.telaAla.getDescricaoEntrada().setText(ala.getDescricao());

                this.telaAla.getIdEntrada().setEnabled(false);
                this.telaAla.getStatusEntrada().requestFocus();

            } else if (evento.getSource() == this.telaAla.getSairButton()) {
                this.telaAla.dispose();
            }

        }
    }
}
