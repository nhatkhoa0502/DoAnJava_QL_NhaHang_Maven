
package DAO;

import DTO.Customer_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer_DAO {
    private Connection conn = ConnectDB.getConnection();
    public Vector<Customer_DTO> getAllCustomer(){
        Vector<Customer_DTO> vectorCustomer = new Vector<Customer_DTO>();
        if (conn!=null) {
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
    
    public String getName(int id){
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
        }
        return "";
    }
}
