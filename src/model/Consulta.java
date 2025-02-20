package model;

import java.util.Date;

public class Consulta {
    private int id;
    private String Responsavel;
    private Date DataHoraConsulta;
    private String anamnese;
    private String diagnostico;
    private String prescricao;
    private String observacoes;
    private boolean status;
    private Atendimento atendimento;
    private Medico medico;

    public Consulta(int id, String responsavel, Date dataHoraConsulta, String anamnese, String diagnostico, String prescricao, String observacoes, boolean status, Atendimento atendimento, Medico medico) {
        this.id = id;
        Responsavel = responsavel;
        DataHoraConsulta = dataHoraConsulta;
        this.anamnese = anamnese;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.observacoes = observacoes;
        this.status = status;
        this.atendimento = atendimento;
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String responsavel) {
        Responsavel = responsavel;
    }

    public Date getDataHoraConsulta() {
        return DataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        DataHoraConsulta = dataHoraConsulta;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", Responsavel='" + Responsavel + '\'' +
                ", DataHoraConsulta=" + DataHoraConsulta +
                ", anamnese='" + anamnese + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", prescricao='" + prescricao + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", status=" + status +
                ", atendimento=" + atendimento +
                ", medico=" + medico +
                '}';
    }
}