package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    /**
     * Creates a new user with the specified details.
     * Inserts a new user record into the PostgreSQL database with the provided information.
     *
     * @param email The email address of the user.
     * @param password The password of the user.
     * @param username The username of the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param phoneNumber The phone number of the user.
     * @param admin The admin status of the user.
     * @return {@code true} if the user was created successfully, {@code false} otherwise.
     */
    @Override
    public boolean createUser(String email, String password, String username, String firstName, String lastName, int phoneNumber, boolean admin) {
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
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return true;
    }

    /**
     * Retrieves a user by their unique identifier.
     * Queries the PostgreSQL database for a user with the specified ID and returns their details.
     *
     * @param id The unique identifier of the user to retrieve.
     * @return A {@link User} object containing the user's details if found, or {@code null} if no match is found.
     */
    @Override
    public User readUser(int id) {
        User user = null;
        String query = "SELECT * FROM \"User\" WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    user = new User(resultSet.getInt("id"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("username"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("phone_number"),
                            resultSet.getBoolean("admin"),
                            resultSet.getInt("nb_followers"),
                            resultSet.getInt("nb_follows"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    /**
     * Retrieves a user by their unique username.
     * Queries the PostgreSQL database for a user with the specified username and returns their details.
     *
     * @param user The username of the user to retrieve.
     * @return A {@link User} object containing the user's details if found, or {@code null} if no match is found.
     */
    @Override
    public List<User> getAllUsers(User user) {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM \"User\"";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("email"),
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

    /**
     * Retrieves a user by their unique username.
     * Queries the PostgreSQL database for a user with the specified username and returns their details.
     *
     * @param user The username of the user to retrieve.
     * @return A {@link User} object containing the user's details if found, or {@code null} if no match is found.
     */
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

    /**
     * Deletes a user by their unique identifier.
     * Removes the user record from the PostgreSQL database with the specified ID.
     *
     * @param id The unique identifier of the user to delete.
     * @return {@code true} if the user was deleted successfully, {@code false} otherwise.
     */
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

    /**
     * Follows a user.
     * Inserts a follow record into the PostgreSQL database and updates the follower and followee counts.
     *
     * @param idFollowed The ID of the user to be followed.
     * @param idFollower The ID of the user who is following.
     * @return {@code true} if the follow operation was successful, {@code false} otherwise.
     */
    @Override
    public boolean followUser(int idFollowed, int idFollower) {
        String insertFollowQuery = "INSERT INTO \"Follow\" (id_followed, id_follower) VALUES (?, ?)";
        String updateFollowersQuery = "UPDATE \"User\" SET nb_followers = nb_followers + 1 WHERE id = ?";
        String updateFollowsQuery = "UPDATE \"User\" SET nb_follows = nb_follows + 1 WHERE id = ?";

        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false); // Start transaction

            try (PreparedStatement insertFollowStmt = connection.prepareStatement(insertFollowQuery);
                 PreparedStatement updateFollowersStmt = connection.prepareStatement(updateFollowersQuery);
                 PreparedStatement updateFollowsStmt = connection.prepareStatement(updateFollowsQuery)) {

                // Execute insert follow query
                insertFollowStmt.setInt(1, idFollowed);
                insertFollowStmt.setInt(2, idFollower);
                insertFollowStmt.executeUpdate();

                // Execute update followers query
                updateFollowersStmt.setInt(1, idFollowed);
                updateFollowersStmt.executeUpdate();

                // Execute update follows query
                updateFollowsStmt.setInt(1, idFollower);
                updateFollowsStmt.executeUpdate();

                connection.commit(); // Commit transaction
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction on error
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    /**
     * Unfollows a user.
     * Deletes a follow record from the PostgreSQL database and updates the follower and followee counts.
     *
     * @param idFollowed The ID of the user to be unfollowed.
     * @param idFollower The ID of the user who is unfollowing.
     * @return {@code true} if the unfollow operation was successful, {@code false} otherwise.
     */
    @Override
    public boolean unfollowUser(int idFollowed, int idFollower) {
        String deleteFollowQuery = "DELETE FROM \"Follow\" WHERE id_followed = ? AND id_follower = ?";
        String updateFollowersQuery = "UPDATE \"User\" SET nb_followers = nb_followers - 1 WHERE id = ?";
        String updateFollowsQuery = "UPDATE \"User\" SET nb_follows = nb_follows - 1 WHERE id = ?";

        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false); // Start transaction

            try (PreparedStatement deleteFollowStmt = connection.prepareStatement(deleteFollowQuery);
                 PreparedStatement updateFollowersStmt = connection.prepareStatement(updateFollowersQuery);
                 PreparedStatement updateFollowsStmt = connection.prepareStatement(updateFollowsQuery)) {

                // Execute delete follow query
                deleteFollowStmt.setInt(1, idFollowed);
                deleteFollowStmt.setInt(2, idFollower);
                deleteFollowStmt.executeUpdate();

                // Execute update followers query
                updateFollowersStmt.setInt(1, idFollowed);
                updateFollowersStmt.executeUpdate();

                // Execute update follows query
                updateFollowsStmt.setInt(1, idFollower);
                updateFollowsStmt.executeUpdate();

                connection.commit(); // Commit transaction
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction on error
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    /**
     * Deletes a user account if the provided password matches.
     * Removes the user record from the PostgreSQL database with the specified ID and password.
     *
     * @param id The unique identifier of the user to delete.
     * @param password The password of the user to delete.
     * @return {@code true} if the account was deleted successfully, {@code false} otherwise.
     */
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

    /**
     * Updates the account details of the current user.
     * Modifies the user record in the PostgreSQL database with the provided information.
     *
     * @param user The user object containing the updated details.
     * @return {@code true} if the account was updated successfully, {@code false} otherwise.
     */
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

    /**
     * Checks if a user is following another user.
     * Queries the PostgreSQL database to determine if a follow record exists between the specified users.
     *
     * @param idFollowed The ID of the user being followed.
     * @param idFollower The ID of the user following.
     * @return {@code true} if the user is following, {@code false} otherwise.
     */
    @Override
    public boolean isFollowing(int idFollowed, int idFollower) {
        String query = "SELECT * FROM \"Follow\" WHERE id_followed = ? AND id_follower = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFollowed);
            statement.setInt(2, idFollower);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the IDs of users followed by the specified user.
     * Queries the PostgreSQL database for the IDs of users followed by the specified user.
     *
     * @param id_follower The ID of the user who is following.
     * @return An array of user IDs that the specified user is following.
     */
    @Override
    public int[] getFollowsIds(int id_follower) {
        int[] followsIds;
        String query = "SELECT id_followed FROM \"Follow\" WHERE id_follower = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            statement.setInt(1, id_follower);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.last();
                followsIds = new int[resultSet.getRow()];
                resultSet.beforeFirst();
                int i = 0;
                while (resultSet.next()) {
                    followsIds[i] = resultSet.getInt("id_followed");
                    i++;
                }
                return followsIds;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}