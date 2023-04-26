
package DAO;

import DTO.FoodCategory_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Customer_DAO {
    private Connection conn = ConnectDB.getConnection();
    public Vector<FoodCategory_DTO> getAllFoodCategory(){
        Vector<FoodCategory_DTO> vectorFoodCategory = new Vector<FoodCategory_DTO>();
        if (conn!=null) {
            try {
                String sql = "Select * from food_category";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    FoodCategory_DTO fc = new FoodCategory_DTO();
                    fc.setId(rs.getInt("id"));
                    fc.setName(rs.getString("name"));                                               
                    vectorFoodCategory.add(fc);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                 ConnectDB.closeConnection(conn);
            }
        }
        return vectorFoodCategory;    
    }
}
