package fr.polytech.picknpic.login;

public class LoginFacade {
    private final UserDAO userDAO;

    public LoginFacade(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Authenticate a user.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return A User object if authentication is successful, null otherwise.
     */
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}
