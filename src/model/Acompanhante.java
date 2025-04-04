package model;

public class Acompanhante {
    private int id;
    private String nome;
    private String grauParentesco;
    private String cpf;
    private String fone;
    private String email;
    private String status;

    public Acompanhante(int id, String nome, String grauParentesco, String cpf, String fone, String email, String status) {
        this.id = id;
        this.nome = nome;
        this.grauParentesco = grauParentesco;
        this.cpf = cpf;
        this.fone = fone;
        this.email = email;
        this.status = status;
    }

    public Acompanhante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Acompanhante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", grauParentesco='" + grauParentesco + '\'' +
                ", cpf='" + cpf + '\'' +
                ", fone='" + fone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
