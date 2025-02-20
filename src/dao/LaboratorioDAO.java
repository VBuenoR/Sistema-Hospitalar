package dao;

import model.Laboratorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioDAO implements InterfaceDAO<Laboratorio>{

    @Override
    public void create(Laboratorio objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "Insert into Laboratorio (nomeFantasia, "
                    + "contato,"
                    + "status) Values (?,?,?) ";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeFantasia());
            pstm.setString(2, objeto.getContato());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
    @Override
    public List<Laboratorio> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Laboratorio> listaLaboratorio = new ArrayList<Laboratorio>();

        String sqlInstrucao = "Select id, nomeFantasia, contato, status" + " from Laboratorio";

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setId(resultado.getInt("id"));
                laboratorio.setNomeFantasia(resultado.getString("nomeFantasia"));
                laboratorio.setContato(resultado.getString("contato"));
                laboratorio.setStatus(resultado.getString("status"));
                listaLaboratorio.add(laboratorio);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaLaboratorio;
        }
    }

    @Override
    public Laboratorio retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "Select id, nomeFantasia, contato, status" + " from Laboratorio Where laboratorio.id = ?";
        Laboratorio laboratorio = new Laboratorio();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                laboratorio.setId(resultado.getInt("id"));
                laboratorio.setNomeFantasia(resultado.getString("nomeFantasia"));
                laboratorio.setContato(resultado.getString("contato"));
                laboratorio.setStatus(resultado.getString("status"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return laboratorio;
        }
    }

    @Override
    public List<Laboratorio> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Laboratorio> listaLaboratorio = new ArrayList<Laboratorio>();

        String sqlInstrucao = "Select id, nomeFantasia, contato, status" +
                " from Laboratorio Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setId(resultado.getInt("id"));
                laboratorio.setNomeFantasia(resultado.getString("nomeFantasia"));
                laboratorio.setContato(resultado.getString("contato"));
                laboratorio.setStatus(resultado.getString("status"));
                listaLaboratorio.add(laboratorio);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaLaboratorio;
        }
    }

    @Override
    public void update(Laboratorio objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update Laboratorio "
                + " set "
                + " laboratorio.nomeFantasia = ? , "
                + " laboratorio.contato = ? , "
                + " laboratorio.status = ?  "
                + " Where laboratorio.id = ?";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeFantasia());
            pstm.setString(2, objeto.getContato());
            pstm.setString(3, objeto.getStatus());
            pstm.setInt(4, objeto.getId());
            pstm.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Laboratorio objeto) {

    }
}
