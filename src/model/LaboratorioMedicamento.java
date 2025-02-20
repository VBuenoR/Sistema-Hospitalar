package model;

public class LaboratorioMedicamento {
    private int id;
    private String codigoBarra;
    private String observacao;
    private String status;
    private Laboratorio laboratorio;
    private Medicamento medicamento;

    public LaboratorioMedicamento(int id, String codigoBarra, String observacao, String status, Laboratorio laboratorio, Medicamento medicamento) {
        this.id = id;
        this.codigoBarra = codigoBarra;
        this.observacao = observacao;
        this.status = status;
        this.laboratorio = laboratorio;
        this.medicamento = medicamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public String toString() {
        return "LaboratorioMedicamento{" +
                "id=" + id +
                ", codigoBarra='" + codigoBarra + '\'' +
                ", observacao='" + observacao + '\'' +
                ", status='" + status + '\'' +
                ", laboratorio=" + laboratorio +
                ", medicamento=" + medicamento +
                '}';
    }
}
