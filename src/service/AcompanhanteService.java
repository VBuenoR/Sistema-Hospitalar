package service;

import dao.AcompanhanteDAO;
import model.Acompanhante;
import java.util.List;

public class AcompanhanteService {

    // Adicionar um acompanhante
    public static void adicionar(Acompanhante objeto) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        acompanhanteDAO.create(objeto);
    }

    // Ler todos os acompanhante
    public static List<Acompanhante> ler() {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        return acompanhanteDAO.retrieve();
    }

    // Ler acompanhante por ID
    public static Acompanhante ler(int PK) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        return acompanhanteDAO.retrieve(PK);
    }

    // Ler enfermeira por um parâmetro e atributo
    public static List<Acompanhante> ler(String parametro, String atributo) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        return acompanhanteDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um acompanhante
    public static void atualizar(Acompanhante objeto) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        acompanhanteDAO.update(objeto);
    }

}
