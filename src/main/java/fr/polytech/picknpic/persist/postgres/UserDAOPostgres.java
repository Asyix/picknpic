package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PostgreSQL implementation of the {@link UserDAO} interface.
 * Provides methods for user authentication by interacting with the PostgreSQL database.
 */
public class UserDAOPostgres implements UserDAO {

    /**
     * Authenticates a user by their username and password.
     * Queries the PostgreSQL database for a matching user and retrieves their information if authenticated.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return A {@link User} object containing the user's details if authentication is successful,
     *         or {@code null} if no match is found.
     */
    @Override
    public User login(String username, String password) {
        User user = null;

        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            String query = "SELECT * FROM \"User\" WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Populate the User object with data from the database
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPhoneNumber(resultSet.getInt("phone_number"));
                user.setAdmin(resultSet.getBoolean("admin"));
            }
        } catch (SQLException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
        }

        return user;
    }
}
