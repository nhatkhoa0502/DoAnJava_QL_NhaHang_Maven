
package DAO;

import DTO.Table_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Table_DAO {
    private Connection conn = ConnectDB.getConnection();
    public Vector<Table_DTO> getAllTable(){
        Vector<Table_DTO> vectorTable = new Vector<Table_DTO>();
        if (conn!=null) {
            try {
                String sql = "Select * from `table`;";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Table_DTO tb = new Table_DTO();
                    tb.setId(rs.getInt("id"));
                    tb.setName(rs.getString("name"));                                               
                    tb.setStatus(rs.getString("status"));
                    vectorTable.add(tb);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                 ConnectDB.closeConnection(conn);
            }
        }
        return vectorTable;    
    }
    
    public Vector<Table_DTO> getTableFree(){
        Vector<Table_DTO> vectorTable = new Vector<Table_DTO>();
        if (conn!=null) {
            try {
                String sql = "Select * from `table` where `status` = 'free';";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Table_DTO tb = new Table_DTO();
                    tb.setId(rs.getInt("id"));
                    tb.setName(rs.getString("name"));                                               
                    tb.setStatus(rs.getString("status"));
                    vectorTable.add(tb);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                 ConnectDB.closeConnection(conn);
            }
        }
        return vectorTable;    
    }
    
    public String getName(int id){
        String sql = "SELECT name FROM `table` WHERE id = " + id + ";";
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
