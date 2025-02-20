package service;

import dao.QuartoDAO;
import model.Quarto;

import java.util.List;

public class QuartoService {
    // Adicionar um quarto
    public static void adicionar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.create(objeto);
    }

    // Ler todos os quartos
    public static List<Quarto> ler() {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.retrieve();
    }

    // Ler quarto por ID
    public static Quarto ler(int PK) {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.retrieve(PK);
    }

    // Ler quarto por um parâmetro e atributo
    public static List<Quarto> ler(String parametro, String atributo) {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um quarto
    public static void atualizar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.update(objeto);
    }

}
