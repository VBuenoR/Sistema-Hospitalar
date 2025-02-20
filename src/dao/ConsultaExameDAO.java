package dao;

import model.ConsultaExame;

import java.util.List;

public class ConsultaExameDAO implements InterfaceDAO<ConsultaExame>{
    @Override
    public void create(ConsultaExame objeto) {

    }

    @Override
    public List<ConsultaExame> retrieve() {
        return List.of();
    }

    @Override
    public ConsultaExame retrieve(int pk) {
        return null;
    }

    @Override
    public List<ConsultaExame> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(ConsultaExame objeto) {

    }

    @Override
    public void delete(ConsultaExame objeto) {

    }
}
