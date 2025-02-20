package dao;

import model.Enfermeira;
import model.Fornecedor;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements InterfaceDAO<Fornecedor>{

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;

        try {
            String sqlInstrucao = "INSERT INTO Fornecedor (nomeFantasia, contato, " +
                    "nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, " +
                    "dataCadastro, cep, cidade, bairro, logradouro, complemento, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeFantasia());
            pstm.setString(2, objeto.getContato());
            pstm.setString(3, objeto.getNome());
            pstm.setString(4, objeto.getFone1());
            pstm.setString(5, objeto.getFone2());
            pstm.setString(6, objeto.getEmail());
            pstm.setString(7, objeto.getCpfCnpj());
            pstm.setString(8, objeto.getRgInscricaoEstadual());
            pstm.setString(9, objeto.getDataCadastro());
            pstm.setString(10, objeto.getCep());
            pstm.setString(11, objeto.getCidade());
            pstm.setString(12, objeto.getBairro());
            pstm.setString(13, objeto.getLogradouro());
            pstm.setString(14, objeto.getComplemento());
            pstm.setString(15, objeto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Fornecedor> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nomeFantasia, contato, id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento FROM Fornecedor";
        List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNomeFantasia(resultado.getString("nomeFantasia"));
                fornecedor.setContato(resultado.getString("contato"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setFone1(resultado.getString("fone1"));
                fornecedor.setFone2(resultado.getString("fone2"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setCpfCnpj(resultado.getString("cpfCnpj"));
                fornecedor.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                fornecedor.setDataCadastro(resultado.getString("dataCadastro"));
                fornecedor.setCep(resultado.getString("cep"));
                fornecedor.setCidade(resultado.getString("cidade"));
                fornecedor.setBairro(resultado.getString("bairro"));
                fornecedor.setLogradouro(resultado.getString("logradouro"));
                fornecedor.setComplemento(resultado.getString("complemento"));
                fornecedor.setStatus(resultado.getString("status"));

                listaFornecedor.add(fornecedor);
            }

        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);

        } return listaFornecedor;
    }

    @Override
    public Fornecedor retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        String sqlInstrucao = "Select id, nomeFantasia, contato, nome, fone1, fone2, email," +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Fornecedor Where fornecedor.id = ?";
        Fornecedor fornecedor = new Fornecedor();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()){
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNomeFantasia(resultado.getString("nomeFantasia"));
                fornecedor.setContato(resultado.getString("contato"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setFone1(resultado.getString("fone1"));
                fornecedor.setFone2(resultado.getString("fone2"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setCpfCnpj(resultado.getString("cpfCnpj"));
                fornecedor.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                fornecedor.setDataCadastro(resultado.getString("dataCadastro"));
                fornecedor.setCep(resultado.getString("cep"));
                fornecedor.setCidade(resultado.getString("cidade"));
                fornecedor.setBairro(resultado.getString("bairro"));
                fornecedor.setLogradouro(resultado.getString("logradouro"));
                fornecedor.setComplemento(resultado.getString("complemento"));
                fornecedor.setStatus(resultado.getString("status"));

            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return fornecedor;
        }
    }

    @Override
    public List<Fornecedor> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm= null;
        ResultSet resultado = null;
        List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();

        String sqlInstrucao = "Select id, nome, nomeFantasia, contato, fone1, fone2, email," +
                "cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status " + " from Fornecedor Where " + atributo + " like ?";
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNomeFantasia(resultado.getString("nomeFantasia"));
                fornecedor.setContato(resultado.getString("contato"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setFone1(resultado.getString("fone1"));
                fornecedor.setFone2(resultado.getString("fone2"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setCpfCnpj(resultado.getString("cpfCnpj"));
                fornecedor.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                fornecedor.setDataCadastro(resultado.getString("dataCadastro"));
                fornecedor.setCep(resultado.getString("cep"));
                fornecedor.setCidade(resultado.getString("cidade"));
                fornecedor.setBairro(resultado.getString("bairro"));
                fornecedor.setLogradouro(resultado.getString("logradouro"));
                fornecedor.setComplemento(resultado.getString("complemento"));
                fornecedor.setStatus(resultado.getString("status"));
                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return  listaFornecedor;
        }
    }
    @Override
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update fornecedor "
                + " set "
                + "fornecedor.nome = ?, "
                + "fornecedor.nomeFantasia = ?, "
                + "fornecedor.contato = ?, "
                + "fornecedor.fone1 = ?, "
                + "fornecedor.fone2 = ?, "
                + "fornecedor.email = ?, "
                + "fornecedor.cpfCnpj = ?, "
                + "fornecedor.rgInscricaoEstadual = ?, "
                + "fornecedor.dataCadastro = ?, "
                + "fornecedor.cep = ?, "
                + "fornecedor.cidade = ?, "
                + "fornecedor.bairro = ?, "
                + "fornecedor.logradouro = ?, "
                + "fornecedor.complemento = ?, "
                + "fornecedor.status = ? "
                + "WHERE fornecedor.id = ?";

        PreparedStatement pstm= null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getNomeFantasia());
            pstm.setString(3, objeto.getContato());
            pstm.setString(4, objeto.getFone1());
            pstm.setString(5, objeto.getFone2());
            pstm.setString(6, objeto.getEmail());
            pstm.setString(7, objeto.getCpfCnpj());
            pstm.setString(8, objeto.getRgInscricaoEstadual());
            pstm.setString(9, objeto.getDataCadastro());
            pstm.setString(10, objeto.getCep());
            pstm.setString(11, objeto.getCidade());
            pstm.setString(12, objeto.getBairro());
            pstm.setString(13, objeto.getLogradouro());
            pstm.setString(14, objeto.getComplemento());
            pstm.setString(15, objeto.getStatus());
            pstm.setInt(16, objeto.getId());

            pstm.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Fornecedor objeto) {

    }
}
