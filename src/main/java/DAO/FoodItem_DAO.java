package DAO;

import DTO.FoodItem_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class FoodItem_DAO {

    private Connection conn;

    public FoodItem_DTO getFoodItemById(int id) {
        conn = ConnectDB.getConnection();
        FoodItem_DTO foodItem = null;
        if (conn != null) {
            try {
                String sql = "Select * from food_item where id = " + id + ";";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    foodItem = new FoodItem_DTO();
                    foodItem.setId(rs.getInt("id"));
                    foodItem.setName(rs.getString("name"));
                    foodItem.setDescription(rs.getString("description"));
                    foodItem.setUrlImage(rs.getString("urlImage"));
                    foodItem.setUnitName(rs.getString("unitName"));
                    foodItem.setUnitPrice(rs.getInt("unitPrice"));
                    foodItem.setIdCategory(rs.getInt("idCategory"));
                    return foodItem;
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return foodItem;
    }

    public Vector<FoodItem_DTO> getAllFoodItemByIdCategory(int id) {
        conn = ConnectDB.getConnection();
        Vector<FoodItem_DTO> vectorFoodCategory = new Vector<FoodItem_DTO>();
        if (conn != null) {
            try {
                String sql = "Select * from food_item where idCategory = " + id + ";";
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

    public Vector<FoodItem_DTO> getAllFoodItem() {
        conn = ConnectDB.getConnection();
        Vector<FoodItem_DTO> vectorFoodCategory = new Vector<FoodItem_DTO>();
        if (conn != null) {
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

    public int getPrice(int id) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "Select unitPrice from food_item where id = " + id + ";";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return 0;
    }

    public String getName(int id) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "Select name from food_item where id = " + id + ";";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    return rs.getString(1);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return "";
    }
}
