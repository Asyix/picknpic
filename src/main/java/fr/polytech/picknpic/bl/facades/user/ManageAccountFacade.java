package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

/**
 * The ManageAccountFacade class provides a unified interface to account management operations
 * such as updating and deleting user accounts.
 * It follows the Singleton design pattern to ensure only one instance exists.
 */
public class ManageAccountFacade {
    /** The singleton instance of the ManageAccountFacade. */
    private static ManageAccountFacade instance;

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /**
     * Constructs a new ManageAccountFacade instance.
     * Private constructor to prevent instantiation.
     */
    private ManageAccountFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the ManageAccountFacade.
     * Ensures that only one instance of the ManageAccountFacade exists throughout the application.
     *
     * @return The singleton instance of the ManageAccountFacade.
     */
    public static ManageAccountFacade getInstance() {
        if (instance == null) {
            instance = new ManageAccountFacade();
        }
        return instance;
    }

    /**
     * Updates the details of an existing user account.
     * Delegates the update process to the DAO layer.
     *
     * @param user The {@link User} object containing the updated user details.
     * @return true if the account was updated successfully, false otherwise.
     */
    public boolean updateAccount(User user) {
        return abstractFactory.createUserDAO().updateAccount(user);
    }

    /**
     * Deletes a user account by their ID and password.
     * Delegates the deletion process to the DAO layer.
     *
     * @param id The ID of the user account to delete.
     * @param password The password of the user account to delete.
     * @return true if the account was deleted successfully, false otherwise.
     */
    public boolean deleteAccount(int id, String password) {
        return abstractFactory.createUserDAO().deleteAccount(id, password);
    }
}