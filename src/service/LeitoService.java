package service;

import dao.LeitoDAO;
import model.Leito;

import java.util.List;


public class LeitoService {
    // Adicionar um leito
    public static void adicionar(Leito objeto) {
        LeitoDAO leitoDAO = new LeitoDAO();
        leitoDAO.create(objeto);
    }

    // Ler todos os leitos
    public static List<Leito> ler() {
        LeitoDAO leitoDAO = new LeitoDAO();
        return leitoDAO.retrieve();
    }

    // Ler leito por ID
    public static Leito ler(int PK) {
        LeitoDAO leitoDAO = new LeitoDAO();
        return leitoDAO.retrieve(PK);
    }

    // Ler leito por um parâmetro e atributo
    public static List<Leito> ler(String parametro, String atributo) {
        LeitoDAO leitoDAO = new LeitoDAO();
        return leitoDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um leito
    public static void atualizar(Leito objeto) {
        LeitoDAO leitoDAO = new LeitoDAO();
        leitoDAO.update(objeto);
    }

}
