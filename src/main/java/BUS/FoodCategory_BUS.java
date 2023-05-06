package BUS;

import DAO.FoodCategory_DAO;
import DTO.FoodCategory_DTO;
import java.util.Vector;

public class FoodCategory_BUS {

    private FoodCategory_DAO foodCategoryDAO = new FoodCategory_DAO();
    
    
    public String getName(int id){
        return foodCategoryDAO.getName(id);
    }
    
    public int getId(String name){
        return foodCategoryDAO.getId(name);
    }
    
    public boolean delete(int id){
        return foodCategoryDAO.delete(id);
    }
    
     public boolean update(String name,int id){
        return foodCategoryDAO.update(name,id);
    }
    
    public boolean insert(String name){
        return foodCategoryDAO.insert(name);
    }
    
    public Vector<FoodCategory_DTO> getAllFoodCategory() {
        return foodCategoryDAO.getAllFoodCategory();
    }
}
