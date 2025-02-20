package model;

public class Enfermeira extends Pessoa {
    private String cre;
    private String login;
    private String senha;
    private String nomeSocial;
    private String sexo;



    public Enfermeira() {
        super();
    }

    public Enfermeira(int id, String nome, String fone1, String fone2, String email, String cpfCnpj, String rgInscricaoEstadual, String dataCadastro, String cep, String cidade, String bairro, String logradouro, String complemento, String status, String cre, String login, String senha, String nomeSocial, String sexo) {
        super(id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status);
        this.cre = cre;
        this.login = login;
        this.senha = senha;
        this.nomeSocial = nomeSocial;
        this.sexo = sexo;
    }

    public Enfermeira(String cre, String login, String senha, String nomeSocial, String sexo) {
        this.cre = cre;
        this.login = login;
        this.senha = senha;
        this.nomeSocial = nomeSocial;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCre() {
        return cre;
    }

    public void setCre(String cre) {
        this.cre = cre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    @Override
    public String toString() {
        return "Enfermeiro{"+ super.toString() +
                "cre='" + cre + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                '}';
    }
}
