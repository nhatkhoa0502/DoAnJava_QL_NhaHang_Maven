
package DTO;

public class OrderItem_DTO {
    private int idOrder, idFoodItem,quantity;
    private String note;

    public OrderItem_DTO(int idOrder, int idFoodItem, int quantity, String note) {
        this.idOrder = idOrder;
        this.idFoodItem = idFoodItem;
        this.quantity = quantity;
        this.note = note;
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

    public String getNote() {
        return note;
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

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
