
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/ql_nhahang";
            String username = "root";
            String password = "";
            return DriverManager.getConnection(dbUrl, username, password);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Statistical_DAO.class.getName()).log(Level.SEVERE, "ClassNotFoundException", ex);                        
        } catch (SQLException ex) {
            Logger.getLogger(Statistical_DAO.class.getName()).log(Level.SEVERE, "SQLException", ex);                        
        }
        return null;
    }
    
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
