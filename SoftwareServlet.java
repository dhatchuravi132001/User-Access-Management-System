package com.example.servlets;

import com.example.servlets.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SoftwareServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String softwareName = request.getParameter("softwareName");
        String description = request.getParameter("description");
        String[] accessLevels = request.getParameterValues("accessLevels");

        try {
            Connection conn = DBConnection.initializeDatabase();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)");
            ps.setString(1, softwareName);
            ps.setString(2, description);
            ps.setString(3, String.join(",", accessLevels)); // Store selected access levels
            ps.executeUpdate();

            ps.close();
            conn.close();

            response.sendRedirect("createSoftware.jsp?success=Software created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
