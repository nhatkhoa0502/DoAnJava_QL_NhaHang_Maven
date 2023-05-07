package BUS;

import DAO.Customer_DAO;
import DTO.Customer_DTO;
import java.util.Vector;

public class Customer_BUS {

    private Customer_DAO ctmDAO = new Customer_DAO();
    
    public int getCountAll(){
        return ctmDAO.getCountAll();
    }
    
    public boolean delete(int id){
        return ctmDAO.delete(id);
    }
    
    public boolean update(Customer_DTO customer) {
        return ctmDAO.update(customer);            
    }

    public Vector<Customer_DTO> getAllCustomer() {
        return ctmDAO.getAllCustomer();
    }

    public int getId(String phoneNumber) {
        return ctmDAO.getId(phoneNumber);
    }

    public int getMaxId() {
        return ctmDAO.getMaxId();
    }

    public void insert(String name, String phone) {
        ctmDAO.insert(name, phone);
    }

    public String getName(int id) {
        return ctmDAO.getName(id);
    }

}
