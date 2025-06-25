package SepMallSolution.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import SepMallSolution.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/placeOrder")
public class OrderServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(OrderServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentId = (String) session.getAttribute("student_id");
        String[] productNames = request.getParameterValues("productNames");
        String[] quantities = request.getParameterValues("quantities");

        Connection con = null;
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            String query = "INSERT INTO orders (student_id, product_name, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                for (int i = 0; i < productNames.length; i++) {
                    int qty = Integer.parseInt(quantities[i]);
                    if (qty < 1 || qty > 20) {
                        throw new IllegalArgumentException("Invalid quantity: " + qty);
                    }
                    pst.setString(1, studentId);
                    pst.setString(2, productNames[i]);
                    pst.setInt(3, qty);
                    pst.addBatch();
                }
                pst.executeBatch();
            }
            con.commit();
            response.sendRedirect("home.jsp");
        } catch (SQLException | IllegalArgumentException e) {
            logger.error("Order placement failed", e);
            if (con != null) {
                try { con.rollback(); } catch (SQLException ex) { logger.error("Rollback failed", ex); }
            }
            request.setAttribute("errorMessage", e.getMessage() != null ? e.getMessage() : "Order placement failed. Please try again.");
            request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
        } finally {
            if (con != null) {
                try { con.setAutoCommit(true); con.close(); } catch (SQLException ex) { logger.error("Failed to close connection", ex); }
            }
        }
    }
}
