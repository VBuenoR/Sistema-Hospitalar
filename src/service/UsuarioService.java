package service;

import dao.UsuarioDAO;
import model.Usuario;

import java.util.List;

public class UsuarioService {

    // Adicionar um usuario
    public static void adicionar(Usuario objeto) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.create(objeto);
    }

    // Ler todos os usuario
    public static List<Usuario> ler() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.retrieve();
    }

    // Ler usuario por ID
    public static Usuario ler(int PK) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.retrieve(PK);
    }

    // Ler médicos por um parâmetro e atributo
    public static List<Usuario> ler(String parametro, String atributo) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.retrieve(parametro, atributo);
    }

    // Atualizar informações de um usuario
    public static void atualizar(Usuario objeto) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.update(objeto);
    }
}
