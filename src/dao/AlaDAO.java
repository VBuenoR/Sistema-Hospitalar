package dao;

import model.Acompanhante;
import model.Ala;
import model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlaDAO implements InterfaceDAO<Ala>{
    @Override
    public void create(Ala objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "INSERT INTO Ala (status, descricao) VALUES (?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getStatus());
            pstm.setString(2, objeto.getDescricao());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Ala> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, status, descricao FROM Ala";
        List<Ala> listaAla = new ArrayList<Ala>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Ala ala = new Ala();
                ala.setId(resultado.getInt("id"));
                ala.setStatus(resultado.getString("status"));
                ala.setDescricao(resultado.getString("descricao"));
                listaAla.add(ala);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaAla;
    }

    @Override
    public Ala retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "Select id, status, descricao" + " from Ala Where ala.id = ?";
        Ala ala = new Ala();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                ala.setId(resultado.getInt("id"));
                ala.setStatus(resultado.getString("status"));
                ala.setDescricao(resultado.getString("descricao"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return ala;
        }
    }

    @Override
    public List<Ala> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Ala> listaAla = new ArrayList<Ala>();

        String sqlInstrucao = "Select id, status, descricao" +
                " from Ala Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Ala ala = new Ala();
                ala.setId(resultado.getInt("id"));
                ala.setStatus(resultado.getString("status"));
                ala.setDescricao(resultado.getString("descricao"));
                listaAla.add(ala);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaAla;
        }
    }

    @Override
    public void update(Ala objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update Ala "
                + " set "
                + " ala.status = ? , "
                + " ala.descricao = ? , "
                + " Where acompanhante.id = ?";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getStatus());
            pstm.setString(2, objeto.getDescricao());
            pstm.setInt(3, objeto.getId());
            pstm.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.closeConnection(conexao, pstm, null);

        }
    }

    @Override
    public void delete(Ala objeto) {

    }
}
