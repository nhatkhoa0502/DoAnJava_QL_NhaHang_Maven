package BUS;

import DAO.Employee_DAO;
import DTO.Employee_DTO;

import java.util.Vector;

public class Employee_BUS {

    private Employee_DAO emd = new Employee_DAO();

    public Vector<Employee_DTO> getAllEmployee() {
        return emd.getAllEmployee();
    }    
    
    public int getId(String username){
        return emd.getId(username);
    }
    
    public Employee_DTO getEmployeeByUsrPass(String username, String password) {
        return emd.getEmployeeByUsrPass(username, password);
    }

    public boolean isManager(String username, String password) {
        return emd.isManager(username, password);
    }

    public boolean checkLogin(String username, String password) {
        System.out.println("usr; " + username);
        System.out.println("pass: " + password);
        Vector<Employee_DTO> vectorEmployee = getAllEmployee();
        for (int i = 0; i < vectorEmployee.size(); i++) {
            if (username.equals(vectorEmployee.get(i).getUsername()) && password.equals(vectorEmployee.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    public String getName(String username, String password) {
        return emd.getName(username, password);
    }

    public String getName(String username) {
        System.out.println("employeeName BUS: " + emd.getName(username));
        return emd.getName(username);
    }

    public String getName(int id) {
        return emd.getName(id);
    }

}
