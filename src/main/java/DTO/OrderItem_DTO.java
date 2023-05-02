
package DTO;

public class OrderItem_DTO {
    private int idOrder, idFoodItem,quantity;    

    public OrderItem_DTO() {
    }

    @Override
    public String toString() {
        return "OrderItem_DTO{" + "idOrder=" + idOrder + ", idFoodItem=" + idFoodItem + ", quantity=" + quantity + '}';
    }        
    
    public OrderItem_DTO(int idOrder, int idFoodItem, int quantity) {
        this.idOrder = idOrder;
        this.idFoodItem = idFoodItem;
        this.quantity = quantity;        
    }
        
    public int getIdOrder() {
        return idOrder;
    }

    public int getIdFoodItem() {
        return idFoodItem;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdFoodItem(int idFoodItem) {
        this.idFoodItem = idFoodItem;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   
}
