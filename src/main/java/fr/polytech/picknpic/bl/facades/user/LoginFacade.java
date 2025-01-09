package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

/**
 * Facade for managing user login operations.
 * Provides a simplified interface for authenticating users by delegating to the DAO layer.
 */
public class LoginFacade {

    /** The authenticated user.
     * This field is used to store the user object after a successful login operation.
     * It is then used to manage the user's session and permissions throughout the application.
     */
    private User currentUser;

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /** The singleton instance of the LoginFacade. */
    private static LoginFacade loginFacade = null;

    /**
     * Constructs a new LoginFacade instance.
     * Initializes the {@link AbstractFactory} singleton for DAO creation.
     */
    private LoginFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the LoginFacade.
     * Ensures that only one instance of the LoginFacade exists throughout the application.
     * @return The singleton instance of the LoginFacade.
     */
    public static LoginFacade getInstance() {
        if (loginFacade == null) {
            loginFacade = new LoginFacade(); // Default factory (PostgreSQL)
        }
        return loginFacade;
    }

    /**
     * Authenticates a user with the given username and password.
     * Delegates the authentication process to the DAO layer.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return A {@link User} object containing the authenticated user's details,
     *         or {@code null} if the credentials are invalid.
     */
    public User login(String username, String password) {
        this.currentUser = abstractFactory.createUserDAO().login(username, password);
        return currentUser;
    }

    /**
     * Retrieves the authenticated user.
     * @return The authenticated user.
     */
    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}
