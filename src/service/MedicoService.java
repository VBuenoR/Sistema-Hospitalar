package service;

import dao.MedicoDAO;
import model.Medico;

import java.util.List;

public class MedicoService {

    // Adicionar um médico
    public static void adicionar(Medico objeto) {
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.create(objeto);
    }

    // Ler todos os médicos
    public static List<Medico> ler() {
        MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.retrieve();
    }

    // Ler médico por ID
    public static Medico ler(int PK) {
        MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.retrieve(PK);
    }

    // Ler médicos por um parâmetro e atributo
    public static List<Medico> ler(String parametro, String atributo) {
        MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um médico
    public static void atualizar(Medico objeto) {
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.update(objeto);
    }
}
