package service;

import dao.FornecedorDAO;
import model.Fornecedor;

import java.util.List;

public class FornecedorService {

    // Adicionar um fornecedor
    public static void adicionar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.create(objeto);
    }

    // Ler todos os fornecedores
    public static List<Fornecedor> ler() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve();
    }

    // Ler fornecedor por ID
    public static Fornecedor ler(int PK) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(PK);
    }

    // Ler fornecedores por um parâmetro e atributo
    public static List<Fornecedor> ler(String parametro, String atributo) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um fornecedor
    public static void atualizar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.update(objeto);
    }
}
