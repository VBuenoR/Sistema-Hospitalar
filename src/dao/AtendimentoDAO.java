package dao;

import model.Atendimento;

import java.util.List;

public class AtendimentoDAO implements InterfaceDAO<Atendimento>{
    @Override
    public void create(Atendimento objeto) {

    }

    @Override
    public List<Atendimento> retrieve() {
        return List.of();
    }

    @Override
    public Atendimento retrieve(int pk) {
        return null;
    }

    @Override
    public List<Atendimento> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(Atendimento objeto) {

    }

    @Override
    public void delete(Atendimento objeto) {

    }
}
