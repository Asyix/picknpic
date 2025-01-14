package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

/**
 * The DisplayUsersFacade class provides a unified interface to user display operations
 * such as retrieving user details and listing all users.
 * It follows the Singleton design pattern to ensure only one instance exists.
 */
public class DisplayUsersFacade {
    /** The singleton instance of the DisplayUsersFacade. */
    private static DisplayUsersFacade instance;

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /**
     * Constructs a new DisplayUsersFacade instance.
     * Private constructor to prevent instantiation.
     */
    private DisplayUsersFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the DisplayUsersFacade.
     * Ensures that only one instance of the DisplayUsersFacade exists throughout the application.
     *
     * @return The singleton instance of the DisplayUsersFacade.
     */
    public static DisplayUsersFacade getInstance() {
        if (instance == null) {
            instance = new DisplayUsersFacade();
        }
        return instance;
    }

    /**
     * Retrieves a user by their ID.
     * Delegates the retrieval process to the DAO layer.
     *
     * @param id The ID of the user to retrieve.
     * @return A {@link User} object containing the user's details.
     */
    public User readUser(int id) {
        return abstractFactory.createUserDAO().readUser(id);
    }

    /**
     * Retrieves all users.
     * Delegates the retrieval process to the DAO layer.
     *
     * @return A list of {@link User} objects containing the details of all users.
     */
    public List<User> getAllUsers(User user) {
        return abstractFactory.createUserDAO().getAllUsers(user);
    }

    /**
     * Updates the details of an existing user.
     * Delegates the update process to the DAO layer.
     *
     * @param user The {@link User} object containing the updated user details.
     */
    public void updateUser(User user) {
        abstractFactory.createUserDAO().updateUser(user);
    }

    /**
     * Deletes a user with the specified ID.
     * Delegates the deletion process to the DAO layer.
     *
     * @param id The ID of the user to delete.
     */
    public void deleteUser(int id) {
        abstractFactory.createUserDAO().deleteUser(id);
    }
}