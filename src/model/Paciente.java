package model;

import java.util.Date;

public class Paciente extends Pessoa {
    private String tipoSanguineo;
    private String sexo;
    private String nomeSocial;


    public Paciente() {
        super();
    }

    public Paciente(int id, String nome, String fone1, String fone2, String email, String cpfCnpj, String rgInscricaoEstadual, String dataCadastro, String cep, String cidade, String bairro, String logradouro, String complemento, String status, String tipoSanguineo, String sexo, String nomeSocial) {
        super(id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, logradouro, complemento, status);
        this.tipoSanguineo = tipoSanguineo;
        this.sexo = sexo;
        this.nomeSocial = nomeSocial;
    }

    public Paciente(String tipoSanguineo, String sexo, String nomeSocial) {
        this.tipoSanguineo = tipoSanguineo;
        this.sexo = sexo;
        this.nomeSocial = nomeSocial;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    @Override
    public String toString() {
        return "Paciente{"+ super.toString() +
                "tipoSanguineo='" + tipoSanguineo + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                '}';
    }
}
