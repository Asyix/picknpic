package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

public class ManageUsersFacade {
    private static ManageUsersFacade instance;

    private final AbstractFactory abstractFactory;

    private ManageUsersFacade() { this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the ManageUsersFacade.
     * Ensures that only one instance of the ManageUsersFacade exists throughout the application.
     * @return The singleton instance of the ManageUsersFacade.
     */
    public static ManageUsersFacade getInstance() {
        if (instance == null) {
            instance = new ManageUsersFacade();
        }
        return instance;
    }

    /**
     * Creates a new user with the specified details.
     * Delegates the creation process to the DAO layer.
     *
     * @param email The email address of the user to create.
     * @param password The password of the user to create.
     * @param username The username of the user to create.
     * @param firstName The first name of the user to create.
     * @param lastName The last name of the user to create.
     * @param phoneNumber The phone number of the user to create.
     * @param admin The admin status of the user to create.
     * @return A {@link User} object containing the created user's details.
     */
    public User createUser(String email, String password, String username, String firstName, String lastName, int phoneNumber, boolean admin) {
        return abstractFactory.createUserDAO().createUser(email, password, username, firstName, lastName, phoneNumber, admin);
    }


    public boolean updateUser(User user) {
        return abstractFactory.createUserDAO().updateUser(user);
    }

    /**
     * Deletes a user by their ID.
     * Delegates the deletion process to the DAO layer.
     *
     * @param id The ID of the user to delete.
     */
    public boolean deleteUser(int id) {
        return abstractFactory.createUserDAO().deleteUser(id);
    }
}
