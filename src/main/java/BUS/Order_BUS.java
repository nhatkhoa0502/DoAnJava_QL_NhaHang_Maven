
package BUS;

import DAO.Order_DAO;
import DTO.Order_DTO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class Order_BUS {
    private Order_DAO orDAO = new Order_DAO();
    
    public Vector<Order_DTO> getAllOrder(){        
        return orDAO.getAllOrder();
    }    
    
    public void insertData(Order_DTO order){
        orDAO.insertData(order);
    }
    
    public int getNumOfOrderInTime(Date startTime, Date endTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDateFormat = dateFormat.format(startTime);
        String endDateFormat = dateFormat.format(endTime);
        return orDAO.getNumOfOrderInTime(startDateFormat, endDateFormat);        
    }
    
    public int getMaxIdOrder(){
        return orDAO.getMaxIdOrder();
    }
}
