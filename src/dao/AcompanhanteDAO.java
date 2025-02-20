package dao;

import model.Acompanhante;
import model.Medicamento;
import model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcompanhanteDAO implements InterfaceDAO<Acompanhante>{
    @Override
    public void create(Acompanhante objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "INSERT INTO Acompanhante (nome, grauParentesco, cpf, fone, email, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getGrauParentesco());
            pstm.setString(3, objeto.getCpf());
            pstm.setString(4, objeto.getFone());
            pstm.setString(5, objeto.getEmail());
            pstm.setString(6, objeto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Acompanhante> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Acompanhante> listaAcompanhante = new ArrayList<Acompanhante>();
        String sqlInstrucao = "SELECT id, nome, grauParentesco, cpf, fone, email, status FROM Acompanhante";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Acompanhante acompanhante = new Acompanhante();
                acompanhante.setId(resultado.getInt("id"));
                acompanhante.setNome(resultado.getString("nome"));
                acompanhante.setGrauParentesco(resultado.getString("grauParentesco"));
                acompanhante.setCpf(resultado.getString("cpf"));
                acompanhante.setFone(resultado.getString("fone"));
                acompanhante.setEmail(resultado.getString("email"));
                acompanhante.setStatus(resultado.getString("status"));
                listaAcompanhante.add(acompanhante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaAcompanhante;
    }

    @Override
    public Acompanhante retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "Select id, nome, grauParentesco, cpf, fone, email, status" + " from Acompanhante Where acompanhante.id = ?";
        Acompanhante acompanhante = new Acompanhante();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                acompanhante.setId(resultado.getInt("id"));
                acompanhante.setNome(resultado.getString("nome"));
                acompanhante.setGrauParentesco(resultado.getString("grauParentesco"));
                acompanhante.setCpf(resultado.getString("cpf"));
                acompanhante.setFone(resultado.getString("fone"));
                acompanhante.setEmail(resultado.getString("email"));
                acompanhante.setStatus(resultado.getString("status"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return acompanhante;
        }
    }

    @Override
    public List<Acompanhante> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Acompanhante> listaAcompanhante = new ArrayList<Acompanhante>();

        String sqlInstrucao = "Select id, nome, grauParentesco, cpf, fone, email, status" +
                " from Acompanhante Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Acompanhante acompanhante = new Acompanhante();
                acompanhante.setId(resultado.getInt("id"));
                acompanhante.setNome(resultado.getString("nome"));
                acompanhante.setGrauParentesco(resultado.getString("grauParentesco"));
                acompanhante.setCpf(resultado.getString("cpf"));
                acompanhante.setFone(resultado.getString("fone"));
                acompanhante.setEmail(resultado.getString("email"));
                acompanhante.setStatus(resultado.getString("status"));
                listaAcompanhante.add(acompanhante);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaAcompanhante;
        }
    }

    @Override
    public void update(Acompanhante objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update Acompanhante "
                + " set "
                + " acompanhante.nome = ? , "
                + " acompanhante.grauParentesco = ? , "
                + " acompanhante.cpf = ? , "
                + " acompanhante.fone = ? , "
                + " acompanhante.email = ? , "
                + " acompanhante.status = ? , "
                + " Where acompanhante.id = ?";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getGrauParentesco());
            pstm.setString(3, objeto.getCpf());
            pstm.setString(4, objeto.getFone());
            pstm.setString(5, objeto.getEmail());
            pstm.setString(6, objeto.getStatus());
            pstm.setInt(7, objeto.getId());
            pstm.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.closeConnection(conexao, pstm, null);

        }
    }

    @Override
    public void delete(Acompanhante objeto) {

    }
}
