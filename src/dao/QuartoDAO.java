package dao;

import model.Quarto;
import model.Ala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO implements InterfaceDAO<Quarto> {

    @Override
    public void create(Quarto quarto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO Quarto (descricao, status, ala_id) VALUES (?, ?, ?)";
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, quarto.getDescricao());
            pstm.setString(2, quarto.getStatus());
            pstm.setInt(3, quarto.getAla().getId());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Quarto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status, ala_id FROM Quarto";
        List<Quarto> listaQuartos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Quarto quarto = new Quarto();
                quarto.setId(resultado.getInt("id"));
                quarto.setDescricao(resultado.getString("descricao"));
                quarto.setStatus(resultado.getString("status"));

                AlaDAO alaDAO = new AlaDAO();
                Ala ala = alaDAO.retrieve(resultado.getInt("ala_id"));
                quarto.setAla(ala);

                listaQuartos.add(quarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaQuartos;
    }

    @Override
    public Quarto retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status, ala_id FROM Quarto WHERE id = ?";
        Quarto quarto = new Quarto();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();

            if (resultado.next()) {
                quarto.setId(resultado.getInt("id"));
                quarto.setDescricao(resultado.getString("descricao"));
                quarto.setStatus(resultado.getString("status"));

                AlaDAO alaDAO = new AlaDAO();
                Ala ala = alaDAO.retrieve(resultado.getInt("ala_id"));
                quarto.setAla(ala);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return quarto;
    }

    @Override
    public List<Quarto> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Quarto> listaQuartos = new ArrayList<>();
        String sqlInstrucao = "SELECT id, descricao, status, ala_id FROM Quarto WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Quarto quarto = new Quarto();
                quarto.setId(resultado.getInt("id"));
                quarto.setDescricao(resultado.getString("descricao"));
                quarto.setStatus(resultado.getString("status"));

                AlaDAO alaDAO = new AlaDAO();
                Ala ala = alaDAO.retrieve(resultado.getInt("ala_id"));
                quarto.setAla(ala);

                listaQuartos.add(quarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaQuartos;
    }

    @Override
    public void update(Quarto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE Quarto SET descricao = ?, status = ?, ala_id = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getStatus());
            pstm.setInt(3, objeto.getAla().getId());
            pstm.setInt(4, objeto.getId());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Quarto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "DELETE FROM Quarto WHERE id = ?";
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