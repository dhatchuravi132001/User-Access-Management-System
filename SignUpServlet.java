package com.example.servlets;

import com.example.servlets.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection conn = DBConnection.initializeDatabase();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password, role) VALUES (?, ?, 'Employee')");
            ps.setString(1, username);
            ps.setString(2, password); // Store passwords securely (e.g., using hashing in real projects)
            ps.executeUpdate();
            ps.close();
            conn.close();

            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
