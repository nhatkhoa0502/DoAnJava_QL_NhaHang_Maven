
package BUS;

import DAO.FoodItem_DAO;
import DTO.FoodItem_DTO;
import java.util.Vector;


public class FoodItem_BUS {
    public Vector<FoodItem_DTO> getAllFoodItem(){
        FoodItem_DAO t = new FoodItem_DAO();
        return t.getAllFoodItem();
    }
}
