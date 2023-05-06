package DAO;

import DTO.Table_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Table_DAO {

    private Connection conn;

    public boolean delete(int id) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM `table` WHERE `id` = '" + id + "';";
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

    public boolean update(Table_DTO tableDTO) {
        System.out.println("id table: " + tableDTO.getId());
        System.out.println("name table: " + tableDTO.getName());
        System.out.println("status table: " + tableDTO.getStatus());
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE `table` SET `name` = ?, `status` = ? WHERE `id` = ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, tableDTO.getName());
                preparedStmt.setString(2, tableDTO.getStatus());
                preparedStmt.setInt(3, tableDTO.getId());
                int i = preparedStmt.executeUpdate();
                System.out.println(i + " dong trong bang 'table' dc sua ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }

    public boolean insert(String name, String status) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO `table` (name, status) VALUES (?,?);";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, name);
                preparedStmt.setString(2, status);
                int i = preparedStmt.executeUpdate();
                System.out.println(i + " dong dc them");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return false;
    }

    public void changeTableToServing(int id) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE `table` SET `status` = 'serving' WHERE `id` = ?;";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1, id);
                preparedStmt.execute();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
    }

    public int getId(String nameTable) {
        conn = ConnectDB.getConnection();
        if (conn != null) {
            try {
                String sql = "Select `id` from `table` where `name` = '" + nameTable + "';";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    return rs.getInt(0);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return 0;
    }

    public Table_DTO getTableById(int id) {
        conn = ConnectDB.getConnection();
        Table_DTO tb = null;
        if (conn != null) {
            try {
                String sql = "Select * from `table` where id = '" + id + "';";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb = new Table_DTO();
                    tb.setId(rs.getInt("id"));
                    tb.setName(rs.getString("name"));
                    tb.setStatus(rs.getString("status"));
                    return tb;
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
        return tb;
    }

    public Vector<Table_DTO> getAllTable() {
        conn = ConnectDB.getConnection();
        Vector<Table_DTO> vectorTable = new Vector<Table_DTO>();
        if (conn != null) {
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

    public Vector<Table_DTO> getTableFree() {
        conn = ConnectDB.getConnection();
        Vector<Table_DTO> vectorTable = new Vector<Table_DTO>();
        if (conn != null) {
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

    public String getName(int id) {
        conn = ConnectDB.getConnection();
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
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return "";
    }
}
