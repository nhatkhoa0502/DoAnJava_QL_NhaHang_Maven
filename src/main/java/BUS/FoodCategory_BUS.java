
package BUS;

import DAO.FoodCategory_DAO;
import DTO.FoodCategory_DTO;
import java.util.Vector;


public class FoodCategory_BUS {

    public Vector<FoodCategory_DTO> getAllFoodCategory(){
        FoodCategory_DAO t = new FoodCategory_DAO();
        return t.getAllFoodCategory();
    } 
}
