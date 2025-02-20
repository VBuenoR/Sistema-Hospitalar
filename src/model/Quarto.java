package model;

public class Quarto {
    private int id;
    private String status;
    private String descricao;
    private Ala ala;

    public Quarto(int id, String status, String descricao, Ala ala) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
        this.ala = ala;
    }

    public Quarto() {
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

    public Ala getAla() {
        return ala;
    }

    public void setAla(Ala ala) {
        this.ala = ala;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
}
