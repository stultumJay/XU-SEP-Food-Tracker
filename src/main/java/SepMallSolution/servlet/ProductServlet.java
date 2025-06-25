package SepMallSolution.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import SepMallSolution.dao.ProductDAO;
import SepMallSolution.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/home")
public class ProductServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        // DBUtil.init(getServletContext()); // Removed, now handled by AppContextListener
    }
}
