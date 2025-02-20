package controller;

import controller.busca.ControllerBuscaAcompanhante;
import model.Acompanhante;
import model.ClasseDadosGravacao;

import utilities.Utilities;
import view.TelaAcompanhante;
import view.busca.TelaBuscaAcompanhante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerCadastroAcompanhante implements ActionListener {

    TelaAcompanhante telaAcompanhante;
    public static int codigo;


    public ControllerCadastroAcompanhante(TelaAcompanhante telaAcompanhante) {
        this.telaAcompanhante = telaAcompanhante;
        this.telaAcompanhante.getAdicionarButton().addActionListener(this);
        this.telaAcompanhante.getCancelarButton().addActionListener(this);
        this.telaAcompanhante.getGravarButton().addActionListener(this);
        this.telaAcompanhante.getBuscarButton().addActionListener(this);
        this.telaAcompanhante.getSairButton().addActionListener(this);


        utilities.Utilities.ativaDesativa(false, this.telaAcompanhante.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaAcompanhante.getJPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaAcompanhante.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaAcompanhante.getJPanelBotoes());
            Utilities.limpaComponentes(true,this.telaAcompanhante.getJPanelDados());
            this.telaAcompanhante.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaAcompanhante.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaAcompanhante.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaAcompanhante.getJPanelDados() );

        } else if (evento.getSource() == this.telaAcompanhante.getGravarButton()) {

            Acompanhante acompanhante = new Acompanhante();

            acompanhante.setNome(this.telaAcompanhante.getNomeEntrada().getText());
            acompanhante.setCpf(this.telaAcompanhante.getCpfEntrada().getText());
            acompanhante.setEmail(this.telaAcompanhante.getEmailEntrada().getText());
            acompanhante.setFone(this.telaAcompanhante.getTelefoneEntrada().getText());
            acompanhante.setGrauParentesco(this.telaAcompanhante.getGrauParentescoEntrada().getText());
            acompanhante.setStatus("A");

            if (this.telaAcompanhante.getIdEntrada().getText().equals("")) {
                service.AcompanhanteService.adicionar(acompanhante);
            } else {
                acompanhante.setId(Integer.parseInt(this.telaAcompanhante.getIdEntrada().getText()));
                service.AcompanhanteService.atualizar(acompanhante);
            }

            Utilities.ativaDesativa(false, this.telaAcompanhante.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaAcompanhante.getJPanelDados());

        } else if (evento.getSource() == this.telaAcompanhante.getBuscarButton()) {

            codigo = 0;

            TelaBuscaAcompanhante telaBuscaAcompanhante = new TelaBuscaAcompanhante();
            ControllerBuscaAcompanhante controllerBuscaAcompanhante = new ControllerBuscaAcompanhante(telaBuscaAcompanhante);
            telaBuscaAcompanhante.setSize(500,500);
            telaBuscaAcompanhante.setLocationRelativeTo(null);
            telaBuscaAcompanhante.setVisible(true);

            if (codigo != 0) {

                Acompanhante acompanhante = new Acompanhante();
                acompanhante = service.AcompanhanteService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaAcompanhante.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaAcompanhante.getJPanelDados());

                this.telaAcompanhante.getIdEntrada().setText(acompanhante.getId() + "");
                this.telaAcompanhante.getNomeEntrada().setText(acompanhante.getNome());
                this.telaAcompanhante.getCpfEntrada().setText(acompanhante.getCpf());
                this.telaAcompanhante.getTelefoneEntrada().setText(acompanhante.getFone());
                this.telaAcompanhante.getEmailEntrada().setText(acompanhante.getEmail());
                this.telaAcompanhante.getStatusEntrada().setSelectedItem(acompanhante.getStatus());
                this.telaAcompanhante.getGrauParentescoEntrada().setText(acompanhante.getGrauParentesco());

                this.telaAcompanhante.getIdEntrada().setEnabled(false);
                this.telaAcompanhante.getNomeEntrada().requestFocus();

            }

        } else if (evento.getSource() == this.telaAcompanhante.getSairButton()) {
            this.telaAcompanhante.dispose();
        }
    }
}
