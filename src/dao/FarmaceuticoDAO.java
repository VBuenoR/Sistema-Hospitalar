package dao;

import model.Enfermeira;
import model.Farmaceutico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FarmaceuticoDAO implements InterfaceDAO<Farmaceutico>{

    @Override
    public void create(Farmaceutico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "INSERT INTO Farmaceutico (crf, senha, login, nomeSocial, " +
                    "sexo, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, " +
                    "dataCadastro, cep, cidade, bairro, logradouro, complemento, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getCrf());
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
    public List<Farmaceutico> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, crf, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento FROM Farmaceutico";
        List<Farmaceutico> listaFarmaceutico = new ArrayList<Farmaceutico>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Farmaceutico farmaceutico = new Farmaceutico();
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setCrf(resultado.getString("crm"));
                farmaceutico.setSenha(resultado.getString("senha"));
                farmaceutico.setLogin(resultado.getString("login"));
                farmaceutico.setNomeSocial(resultado.getString("nomeSocial"));
                farmaceutico.setSexo(resultado.getString("sexo"));
                farmaceutico.setNome(resultado.getString("nome"));
                farmaceutico.setFone1(resultado.getString("fone1"));
                farmaceutico.setFone2(resultado.getString("fone2"));
                farmaceutico.setEmail(resultado.getString("email"));
                farmaceutico.setCpfCnpj(resultado.getString("cpfCnpj"));
                farmaceutico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                farmaceutico.setDataCadastro(resultado.getString("dataCadastro"));
                farmaceutico.setCep(resultado.getString("cep"));
                farmaceutico.setCidade(resultado.getString("cidade"));
                farmaceutico.setBairro(resultado.getString("bairro"));
                farmaceutico.setLogradouro(resultado.getString("logradouro"));
                farmaceutico.setComplemento(resultado.getString("complemento"));

                listaFarmaceutico.add(farmaceutico);
            }

        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);

        } return listaFarmaceutico;
    }

    @Override
    public Farmaceutico retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "Select id, crf, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email," +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Farmaceutico Where farmaceutico.id = ?";
        Farmaceutico farmaceutico = new Farmaceutico();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setCrf(resultado.getString("crf"));
                farmaceutico.setSenha(resultado.getString("senha"));
                farmaceutico.setLogin(resultado.getString("login"));
                farmaceutico.setNomeSocial(resultado.getString("nomeSocial"));
                farmaceutico.setSexo(resultado.getString("sexo"));
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setNome(resultado.getString("nome"));
                farmaceutico.setFone1(resultado.getString("fone1"));
                farmaceutico.setFone2(resultado.getString("fone2"));
                farmaceutico.setEmail(resultado.getString("email"));
                farmaceutico.setCpfCnpj(resultado.getString("cpfCnpj"));
                farmaceutico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                farmaceutico.setDataCadastro(resultado.getString("dataCadastro"));
                farmaceutico.setCep(resultado.getString("cep"));
                farmaceutico.setCidade(resultado.getString("cidade"));
                farmaceutico.setBairro(resultado.getString("bairro"));
                farmaceutico.setLogradouro(resultado.getString("logradouro"));
                farmaceutico.setComplemento(resultado.getString("complemento"));
                farmaceutico.setStatus(resultado.getString("status"));
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return farmaceutico;
        }
    }

    @Override
    public List<Farmaceutico> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Farmaceutico> listaFarmaceutico = new ArrayList<Farmaceutico>();

        String sqlInstrucao = "Select id, crf, senha, login, nomeSocial, sexo, id, nome, fone1, fone2, email," +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Farmaceutico Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Farmaceutico farmaceutico = new Farmaceutico();
                farmaceutico.setCrf(resultado.getString("crf"));
                farmaceutico.setSenha(resultado.getString("senha"));
                farmaceutico.setLogin(resultado.getString("login"));
                farmaceutico.setNomeSocial(resultado.getString("nomeSocial"));
                farmaceutico.setSexo(resultado.getString("sexo"));
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setNome(resultado.getString("nome"));
                farmaceutico.setFone1(resultado.getString("fone1"));
                farmaceutico.setFone2(resultado.getString("fone2"));
                farmaceutico.setEmail(resultado.getString("email"));
                farmaceutico.setCpfCnpj(resultado.getString("cpfCnpj"));
                farmaceutico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                farmaceutico.setDataCadastro(resultado.getString("dataCadastro"));
                farmaceutico.setCep(resultado.getString("cep"));
                farmaceutico.setCidade(resultado.getString("cidade"));
                farmaceutico.setBairro(resultado.getString("bairro"));
                farmaceutico.setLogradouro(resultado.getString("logradouro"));
                farmaceutico.setComplemento(resultado.getString("complemento"));
                farmaceutico.setStatus(resultado.getString("status"));
                listaFarmaceutico.add(farmaceutico);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaFarmaceutico;
        }
    }

    @Override
    public void update(Farmaceutico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update farmaceutico "
                + " set "
                + "farmaceutico.crf = ?, "
                + "farmaceutico.senha = ?, "
                + "farmaceutico.login = ?, "
                + "farmaceutico.nomeSocial = ?, "
                + "farmaceutico.sexo = ?, "
                + "farmaceutico.nome = ?, "
                + "farmaceutico.fone1 = ?, "
                + "farmaceutico.fone2 = ?, "
                + "farmaceutico.email = ?, "
                + "farmaceutico.cpfCnpj = ?, "
                + "farmaceutico.rgInscricaoEstadual = ?, "
                + "farmaceutico.dataCadastro = ?, "
                + "farmaceutico.cep = ?, "
                + "farmaceutico.cidade = ?, "
                + "farmaceutico.bairro = ?, "
                + "farmaceutico.logradouro = ?, "
                + "farmaceutico.complemento = ?, "
                + "farmaceutico.status = ? "
                + "WHERE farmaceutico.id = ?";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getCrf());
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
    public void delete(Farmaceutico objeto) {

    }
}
