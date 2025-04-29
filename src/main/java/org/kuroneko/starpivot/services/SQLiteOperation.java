package org.kuroneko.starpivot.services;

import org.kuroneko.starpivot.config.GlobalConfig;

import java.sql.*;

public class SQLiteOperation {

    static GlobalConfig globalConfig = new GlobalConfig();
    //static String url = String.format("jdbc:sqlite:%s/test.db",globalConfig.getStarpivotHome());
    static String url = "C:\\Users\\Administrator\\Desktop\\test.db";
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY,"
                + "name TEXT NOT NULL,"
                + "email TEXT NOT NULL)";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("表已创建或已存在");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData() {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Alice");
            pstmt.setString(2, "alice@example.com");
            pstmt.executeUpdate();
            System.out.println("数据插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void queryData() {
        String sql = "SELECT id, name, email FROM users";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateData() {
        String sql = "UPDATE users SET email = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "updated_alice@example.com");
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();
            System.out.println("数据更新成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteData() {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);
            pstmt.executeUpdate();
            System.out.println("数据删除成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
