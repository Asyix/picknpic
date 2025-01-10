package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
        String query = "SELECT * FROM \"User\" WHERE username = ? AND password = ?";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    // Populate the User object with data from the database
                    user = new User(resultSet.getInt("id"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("username"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("phone_number"),
                            resultSet.getBoolean("admin"));
                }
            }
        } catch (SQLException e) {
            // Log the exception for debugging purposes
            throw new RuntimeException(e);
        }

        return user;
    }

    /**
     * Registers a new user with the specified details.
     * Inserts a new user record into the PostgreSQL database with the provided information.
     *
     * @param email The email address of the user.
     * @param password The password of the user.
     * @param username The username of the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param phoneNumber The phone number of the user.
     * @return A {@link User} object containing the user's details if registration is successful,
     *         or {@code null} if the operation fails.
     */
    @Override
    public User register(String email, String password, String username, String firstName, String lastName, int phoneNumber) {
        User user = null;
        String query = "INSERT INTO \"User\" (email, password, username, first_name, last_name, phone_number) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, username);
            statement.setString(4, firstName);
            statement.setString(5, lastName);
            statement.setInt(6, phoneNumber);

            try (ResultSet resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    // Populate the User object with data from the database
                    user = new User(resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("username"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("phone_number"),
                            resultSet.getBoolean("admin"));
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public User createUser(String email, String password, String username, String firstName, String lastName, int phoneNumber, boolean admin) {
        User user = null;
        String query = "INSERT INTO \"User\" (email, password, username, first_name, last_name, phone_number, admin) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, username);
            statement.setString(4, firstName);
            statement.setString(5, lastName);
            statement.setInt(6, phoneNumber);
            statement.setBoolean(7, admin);

            try (ResultSet resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    // Populate the User object with data from the database
                    user = new User(resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("username"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("phone_number"),
                            resultSet.getBoolean("admin"));
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return user;
    }

    @Override
    public User readUser(int id) {
        User user = null;
        String query = "SELECT * FROM \"User\" WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    user = new User(resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("username"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("phone_number"),
                            resultSet.getBoolean("admin"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public List<User> getAllUsers(User user) {
        List<User> users = null;
        String query = "SELECT * FROM \"User\"";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                user = new User(resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("username"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("phone_number"),
                        resultSet.getBoolean("admin"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public boolean updateUser(User user) {
        String query = "UPDATE \"User\" SET email = ?, password = ?, username = ?, first_name = ?, last_name = ?, phone_number = ?, admin = ? WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setInt(6, user.getPhoneNumber());
            statement.setBoolean(7, user.isAdmin());
            statement.setInt(8, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        String query = "DELETE FROM \"User\" WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public boolean followUser(int idFollowed, int idFollower) {
        String query = "INSERT INTO \"Follow\" (id_followed, id_follower) VALUES (?, ?)";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFollowed);
            statement.setInt(2, idFollower);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public boolean unfollowUser(int idFollowed, int idFollower) {
        String query = "DELETE FROM \"Follow\" WHERE id_followed = ? AND id_follower = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFollowed);
            statement.setInt(2, idFollower);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public boolean deleteAccount(int id, String password) {
        if (LoginFacade.getInstance().getCurrentUser().getId() != id) {
            return false;
        }
        else {
            String query = "DELETE FROM \"User\" WHERE id = ? AND password = ?";
            try (Connection connection = JDBCConnector.getInstance().getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.setString(2, password);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return true;
        }

    }

    @Override
    public boolean updateAccount(User user) {
        if (LoginFacade.getInstance().getCurrentUser().getId() != user.getId()) {
            return false;
        }
        else {
            String query = "UPDATE \"User\" SET email = ?, password = ?, username = ?, first_name = ?, last_name = ?, phone_number = ? WHERE id = ?";
            try (Connection connection = JDBCConnector.getInstance().getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getUsername());
                statement.setString(4, user.getFirstName());
                statement.setString(5, user.getLastName());
                statement.setInt(6, user.getPhoneNumber());
                statement.setInt(7, user.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return true;
        }
    }
}