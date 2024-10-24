package com.example.servlets;

import com.example.servlets.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ApprovalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestId = request.getParameter("requestId");
        String action = request.getParameter("action");

        try {
            Connection conn = DBConnection.initializeDatabase();
            PreparedStatement ps = conn.prepareStatement("UPDATE requests SET status = ? WHERE id = ?");
            ps.setString(1, action.equals("approve") ? "Approved" : "Rejected");
            ps.setString(2, requestId);
            ps.executeUpdate();

            ps.close();
            conn.close();

            response.sendRedirect("pendingRequests.jsp?success=Request updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
