package dao;

import model.InternacaoLeito;

import java.util.List;

public class InternacaoLeitoDAO implements InterfaceDAO<InternacaoLeito>{
    @Override
    public void create(InternacaoLeito objeto) {

    }

    @Override
    public List<InternacaoLeito> retrieve() {
        return List.of();
    }

    @Override
    public InternacaoLeito retrieve(int pk) {
        return null;
    }

    @Override
    public List<InternacaoLeito> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(InternacaoLeito objeto) {

    }

    @Override
    public void delete(InternacaoLeito objeto) {

    }
}
