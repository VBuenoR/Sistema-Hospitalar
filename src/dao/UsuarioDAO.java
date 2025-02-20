package dao;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements InterfaceDAO<Usuario>{
    @Override
    public void create(Usuario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "INSERT INTO Usuario (id, login, senha, nomeSocial, status) " +
                    "VALUES (?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, objeto.getId());
            pstm.setString(2, objeto.getLogin());
            pstm.setString(3, objeto.getSenha());
            pstm.setString(4, objeto.getNomeSocial());
            pstm.setString(5, objeto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Usuario> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, login, senha, nomeSocial, status FROM Usuario";
        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNomeSocial(resultado.getString("nomeSocial"));
                usuario.setStatus(resultado.getString("status"));

                listaUsuario.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);

        }
        return listaUsuario;
    }

    @Override
    public Usuario retrieve(int pk) {
        String sqlInstrucao = "SELECT id, login, senha, nomeSocial, status FROM Usuario WHERE id = ?";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement pstm = conexao.prepareStatement(sqlInstrucao)) {

            pstm.setInt(1, pk);
            try (ResultSet resultado = pstm.executeQuery()) {
                if (resultado.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuario.setNomeSocial(resultado.getString("nomeSocial"));
                    usuario.setStatus(resultado.getString("status"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> retrieve(String parametro, String atributo) {
        String sqlInstrucao = "SELECT id, login, senha, nomeSocial, status FROM Usuario WHERE " + atributo + " = ?";
        List<Usuario> listaUsuario = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement pstm = conexao.prepareStatement(sqlInstrucao)) {

            pstm.setString(1, atributo);
            try (ResultSet resultado = pstm.executeQuery()) {
                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuario.setNomeSocial(resultado.getString("nomeSocial"));
                    usuario.setStatus(resultado.getString("status"));
                    listaUsuario.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }


    @Override
    public void update(Usuario objeto) {
        String sqlInstrucao = "UPDATE Usuario"
                + " set "
                + " usuario.login = ?, "
                + " usuario.senha = ?, "
                + " usuario.nomeSocial = ?, "
                + " usuario.status = ? "
                + " WHERE id = ?";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement pstm = conexao.prepareStatement(sqlInstrucao)) {

            pstm.setString(1, objeto.getLogin());
            pstm.setString(2, objeto.getSenha());
            pstm.setString(3, objeto.getNomeSocial());
            pstm.setString(4, objeto.getStatus());
            pstm.setInt(5, objeto.getId());
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Usuario objeto) {

    }
}
