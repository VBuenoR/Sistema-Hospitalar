package controller;

import model.ClasseDadosGravacao;
import model.Exame;
import utilities.Utilities;
import view.TelaExame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCadastroExame implements ActionListener {

    TelaExame telaExame;

    public ControllerCadastroExame(TelaExame telaExame) {
        this.telaExame = telaExame;
        this.telaExame.getAdicionarButton().addActionListener(this);
        this.telaExame.getCancelarButton().addActionListener(this);
        this.telaExame.getGravarButton().addActionListener(this);
        this.telaExame.getBuscarButton().addActionListener(this);
        this.telaExame.getSairButton().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaExame.getJPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaExame.getJPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaExame.getAdicionarButton()) {
            Utilities.ativaDesativa(true, this.telaExame.getJPanelBotoes());
            utilities.Utilities.limpaComponentes(true,this.telaExame.getJPanelDados());
            this.telaExame.getIdEntrada().setEnabled(false);


        } else if (evento.getSource() == this.telaExame.getCancelarButton()) {
            utilities.Utilities.ativaDesativa(false, this.telaExame.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaExame.getJPanelDados() );

        } else if (evento.getSource() == this.telaExame.getGravarButton()) {

            Exame exame = new Exame();

            exame.setId(ClasseDadosGravacao.listaExame.size() + 1);
            exame.setTipoExame(this.telaExame.getTipoExameEntrada().getText());
            exame.setTiutloExame(this.telaExame.getNomeExameEntrada().getText());
            exame.setStatus(this.telaExame.getStatusEntrada().getSelectedItem()+ "");

            ClasseDadosGravacao.listaExame.add(exame);

            Utilities.ativaDesativa(false, this.telaExame.getJPanelBotoes());
            Utilities.limpaComponentes(false, this.telaExame.getJPanelDados());

        }else if (evento.getSource() == this.telaExame.getBuscarButton()) {
            // Chamar a tela de buscas...
            //como não desenvolvemos ainda, carregar uma tela de dialogo presentando
            //pelo metodo toString() o resultado da lista referente ao cadastro
            JOptionPane.showMessageDialog(null, ClasseDadosGravacao.listaExame.toString());
        } else if (evento.getSource() == this.telaExame.getSairButton()) {
            this.telaExame.dispose();
        }


    }
}
