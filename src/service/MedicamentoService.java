package service;

import dao.MedicamentoDAO;
import model.Medicamento;

import java.util.List;

public class MedicamentoService {

    public static void adicionar(Medicamento objeto){
        MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
        medicamentoDAO.create(objeto);
    }
    public static List<Medicamento> ler(){
        MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
        return medicamentoDAO.retrieve();
    }
    public static Medicamento ler(int PK) {
        MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
        return  medicamentoDAO.retrieve(PK);
    }
    public static List<Medicamento> ler(String parametro, String atributo){
        MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
        return medicamentoDAO.retrieve(parametro,atributo);
    }
    public static void atualizar(Medicamento objeto){
        MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
        medicamentoDAO.update(objeto);
    }
}
