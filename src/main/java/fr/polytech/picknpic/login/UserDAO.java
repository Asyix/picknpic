package fr.polytech.picknpic.login;

public interface UserDAO {
    /**
     * Authenticate a user by username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return A User object if authentication is successful, null otherwise.
     */
    User login(String username, String password);
}
