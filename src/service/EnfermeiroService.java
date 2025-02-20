package service;


import dao.EnfermeiraDAO;
import model.Enfermeira;

import java.util.List;

public class EnfermeiroService {

    // Adicionar um enfermeira
    public static void adicionar(Enfermeira objeto) {
        EnfermeiraDAO enfermeiraDAO = new EnfermeiraDAO();
        enfermeiraDAO.create(objeto);
    }

    // Ler todos os enfermeira
    public static List<Enfermeira> ler() {
        EnfermeiraDAO enfermeiraDAO = new EnfermeiraDAO();
        return enfermeiraDAO.retrieve();
    }

    // Ler enfermeira por ID
    public static Enfermeira ler(int PK) {
        EnfermeiraDAO enfermeiraDAO = new EnfermeiraDAO();
        return enfermeiraDAO.retrieve(PK);
    }

    // Ler enfermeira por um parâmetro e atributo
    public static List<Enfermeira> ler(String parametro, String atributo) {
        EnfermeiraDAO enfermeiraDAO = new EnfermeiraDAO();
        return enfermeiraDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um enfermeira
    public static void atualizar(Enfermeira objeto) {
        EnfermeiraDAO enfermeiraDAO = new EnfermeiraDAO();
        enfermeiraDAO.update(objeto);
    }

}
