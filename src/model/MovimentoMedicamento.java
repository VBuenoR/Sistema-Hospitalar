package model;

import java.util.Date;

public class MovimentoMedicamento {
    private int id;
    private Date dataHoraMovimento;
    private String tipoMovimento;
    private float qtdMedicamento;
    private String observação;
    private String status;
    private Lote lote;
    private ReceitaMedicamento receitaMedicamento;

    public MovimentoMedicamento(int id, Date dataHoraMovimento, String tipoMovimento, float qtdMedicamento, String observação, String status, Lote lote, ReceitaMedicamento receitaMedicamento) {
        this.id = id;
        this.dataHoraMovimento = dataHoraMovimento;
        this.tipoMovimento = tipoMovimento;
        this.qtdMedicamento = qtdMedicamento;
        this.observação = observação;
        this.status = status;
        this.lote = lote;
        this.receitaMedicamento = receitaMedicamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraMovimento() {
        return dataHoraMovimento;
    }

    public void setDataHoraMovimento(Date dataHoraMovimento) {
        this.dataHoraMovimento = dataHoraMovimento;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public float getQtdMedicamento() {
        return qtdMedicamento;
    }

    public void setQtdMedicamento(float qtdMedicamento) {
        this.qtdMedicamento = qtdMedicamento;
    }

    public String getObservação() {
        return observação;
    }

    public void setObservação(String observação) {
        this.observação = observação;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public ReceitaMedicamento getReceitaMedicamento() {
        return receitaMedicamento;
    }

    public void setReceitaMedicamento(ReceitaMedicamento receitaMedicamento) {
        this.receitaMedicamento = receitaMedicamento;
    }

    @Override
    public String toString() {
        return "MovimentoMedicamento{" +
                "id=" + id +
                ", dataHoraMovimento=" + dataHoraMovimento +
                ", tipoMovimento='" + tipoMovimento + '\'' +
                ", qtdMedicamento=" + qtdMedicamento +
                ", observação='" + observação + '\'' +
                ", status='" + status + '\'' +
                ", lote=" + lote +
                ", receitaMedicamento=" + receitaMedicamento +
                '}';
    }
}
