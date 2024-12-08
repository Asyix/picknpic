package fr.polytech.picknpic.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

    // Singleton instance
    private static JDBCConnector instance;

    // JDBC URL, username, and password
    private static final String URL = "jdbc:postgresql://localhost:5432/LoginDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "your_password";

    // Private constructor to prevent instantiation
    private JDBCConnector() {}

    // Static method to get the singleton instance
    public static JDBCConnector getInstance() {
        if (instance == null) {
            instance = new JDBCConnector();
        }
        return instance;
    }

    // Method to get a database connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
