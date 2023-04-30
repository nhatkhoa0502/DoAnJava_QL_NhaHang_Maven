
package DTO;

import java.sql.Timestamp;


public class Order_DTO {
    private int id, idEmployee, idCustomer, idTable, totalAmount, discount, cash, change;
    private String type, status;    
    private Timestamp orderDate;

    public Order_DTO() {
    }

    public int getCash() {
        return cash;
    }

    public int getChange() {
        return change;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setChange(int change) {
        this.change = change;
    }

    
    
    public int getId() {
        return id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdTable() {
        return idTable;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getDiscount() {
        return discount;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
    
    
}
