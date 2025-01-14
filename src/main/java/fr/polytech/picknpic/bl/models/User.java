package fr.polytech.picknpic.bl.models;

/**
 * Represents a user in the Pick'n'Pic application.
 * A user can have various attributes such as email, username,
 * personal details, and a role indicating if they are an admin.
 */
public class User {
    /** The unique identifier of the user. */
    private int id;
    /** The user's email address. */
    private String email;

    /** The user's password. */
    private String password;

    /** The user's unique username. */
    private String username;

    /** The user's first name. */
    private String firstName;

    /** The user's last name. */
    private String lastName;

    /** The user's phone number. */
    private int phoneNumber;

    /** Indicates whether the user has admin privileges. */
    private boolean admin;

    /** The number of followers the user has. */

    private int nbFollowers;

    /** The number of users the user follows. */
    private int nbFollows;

    /**
     * Constructs a new User instance with the specified details.
     *
     * @param email The user's email address.
     * @param password The user's password.
     * @param username The user's unique username.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param phoneNumber The user's phone number.
     * @param admin Indicates whether the user has admin privileges.
     * @param nbFollowers The number of followers the user has.
     * @param nbFollows The number of users the user follows.
     */
    public User(String email, String password, String username, String firstName, String lastName, int phoneNumber, boolean admin, int nbFollowers, int nbFollows) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
        this.nbFollowers = nbFollowers;
        this.nbFollows = nbFollows;
    }

    /**
     * Constructs a new User instance with the specified details.
     *
     * @param id The unique identifier of the user.
     * @param email The user's email address.
     * @param password The user's password.
     * @param username The user's unique username.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param phoneNumber The user's phone number.
     * @param admin Indicates whether the user has admin privileges.
     */
    public User(int id, String email, String password, String username, String firstName, String lastName, int phoneNumber, boolean admin) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
    }

    /**
     * Constructs a new User instance with the specified details.
     *
     * @param id The unique identifier of the user.
     * @param email The user's email address.
     * @param password The user's password.
     * @param username The user's unique username.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param phoneNumber The user's phone number.
     * @param admin Indicates whether the user has admin privileges.
     * @param nbFollowers The number of followers the user has.
     * @param nbFollows The number of users the user follows.
     */
    public User(int id, String email, String password, String username, String firstName, String lastName, int phoneNumber, boolean admin, int nbFollowers, int nbFollows) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
        this.nbFollowers = nbFollowers;
        this.nbFollows = nbFollows;
    }

    /**
     * Constructs a new User instance with default values.
     */
    public User() {
        this.admin = false;
    };

    /**
     * Gets the user's email address.
     *
     * @return the email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email the email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's password.
     *
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's username.
     *
     * @return the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username.
     *
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user's first name.
     *
     * @return the first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName the first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     *
     * @return the last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName the last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's phone number.
     *
     * @return the phone number of the user.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phoneNumber the phone number to set.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Checks if the user has admin privileges.
     *
     * @return true if the user is an admin, false otherwise.
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Sets the user's admin privileges.
     *
     * @param admin true to make the user an admin, false otherwise.
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return the unique identifier of the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the number of followers the user has.
     *
     * @return the number of followers.
     */
    public int getNbFollowers() {
        return nbFollowers;
    }

    /**
     * Gets the number of users the user follows.
     *
     * @return the number of users followed.
     */
    public int getNbFollows() {
        return nbFollows;
    }
}
