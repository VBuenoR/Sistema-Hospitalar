package model;

import java.util.Date;

public class Prontuario {
    private int id;
    private Date dataHoraVisita;
    private String descricaoVisita;
    private String observacao;
    private String status;
    private InternacaoLeito internacaoLeite;
    private Enfermeira enfermeiro;
    private Medico medico;
    private MovimentoMedicamento movimentoMedicamento;

    public Prontuario(int id, Date dataHoraVisita, String descricaoVisita, String observacao, String status, InternacaoLeito internacaoLeite, Enfermeira enfermeiro, Medico medico, MovimentoMedicamento movimentoMedicamento) {
        this.id = id;
        this.dataHoraVisita = dataHoraVisita;
        this.descricaoVisita = descricaoVisita;
        this.observacao = observacao;
        this.status = status;
        this.internacaoLeite = internacaoLeite;
        this.enfermeiro = enfermeiro;
        this.medico = medico;
        this.movimentoMedicamento = movimentoMedicamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraVisita() {
        return dataHoraVisita;
    }

    public void setDataHoraVisita(Date dataHoraVisita) {
        this.dataHoraVisita = dataHoraVisita;
    }

    public String getDescricaoVisita() {
        return descricaoVisita;
    }

    public void setDescricaoVisita(String descricaoVisita) {
        this.descricaoVisita = descricaoVisita;
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

    public Enfermeira getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeira enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public MovimentoMedicamento getMovimentoMedicamento() {
        return movimentoMedicamento;
    }

    public void setMovimentoMedicamento(MovimentoMedicamento movimentoMedicamento) {
        this.movimentoMedicamento = movimentoMedicamento;
    }

    @Override
    public String toString() {
        return "Prontuario{" +
                "id=" + id +
                ", dataHoraVisita=" + dataHoraVisita +
                ", descricaoVisita='" + descricaoVisita + '\'' +
                ", observacao='" + observacao + '\'' +
                ", status='" + status + '\'' +
                ", internacaoLeite=" + internacaoLeite +
                ", enfermeiro=" + enfermeiro +
                ", medico=" + medico +
                ", movimentoMedicamento=" + movimentoMedicamento +
                '}';
    }
}
