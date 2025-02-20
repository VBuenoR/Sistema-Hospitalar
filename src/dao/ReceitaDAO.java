package dao;

import model.Receita;

import java.util.List;

public class ReceitaDAO implements InterfaceDAO<Receita>{
    @Override
    public void create(Receita objeto) {

    }

    @Override
    public List<Receita> retrieve() {
        return List.of();
    }

    @Override
    public Receita retrieve(int pk) {
        return null;
    }

    @Override
    public List<Receita> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(Receita objeto) {

    }

    @Override
    public void delete(Receita objeto) {

    }
}
