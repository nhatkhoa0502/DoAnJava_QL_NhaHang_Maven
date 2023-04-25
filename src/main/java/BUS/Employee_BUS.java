
package BUS;

import DAO.Employee_DAO;
import DTO.Employee_DTO;

import java.util.Vector;


public class Employee_BUS {
    public Vector<Employee_DTO> getAllEmployee(){
        Employee_DAO t = new Employee_DAO();
        return t.getAllEmployee();
    } 
}
