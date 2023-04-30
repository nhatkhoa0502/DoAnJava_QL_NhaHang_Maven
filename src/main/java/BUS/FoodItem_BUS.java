
package BUS;

import DAO.FoodItem_DAO;
import DTO.FoodItem_DTO;
import java.util.Vector;


public class FoodItem_BUS {
    FoodItem_DAO foodItemDAO = new FoodItem_DAO();
    
    public Vector<FoodItem_DTO> getAllFoodItem(){        
        return foodItemDAO.getAllFoodItem();
    }
    
    public String getName(int id){
        return foodItemDAO.getName(id);
    }
    
    public int getPrice(int id){
        return foodItemDAO.getPrice(id);
    }
    
}
