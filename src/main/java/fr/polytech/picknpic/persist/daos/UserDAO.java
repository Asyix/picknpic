package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.User;

/**
 * Interface for Data Access Object (DAO) operations related to the User entity.
 * Provides methods for user authentication and data retrieval.
 */
public interface UserDAO {

    /**
     * Authenticates a user by their username and password.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return A {@link User} object if authentication is successful,
     *         or {@code null} if the credentials are invalid.
     */
    User login(String username, String password);
}
