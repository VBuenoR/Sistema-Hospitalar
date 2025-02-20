package dao;

import model.Enfermeira;
import model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnfermeiraDAO implements InterfaceDAO<Enfermeira>{

    @Override
    public void create(Enfermeira objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "INSERT INTO Enfermeiro (cre, senha, login, nomeSocial, " +
                    "sexo, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, " +
                    "dataCadastro, cep, cidade, bairro, logradouro, complemento, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getCre());
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
    public List<Enfermeira> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, cre, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento FROM Enfermeira";
        List<Enfermeira> listaEnfermeira = new ArrayList<Enfermeira>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Enfermeira enfermeira = new Enfermeira();
                enfermeira.setCre(resultado.getString("cre"));
                enfermeira.setSenha(resultado.getString("senha"));
                enfermeira.setLogin(resultado.getString("login"));
                enfermeira.setNomeSocial(resultado.getString("nomeSocial"));
                enfermeira.setSexo(resultado.getString("sexo"));
                enfermeira.setId(resultado.getInt("id"));
                enfermeira.setNome(resultado.getString("nome"));
                enfermeira.setFone1(resultado.getString("fone1"));
                enfermeira.setFone2(resultado.getString("fone2"));
                enfermeira.setEmail(resultado.getString("email"));
                enfermeira.setCpfCnpj(resultado.getString("cpfCnpj"));
                enfermeira.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                enfermeira.setDataCadastro(resultado.getString("dataCadastro"));
                enfermeira.setCep(resultado.getString("cep"));
                enfermeira.setCidade(resultado.getString("cidade"));
                enfermeira.setBairro(resultado.getString("bairro"));
                enfermeira.setLogradouro(resultado.getString("logradouro"));
                enfermeira.setComplemento(resultado.getString("complemento"));

                listaEnfermeira.add(enfermeira);
            }

        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);

        } return listaEnfermeira;
    }

    @Override
    public Enfermeira retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "Select id, cre, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email," +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Enfermeiro Where enfermeiro.id = ?";
        Enfermeira enfermeira = new Enfermeira();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                enfermeira.setId(resultado.getInt("id"));
                enfermeira.setCre(resultado.getString("cre"));
                enfermeira.setSenha(resultado.getString("senha"));
                enfermeira.setLogin(resultado.getString("login"));
                enfermeira.setNomeSocial(resultado.getString("nomeSocial"));
                enfermeira.setSexo(resultado.getString("sexo"));
                enfermeira.setId(resultado.getInt("id"));
                enfermeira.setNome(resultado.getString("nome"));
                enfermeira.setFone1(resultado.getString("fone1"));
                enfermeira.setFone2(resultado.getString("fone2"));
                enfermeira.setEmail(resultado.getString("email"));
                enfermeira.setCpfCnpj(resultado.getString("cpfCnpj"));
                enfermeira.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                enfermeira.setDataCadastro(resultado.getString("dataCadastro"));
                enfermeira.setCep(resultado.getString("cep"));
                enfermeira.setCidade(resultado.getString("cidade"));
                enfermeira.setBairro(resultado.getString("bairro"));
                enfermeira.setLogradouro(resultado.getString("logradouro"));
                enfermeira.setComplemento(resultado.getString("complemento"));
                enfermeira.setStatus(resultado.getString("status"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return enfermeira;
        }
    }

    @Override
    public List<Enfermeira> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Enfermeira> listaEnfermeira = new ArrayList<Enfermeira>();

        String sqlInstrucao = "Select id, cre, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email," +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Enfermeiro Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Enfermeira enfermeira = new Enfermeira();
                enfermeira.setCre(resultado.getString("cre"));
                enfermeira.setSenha(resultado.getString("senha"));
                enfermeira.setLogin(resultado.getString("login"));
                enfermeira.setNomeSocial(resultado.getString("nomeSocial"));
                enfermeira.setSexo(resultado.getString("sexo"));
                enfermeira.setId(resultado.getInt("id"));
                enfermeira.setNome(resultado.getString("nome"));
                enfermeira.setFone1(resultado.getString("fone1"));
                enfermeira.setFone2(resultado.getString("fone2"));
                enfermeira.setEmail(resultado.getString("email"));
                enfermeira.setCpfCnpj(resultado.getString("cpfCnpj"));
                enfermeira.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                enfermeira.setDataCadastro(resultado.getString("dataCadastro"));
                enfermeira.setCep(resultado.getString("cep"));
                enfermeira.setCidade(resultado.getString("cidade"));
                enfermeira.setBairro(resultado.getString("bairro"));
                enfermeira.setLogradouro(resultado.getString("logradouro"));
                enfermeira.setComplemento(resultado.getString("complemento"));
                enfermeira.setStatus(resultado.getString("status"));
                listaEnfermeira.add(enfermeira);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaEnfermeira;
        }
    }

    @Override
    public void update(Enfermeira objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update enfermeiro "
                + " set "
                + "enfermeiro.cre = ?, "
                + "enfermeiro.senha = ?, "
                + "enfermeiro.login = ?, "
                + "enfermeiro.nomeSocial = ?, "
                + "enfermeiro.sexo = ?, "
                + "enfermeiro.nome = ?, "
                + "enfermeiro.fone1 = ?, "
                + "enfermeiro.fone2 = ?, "
                + "enfermeiro.email = ?, "
                + "enfermeiro.cpfCnpj = ?, "
                + "enfermeiro.rgInscricaoEstadual = ?, "
                + "enfermeiro.dataCadastro = ?, "
                + "enfermeiro.cep = ?, "
                + "enfermeiro.cidade = ?, "
                + "enfermeiro.bairro = ?, "
                + "enfermeiro.logradouro = ?, "
                + "enfermeiro.complemento = ?, "
                + "enfermeiro.status = ? "
                + "WHERE enfermeiro.id = ?";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getCre());
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
    public void delete(Enfermeira objeto) {

    }
}
