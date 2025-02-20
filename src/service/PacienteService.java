package service;

import dao.PacienteDAO;
import model.Paciente;

import java.util.List;

public class PacienteService {

    // Adicionar um paciente
    public static void adicionar(Paciente objeto) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.create(objeto);
    }

    // Ler todos os paciente
    public static List<Paciente> ler() {
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.retrieve();
    }

    // Ler paciente por ID
    public static Paciente ler(int PK) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.retrieve(PK);
    }

    // Ler paciente por um parâmetro e atributo
    public static List<Paciente> ler(String parametro, String atributo) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um paciente
    public static void atualizar(Paciente objeto) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.update(objeto);
    }
}
