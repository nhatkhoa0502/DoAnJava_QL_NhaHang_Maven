
package DAO;

import DTO.Table_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
}
