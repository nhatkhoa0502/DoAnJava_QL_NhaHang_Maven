
package BUS;


import DAO.Table_DAO;
import DTO.Table_DTO;
import java.util.Vector;


public class Table_BUS {
    private Table_DAO tbd = new Table_DAO();
    
    public Vector<Table_DTO> getAllTable(){        
        return tbd.getAllTable();
    }       
}