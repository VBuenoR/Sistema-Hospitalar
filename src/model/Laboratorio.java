package model;

import java.util.Date;

public class Laboratorio {
    private int id;
    private String nomeFantasia;
    private String contato;
    private String status;

    public Laboratorio(String nomeFantasia, String contato, String status, int id) {
        this.nomeFantasia = nomeFantasia;
        this.contato = contato;
        this.status = status;
        this.id = id;
    }

    public Laboratorio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "Laboratorio{" +
                "nomeFantasia='" + nomeFantasia + '\'' +
                ", contato='" + contato + '\'' +
                ", status=" + status +
                '}';
    }
}
