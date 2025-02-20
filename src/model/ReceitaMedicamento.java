package model;

public class ReceitaMedicamento {
    private int id;
    private String prescricao;
    private String status;
    private Medicamento medicamento;
    private Receita receita;


    public ReceitaMedicamento(int id, String prescricao, String status, Medicamento medicamento, Receita receita) {
        this.id = id;
        this.prescricao = prescricao;
        this.status = status;
        this.medicamento = medicamento;
        this.receita = receita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    @Override
    public String toString() {
        return "ReceitaMedicamento{" +
                "id=" + id +
                ", prescricao='" + prescricao + '\'' +
                ", status='" + status + '\'' +
                ", medicamento=" + medicamento +
                ", receita=" + receita +
                '}';
    }
}
