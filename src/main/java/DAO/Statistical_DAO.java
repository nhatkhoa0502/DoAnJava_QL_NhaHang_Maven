
package DAO;

import DTO.Session_DTO;
import java.sql.Connection;
//import DTO.employeeDTO;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Statistical_DAO {

    private Connection conn = ConnectDB.getConnection();

    public Vector<Session_DTO> getAllSessionEmployees() {
        Vector<Session_DTO> arr = new Vector<Session_DTO>();
        if (conn!=null) {
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
}
