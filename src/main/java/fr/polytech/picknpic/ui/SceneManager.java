package fr.polytech.picknpic.ui;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Manages scenes and user interactions within the application.
 * Handles navigation between different application views and maintains the current user state.
 */
public class SceneManager {

    /** The primary stage of the application. */
    private final Stage primaryStage;

    /** The facade responsible for managing user login operations. */
    private final LoginFacade loginFacade;

    /** The currently logged-in user. */
    private User currentUser;

    /**
     * Constructs a new SceneManager instance.
     *
     * @param primaryStage The primary stage of the application.
     */
    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.loginFacade = new LoginFacade();
    }

    /**
     * Loads the login scene and displays it in the specified stage.
     * The method initializes the {@link LoginController} and sets required dependencies.
     *
     * @param loginStage The stage where the login scene will be displayed.
     * @return {@code true} if a user successfully logs in, {@code false} otherwise.
     */
    public boolean loadLoginScene(Stage loginStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/login.fxml"));
            Scene scene = new Scene(loader.load());
            LoginController controller = loader.getController();

            // Inject the LoginFacade and SceneManager into the LoginController
            controller.setLoginFacade(loginFacade);
            controller.setSceneManager(this);

            loginStage.setScene(scene);
            loginStage.setTitle("Login");
            loginStage.showAndWait();

            return currentUser != null; // Return true if a user is logged in
        } catch (Exception e) {
            e.printStackTrace(); // Log exceptions for debugging
            return false;
        }
    }

    /**
     * Sets the currently logged-in user.
     *
     * @param user The user to set as the currently logged-in user.
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    /**
     * Retrieves the currently logged-in user.
     *
     * @return The currently logged-in {@link User}, or {@code null} if no user is logged in.
     */
    public User getCurrentUser() {
        return currentUser;
    }
}
