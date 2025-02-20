package dao;

import model.MovimentoMedicamento;

import java.util.List;

public class MovimentoMedicamentoDAO implements InterfaceDAO<MovimentoMedicamento>{
    @Override
    public void create(MovimentoMedicamento objeto) {

    }

    @Override
    public List<MovimentoMedicamento> retrieve() {
        return List.of();
    }

    @Override
    public MovimentoMedicamento retrieve(int pk) {
        return null;
    }

    @Override
    public List<MovimentoMedicamento> retrieve(String parametro, String atributo    ) {
        return List.of();
    }

    @Override
    public void update(MovimentoMedicamento objeto) {

    }

    @Override
    public void delete(MovimentoMedicamento objeto) {

    }
}
