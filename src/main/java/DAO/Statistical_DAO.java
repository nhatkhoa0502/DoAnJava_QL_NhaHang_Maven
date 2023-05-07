package DAO;

import DTO.Employee_DTO;
import DTO.Session_DTO;
import java.sql.Connection;
import java.sql.*;
import java.util.Vector;


public class Statistical_DAO {

    private Connection conn;
    
    public int getQuantityByIdFoodItemAndTime(int id, String startTime, String endTime) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "select SUM(quantity) from `order` o, `order_item` oi " +
                             "where o.id = oi.idOrder AND idFoodItem = ? AND `orderDate` BETWEEN ? AND ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, startTime);
                preparedStmt.setString(3, endTime);
                ResultSet rs = preparedStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("count quantity food item in time: " + rs.getInt(1));
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
    
    public int getCountAllEmployee() {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT COUNT(DISTINCT `idEmployee`) FROM `session`;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);           
                ResultSet rs = preparedStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("count employee in time: " + rs.getInt(1));
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
    
    public int getCountEmployeeByTime(String startTime, String endTime) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT COUNT(DISTINCT `idEmployee`) FROM `session` WHERE `startTime` BETWEEN ? AND ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, startTime);
                preparedStmt.setString(2, endTime);
                ResultSet rs = preparedStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("count employee in time: " + rs.getInt(1));
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
    
    public Vector<Session_DTO> getAllSessionEmployees() {
        conn = ConnectDB.getConnection();
        Vector<Session_DTO> arr = new Vector<Session_DTO>();
        if (conn != null) {
            try {
                String sql = "Select * from session";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Session_DTO se = new Session_DTO();
                    se.setId(rs.getInt("id"));
                    se.setIdEmployee(rs.getInt("idEmployee"));
                    se.setNameEmployee(rs.getString("nameEmployee"));
                    se.setStartTime(rs.getTimestamp("startTime"));
                    se.setEndTime(rs.getTimestamp("endTime"));
                    se.setMessage(rs.getString("message"));
                    arr.add(se);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return arr;
    }
    public Vector<Session_DTO> statisticalByTime(String startTime, String endTime){
        conn = ConnectDB.getConnection();      
        Vector<Session_DTO> arr = new Vector<Session_DTO>();
        if (conn != null) {
            try {
                System.out.println("startTime; " + startTime);
                System.out.println("endTime; " + endTime);
                String sql = "SELECT * FROM `session` WHERE `startTime` BETWEEN ? AND ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1,startTime);
                preparedStmt.setString (2,endTime);
                ResultSet rs = preparedStmt.executeQuery(); 
                while (rs.next()) {
                    Session_DTO se = new Session_DTO();
                    se.setId(rs.getInt("id"));
                    se.setIdEmployee(rs.getInt("idEmployee"));
                    se.setNameEmployee(rs.getString("nameEmployee"));
                    se.setStartTime(rs.getTimestamp("startTime"));
                    se.setEndTime(rs.getTimestamp("endTime"));
                    se.setMessage(rs.getString("message"));
                    arr.add(se);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }    
        return arr;
    }

    public void writeLoginTime(Employee_DTO em, Timestamp time) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = " insert into `session` (idEmployee , nameEmployee, startTime, message)"
                        + " values (?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1,em.getId());
                preparedStmt.setString (2, em.getName());
                preparedStmt.setTimestamp(3, time);
                preparedStmt.setString(4, "login");                                
                preparedStmt.execute(); 
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
    }
    
    public int getMaxId(){
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT MAX(id) FROM `session`";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {                    
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
    
    public void writeLogoutTime(int id, Timestamp time) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {                
                String sql = "UPDATE `session` SET endTime = (?), message = 'logout' WHERE id = (?);";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);   
                preparedStmt.setTimestamp(1,time);
                preparedStmt.setInt(2,id);
                preparedStmt.execute(); 
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
    }
}
