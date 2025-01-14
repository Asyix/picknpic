package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.User;

import java.util.List;

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

    /**
     * Registers a new user.
     *
     * @param email The email of the user.
     * @param password The password of the user.
     * @param username The username of the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param phoneNumber The phone number of the user.
     * @return A {@link User} object if registration is successful,
     *         or {@code null} if the registration fails.
     */
    User register(String email, String password, String username, String firstName, String lastName, int phoneNumber);

    /**
     * Creates a new user.
     *
     * @param email The email of the user.
     * @param password The password of the user.
     * @param username The username of the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param phoneNumber The phone number of the user.
     * @param admin Whether the user is an admin.
     * @return true if the user was created successfully, false otherwise.
     */
    boolean createUser(String email, String password, String username, String firstName, String lastName, int phoneNumber, boolean admin);

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return A {@link User} object containing the user's details.
     */
    User readUser(int id);

    /**
     * Retrieves all users.
     *
     * @param user The user requesting the list.
     * @return A list of {@link User} objects containing the details of all users.
     */
    List<User> getAllUsers(User user);

    /**
     * Updates the details of an existing user.
     *
     * @param user The {@link User} object containing the updated user details.
     * @return true if the user was updated successfully, false otherwise.
     */
    boolean updateUser(User user);

    /**
     * Deletes a user with the specified ID.
     *
     * @param id The ID of the user to delete.
     * @return true if the user was deleted successfully, false otherwise.
     */
    boolean deleteUser(int id);

    /**
     * Follows a user.
     *
     * @param idFollowed The ID of the user to be followed.
     * @param idFollower The ID of the user who is following.
     * @return true if the follow operation was successful, false otherwise.
     */
    boolean followUser(int idFollowed, int idFollower);

    /**
     * Unfollows a user.
     *
     * @param idFollowed The ID of the user to be unfollowed.
     * @param idFollower The ID of the user who is unfollowing.
     * @return true if the unfollow operation was successful, false otherwise.
     */
    boolean unfollowUser(int idFollowed, int idFollower);

    /**
     * Deletes a user account.
     *
     * @param id The ID of the user.
     * @param password The password of the user.
     * @return true if the account was deleted successfully, false otherwise.
     */
    boolean deleteAccount(int id, String password);

    /**
     * Updates a user account.
     *
     * @param user The {@link User} object containing the updated account details.
     * @return true if the account was updated successfully, false otherwise.
     */
    boolean updateAccount(User user);

    /**
     * Checks if a user is following another user.
     *
     * @param idFollowed The ID of the user being followed.
     * @param idFollower The ID of the user who is following.
     * @return true if the user is following, false otherwise.
     */
    boolean isFollowing(int idFollowed, int idFollower);

    /**
     * Retrieves the IDs of users followed by a specific user.
     *
     * @param idFollower The ID of the user whose follows are being retrieved.
     * @return An array of IDs of users followed by the specified user.
     */
    int[] getFollowsIds(int idFollower);
}