package model;

import java.util.Date;

public class AcompanhanteInternacao {
    private int id;
    private Date dataEntrada;
    private Date dataSaida;
    private String observacao;
    private String status;
    private InternacaoLeito internacaoLeite;
    private Acompanhante acompanhante;

    public AcompanhanteInternacao(int id, Date dataEntrada, Date dataSaida, String observacao, String status, InternacaoLeito internacaoLeite, Acompanhante acompanhante) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.observacao = observacao;
        this.status = status;
        this.internacaoLeite = internacaoLeite;
        this.acompanhante = acompanhante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
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

    public InternacaoLeito getInternacaoLeite() {
        return internacaoLeite;
    }

    public void setInternacaoLeite(InternacaoLeito internacaoLeite) {
        this.internacaoLeite = internacaoLeite;
    }

    public Acompanhante getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(Acompanhante acompanhante) {
        this.acompanhante = acompanhante;
    }

    @Override
    public String toString() {
        return "AcompanhanteInternacao{" +
                "id=" + id +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", observacao='" + observacao + '\'' +
                ", status='" + status + '\'' +
                ", internacaoLeite=" + internacaoLeite +
                ", acompanhante=" + acompanhante +
                '}';
    }
}
