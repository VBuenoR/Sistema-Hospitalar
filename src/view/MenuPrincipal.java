package view;

import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuPrincipal extends javax.swing.JFrame {
    private JPanel panel1;
    private JComboBox comboBoxPessoas;
    private JComboBox comboBoxAlas;
    private JComboBox comboBoxItens;

    static JMenuBar menuBar;

    // JMenu
    static JMenu menuCadastro;
    static JMenu menuMovimento;

    // Menu items
    static JMenuItem pacienteItemMenu, acompanhanteItemMenu, medicoItemMenu,
            enfermeiroItemMenu, farmaceuticoItemMenu, usuarioItemMenu,
            fornecedorItemMenu, laboratorioItemMenu, alaItemMenu, quartoItemMenu,
            leitoItemMenu, medicamentoItemMenu;



    public MenuPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setContentPane(panel1);

        menuBar = new JMenuBar();

        menuCadastro = new JMenu("Cadastro");
        menuMovimento = new JMenu("Movimento");

        pacienteItemMenu = new JMenuItem("Paciente");
        acompanhanteItemMenu = new JMenuItem("Acompanhante");
        medicoItemMenu = new JMenuItem("Medico");
        enfermeiroItemMenu = new JMenuItem("Enfermeiro");
        farmaceuticoItemMenu = new JMenuItem("Farmaceutico");
        usuarioItemMenu = new JMenuItem("Usuario");
        fornecedorItemMenu = new JMenuItem("Fornecedor");
        laboratorioItemMenu = new JMenuItem("Laboratorio");
        alaItemMenu = new JMenuItem("Alagoas");
        quartoItemMenu = new JMenuItem("Quarto");
        leitoItemMenu = new JMenuItem("Leito");
        medicamentoItemMenu = new JMenuItem("Medicamento");

        menuCadastro.add(pacienteItemMenu);
        menuCadastro.add(acompanhanteItemMenu);
        menuCadastro.add(medicoItemMenu);
        menuCadastro.add(enfermeiroItemMenu);
        menuCadastro.add(farmaceuticoItemMenu);
        menuCadastro.add(usuarioItemMenu);
        menuCadastro.add(fornecedorItemMenu);
        menuCadastro.add(laboratorioItemMenu);
        menuCadastro.add(alaItemMenu);
        menuCadastro.add(quartoItemMenu);
        menuCadastro.add(leitoItemMenu);
        menuCadastro.add(medicamentoItemMenu);

        menuBar.add(menuCadastro);
        menuBar.add(menuMovimento);


        pacienteItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                if (event.getSource() == pacienteItemMenu){
                    TelaPaciente telaPaciente = new TelaPaciente();
                    ControllerCadastroPaciente controllerCadastroPaciente = new ControllerCadastroPaciente(telaPaciente);
                    telaPaciente.setSize(1000, 500);
                    telaPaciente.setLocationRelativeTo(null);
                    telaPaciente.setVisible(true);
                }

            }
        });
        acompanhanteItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                if (event.getSource() == acompanhanteItemMenu){
                    TelaAcompanhante telaAcompanhante = new TelaAcompanhante();
                    ControllerCadastroAcompanhante controllerCadastroAcompanhante = new ControllerCadastroAcompanhante(telaAcompanhante);
                    telaAcompanhante.setSize(1000, 500);
                    telaAcompanhante.setLocationRelativeTo(null);
                    telaAcompanhante.setVisible(true);
                }

            }
        });
        medicoItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                if (event.getSource() == medicoItemMenu){
                    TelaMedico telaMedico = new TelaMedico();
                    ControllerCadastroMedico controllerCadastroMedico = new ControllerCadastroMedico(telaMedico);
                    telaMedico.setSize(1000, 500);
                    telaMedico.setLocationRelativeTo(null);
                    telaMedico.setVisible(true);
                }
            }
        });
        enfermeiroItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                if (event.getSource() == enfermeiroItemMenu){
                    TelaEnfermeira telaEnfermeiro = new TelaEnfermeira();
                    ControllerCadastroEnfermeiro controllerCadastroEnfermeiro = new ControllerCadastroEnfermeiro(telaEnfermeiro);
                    telaEnfermeiro.setSize(1000, 500);
                    telaEnfermeiro.setLocationRelativeTo(null);
                    telaEnfermeiro.setVisible(true);
                }
            }
        });
        farmaceuticoItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                if (event.getSource() == farmaceuticoItemMenu){
                    TelaFarmaceutico telaFarmaceutico = new TelaFarmaceutico();
                    ControllerCadastroFarmaceutico controllerCadastroFarmaceutico = new ControllerCadastroFarmaceutico(telaFarmaceutico);
                    telaFarmaceutico.setSize(1000, 800);
                    telaFarmaceutico.setLocationRelativeTo(null);
                    telaFarmaceutico.setVisible(true);
                }
            }
        });
        usuarioItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                if (event.getSource() == usuarioItemMenu){
                    TelaUsuario telaUsuario = new TelaUsuario();
                    ControllerCadastroUsuario controllerCadastroUsuario = new ControllerCadastroUsuario(telaUsuario);
                    telaUsuario.setSize(1000, 500);
                    telaUsuario.setLocationRelativeTo(null);
                    telaUsuario.setVisible(true);
                }
            }
        });
        fornecedorItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                if (event.getSource() == fornecedorItemMenu){
                    TelaFornecedor telaFornecedor = new TelaFornecedor();
                    ControllerCadastroFornecedor controllerCadastroFornecedor = new ControllerCadastroFornecedor(telaFornecedor);
                    telaFornecedor.setSize(1000, 500);
                    telaFornecedor.setLocationRelativeTo(null);
                    telaFornecedor.setVisible(true);
                }
            }
        });

        comboBoxPessoas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBoxPessoas.getSelectedItem() == "- Paciente") {
                    TelaPaciente telaPaciente = new TelaPaciente();
                    ControllerCadastroPaciente controllerCadastroPaciente = new ControllerCadastroPaciente(telaPaciente);
                    telaPaciente.setSize(1000, 500);
                    telaPaciente.setLocationRelativeTo(null);
                    telaPaciente.setVisible(true);
                } else if (comboBoxPessoas.getSelectedItem() == "- Acompanhante") {
                    TelaAcompanhante telaAcompanhante = new TelaAcompanhante();
                    ControllerCadastroAcompanhante controllerCadastroAcompanhante = new ControllerCadastroAcompanhante(telaAcompanhante);
                    telaAcompanhante.setSize(1000, 500);
                    telaAcompanhante.setLocationRelativeTo(null);
                    telaAcompanhante.setVisible(true);
                } else if (comboBoxPessoas.getSelectedItem() == "- Medico") {
                    TelaMedico telaMedico = new TelaMedico();
                    ControllerCadastroMedico controllerCadastroMedico = new ControllerCadastroMedico(telaMedico);
                    telaMedico.setSize(1000, 500);
                    telaMedico.setLocationRelativeTo(null);
                    telaMedico.setVisible(true);
                } else if (comboBoxPessoas.getSelectedItem() == "- Enfermeira") {
                    TelaEnfermeira telaEnfermeira = new TelaEnfermeira();
                    ControllerCadastroEnfermeiro controllerCadastroEnfermeiro = new ControllerCadastroEnfermeiro(telaEnfermeira);
                    telaEnfermeira.setSize(1000, 500);
                    telaEnfermeira.setLocationRelativeTo(null);
                    telaEnfermeira.setVisible(true);
                } else if (comboBoxPessoas.getSelectedItem() == "- Farmaceutico") {
                    TelaFarmaceutico telaFarmaceutico = new TelaFarmaceutico();
                    ControllerCadastroFarmaceutico controllerCadastroFarmaceutico = new ControllerCadastroFarmaceutico(telaFarmaceutico);
                    telaFarmaceutico.setSize(1000, 500);
                    telaFarmaceutico.setLocationRelativeTo(null);
                    telaFarmaceutico.setVisible(true);
                } else if (comboBoxPessoas.getSelectedItem() == "- Usuario") {
                    TelaUsuario telaUsuario = new TelaUsuario();
                    ControllerCadastroUsuario controllerCadastroUsuario = new ControllerCadastroUsuario(telaUsuario);
                    telaUsuario.setSize(1000, 500);
                    telaUsuario.setLocationRelativeTo(null);
                    telaUsuario.setVisible(true);
                } else if (comboBoxPessoas.getSelectedItem() == "- Fornecedor") {
                    TelaFornecedor telaFornecedor = new TelaFornecedor();
                    ControllerCadastroFornecedor controllerCadastroFornecedor = new ControllerCadastroFornecedor(telaFornecedor);
                    telaFornecedor.setSize(1000, 500);
                    telaFornecedor.setLocationRelativeTo(null);
                    telaFornecedor.setVisible(true);
                } else if (comboBoxPessoas.getSelectedItem() == "- Laboratorio") {
                    TelaLaboratorio telaLaboratorio = new TelaLaboratorio();
                    ControllerCadastroLaboratorio controllerCadastroLaboratorio = new ControllerCadastroLaboratorio(telaLaboratorio);
                    telaLaboratorio.setSize(1000, 500);
                    telaLaboratorio.setLocationRelativeTo(null);
                    telaLaboratorio.setVisible(true);
                }
            }
        });

        comboBoxAlas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxAlas.getSelectedItem() == "- Ala") {
                    TelaAla telaAla = new TelaAla();
                    ControllerCadastroAla controllerCadastroAla = new ControllerCadastroAla(telaAla);
                    telaAla.setSize(1000, 500);
                    telaAla.setLocationRelativeTo(null);
                    telaAla.setVisible(true);
                } else if (comboBoxAlas.getSelectedItem() == "- Quarto") {
                    TelaQuarto telaQuarto = new TelaQuarto();
                    ControllerCadastroQuarto controllerCadastroQuarto = new ControllerCadastroQuarto(telaQuarto);
                    telaQuarto.setSize(1000, 500);
                    telaQuarto.setLocationRelativeTo(null);
                    telaQuarto.setVisible(true);
                } else if (comboBoxAlas.getSelectedItem() == "- Leito") {
                    TelaLeito telaLeito = new TelaLeito();
                    ControllerCadastroLeito controllerCadastroLeito = new ControllerCadastroLeito(telaLeito);
                    telaLeito.setSize(1000, 500);
                    telaLeito.setLocationRelativeTo(null);
                    telaLeito.setVisible(true);
                }
            }
        });
        comboBoxItens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxItens.getSelectedItem() == "- Exame") {
                    TelaExame telaExame = new TelaExame();
                    ControllerCadastroExame controllerCadastroExame = new ControllerCadastroExame(telaExame);
                    telaExame.setSize(1000, 500);
                    telaExame.setLocationRelativeTo(null);
                    telaExame.setVisible(true);
                }
                else if (comboBoxItens.getSelectedItem() == "- Medicamento") {
                    TelaMedicamento telaMedicamento = new TelaMedicamento();
                    ControllerCadastroMedicamento controllerCadastroMedicamento = new ControllerCadastroMedicamento(telaMedicamento);
                    telaMedicamento.setSize(750, 500);
                    telaMedicamento.setLocationRelativeTo(null);
                    telaMedicamento.setVisible(true);

                }
            }
        });
    }



    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        menuPrincipal.setJMenuBar(menuBar);
        menuPrincipal.setSize(720, 200);
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setVisible(true);
        menuPrincipal.setPreferredSize(new Dimension(720, 200));
    }
}
