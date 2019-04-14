package com.leon.jdbcdemo;

import java.sql.*;

/**
 * show how to connect mysql,not best practice
 * @Author leon
 * @Date 2019/4/11 10:55
 */
public class SimpleJdbcDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // use the latest Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
            stmt = conn.prepareStatement("select * from person where id=?");
            stmt.setInt(1, 10);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println("---------------");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
