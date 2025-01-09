package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

public class DisplayUsersFacade {
    private static DisplayUsersFacade instance;

    private final AbstractFactory abstractFactory;

    private DisplayUsersFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the DisplayUsersFacade.
     * Ensures that only one instance of the DisplayUsersFacade exists throughout the application.
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
