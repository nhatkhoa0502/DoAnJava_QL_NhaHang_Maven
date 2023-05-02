
package BUS;

import DAO.FoodItem_DAO;
import DTO.FoodItem_DTO;
import java.util.Vector;


public class FoodItem_BUS {
    FoodItem_DAO foodItemDAO = new FoodItem_DAO();
    
    public FoodItem_DTO getFoodItemById(int id){
        return foodItemDAO.getFoodItemById(id);
    }
    
    public Vector<FoodItem_DTO> getAllFoodItem(){        
        return foodItemDAO.getAllFoodItem();
    }
    
    public Vector<FoodItem_DTO> getAllFoodItemByIdCategory(int id){
        return foodItemDAO.getAllFoodItemByIdCategory(id);
    }
    
    public String getName(int id){
        return foodItemDAO.getName(id);
    }
    
    public int getPrice(int id){
        return foodItemDAO.getPrice(id);
    }
    
}
