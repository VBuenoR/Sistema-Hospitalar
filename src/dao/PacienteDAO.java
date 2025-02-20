package dao;

import model.Farmaceutico;
import model.Medico;
import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO implements InterfaceDAO<Paciente>{
    @Override
    public void create(Paciente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO Paciente (tipoSanguineo, nomeSocial, sexo, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, " +
                    "dataCadastro, cep, cidade, bairro, logradouro, complemento, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getTipoSanguineo());
            pstm.setString(2, objeto.getNomeSocial());
            pstm.setString(3, objeto.getSexo());
            pstm.setString(4, objeto.getNome());
            pstm.setString(5, objeto.getFone1());
            pstm.setString(6, objeto.getFone2());
            pstm.setString(7, objeto.getEmail());
            pstm.setString(8, objeto.getCpfCnpj());
            pstm.setString(9, objeto.getRgInscricaoEstadual());
            pstm.setString(10, objeto.getDataCadastro());
            pstm.setString(11, objeto.getCep());
            pstm.setString(12, objeto.getCidade());
            pstm.setString(13, objeto.getBairro());
            pstm.setString(14, objeto.getLogradouro());
            pstm.setString(15, objeto.getComplemento());
            pstm.setString(16, objeto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }


    @Override
    public List<Paciente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, tipoSanguineo, nomeSocial, sexo, id, nome, fone1, fone2, email, " +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status FROM Paciente";
        List<Paciente> listaPaciente = new ArrayList<Paciente>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setId(resultado.getInt("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setFone1(resultado.getString("fone1"));
                paciente.setFone2(resultado.getString("fone2"));
                paciente.setEmail(resultado.getString("email"));
                paciente.setCpfCnpj(resultado.getString("cpfCnpj"));
                paciente.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                paciente.setDataCadastro(resultado.getString("dataCadastro"));
                paciente.setCep(resultado.getString("cep"));
                paciente.setCidade(resultado.getString("cidade"));
                paciente.setBairro(resultado.getString("bairro"));
                paciente.setLogradouro(resultado.getString("logradouro"));
                paciente.setComplemento(resultado.getString("complemento"));
                paciente.setStatus(resultado.getString("status"));


                listaPaciente.add(paciente);
            }

        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);

        } return listaPaciente;
    }

    @Override
    public Paciente retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, tipoSanguineo, nomeSocial, sexo, id, nome, fone1, fone2, email, cpfCnpj," +
                " rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Paciente Where paciente.id = ?";
        Paciente paciente = new Paciente();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setId(resultado.getInt("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setFone1(resultado.getString("fone1"));
                paciente.setFone2(resultado.getString("fone2"));
                paciente.setEmail(resultado.getString("email"));
                paciente.setCpfCnpj(resultado.getString("cpfCnpj"));
                paciente.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                paciente.setDataCadastro(resultado.getString("dataCadastro"));
                paciente.setCep(resultado.getString("cep"));
                paciente.setCidade(resultado.getString("cidade"));
                paciente.setBairro(resultado.getString("bairro"));
                paciente.setLogradouro(resultado.getString("logradouro"));
                paciente.setComplemento(resultado.getString("complemento"));
                paciente.setStatus(resultado.getString("status"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return paciente;
        }
    }

    @Override
    public List<Paciente> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Paciente> listaPaciente = new ArrayList<Paciente>();

        String sqlInstrucao = "SELECT id, tipoSanguineo, nomeSocial, sexo, id, nome, fone1, fone2, email, cpfCnpj," +
                "rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Paciente Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Paciente paciente = new Paciente();
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setId(resultado.getInt("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setFone1(resultado.getString("fone1"));
                paciente.setFone2(resultado.getString("fone2"));
                paciente.setEmail(resultado.getString("email"));
                paciente.setCpfCnpj(resultado.getString("cpfCnpj"));
                paciente.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                paciente.setDataCadastro(resultado.getString("dataCadastro"));
                paciente.setCep(resultado.getString("cep"));
                paciente.setCidade(resultado.getString("cidade"));
                paciente.setBairro(resultado.getString("bairro"));
                paciente.setLogradouro(resultado.getString("logradouro"));
                paciente.setComplemento(resultado.getString("complemento"));
                paciente.setStatus(resultado.getString("status"));
                listaPaciente.add(paciente);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaPaciente;
        }
    }

    @Override
    public void update(Paciente objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlInstrucao = "UPDATE paciente set (tipoSanguineo, nomeSocial, " +
                "sexo, id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, " +
                "dataCadastro, cep, cidade, bairro, logradouro, complemento, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getTipoSanguineo());
            pstm.setString(4, objeto.getNomeSocial());
            pstm.setString(5, objeto.getSexo());
            pstm.setInt(6, objeto.getId());
            pstm.setString(7, objeto.getNome());
            pstm.setString(8, objeto.getFone1());
            pstm.setString(9, objeto.getFone2());
            pstm.setString(10, objeto.getEmail());
            pstm.setString(11, objeto.getCpfCnpj());
            pstm.setString(12, objeto.getRgInscricaoEstadual());
            pstm.setString(13, objeto.getDataCadastro());
            pstm.setString(14, objeto.getCep());
            pstm.setString(15, objeto.getCidade());
            pstm.setString(16, objeto.getBairro());
            pstm.setString(17, objeto.getLogradouro());
            pstm.setString(18, objeto.getComplemento());
            pstm.setString(19, objeto.getStatus());
            pstm.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Paciente objeto) {

    }
}
