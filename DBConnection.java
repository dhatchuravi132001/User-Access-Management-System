package com.example.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/user_access_management";
    private static final String USER = "root"; 
    private static final String PASSWORD = "W7301@jqir#";

    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
