package service;

import dao.FarmaceuticoDAO;
import model.Farmaceutico;

import java.util.List;

public class FarmaceuticoService {

    // Adicionar um farmacêutico
    public static void adicionar(Farmaceutico objeto) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        farmaceuticoDAO.create(objeto);
    }

    // Ler todos os farmacêuticos
    public static List<Farmaceutico> ler() {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve();
    }

    // Ler farmacêutico por ID
    public static Farmaceutico ler(int PK) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve(PK);
    }

    // Ler farmacêuticos por um parâmetro e atributo
    public static List<Farmaceutico> ler(String parametro, String atributo) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um farmacêutico
    public static void atualizar(Farmaceutico objeto) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        farmaceuticoDAO.update(objeto);
    }
}
