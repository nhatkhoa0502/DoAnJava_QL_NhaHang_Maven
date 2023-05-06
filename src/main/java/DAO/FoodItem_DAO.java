package DAO;

import DTO.FoodItem_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

public class FoodItem_DAO {

    private Connection conn;

    public boolean delete(int id) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM `food_item` WHERE `id` = '" + id + "';";
                Statement stmt = conn.createStatement();
                int i = stmt.executeUpdate(sql);
                System.out.println(i + " hang trong 'food_item' dc xóa");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }

    public boolean update(FoodItem_DTO foodItem) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            System.out.println("foodItem DAO: " + foodItem.toString());
            try {
                String sql = "UPDATE `food_item` SET `name` = ?,`description` = ?,`unitName` = ?,`unitPrice` = ?,`idCategory` = ? WHERE `id` = ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, foodItem.getName());
                preparedStmt.setString(2, foodItem.getDescription());
                preparedStmt.setString(3, foodItem.getUnitName());
                preparedStmt.setInt(4, foodItem.getUnitPrice());
                preparedStmt.setInt(5, foodItem.getIdCategory());
                preparedStmt.setInt(6, foodItem.getId());
                int i = preparedStmt.executeUpdate();
                System.out.println(i + " dong dc chinh sua trong bang 'food_item'");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }

    public boolean insert(FoodItem_DTO foodItem) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "insert into `food_item`(name, description, unitName, unitPrice, idCategory) values (?, ?, ?, ?, ?);";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, foodItem.getName());
                preparedStmt.setString(2, foodItem.getDescription());
                preparedStmt.setString(3, foodItem.getUnitName());
                preparedStmt.setInt(4, foodItem.getUnitPrice());
                preparedStmt.setInt(5, foodItem.getIdCategory());
                int i = preparedStmt.executeUpdate();
                System.out.println(i + " dong dc them vao bang 'food_item'");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }

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
