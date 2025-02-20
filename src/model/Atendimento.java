package model;

import java.util.Date;

public class Atendimento {
    private int id;
    private Date dataHoraAtendimento;
    private String pressao;
    private String temperatura;
    private int bpm;
    private float oximetria;
    private String HistoricoDeDoencas;
    private String alergias;
    private String medicacoesEmUso;
    private String anamnese;
    private String tipoAtendimento;
    private String classificao;
    private String observacoes;
    private boolean status;
    private Paciente paciente;
    private Usuario usuario;
    private Medico medico;
    private Enfermeira enfermeiro;

    public Atendimento(int id, Date dataHoraAtendimento, String pressao, String temperatura, int bpm, float oximetria, String historicoDeDoencas, String alergias, String medicacoesEmUso, String anamnese, String tipoAtendimento, String classificao, String observacoes, boolean status, Paciente paciente, Usuario usuario, Medico medico, Enfermeira enfermeiro) {
        this.id = id;
        this.dataHoraAtendimento = dataHoraAtendimento;
        this.pressao = pressao;
        this.temperatura = temperatura;
        this.bpm = bpm;
        this.oximetria = oximetria;
        HistoricoDeDoencas = historicoDeDoencas;
        this.alergias = alergias;
        this.medicacoesEmUso = medicacoesEmUso;
        this.anamnese = anamnese;
        this.tipoAtendimento = tipoAtendimento;
        this.classificao = classificao;
        this.observacoes = observacoes;
        this.status = status;
        this.paciente = paciente;
        this.usuario = usuario;
        this.medico = medico;
        this.enfermeiro = enfermeiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }

    public void setDataHoraAtendimento(Date dataHoraAtendimento) {
        this.dataHoraAtendimento = dataHoraAtendimento;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public float getOximetria() {
        return oximetria;
    }

    public void setOximetria(float oximetria) {
        this.oximetria = oximetria;
    }

    public String getHistoricoDeDoencas() {
        return HistoricoDeDoencas;
    }

    public void setHistoricoDeDoencas(String historicoDeDoencas) {
        HistoricoDeDoencas = historicoDeDoencas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicacoesEmUso() {
        return medicacoesEmUso;
    }

    public void setMedicacoesEmUso(String medicacoesEmUso) {
        this.medicacoesEmUso = medicacoesEmUso;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getClassificao() {
        return classificao;
    }

    public void setClassificao(String classificao) {
        this.classificao = classificao;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Enfermeira getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeira enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    @Override
    public String toString() {
        return "Atendimento{"+ super.toString() +
                "id=" + id +
                ", dataHoraAtendimento=" + dataHoraAtendimento +
                ", pressao='" + pressao + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", bpm=" + bpm +
                ", oximetria=" + oximetria +
                ", HistoricoDeDoencas='" + HistoricoDeDoencas + '\'' +
                ", alergias='" + alergias + '\'' +
                ", medicacoesEmUso='" + medicacoesEmUso + '\'' +
                ", anamnese='" + anamnese + '\'' +
                ", tipoAtendimento='" + tipoAtendimento + '\'' +
                ", classificao='" + classificao + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", status=" + status +
                ", paciente=" + paciente +
                ", usuario=" + usuario +
                ", medico=" + medico +
                ", enfermeiro =" + enfermeiro +
                '}';
    }
}
