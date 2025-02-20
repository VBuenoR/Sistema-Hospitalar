package model;

public class Exame {
    private int id;
    private String tiutloExame;
    private String tipoExame;
    private String status;

    public Exame(int id, String tiutloExame, String tipoExame, String status) {
        this.id = id;
        this.tiutloExame = tiutloExame;
        this.tipoExame = tipoExame;
        this.status = status;
    }

    public Exame() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTiutloExame() {
        return tiutloExame;
    }

    public void setTiutloExame(String tiutloExame) {
        this.tiutloExame = tiutloExame;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Exame{" +
                "id=" + id +
                ", tiutloExame='" + tiutloExame + '\'' +
                ", tipoExame='" + tipoExame + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
