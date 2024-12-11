package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

/**
 * Facade for managing user login operations.
 * Provides a simplified interface for authenticating users by delegating to the DAO layer.
 */
public class LoginFacade {

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /**
     * Constructs a new LoginFacade instance.
     * Initializes the {@link AbstractFactory} singleton for DAO creation.
     */
    public LoginFacade() {
        this.abstractFactory = AbstractFactory.getAbstractFactoryInstance();
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
        return abstractFactory.createUserDAO().login(username, password);
    }
}
