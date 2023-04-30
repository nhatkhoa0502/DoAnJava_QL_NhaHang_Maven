
package DAO;

import DTO.Order_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Order_DAO {
    private Connection conn;
    public Vector<Order_DTO> getAllOrder(){
        conn = ConnectDB.getConnection();
        Vector<Order_DTO> vectorOrder = new Vector<Order_DTO>();
        if (conn!=null) {
            try {
                String sql = "Select * from `order`";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Order_DTO or = new Order_DTO();
                    or.setId(rs.getInt("id"));
                    or.setIdEmployee(rs.getInt("idEmployee"));                                               
                    or.setIdCustomer(rs.getInt("idCustomer")); 
                    or.setIdTable(rs.getInt("idTable")); 
                    or.setType(rs.getString("type")); 
                    or.setStatus(rs.getString("status"));
                    or.setOrderDate(rs.getTimestamp("orderDate"));
                    or.setTotalAmount(rs.getInt("totalAmount")); 
                    or.setDiscount(rs.getInt("discount")); 
                    or.setCash(rs.getInt("cash"));
                    or.setChange(rs.getInt("change"));
                    vectorOrder.add(or);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                 ConnectDB.closeConnection(conn);
            }
        }
        return vectorOrder;    
    }
    
    public int getNumOfOrderInTime(String startTime, String endTime){
        conn = ConnectDB.getConnection();
        if (conn!=null) {
            try {
                String sql = "SELECT COUNT(id) FROM `order` WHERE `orderDate` BETWEEN ? AND ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1,startTime);
                preparedStmt.setString (2,endTime);
                ResultSet rs = preparedStmt.executeQuery(); 
                if(rs.next()) {   
                    System.out.println("count: " + rs.getInt(1));
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
    
    public int getMaxIdOrder(){
        conn = ConnectDB.getConnection();
        if (conn!=null) {
            try {
                String sql = "SELECT MAX(id) FROM `order`;";
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
}
