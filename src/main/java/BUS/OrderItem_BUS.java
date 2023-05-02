package BUS;

import DAO.OrderItem_DAO;
import DTO.FoodItem_DTO;
import DTO.OrderItem_DTO;
import java.util.Vector;

public class OrderItem_BUS {

    OrderItem_DAO orderItemDAO = new OrderItem_DAO();
    Vector<OrderItem_DTO> vectorOderItem = new Vector<OrderItem_DTO>();
    
    public Vector<OrderItem_DTO> getByIdOrder(int id){
        return orderItemDAO.getByIdOrder(id);
    }
    
    private boolean checkIdFoodItemExist(int idFoodItem) {
        for (int i = 0; i < vectorOderItem.size(); i++) {
            if (vectorOderItem.get(i).getIdFoodItem() == idFoodItem) {
                return true;
            }
        }
        return false;
    }

    private void increaseQuantity(int idFoodItem) {
        for (int i = 0; i < vectorOderItem.size(); i++) {
            if (vectorOderItem.get(i).getIdFoodItem() == idFoodItem) {
                int quantity = vectorOderItem.get(i).getQuantity();
                vectorOderItem.get(i).setQuantity(++quantity);
            }
        }
    }

    public void inserData(int idOrder, Vector<FoodItem_DTO> vectorFoodItem) {
        int idFoodItem;
        for (int i = 0; i < vectorFoodItem.size(); i++) {
            idFoodItem = vectorFoodItem.get(i).getId();
            if (!checkIdFoodItemExist(idFoodItem)) {
                vectorOderItem.add(new OrderItem_DTO(idOrder, idFoodItem, 1));
            } else {
                increaseQuantity(idFoodItem);
            }
        }
        orderItemDAO.insertData(vectorOderItem);
    }
}
