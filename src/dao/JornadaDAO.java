package dao;

import model.Jornada;

import java.util.List;

public class JornadaDAO implements InterfaceDAO<Jornada>{
    @Override
    public void create(Jornada objeto) {

    }

    @Override
    public List<Jornada> retrieve() {
        return List.of();
    }

    @Override
    public Jornada retrieve(int pk) {
        return null;
    }

    @Override
    public List<Jornada> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(Jornada objeto) {

    }

    @Override
    public void delete(Jornada objeto) {

    }
}
