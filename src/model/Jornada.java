package model;

import java.util.Date;

public class Jornada {
    private Date dataInicial;
    private Date dataFinal;
    private int cargaHorario;
    private Medico medico;
    private Farmaceutico farmaceutico;
    private Enfermeira enfermeiro;

    public Jornada(Date dataInicial, Date dataFinal, int cargaHorario, Medico medico, Farmaceutico farmaceutico, Enfermeira enfermeiro) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cargaHorario = cargaHorario;
        this.medico = medico;
        this.farmaceutico = farmaceutico;
        this.enfermeiro = enfermeiro;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(int cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

    public void setFarmaceutico(Farmaceutico farmaceutico) {
        this.farmaceutico = farmaceutico;
    }

    public Enfermeira getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeira enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    @Override
    public String toString() {
        return "Jornada{" + super.toString() +
                "dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", cargaHorario=" + cargaHorario +
                ", medico=" + medico +
                ", farmaceutico=" + farmaceutico +
                ", enfermeiro=" + enfermeiro +'}';
    }
}
