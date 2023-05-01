package DAO;

import DTO.Employee_DTO;
import DTO.Session_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee_DAO {

    private Connection conn;
    
    public int getId(String username){
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "Select id from employee WHERE `username` = '" + username +"';";
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
    
    public Vector<Employee_DTO> getAllEmployee() {
        conn = ConnectDB.getConnection();
        Vector<Employee_DTO> vectorEmployee = new Vector<Employee_DTO>();
        if (conn != null) {
            try {
                String sql = "Select * from employee";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Employee_DTO se = new Employee_DTO();
                    se.setId(rs.getInt("id"));
                    se.setUsername(rs.getString("username"));
                    se.setPassword(rs.getString("password"));
                    se.setName(rs.getString("name"));
                    se.setPhoneNumber(rs.getString("phoneNumber"));
                    se.setStartDate(rs.getTimestamp("startDate"));
                    se.setPermission(rs.getString("permission"));
                    se.setSalary(rs.getInt("salary"));
                    vectorEmployee.add(se);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return vectorEmployee;
    }

    public String getName(int id) {
        conn = ConnectDB.getConnection();
        String sql = "SELECT name FROM employee WHERE id = " + id + ";";
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
        }
        return "";
    }

    public Employee_DTO getEmployeeByUsrPass(String username, String password) {
        conn = ConnectDB.getConnection();
        String sql = "SELECT * FROM employee WHERE username ='" + username + "' AND password ='" + password + "';";
        Statement stmt;
        ResultSet rs;
        Employee_DTO employeeTemp = new Employee_DTO();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                employeeTemp.setId(rs.getInt(1));
                employeeTemp.setUsername(rs.getString(2));
                employeeTemp.setPassword(rs.getString(3));
                employeeTemp.setName(rs.getString(4));
                employeeTemp.setPhoneNumber(rs.getString(5));
                employeeTemp.setStartDate(rs.getTimestamp(6));
                employeeTemp.setPermission(rs.getString(7));
                employeeTemp.setSalary(rs.getInt(8));
                return employeeTemp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeeTemp;
    }

    public String getName(String username, String password) {
        conn = ConnectDB.getConnection();
        String sql = "SELECT name FROM employee WHERE username ='" + username + "' AND password ='" + password + "';";
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
        }
        return "";
    }
    
    public String getName(String username) {
        conn = ConnectDB.getConnection();
        System.out.println("ursname DAO; " + username);
        String sql = "SELECT name FROM `employee` WHERE `username` = '" + username + "';";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println("employee name DAO: " + name);
                return name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public boolean isManager(String username, String password) {
        conn = ConnectDB.getConnection();
        String sql = "SELECT permission FROM employee WHERE username ='" + username + "' AND password ='" + password + "';";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if (rs.getString("permission").equals("manager")) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
