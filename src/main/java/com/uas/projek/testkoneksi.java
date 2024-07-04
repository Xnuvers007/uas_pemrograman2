package com.uas.projek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testkoneksi {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/05tplp003_indradwiaryadi";
        String username = "root";
        String password = "";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connected to the database.");
                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
