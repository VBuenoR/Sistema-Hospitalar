package model;

import java.util.Date;

public class Medico extends Pessoa {
    private String crm;
    private String senha;
    private String login;
    private String nomeSocial;
    private String sexo;

    public Medico() {
        super();
    }

    public Medico(int id, String nome, String fone1, String fone2, String email, String cpfCnpj, String rgInscricaoEstadual, String dataCadastro, String cep, String cidade, String bairro, String logradouro, String complemento, String status, String crm, String senha, String login, String nomeSocial, String sexo) {
        super(id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status);
        this.crm = crm;
        this.senha = senha;
        this.login = login;
        this.nomeSocial = nomeSocial;
        this.sexo = sexo;
    }

    public Medico(String crm, String senha, String login, String nomeSocial, String sexo) {
        this.crm = crm;
        this.senha = senha;
        this.login = login;
        this.nomeSocial = nomeSocial;
        this.sexo = sexo;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Medico{" + super.toString() +
                "crm='" + crm + '\'' +
                ", senha='" + senha + '\'' +
                ", login='" + login + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                '}';
    }
}
