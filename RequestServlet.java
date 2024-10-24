package com.example.servlets;

import com.example.servlets.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String softwareId = request.getParameter("softwareId");
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        try {
            Connection conn = DBConnection.initializeDatabase();

            // Get user ID from username
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt("id");
            }

            // Insert request
            ps = conn.prepareStatement("INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, 'Pending')");
            ps.setInt(1, userId);
            ps.setString(2, softwareId);
            ps.setString(3, accessType);
            ps.setString(4, reason);
            ps.executeUpdate();

            ps.close();
            conn.close();

            response.sendRedirect("requestAccess.jsp?success=Request submitted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
