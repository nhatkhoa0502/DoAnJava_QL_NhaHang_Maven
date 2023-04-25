
package BUS;

import DAO.Statistical_DAO;
import DTO.Session_DTO;
import java.util.Vector; 

public class Statistical_BUS {
    
    Statistical_DAO statistical_DAO = new Statistical_DAO();
    
    public Vector<Session_DTO> getAllSessionEmployees() {        
        return statistical_DAO.getAllSessionEmployees();
    }
}
