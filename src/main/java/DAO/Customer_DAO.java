
package DAO;

import DTO.Customer_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
}
