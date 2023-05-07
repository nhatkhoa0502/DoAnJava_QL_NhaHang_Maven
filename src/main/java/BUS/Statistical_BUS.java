
package BUS;

import DAO.Customer_DAO;
import DAO.Employee_DAO;
import DAO.FoodItem_DAO;
import DAO.OrderItem_DAO;
import DAO.Statistical_DAO;
import DTO.Employee_DTO;
import DTO.Session_DTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector; 
import DTO.FoodItem_DTO;

public class Statistical_BUS {
    
    Statistical_DAO statisticalDAO = new Statistical_DAO();
    Employee_DAO emd = new Employee_DAO();
    FoodItem_DAO foodItemDAO = new FoodItem_DAO();
    OrderItem_DAO orderItemDAO = new OrderItem_DAO();    
    Customer_DAO customerDAO = new Customer_DAO();
    
    public int getQuantityByIdFoodItemAndTime(int id,Date startTime, Date endTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateFormat = dateFormat.format(startTime);
        String endDateFormat = dateFormat.format(endTime);
        return statisticalDAO.getQuantityByIdFoodItemAndTime(id,startDateFormat,endDateFormat);
    }
    
    public int getCountCustomerByTime(Date startTime, Date endTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateFormat = dateFormat.format(startTime);
        String endDateFormat = dateFormat.format(endTime);
        return customerDAO.getCountCustomerByTime(startDateFormat,endDateFormat);
    }
    
    public int getCountAllEmployee(){
        return statisticalDAO.getCountAllEmployee();
    }
    
    public int getCountEmployeeByTime(Date startTime, Date endTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateFormat = dateFormat.format(startTime);
        String endDateFormat = dateFormat.format(endTime);
        return statisticalDAO.getCountEmployeeByTime(startDateFormat,endDateFormat);
    }
    
    public int getQuantityByIdFoodItem(int id){
        return orderItemDAO.getQuantityByIdFoodItem(id);
    }
    
    public Vector<FoodItem_DTO> getAllFoodItem(){
        return foodItemDAO.getAllFoodItem();
    }
    
    public Vector<Session_DTO> getAllSessionEmployees() {        
        return statisticalDAO.getAllSessionEmployees();
    }
    
    public Vector<Session_DTO> statisticalSessionByTime(Date start, Date end){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateFormat = dateFormat.format(start);
        String endDateFormat = dateFormat.format(end);
        System.out.println("start date format: " + startDateFormat);
        System.out.println("end date format: " + endDateFormat);        
        return statisticalDAO.statisticalByTime(startDateFormat, endDateFormat);        
    }
    
    public void writeLogoutTime(){             
        int id = statisticalDAO.getMaxId();        
        System.out.println("max id: "+id);
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        statisticalDAO.writeLogoutTime(id, timestamp);
    }
    
    public void writeLoginTime(String username, String password){
        Employee_DTO t = emd.getEmployeeByUsrPass(username, password);
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        statisticalDAO.writeLoginTime(t, timestamp);
    }
}
