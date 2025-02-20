package dao;

import model.Prontuario;

import java.util.List;

public class ProntuarioDAO implements InterfaceDAO<Prontuario>{
    @Override
    public void create(Prontuario objeto) {

    }

    @Override
    public List<Prontuario> retrieve() {
        return List.of();
    }

    @Override
    public Prontuario retrieve(int pk) {
        return null;
    }

    @Override
    public List<Prontuario> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(Prontuario objeto) {

    }

    @Override
    public void delete(Prontuario objeto) {

    }
}
