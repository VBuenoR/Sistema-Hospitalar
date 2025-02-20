package dao;

import model.Acompanhante;
import model.Exame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExameDAO implements InterfaceDAO<Exame>{
    @Override
    public void create(Exame objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "INSERT INTO Medico (id, tituloExame, tipoExame, status) VALUES (?, ?, ?, ?)";


            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, objeto.getId());
            pstm.setString(2,objeto.getTiutloExame());
            pstm.setString(3,objeto.getTipoExame());
            pstm.setString(4,objeto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Exame> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, tituloExame, tipoExame, status FROM Medico";
        List<Exame> listaExame = new ArrayList<Exame>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Exame exame = new Exame();
                exame.setId(resultado.getInt("id"));
                exame.setTiutloExame(resultado.getString("tituloExame"));
                exame.setTipoExame(resultado.getString("tipoExame"));
                exame.setStatus(resultado.getString("status"));
                listaExame.add(exame);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaExame;
    }

    @Override
    public Exame retrieve(int pk) {
        return null;
    }

    @Override
    public List<Exame> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(Exame objeto) {

    }

    @Override
    public void delete(Exame objeto) {

    }
}
