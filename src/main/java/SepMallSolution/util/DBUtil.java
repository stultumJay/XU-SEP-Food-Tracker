package SepMallSolution.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.ServletContext;

/**
 * Utility class for providing database connections.
 * Reads DB config from context params in web.xml for security.
 */
public class DBUtil {
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;
    private static boolean initialized = false;
    private static final Logger logger = LoggerFactory.getLogger(DBUtil.class);

    // Prevent instantiation
    private DBUtil() {}

    /**
     * Initialize DB config from ServletContext (should be called once at app startup).
     */
    public static synchronized void init(ServletContext context) {
        if (!initialized) {
            dbUrl = context.getInitParameter("dbUrl");
            dbUser = context.getInitParameter("dbUser");
            dbPassword = context.getInitParameter("dbPassword");
            initialized = true;
        }
    }

    /**
     * Get a new database connection.
     * @return Connection
     */
    public static Connection getConnection() {
        if (!initialized) {
            throw new IllegalStateException("DBUtil not initialized. Call DBUtil.init(context) at startup.");
        }
        try {
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            logger.error("Failed to get DB connection", e);
            throw new RuntimeException("Failed to get DB connection", e);
        }
    }
} 