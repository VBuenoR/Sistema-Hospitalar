package controller;

import controller.busca.ControllerBuscaMedicamento;
import model.ClasseDadosGravacao;
import model.Medicamento;
import utilities.Utilities;
import view.busca.TelaBuscaMedicamento;
import view.TelaMedicamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider;

public class ControllerCadastroMedicamento implements ActionListener {


    TelaMedicamento telaMedicamento;
    public static int codigo;


    public ControllerCadastroMedicamento(TelaMedicamento telaMedicamento) {
        this.telaMedicamento = telaMedicamento;
        this.telaMedicamento.getAdicionarButton().addActionListener(this);
        this.telaMedicamento.getCancelarButton().addActionListener(this);
        this.telaMedicamento.getGravarButton().addActionListener(this);
        this.telaMedicamento.getBuscarButton().addActionListener(this);
        this.telaMedicamento.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaMedicamento.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaMedicamento.getJPanelDados());
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaMedicamento.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaMedicamento.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaMedicamento.getJPanelDados());
            this.telaMedicamento.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaMedicamento.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaMedicamento.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaMedicamento.getJPanelDados());

        } else if (evento.getSource() == this.telaMedicamento.getGravarButton()) {

            Medicamento medicamento = new Medicamento();

            medicamento.setDescricaoMedicamento(this.telaMedicamento.getDescricaoMedicamentoEntrada().getText());
            medicamento.setPrincipioAtivo(this.telaMedicamento.getPrincipioAtivoEntrada().getText());
            medicamento.setStatus("A");
            medicamento.setQtdMinima(Float.parseFloat(this.telaMedicamento.getQuantidadeMinimaEntrada().getText()));

            if (this.telaMedicamento.getIdEntrada().getText().equals("")) {
                service.MedicamentoService.adicionar(medicamento);
            } else {
                medicamento.setId(Integer.parseInt(this.telaMedicamento.getIdEntrada().getText()));
                service.MedicamentoService.atualizar(medicamento);
            }

            Utilities.ativaDesativa(false, this.telaMedicamento.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaMedicamento.getJPanelDados());

        } else if (evento.getSource() == this.telaMedicamento.getBuscarButton()) {
            codigo = 0;

            TelaBuscaMedicamento telaBuscaMedicamento = new TelaBuscaMedicamento();
            ControllerBuscaMedicamento controllerBuscaMedicamentoo = new ControllerBuscaMedicamento(telaBuscaMedicamento);
            telaBuscaMedicamento.setSize(500, 500);
            telaBuscaMedicamento.setLocationRelativeTo(null);
            telaBuscaMedicamento.setVisible(true);

            if (codigo != 0) {

                Medicamento medicamento = new Medicamento();
                medicamento = service.MedicamentoService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaMedicamento.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaMedicamento.getJPanelDados());

                this.telaMedicamento.getIdEntrada().setText(medicamento.getId() + "");
                this.telaMedicamento.getStatusEntrada().setSelectedItem(medicamento.getStatus());
                this.telaMedicamento.getPrincipioAtivoEntrada().setText(medicamento.getPrincipioAtivo());
                this.telaMedicamento.getQuantidadeMinimaEntrada().setText(String.valueOf(medicamento.getQtdMinima()));
                this.telaMedicamento.getDescricaoMedicamentoEntrada().setText(medicamento.getDescricaoMedicamento());

                this.telaMedicamento.getIdEntrada().setEnabled(false);
                this.telaMedicamento.getStatusEntrada().requestFocus();

            }


        } else if (evento.getSource() == this.telaMedicamento.getSairButton()) {
            this.telaMedicamento.dispose();

        }
    }
}
