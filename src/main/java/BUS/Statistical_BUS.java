
package BUS;

import DAO.Employee_DAO;
import DAO.Statistical_DAO;
import DTO.Employee_DTO;
import DTO.Session_DTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector; 

public class Statistical_BUS {
    
    Statistical_DAO statistical_DAO = new Statistical_DAO();
    Employee_DAO emd = new Employee_DAO();
    
    public Vector<Session_DTO> getAllSessionEmployees() {        
        return statistical_DAO.getAllSessionEmployees();
    }
    
    public Vector<Session_DTO> statisticalByTime(Date start, Date end){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateFormat = dateFormat.format(start);
        String endDateFormat = dateFormat.format(end);
        System.out.println("start date format: " + startDateFormat);
        System.out.println("end date format: " + endDateFormat);        
        return statistical_DAO.statisticalByTime(startDateFormat, endDateFormat);        
    }
    
    public void writeLogoutTime(){             
        int id = statistical_DAO.getMaxId();        
        System.out.println("max id: "+id);
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        statistical_DAO.writeLogoutTime(id, timestamp);
    }
    
    public void writeLoginTime(String username, String password){
        Employee_DTO t = emd.getEmployeeByUsrPass(username, password);
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        statistical_DAO.writeLoginTime(t, timestamp);
    }
}
