package DAO;

import DTO.OrderItem_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OrderItem_DAO {
    
    private Connection conn;
    
    public int getQuantityByIdFoodItem(int id){
        conn = ConnectDB.getConnection();        
        if (conn != null) {
            try {
                String sql = "SELECT SUM(quantity) FROM `order_item` WHERE `idFoodItem` = '" + id + "';";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()) {                    
                    return rs.getInt(1);                    
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return 0;
    }
    
     public Vector<OrderItem_DTO> getByIdOrder(int id){
        conn = ConnectDB.getConnection();
        Vector<OrderItem_DTO> vectorOrderItem = new Vector<OrderItem_DTO>();
        if (conn != null) {
            try {
                String sql = "Select * from `order_item` where idOrder = '" + id + "';";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    OrderItem_DTO t = new OrderItem_DTO();
                    t.setIdOrder(rs.getInt(1));
                    t.setIdFoodItem(rs.getInt(2));
                    t.setQuantity(rs.getInt(3));  
                    System.out.println("t: " + t);
                    vectorOrderItem.add(t);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return vectorOrderItem;
    }

    public void insertData(Vector<OrderItem_DTO> vectorOderItem) {        
        for(int i=0;i<vectorOderItem.size();i++){
            System.out.println("order item: "+vectorOderItem.get(i));
        }        
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "insert into `order_item`(idOrder, idFoodItem, quantity) values (?, ?, ?);";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                for(int i=0;i<vectorOderItem.size();i++){
                    preparedStmt.setInt(1, vectorOderItem.get(i).getIdOrder());      
                    preparedStmt.setInt(2, vectorOderItem.get(i).getIdFoodItem());        
                    preparedStmt.setInt(3, vectorOderItem.get(i).getQuantity());
                    preparedStmt.execute();
                }                 
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }        
    }
}
