package DAO;

import DTO.Customer_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer_DAO {

    private Connection conn;

    public int getCountCustomerByTime(String startTime, String endTime) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT COUNT(id) FROM `customer` WHERE `dateCreate` BETWEEN ? AND ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, startTime);
                preparedStmt.setString(2, endTime);
                ResultSet rs = preparedStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("count customer in time: " + rs.getInt(1));
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
    
    public int getCountAll(){
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "SELECT COUNT(*) FROM `customer`";
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
    
    public boolean delete(int id){
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM `customer` WHERE `id` = '" + id + "';";
                Statement stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                System.out.println(i + " hang duoc cap nhap ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }
    
    public boolean update(Customer_DTO customer){
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE `customer` SET `name` = ?, `phoneNumber` = ? WHERE `id` = ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, customer.getName());
                preparedStmt.setString(2, customer.getPhoneNumber());
                preparedStmt.setInt(3, customer.getId());
                int i = preparedStmt.executeUpdate();
                System.out.println(i + " dong trong bang 'customer' dc sua ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }
    
    public Vector<Customer_DTO> getAllCustomer() {
        conn = ConnectDB.getConnection();
        Vector<Customer_DTO> vectorCustomer = new Vector<Customer_DTO>();
        if (conn != null) {
            try {
                String sql = "Select * from customer";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Customer_DTO ctm = new Customer_DTO();
                    ctm.setId(rs.getInt("id"));
                    ctm.setName(rs.getString("name"));
                    ctm.setPhoneNumber(rs.getString("phoneNumber"));
                    ctm.setDateCreate(rs.getTimestamp("dateCreate"));
                    vectorCustomer.add(ctm);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return vectorCustomer;
    }

    public int getId(String phoneNumber) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "Select id from customer where `phoneNumber` = '" + phoneNumber + "';";
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

    public void insert(String name, String phone) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = " insert into `customer` (name, phoneNumber, dateCreate) values (?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, name);
                preparedStmt.setString(2, phone);
                Date now = new Date();
                Timestamp dateCreate = new Timestamp(now.getTime());
                preparedStmt.setTimestamp(3, dateCreate);
                preparedStmt.execute();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
    }

    public int getMaxId() {
        conn = ConnectDB.getConnection();
        String sql = "SELECT MAX(id) FROM customer;";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return 0;
    }

    public String getName(int id) {
        conn = ConnectDB.getConnection();
        String sql = "SELECT name FROM customer WHERE id = " + id + ";";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return "";
    }
}
