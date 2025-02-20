package dao;

import model.Medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO implements InterfaceDAO<Medicamento>{

    @Override
    public void create(Medicamento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "Insert into Medicamento (descricaoMedicamento, "
                    + "principioAtivo,"
                    + "qtdMinima, "
                    + "status) Values (?,?,?,?) ";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricaoMedicamento());
            pstm.setString(2, objeto.getPrincipioAtivo());
            pstm.setFloat(3, objeto.getQtdMinima());
            pstm.setString(4, objeto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Medicamento> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Medicamento> listaMedicamento = new ArrayList<Medicamento>();

        String sqlInstrucao = "Select id, descricaoMedicamento, principioAtivo, qtdMinima, status" + " from Medicamento";

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                Medicamento medicamento = new Medicamento();
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricaoMedicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principioAtivo"));
                medicamento.setQtdMinima(resultado.getInt("qtdMinima"));
                medicamento.setStatus(resultado.getString("status"));
                listaMedicamento.add(medicamento);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaMedicamento;
        }
    }

    @Override
    public Medicamento retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "Select id, descricaoMedicamento, principioAtivo, qtdMinima, status" + " from Medicamento Where medicamento.id = ?";
        Medicamento medicamento = new Medicamento();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricaoMedicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principioAtivo"));
                medicamento.setQtdMinima(resultado.getInt("qtdMinima"));
                medicamento.setStatus(resultado.getString("status"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return medicamento;
        }
    }

    @Override
    public List<Medicamento> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Medicamento> listaMedicamento = new ArrayList<Medicamento>();

        String sqlInstrucao = "Select id, descricaoMedicamento, principioAtivo, qtdMinima, status" +
                " from Medicamento Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Medicamento medicamento = new Medicamento();
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricaoMedicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principioAtivo"));
                medicamento.setQtdMinima(resultado.getInt("qtdMinima"));
                medicamento.setStatus(resultado.getString("status"));
                listaMedicamento.add(medicamento);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaMedicamento;
        }
    }

    @Override
    public void update(Medicamento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update Medicamento "
                + " set "
                + " medicamento.descricaoMedicamento = ? , "
                + " medicamento.principioAtivo = ? , "
                + " medicamento.qtdMinima = ? , "
                + " medicamento.status = ? "
                + " Where medicamento.id = ?";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, objeto.getId());
            pstm.setString(2, objeto.getDescricaoMedicamento());
            pstm.setString(3, objeto.getPrincipioAtivo());
            pstm.setFloat(4,objeto.getQtdMinima());
            pstm.setString(5,objeto.getStatus());
            pstm.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.closeConnection(conexao, pstm, null);
            
        }
    }

    @Override
    public void delete(Medicamento objeto) {

    }
}
