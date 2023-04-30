
package BUS;

import DAO.Customer_DAO;
import DTO.Customer_DTO;
import java.util.Vector;

public class Customer_BUS {
    private Customer_DAO ctmDAO = new Customer_DAO();
    
    public Vector<Customer_DTO> getAllCustomer(){        
        return ctmDAO.getAllCustomer();
    } 
    
    public String getName(int id){
        return ctmDAO.getName(id);
    }
}
