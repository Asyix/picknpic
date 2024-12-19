package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for handling the login view logic.
 * Manages user input for login credentials and communicates with the {@link LoginFacade} to authenticate users.
 */
public class LoginController {

    /** The text field for entering the username. */
    @FXML
    private TextField usernameField;

    /** The password field for entering the password. */
    @FXML
    private PasswordField passwordField;

    /** The label for displaying messages to the user (e.g., error messages). */
    @FXML
    private Label messageLabel;

    /** The facade for handling user login operations. */
    private final LoginFacade loginFacade = new LoginFacade();

    /** The scene manager for transitioning between application views. */
    private SceneManager sceneManager;

    /**
     * Sets the {@link SceneManager} for managing scene transitions.
     *
     * @param sceneManager The {@link SceneManager} instance to set.
     */
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    /**
     * Handles the login button action.
     * Authenticates the user and updates the application state based on the result.
     */
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = loginFacade.login(username, password);

        if (user != null) {
            // Successful login: Set the current user and close the window
            sceneManager.setCurrentUser(user);
            ((Stage) usernameField.getScene().getWindow()).close();
        } else {
            // Failed login: Display an error message
            messageLabel.setText("Invalid username or password.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
