package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

public class RegisterFacade {

    /** The singleton instance of the RegisterFacade. */
    private static RegisterFacade registerFacade = null;
    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory factory = AbstractFactory.getInstance();

    private RegisterFacade() {}
    /**
     * Retrieves the singleton instance of the RegisterFacade.
     * Ensures that only one instance of the RegisterFacade exists throughout the application.
     * @return The singleton instance of the RegisterFacade.
     */
    public static RegisterFacade getInstance() {
        if (registerFacade == null) {
            registerFacade = new RegisterFacade();
        }
        return registerFacade;
    }

    /**
     * Registers a new user with the specified details.
     * Delegates the registration process to the DAO layer.
     *
     * @param email The email address of the user to register.
     * @param password The password of the user to register.
     * @param username The username of the user to register.
     * @param firstName The first name of the user to register.
     * @param lastName The last name of the user to register.
     * @param phoneNumber The phone number of the user to register.
     * @return A {@link User} object containing the registered user's details.
     */
    public User register(String email, String password, String username, String firstName, String lastName, int phoneNumber) {
        return factory.createUserDAO().register(email, password, username, firstName, lastName, phoneNumber);
    }
}
