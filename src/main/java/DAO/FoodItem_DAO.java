
package DAO;


import DTO.FoodItem_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class FoodItem_DAO {
    private Connection conn = ConnectDB.getConnection();
    public Vector<FoodItem_DTO> getAllFoodItem(){
        Vector<FoodItem_DTO> vectorFoodCategory = new Vector<FoodItem_DTO>();
        if (conn!=null) {
            try {
                String sql = "Select * from food_item";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    FoodItem_DTO fi = new FoodItem_DTO();
                    fi.setId(rs.getInt("id"));
                    fi.setName(rs.getString("name"));  
                    fi.setDescription(rs.getString("description"));
                    fi.setUrlImage(rs.getString("urlImage"));
                    fi.setUnitName(rs.getString("unitName"));
                    fi.setUnitPrice(rs.getInt("unitPrice"));
                    fi.setIdCategory(rs.getInt("idCategory"));           
                    vectorFoodCategory.add(fi);
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
