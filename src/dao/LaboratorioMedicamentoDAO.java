package dao;

import model.LaboratorioMedicamento;

import java.util.List;

public class LaboratorioMedicamentoDAO implements InterfaceDAO<LaboratorioMedicamento>{
    @Override
    public void create(LaboratorioMedicamento objeto) {

    }

    @Override
    public List<LaboratorioMedicamento> retrieve() {
        return List.of();
    }

    @Override
    public LaboratorioMedicamento retrieve(int pk) {
        return null;
    }

    @Override
    public List<LaboratorioMedicamento> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(LaboratorioMedicamento objeto) {

    }

    @Override
    public void delete(LaboratorioMedicamento objeto) {

    }
}
