package controller;

import controller.busca.ControllerBuscaFornecedor;
import model.Fornecedor;
import utilities.Utilities;
import view.TelaFornecedor;
import view.busca.TelaBuscaFornecedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerCadastroFornecedor implements ActionListener {
    TelaFornecedor telaFornecedor;
    public static int codigo;


    public ControllerCadastroFornecedor(TelaFornecedor telaFornecedor) {
        this.telaFornecedor = telaFornecedor;
        this.telaFornecedor.getAdicionarButton().addActionListener(this);
        this.telaFornecedor.getCancelarButton().addActionListener(this);
        this.telaFornecedor.getGravarButton().addActionListener(this);
        this.telaFornecedor.getBuscarButton().addActionListener(this);
        this.telaFornecedor.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaFornecedor.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaFornecedor.getJPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaFornecedor.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaFornecedor.getJPanelBotoes());
            Utilities.limpaComponentes(true, this.telaFornecedor.getJPanelDados());
            SimpleDateFormat data = new SimpleDateFormat("YYYY-MM-dd");
            String currentdate = data.format(new Date());
            telaFornecedor.getDataCadastroEntrada().setText(currentdate);
            this.telaFornecedor.getIdEntrada().setEnabled(false);

        } else if (evento.getSource() == this.telaFornecedor.getCancelarButton()) {
            Utilities.ativaDesativa(false, this.telaFornecedor.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaFornecedor.getJPanelDados());

        } else if (evento.getSource() == this.telaFornecedor.getGravarButton()) {

            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setNomeFantasia(this.telaFornecedor.getNomeFantasiaEntrada().getText());
            fornecedor.setContato(this.telaFornecedor.getContatoEntrada().getText());
            fornecedor.setNome(this.telaFornecedor.getNomeEntrada().getText());
            fornecedor.setBairro(this.telaFornecedor.getBairroEntrada().getText());
            fornecedor.setCidade(this.telaFornecedor.getCidadeEntrada().getText());
            fornecedor.setCep(this.telaFornecedor.getCepEntrada().getText());
            fornecedor.setComplemento(this.telaFornecedor.getComplementoEntrada().getText());
            fornecedor.setFone1(this.telaFornecedor.getTelefone1Entrada().getText());
            fornecedor.setFone2(this.telaFornecedor.getTelefone2Entrada().getText());
            fornecedor.setEmail(this.telaFornecedor.getEmailEntrada().getText());
            fornecedor.setCpfCnpj(this.telaFornecedor.getCpfCnpjEntrada().getText());
            fornecedor.setRgInscricaoEstadual(this.telaFornecedor.getRgInscricaoEstaEntrada().getText());
            fornecedor.setStatus("A");

            if (this.telaFornecedor.getIdEntrada().getText().equals("")) {
                service.FornecedorService.adicionar(fornecedor);
            } else {
                fornecedor.setId(Integer.parseInt(this.telaFornecedor.getIdEntrada().getText()));
                service.FornecedorService.atualizar(fornecedor);
            }

            Utilities.ativaDesativa(false, this.telaFornecedor.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaFornecedor.getJPanelDados());

        } else if (evento.getSource() == this.telaFornecedor.getBuscarButton()) {
            codigo = 0;

            TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor();
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
            telaBuscaFornecedor.setSize(1500, 768);
            telaBuscaFornecedor.setLocationRelativeTo(null);
            telaBuscaFornecedor.setVisible(true);

            if (codigo != 0) {

                Fornecedor fornecedor = new Fornecedor();
                fornecedor = service.FornecedorService.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaFornecedor.getJPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaFornecedor.getJPanelDados());

                this.telaFornecedor.getIdEntrada().setText(fornecedor.getId() + "");
                this.telaFornecedor.getDataCadastroEntrada().setText(fornecedor.getDataCadastro());
                this.telaFornecedor.getNomeEntrada().setText(fornecedor.getNome());
                this.telaFornecedor.getNomeFantasiaEntrada().setText(fornecedor.getNomeFantasia());
                this.telaFornecedor.getContatoEntrada().setText(fornecedor.getContato());
                this.telaFornecedor.getTelefone1Entrada().setText(fornecedor.getFone1());
                this.telaFornecedor.getTelefone2Entrada().setText(fornecedor.getFone2());
                this.telaFornecedor.getEmailEntrada().setText(fornecedor.getEmail());
                this.telaFornecedor.getRgInscricaoEstaEntrada().setText(fornecedor.getRgInscricaoEstadual());
                this.telaFornecedor.getCpfCnpjEntrada().setText(fornecedor.getCpfCnpj());
                this.telaFornecedor.getCepEntrada().setText(fornecedor.getCep());
                this.telaFornecedor.getCidadeEntrada().setText(fornecedor.getCidade());
                this.telaFornecedor.getBairroEntrada().setText(fornecedor.getBairro());
                this.telaFornecedor.getLogradouroEntrada().setText(fornecedor.getLogradouro());
                this.telaFornecedor.getComplementoEntrada().setText(fornecedor.getComplemento());
                this.telaFornecedor.getStatusEntrada().setSelectedItem(fornecedor.getStatus());


                this.telaFornecedor.getIdEntrada().setEnabled(false);
                this.telaFornecedor.getNomeFantasiaEntrada().requestFocus();

            } else if (evento.getSource() == this.telaFornecedor.getSairButton()) {
                this.telaFornecedor.dispose();
            }

        }
    }
}
