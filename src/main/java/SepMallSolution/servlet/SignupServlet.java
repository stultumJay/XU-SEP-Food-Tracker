package SepMallSolution.servlet;

import SepMallSolution.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(SignupServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String studentId = request.getParameter("student_id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String status = null;

        // Hash the password
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));

        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO personnel (student_id, first_name, last_name, email, password_hash) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, studentId);
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                ps.setString(4, email);
                ps.setString(5, passwordHash);
                int rowCount = ps.executeUpdate();
                status = (rowCount > 0) ? "success" : "failed";
            }
        } catch (Exception e) {
            logger.error("Signup failed", e);
            status = "failed";
        }
        request.setAttribute("status", status);
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }
} 