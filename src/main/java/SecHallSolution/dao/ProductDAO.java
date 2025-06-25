package SecHallSolution.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SecHallSolution.model.Product;
import SecHallSolution.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);
    // SQL query as a constant, select only needed columns
    private static final String GET_ALL_PRODUCTS = "SELECT product_name, price, image_url FROM product";

    /**
     * Fetch all products from the database.
     * @return List of Product objects
     */
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_ALL_PRODUCTS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String title = rs.getString("product_name");
                double price = rs.getDouble("price");
                String imageUrl = rs.getString("image_url");
                products.add(new Product(title, price, imageUrl));
            }
        } catch (SQLException e) {
            logger.error("Error fetching products", e);
            throw new RuntimeException("Error fetching products", e);
        }
        return products;
    }
}
