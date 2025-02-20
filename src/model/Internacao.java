package model;

import java.util.Date;

public class Internacao {
    private int id;
    private Date dataHoraInternacao;
    private Date dataHoraAlta;
    private String observacao;
    private String status;
    private Consulta consulta;

    public Internacao(int id, Date dataHoraInternacao, Date dataHoraAlta, String observacao, String status, Consulta consulta) {
        this.id = id;
        this.dataHoraInternacao = dataHoraInternacao;
        this.dataHoraAlta = dataHoraAlta;
        this.observacao = observacao;
        this.status = status;
        this.consulta = consulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraInternacao() {
        return dataHoraInternacao;
    }

    public void setDataHoraInternacao(Date dataHoraInternacao) {
        this.dataHoraInternacao = dataHoraInternacao;
    }

    public Date getDataHoraAlta() {
        return dataHoraAlta;
    }

    public void setDataHoraAlta(Date dataHoraAlta) {
        this.dataHoraAlta = dataHoraAlta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    @Override
    public String toString() {
        return "Internacao{" +
                "id=" + id +
                ", dataHoraInternacao=" + dataHoraInternacao +
                ", dataHoraAlta=" + dataHoraAlta +
                ", observacao='" + observacao + '\'' +
                ", status='" + status + '\'' +
                ", consulta=" + consulta +
                '}';
    }
}
