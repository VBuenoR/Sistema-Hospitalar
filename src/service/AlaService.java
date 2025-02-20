package service;

import dao.AlaDAO;
import model.Ala;

import java.util.List;

public class AlaService {

    // Adicionar um ala
    public static void adicionar(Ala objeto) {
        AlaDAO alaDAO = new AlaDAO();
        alaDAO.create(objeto);
    }

    // Ler todos os ala
    public static List<Ala> ler() {
        AlaDAO alaDAO = new AlaDAO();
        return alaDAO.retrieve();
    }

    // Ler ala por ID
    public static Ala ler(int PK) {
        AlaDAO alaDAO = new AlaDAO();
        return alaDAO.retrieve(PK);
    }

    // Ler ala por um parâmetro e atributo
    public static List<Ala> ler(String parametro, String atributo) {
        AlaDAO alaDAO = new AlaDAO();
        return alaDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um ala
    public static void atualizar(Ala objeto) {
        AlaDAO alaDAO = new AlaDAO();
        alaDAO.update(objeto);
    }
}
