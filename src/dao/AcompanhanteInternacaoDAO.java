package dao;

import model.Acompanhante;
import model.AcompanhanteInternacao;

import java.util.List;

public class AcompanhanteInternacaoDAO implements InterfaceDAO<AcompanhanteInternacao>{
    @Override
    public void create(AcompanhanteInternacao objeto) {

    }

    @Override
    public List<AcompanhanteInternacao> retrieve() {
        return List.of();
    }

    @Override
    public AcompanhanteInternacao retrieve(int pk) {
        return null;
    }

    @Override
    public List<AcompanhanteInternacao> retrieve(String parametro, String atributo) {
        return List.of();
    }

    @Override
    public void update(AcompanhanteInternacao objeto) {

    }

    @Override
    public void delete(AcompanhanteInternacao objeto) {

    }
}
