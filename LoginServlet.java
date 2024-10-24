package com.example.servlets;

import com.example.servlets.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection conn = DBConnection.initializeDatabase();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);  // In real projects, compare hashed passwords
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                if ("Admin".equals(role)) {
                    response.sendRedirect("createSoftware.jsp");
                } else if ("Manager".equals(role)) {
                    response.sendRedirect("pendingRequests.jsp");
                } else {
                    response.sendRedirect("requestAccess.jsp");
                }
            } else {
                response.sendRedirect("login.jsp?error=Invalid credentials");
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
