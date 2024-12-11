package fr.polytech.picknpic.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * A utility class for managing database connections using the JDBC API.
 * Implements the Singleton design pattern to ensure only one instance exists.
 */
public class JDBCConnector {

    /** The singleton instance of the JDBCConnector. */
    private static JDBCConnector JDBCConnector;

    /** The JDBC URL for the database connection. */
    private static final String URL;

    /** The username for the database connection. */
    private static final String USER;

    /** The password for the database connection. */
    private static final String PASSWORD;

    // Static block to initialize database properties.
    static {
        try (InputStream input = JDBCConnector.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }

            Properties properties = new Properties();
            properties.load(input);

            // Load database properties from the configuration file
            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
        } catch (IOException ex) {
            throw new RuntimeException("Error loading database configuration", ex);
        }
    }

    /**
     * Private constructor to prevent instantiation.
     */
    private JDBCConnector() {}

    /**
     * Retrieves the singleton instance of the JDBCConnector.
     *
     * @return The singleton instance of {@link JDBCConnector}.
     */
    public static JDBCConnector getInstance() {
        if (JDBCConnector == null) {
            JDBCConnector = new JDBCConnector();
        }
        return JDBCConnector;
    }

    /**
     * Establishes and returns a connection to the database.
     *
     * @return A {@link Connection} object to the database.
     * @throws SQLException If a database access error occurs.
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
