
package DAO;

import DTO.Employee_DTO;
import DTO.Session_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Employee_DAO {
    
    private Connection conn = ConnectDB.getConnection();
            
    public Vector<Employee_DTO> getAllEmployee(){
        Vector<Employee_DTO> vectorEmployee = new Vector<Employee_DTO>();
        if (conn!=null) {
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
}