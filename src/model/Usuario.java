package model;

import java.util.Date;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String nomeSocial;
    private String status;


    public Usuario() {
    }

    public Usuario(int id, String login, String senha, String nomeSocial, String status) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nomeSocial = nomeSocial;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
