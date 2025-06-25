package SecHallSolution.servlet;

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

import SecHallSolution.util.DBUtil;
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

        try (Connection con = DBUtil.getConnection()) {
            con.setAutoCommit(false);
            String query = "INSERT INTO orders (product_name, quantity) VALUES (?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                for (int i = 0; i < productNames.length; i++) {
                    pst.setString(1, productNames[i]);
                    pst.setInt(2, Integer.parseInt(quantities[i]));
                    pst.addBatch();
                }
                pst.executeBatch();
            }
            con.commit();
            response.sendRedirect("home.jsp");
        } catch (SQLException e) {
            logger.error("Order placement failed", e);
            try { con.rollback(); } catch (SQLException ex) { logger.error("Rollback failed", ex); }
            request.setAttribute("errorMessage", "Order placement failed. Please try again.");
            request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
        }
    }
}
