package controller;

import controller.busca.ControllerBuscaLaboratorio;
import model.ClasseDadosGravacao;
import model.Laboratorio;
import utilities.Utilities;
import view.busca.TelaBuscaLaboratorio;
import view.TelaLaboratorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCadastroLaboratorio implements ActionListener {

    TelaLaboratorio telaLaboratorio;
    public static int codigo;


    public ControllerCadastroLaboratorio(TelaLaboratorio telaLaboratorio) {
        this.telaLaboratorio = telaLaboratorio;

        this.telaLaboratorio.getAdicionarButton().addActionListener(this);
        this.telaLaboratorio.getCancelarButton().addActionListener(this);
        this.telaLaboratorio.getGravarButton().addActionListener(this);
        this.telaLaboratorio.getBuscarButton().addActionListener(this);
        this.telaLaboratorio.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaLaboratorio.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaLaboratorio.getJPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaLaboratorio.getAdicionarButton()) { // BOTÃO ADICIONAR//
            Utilities.ativaDesativa(true, this.telaLaboratorio.getJPanelBotoes());
            Utilities.limpaComponentes(true,this.telaLaboratorio.getJPanelDados());
            this.telaLaboratorio.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaLaboratorio.getCancelarButton()) { //BOTÃO CANCELAR//
            Utilities.ativaDesativa(false, this.telaLaboratorio.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaLaboratorio.getJPanelDados() );

        } else if (evento.getSource() == this.telaLaboratorio.getGravarButton()) { //BOTÃO GRAVAR//
            Laboratorio laboratorio = new Laboratorio();

            laboratorio.setNomeFantasia(this.telaLaboratorio.getNomeFantasiaEntrada().getText());
            laboratorio.setContato(this.telaLaboratorio.getContatoEntrada().getText());
            laboratorio.setStatus("A");

            //PARTE CORRIGIDA//
            if (this.telaLaboratorio.getIdEntrada().getText().equals("")) {
                service.LaboratorioService.adicionar(laboratorio);
            } else {
                laboratorio.setId(Integer.parseInt(this.telaLaboratorio.getIdEntrada().getText()));
                service.LaboratorioService.atualizar(laboratorio);
            }
            //PARTE CORRIGIDA//

            Utilities.ativaDesativa(false, this.telaLaboratorio.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaLaboratorio.getJPanelDados());

        } else if (evento.getSource() == this.telaLaboratorio.getBuscarButton()) { // BOTÃO BUSCAR//

            codigo = 0;

            TelaBuscaLaboratorio telaBuscaLaboratorio = new TelaBuscaLaboratorio();
            ControllerBuscaLaboratorio controllerBuscaLaboratorio = new ControllerBuscaLaboratorio(telaBuscaLaboratorio);
            //n precisa
            telaBuscaLaboratorio.setSize(500,500);
            telaBuscaLaboratorio.setLocationRelativeTo(null);
            //n precisa
            telaBuscaLaboratorio.setVisible(true);

            if (codigo != 0) {

                Laboratorio laboratorio = new Laboratorio();
                laboratorio = service.LaboratorioService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaLaboratorio.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaLaboratorio.getJPanelDados());

                this.telaLaboratorio.getIdEntrada().setText(laboratorio.getId() + "");
                this.telaLaboratorio.getNomeFantasiaEntrada().setText(laboratorio.getNomeFantasia());
                this.telaLaboratorio.getContatoEntrada().setText(laboratorio.getContato());
                this.telaLaboratorio.getStatusEntrada().setSelectedItem(laboratorio.getStatus());

                this.telaLaboratorio.getIdEntrada().setEnabled(false);
                this.telaLaboratorio.getNomeFantasiaEntrada().requestFocus();

            }

        } else if (evento.getSource() == this.telaLaboratorio.getSairButton()) { // BOTÃO SAIR //
            this.telaLaboratorio.dispose();
        }

    }
}