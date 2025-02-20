package dao;

import model.Consulta;

import java.util.List;

public class ConsultaDAO implements InterfaceDAO<Consulta>{
    @Override
    public void create(Consulta objeto) {

    }

    @Override
    public List<Consulta> retrieve() {
        return List.of();
    }

    @Override
    public Consulta retrieve(int pk) {
        return null;
    }

    @Override
    public List<Consulta> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(Consulta objeto) {

    }

    @Override
    public void delete(Consulta objeto) {

    }
}
