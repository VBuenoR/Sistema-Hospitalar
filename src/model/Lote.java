package model;

import java.util.Date;

public class Lote {
    private int id;
    private String descricao;
    private Date dataFabricacao;
    private Date dataValidade;
    private String status;
    private LaboratorioMedicamento laboratorioMedicamento;


    public Lote(int id, String descricao, Date dataFabricacao, Date dataValidade, String status, LaboratorioMedicamento laboratorioMedicamento) {
        this.id = id;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.status = status;
        this.laboratorioMedicamento = laboratorioMedicamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LaboratorioMedicamento getLaboratorioMedicamento() {
        return laboratorioMedicamento;
    }

    public void setLaboratorioMedicamento(LaboratorioMedicamento laboratorioMedicamento) {
        this.laboratorioMedicamento = laboratorioMedicamento;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataFabricacao=" + dataFabricacao +
                ", dataValidade=" + dataValidade +
                ", status='" + status + '\'' +
                ", laboratorioMedicamento=" + laboratorioMedicamento +
                '}';
    }
}
