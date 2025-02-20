package dao;

import model.ReceitaMedicamento;

import java.util.List;

public class ReceitaMedicamentoDAO implements InterfaceDAO<ReceitaMedicamento>{
    @Override
    public void create(ReceitaMedicamento objeto) {

    }

    @Override
    public List<ReceitaMedicamento> retrieve() {
        return List.of();
    }

    @Override
    public ReceitaMedicamento retrieve(int pk) {
        return null;
    }

    @Override
    public List<ReceitaMedicamento> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(ReceitaMedicamento objeto) {

    }

    @Override
    public void delete(ReceitaMedicamento objeto) {

    }
}
