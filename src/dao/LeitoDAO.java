package dao;

import model.Leito;
import model.Quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeitoDAO implements InterfaceDAO<Leito> {

    @Override
    public void create(Leito leito) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO Leito (descricao, status, quarto_id) VALUES (?, ?, ?)";
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, leito.getDescricao());
            pstm.setString(2, leito.getStatus());
            pstm.setInt(3, leito.getQuarto().getId());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Leito> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status, quarto_id FROM Leito";
        List<Leito> listaLeitos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Leito leito = new Leito();
                leito.setId(resultado.getInt("id"));
                leito.setDescricao(resultado.getString("descricao"));
                leito.setStatus(resultado.getString("status"));

                QuartoDAO quartoDAO = new QuartoDAO();
                Quarto quarto = quartoDAO.retrieve(resultado.getInt("quarto_id"));
                leito.setQuarto(quarto);

                listaLeitos.add(leito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaLeitos;
    }

    @Override
    public Leito retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status, quarto_id FROM Leito WHERE id = ?";
        Leito leito = new Leito();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();

            if (resultado.next()) {
                leito.setId(resultado.getInt("id"));
                leito.setDescricao(resultado.getString("descricao"));
                leito.setStatus(resultado.getString("status"));

                QuartoDAO quartoDAO = new QuartoDAO();
                Quarto quarto = quartoDAO.retrieve(resultado.getInt("quarto_id"));
                leito.setQuarto(quarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return leito;
    }

    @Override
    public List<Leito> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Leito> listaLeitos = new ArrayList<>();
        String sqlInstrucao = "SELECT id, descricao, status, quarto_id FROM Leito WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Leito leito = new Leito();
                leito.setId(resultado.getInt("id"));
                leito.setDescricao(resultado.getString("descricao"));
                leito.setStatus(resultado.getString("status"));

                QuartoDAO quartoDAO = new QuartoDAO();
                Quarto quarto = quartoDAO.retrieve(resultado.getInt("quarto_id"));
                leito.setQuarto(quarto);

                listaLeitos.add(leito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaLeitos;
    }

    @Override
    public void update(Leito objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE Leito SET descricao = ?, status = ?, quarto_id = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getStatus());
            pstm.setInt(3, objeto.getQuarto().getId());
            pstm.setInt(4, objeto.getId());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Leito objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "DELETE FROM Leito WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, objeto.getId());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}