package dao;

import model.Internacao;

import java.util.List;

public class InternacaoDAO implements InterfaceDAO<Internacao>{
    @Override
    public void create(Internacao objeto) {

    }

    @Override
    public List<Internacao> retrieve() {
        return List.of();
    }

    @Override
    public Internacao retrieve(int pk) {
        return null;
    }

    @Override
    public List<Internacao> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(Internacao objeto) {

    }

    @Override
    public void delete(Internacao objeto) {

    }
}
