package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;

public class UserFacade {

    /** The singleton instance of the UserFacade. */
    private static UserFacade userFacade = null;
    /** The singleton LoginFacade instance used to authenticate users. */
    private final LoginFacade loginFacade;
    /** The singleton instance of the RegisterFacade. */
    private final RegisterFacade registerFacade;
    /** The singleton instance of the ManageUsersFacade. */
    private final ManageUsersFacade manageUsersFacade;
    /** The singleton instance of the DisplayUsersFacade. */
    private final DisplayUsersFacade displayUsersFacade;

    /**
     * Constructs a new UserFacade instance.
     * Initializes the LoginFacade and RegisterFacade singletons.
     */
    private UserFacade() {
        loginFacade = LoginFacade.getInstance();
        registerFacade = RegisterFacade.getInstance();
        manageUsersFacade = ManageUsersFacade.getInstance();
        displayUsersFacade = DisplayUsersFacade.getInstance();
    }

    /**
     * Retrieves the singleton instance of the UserFacade.
     * Ensures that only one instance of the UserFacade exists throughout the application.
     * @return The singleton instance of the UserFacade.
     */
    public static UserFacade getInstance() {
        if (userFacade == null) {
            userFacade = new UserFacade();
        }
        return userFacade;
    }

    /**
     * Authenticates a user with the given username and password.
     * Delegates the authentication process to the LoginFacade.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return A {@link User} object containing the authenticated user's details,
     *         or {@code null} if the credentials are invalid.
     */
    public User login(String username, String password) {
        return loginFacade.login(username, password);
    }

    /**
     * Registers a new user with the specified details.
     * Delegates the registration process to the RegisterFacade.
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
        return registerFacade.register(email, password, username, firstName, lastName, phoneNumber);
    }

    public boolean createUser(String email, String password, String username, String firstName, String lastName, int phoneNumber, boolean admin) {
        return manageUsersFacade.createUser(email, password, username, firstName, lastName, phoneNumber, admin);
    }



    public boolean updateUser(User user) {
        return manageUsersFacade.updateUser(user);
    }

    public void deleteUser(int id) {
        manageUsersFacade.deleteUser(id);
    }

    public User readUser(int id) {
        return displayUsersFacade.readUser(id);
    }
}
