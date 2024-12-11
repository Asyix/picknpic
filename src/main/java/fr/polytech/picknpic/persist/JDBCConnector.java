package fr.polytech.picknpic.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCConnector {

    // Singleton instance
    private static JDBCConnector JDBCConnector;

    // JDBC URL, username, and password
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    // Static block to load properties
    static {
        try (InputStream input = JDBCConnector.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }

            Properties properties = new Properties();
            properties.load(input);

            // Load database properties
            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
        } catch (IOException ex) {
            throw new RuntimeException("Error loading database configuration", ex);
        }
    }

    // Private constructor to prevent instantiation
    private JDBCConnector() {}

    // Static method to get the singleton instance
    public static JDBCConnector getInstance() {
        if (JDBCConnector == null) {
            JDBCConnector = new JDBCConnector();
        }
        return JDBCConnector;
    }

    // Method to get a database connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
