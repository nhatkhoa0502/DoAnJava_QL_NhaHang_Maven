package DAO;

import DTO.FoodCategory_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class FoodCategory_DAO {

    private Connection conn;

    public boolean delete(int id){
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {                 
                String sql = "DELETE FROM `food_category` WHERE `id` = '" + id +"';";
                Statement stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                System.out.println(i+ " hang duoc cap nhap ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false; 
    }
    
    public boolean update(String name, int id) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE `food_category` SET `name` = '" + name + "' WHERE `id` = '" + id + "';";
                Statement stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                System.out.println(i + " hang duoc cap nhap ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }

    public boolean insert(String name) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO `food_category` (name) VALUES ('" + name + "');";
                Statement stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                System.out.println(i + " hang duoc cap nhap ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }

    public Vector<FoodCategory_DTO> getAllFoodCategory() {
        conn = ConnectDB.getConnection();
        Vector<FoodCategory_DTO> vectorFoodCategory = new Vector<FoodCategory_DTO>();
        if (conn != null) {
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
