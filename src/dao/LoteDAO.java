package dao;

import model.Lote;

import java.util.List;

public class LoteDAO implements InterfaceDAO<Lote> {
    @Override
    public void create(Lote objeto) {

    }

    @Override
    public List<Lote> retrieve() {
        return List.of();
    }

    @Override
    public Lote retrieve(int pk) {
        return null;
    }

    @Override
    public List<Lote> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(Lote objeto) {

    }

    @Override
    public void delete(Lote objeto) {

    }
}
