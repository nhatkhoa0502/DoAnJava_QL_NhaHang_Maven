package BUS;

import DAO.Table_DAO;
import DTO.Table_DTO;
import java.util.Vector;

public class Table_BUS {

    private Table_DAO tbd = new Table_DAO();

    public boolean delete(int id){
        return tbd.delete(id);
    }
    
    public boolean update(Table_DTO tableDTO) {
        tableDTO.setStatus(tableDTO.getStatus().equals("Trống") ? "free" : "serving");
        return tbd.update(tableDTO);            
    }

    public boolean insert(String name, String status) {
        status = status.equals("Trống") ? "free" : "serving";
        return tbd.insert(name, status);
    }

    public int getId(String nameTable) {
        nameTable = nameTable.trim();
        return tbd.getId(nameTable);
    }

    public void changeTableToServing(int id) {
        tbd.changeTableToServing(id);
    }

    public void changeTableToServing(String nameTable) {
        int id = getId(nameTable);
        tbd.changeTableToServing(id);
    }

    public Table_DTO getTableById(int id) {
        return tbd.getTableById(id);
    }

    public Vector<Table_DTO> getAllTable() {
        return tbd.getAllTable();
    }

    public Vector<Table_DTO> getTableFree() {
        return tbd.getTableFree();
    }

    public String getName(int id) {
        return tbd.getName(id);
    }
}
