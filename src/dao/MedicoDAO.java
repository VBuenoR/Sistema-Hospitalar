package dao;

import model.Medicamento;
import model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO implements InterfaceDAO<Medico> {

    @Override
    public void create(Medico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "INSERT INTO Medico (crm, senha, login, nomeSocial, " +
                    "sexo, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, " +
                    "dataCadastro, cep, cidade, bairro, logradouro, complemento, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getCrm());
            pstm.setString(2, objeto.getSenha());
            pstm.setString(3, objeto.getLogin());
            pstm.setString(4, objeto.getNomeSocial());
            pstm.setString(5, objeto.getSexo());
            pstm.setString(6, objeto.getNome());
            pstm.setString(7, objeto.getFone1());
            pstm.setString(8, objeto.getFone2());
            pstm.setString(9, objeto.getEmail());
            pstm.setString(10, objeto.getCpfCnpj());
            pstm.setString(11, objeto.getRgInscricaoEstadual());
            pstm.setString(12, objeto.getDataCadastro());
            pstm.setString(13, objeto.getCep());
            pstm.setString(14, objeto.getCidade());
            pstm.setString(15, objeto.getBairro());
            pstm.setString(16, objeto.getLogradouro());
            pstm.setString(17, objeto.getComplemento());
            pstm.setString(18, objeto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Medico> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, crm, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email, " +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status FROM Medico";
        List<Medico> listaMedico = new ArrayList<Medico>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Medico medico = new Medico();
                medico.setCrm(resultado.getString("crm"));
                medico.setSenha(resultado.getString("senha"));
                medico.setLogin(resultado.getString("login"));
                medico.setNomeSocial(resultado.getString("nomeSocial"));
                medico.setSexo(resultado.getString("sexo"));
                medico.setId(resultado.getInt("id"));
                medico.setNome(resultado.getString("nome"));
                medico.setFone1(resultado.getString("fone1"));
                medico.setFone2(resultado.getString("fone2"));
                medico.setEmail(resultado.getString("email"));
                medico.setCpfCnpj(resultado.getString("cpfCnpj"));
                medico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                medico.setDataCadastro(resultado.getString("dataCadastro"));
                medico.setCep(resultado.getString("cep"));
                medico.setCidade(resultado.getString("cidade"));
                medico.setBairro(resultado.getString("bairro"));
                medico.setLogradouro(resultado.getString("logradouro"));
                medico.setComplemento(resultado.getString("complemento"));
                medico.setStatus(resultado.getString("status"));

                listaMedico.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaMedico;
    }

    @Override
    public Medico retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "Select id, crm, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email," +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Medico Where medico.id = ?";
        Medico medico = new Medico();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                medico.setId(resultado.getInt("id"));
                medico.setCrm(resultado.getString("crm"));
                medico.setSenha(resultado.getString("senha"));
                medico.setLogin(resultado.getString("login"));
                medico.setNomeSocial(resultado.getString("nomeSocial"));
                medico.setSexo(resultado.getString("sexo"));
                medico.setId(resultado.getInt("id"));
                medico.setNome(resultado.getString("nome"));
                medico.setFone1(resultado.getString("fone1"));
                medico.setFone2(resultado.getString("fone2"));
                medico.setEmail(resultado.getString("email"));
                medico.setCpfCnpj(resultado.getString("cpfCnpj"));
                medico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                medico.setDataCadastro(resultado.getString("dataCadastro"));
                medico.setCep(resultado.getString("cep"));
                medico.setCidade(resultado.getString("cidade"));
                medico.setBairro(resultado.getString("bairro"));
                medico.setLogradouro(resultado.getString("logradouro"));
                medico.setComplemento(resultado.getString("complemento"));
                medico.setStatus(resultado.getString("status"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return medico;
        }
    }

    @Override
    public List<Medico> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Medico> listaMedico = new ArrayList<Medico>();

        String sqlInstrucao = "Select id, crm, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email," +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Medico Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Medico medico = new Medico();
                medico.setCrm(resultado.getString("crm"));
                medico.setSenha(resultado.getString("senha"));
                medico.setLogin(resultado.getString("login"));
                medico.setNomeSocial(resultado.getString("nomeSocial"));
                medico.setSexo(resultado.getString("sexo"));
                medico.setId(resultado.getInt("id"));
                medico.setNome(resultado.getString("nome"));
                medico.setFone1(resultado.getString("fone1"));
                medico.setFone2(resultado.getString("fone2"));
                medico.setEmail(resultado.getString("email"));
                medico.setCpfCnpj(resultado.getString("cpfCnpj"));
                medico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                medico.setDataCadastro(resultado.getString("dataCadastro"));
                medico.setCep(resultado.getString("cep"));
                medico.setCidade(resultado.getString("cidade"));
                medico.setBairro(resultado.getString("bairro"));
                medico.setLogradouro(resultado.getString("logradouro"));
                medico.setComplemento(resultado.getString("complemento"));
                medico.setStatus(resultado.getString("status"));
                listaMedico.add(medico);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaMedico;
        }
    }

    @Override
    public void update(Medico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update medico "
                + " set "
                + "medico.crm = ?, "
                + "medico.senha = ?, "
                + "medico.login = ?, "
                + "medico.nomeSocial = ?, "
                + "medico.sexo = ?, "
                + "medico.nome = ?, "
                + "medico.fone1 = ?, "
                + "medico.fone2 = ?, "
                + "medico.email = ?, "
                + "medico.cpfCnpj = ?, "
                + "medico.rgInscricaoEstadual = ?, "
                + "medico.dataCadastro = ?, "
                + "medico.cep = ?, "
                + "medico.cidade = ?, "
                + "medico.bairro = ?, "
                + "medico.logradouro = ?, "
                + "medico.complemento = ?, "
                + "medico.status = ? "
                + "WHERE medico.id = ?";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getCrm());
            pstm.setString(2, objeto.getSenha());
            pstm.setString(3, objeto.getLogin());
            pstm.setString(4, objeto.getNomeSocial());
            pstm.setString(5, objeto.getSexo());
            pstm.setString(6, objeto.getNome());
            pstm.setString(7, objeto.getFone1());
            pstm.setString(8, objeto.getFone2());
            pstm.setString(9, objeto.getEmail());
            pstm.setString(10, objeto.getCpfCnpj());
            pstm.setString(11, objeto.getRgInscricaoEstadual());
            pstm.setString(12, objeto.getDataCadastro());
            pstm.setString(13, objeto.getCep());
            pstm.setString(14, objeto.getCidade());
            pstm.setString(15, objeto.getBairro());
            pstm.setString(16, objeto.getLogradouro());
            pstm.setString(17, objeto.getComplemento());
            pstm.setString(18, objeto.getStatus());
            pstm.setInt(19, objeto.getId());

            pstm.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.closeConnection(conexao, pstm, null);

        }

    }

    @Override
    public void delete(Medico objeto) {

    }
}
