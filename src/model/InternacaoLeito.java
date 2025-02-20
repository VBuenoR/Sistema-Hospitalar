package model;

import java.util.Date;

public class InternacaoLeito {
    private int id;
    private Date dataHoraAlocacao;
    private Date dataHoraDesocupacao;
    private String status;
    private Internacao internacao;
    private Leito leito;

    public InternacaoLeito(int id, Date dataHoraAlocacao, Date dataHoraDesocupacao, String status, Internacao internacao, Leito leito) {
        this.id = id;
        this.dataHoraAlocacao = dataHoraAlocacao;
        this.dataHoraDesocupacao = dataHoraDesocupacao;
        this.status = status;
        this.internacao = internacao;
        this.leito = leito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraAlocacao() {
        return dataHoraAlocacao;
    }

    public void setDataHoraAlocacao(Date dataHoraAlocacao) {
        this.dataHoraAlocacao = dataHoraAlocacao;
    }

    public Date getDataHoraDesocupacao() {
        return dataHoraDesocupacao;
    }

    public void setDataHoraDesocupacao(Date dataHoraDesocupacao) {
        this.dataHoraDesocupacao = dataHoraDesocupacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Internacao getInternacao() {
        return internacao;
    }

    public void setInternacao(Internacao internacao) {
        this.internacao = internacao;
    }

    public Leito getLeito() {
        return leito;
    }

    public void setLeito(Leito leito) {
        this.leito = leito;
    }

    @Override
    public String toString() {
        return "InternacaoLeite{" +
                "id=" + id +
                ", dataHoraAlocacao=" + dataHoraAlocacao +
                ", dataHoraDesocupacao=" + dataHoraDesocupacao +
                ", status='" + status + '\'' +
                ", internacao=" + internacao +
                ", leito=" + leito +
                '}';
    }
}


