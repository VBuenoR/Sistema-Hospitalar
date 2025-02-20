package model;

public class Ala {
    private int id;
    private String status;
    private String descricao;

    public Ala(int id, String status, String descricao) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
    }

    public Ala() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
}
