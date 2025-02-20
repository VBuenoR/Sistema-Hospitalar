package model;

import java.util.Date;

public class ConsultaExame {
    private int id;
    private Date dataHoraExame;
    private String imagemExame;
    private String status;
    private Consulta consulta;
    private Exame exame;

    public ConsultaExame(int id, Date dataHoraExame, String imagemExame, String status, Consulta consulta, Exame exame) {
        this.id = id;
        this.dataHoraExame = dataHoraExame;
        this.imagemExame = imagemExame;
        this.status = status;
        this.consulta = consulta;
        this.exame = exame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraExame() {
        return dataHoraExame;
    }

    public void setDataHoraExame(Date dataHoraExame) {
        this.dataHoraExame = dataHoraExame;
    }

    public String getImagemExame() {
        return imagemExame;
    }

    public void setImagemExame(String imagemExame) {
        this.imagemExame = imagemExame;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    @Override
    public String toString() {
        return "ConsultaExame{" +
                "id=" + id +
                ", dataHoraExame=" + dataHoraExame +
                ", imagemExame='" + imagemExame + '\'' +
                ", status='" + status + '\'' +
                ", consulta=" + consulta +
                ", exame=" + exame +
                '}';
    }
}
