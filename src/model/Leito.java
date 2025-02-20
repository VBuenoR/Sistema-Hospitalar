package model;

public class Leito {
    private int id;
    private String status;
    private String descricao;
    private Quarto quarto;

    public Leito(int id, String status, String descricao, Quarto quarto) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
        this.quarto = quarto;
    }

    public Leito() {
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



    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    @Override
    public String toString() {
        return "Leito{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quarto=" + quarto +
                '}';
    }
}
