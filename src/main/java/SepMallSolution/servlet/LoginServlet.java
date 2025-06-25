package SepMallSolution.servlet;

import SepMallSolution.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Make sure to add the BCrypt dependency in your pom.xml:
// <dependency>
//   <groupId>org.mindrot</groupId>
//   <artifactId>jbcrypt</artifactId>
//   <version>0.4</version>
// </dependency>
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("student_id");
        String password = request.getParameter("password");
        String errorMessage = null;

        try (Connection con = DBUtil.getConnection()) {
            String sql = "SELECT password_hash FROM personnel WHERE student_id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, studentId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String hash = rs.getString("password_hash");
                        if (BCrypt.checkpw(password, hash)) {
                            HttpSession session = request.getSession(true);
                            session.setAttribute("student_id", studentId);
                            response.sendRedirect("home.jsp");
                            return;
                        } else {
                            errorMessage = "Incorrect Student ID or Password. Please try again.";
                        }
                    } else {
                        errorMessage = "Incorrect Student ID or Password. Please try again.";
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Login failed", e);
            errorMessage = "An error occurred. Please try again later.";
        }
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return;
    }
} 