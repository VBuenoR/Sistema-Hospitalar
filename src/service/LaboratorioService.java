package service;

import dao.LaboratorioDAO;
import dao.MedicamentoDAO;
import model.Laboratorio;
import model.Medicamento;

import java.util.List;

public class LaboratorioService {

    public static void adicionar(Laboratorio objeto){
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        laboratorioDAO.create(objeto);
    }
    public static List<Laboratorio> ler(){
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        return laboratorioDAO.retrieve();
    }
    public static Laboratorio ler(int PK) {
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        return  laboratorioDAO.retrieve(PK);
    }
    public static List<Laboratorio> ler(String parametro, String atributo){
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        return laboratorioDAO.retrieve(parametro,atributo);
    }
    public static void atualizar(Laboratorio objeto){
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        laboratorioDAO.update(objeto);
    }
}
