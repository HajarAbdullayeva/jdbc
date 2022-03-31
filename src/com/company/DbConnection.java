package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConnection {
    // Connection, ResultSet, PreparedStatement

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "2001");
    }

    public static void closeConnection(Connection c,
                                       PreparedStatement p,
                                       ResultSet rs) {
        try {
            if (c != null) {
                c.close();
            }
            if (p != null) {
                p.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
