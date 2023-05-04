package DAO;

import DTO.Order_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

public class Order_DAO {

    private Connection conn;

    public void cancelOrderById(int id){
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE `order` SET `status` = 'cancel' WHERE `id` = ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1, id);
                preparedStmt.execute();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
    }
    
    public void updateData(Order_DTO order){
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE `order` SET `totalAmount` = ?, `cash` = ?, `change` = ?, `discount` = ? WHERE `id` = ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1,order.getTotalAmount());
                preparedStmt.setInt(2,order.getCash());              
                preparedStmt.setInt(3, order.getChange());        
                preparedStmt.setInt(4, order.getDiscount());   
                preparedStmt.setInt(5, order.getId());
                preparedStmt.execute();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
    }
    
    public boolean idIsExist(int id) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT COUNT(1) FROM `order` WHERE `id` = '" + id + "';";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    if (rs.getInt(1) == 0) {
                        return false;
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return true;
    }

    public Order_DTO getDataById(int idOrder) {
        conn = ConnectDB.getConnection();
        Order_DTO orderTemp = null;
        if (conn != null) {
            try {
                String sql = "Select * from `order` where id = '" + idOrder + "';";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    orderTemp = new Order_DTO();
                    orderTemp.setId(rs.getInt("id"));
                    orderTemp.setIdEmployee(rs.getInt("idEmployee"));
                    orderTemp.setIdCustomer(rs.getInt("idCustomer"));
                    orderTemp.setIdTable(rs.getInt("idTable"));
                    orderTemp.setType(rs.getString("type"));
                    orderTemp.setStatus(rs.getString("status"));
                    orderTemp.setOrderDate(rs.getTimestamp("orderDate"));
                    orderTemp.setTotalAmount(rs.getInt("totalAmount"));
                    orderTemp.setDiscount(rs.getInt("discount"));
                    orderTemp.setCash(rs.getInt("cash"));
                    orderTemp.setChange(rs.getInt("change"));
                    return orderTemp;
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return orderTemp;
    }

    public void insertData(Order_DTO o) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "insert into `order`(idEmployee, idCustomer, idTable, type, status, orderDate, discount, totalAmount, cash, `change`) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1, o.getIdEmployee());
                if (o.getIdCustomer() != 0) {
                    preparedStmt.setInt(2, o.getIdCustomer());
                } else {
                    preparedStmt.setNull(2, Types.INTEGER);
                }
                preparedStmt.setInt(3, o.getIdTable());
                preparedStmt.setString(4, o.getType());
                preparedStmt.setString(5, o.getStatus());
                preparedStmt.setTimestamp(6, o.getOrderDate());
                preparedStmt.setInt(7, o.getDiscount());
                preparedStmt.setInt(8, o.getTotalAmount());
                preparedStmt.setInt(9, o.getCash());
                preparedStmt.setInt(10, o.getChange());
                preparedStmt.execute();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
    }

    public Vector<Order_DTO> getAllOrder() {
        conn = ConnectDB.getConnection();
        Vector<Order_DTO> vectorOrder = new Vector<Order_DTO>();
        if (conn != null) {
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

    public int getNumOfOrderInTime(String startTime, String endTime) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT COUNT(id) FROM `order` WHERE `orderDate` BETWEEN ? AND ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, startTime);
                preparedStmt.setString(2, endTime);
                ResultSet rs = preparedStmt.executeQuery();
                if (rs.next()) {
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

    public int getMaxIdOrder() {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT MAX(id) FROM `order`;";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
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
