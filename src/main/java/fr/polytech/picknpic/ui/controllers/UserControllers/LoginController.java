package fr.polytech.picknpic.ui.controllers.UserControllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.facades.user.UserFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.ui.controllers.MainController;
import javafx.event.ActionEvent;
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
    private final UserFacade userFacade;

    /** The scene manager for managing scene transitions. */
    private SceneManager sceneManager;

    public LoginController() {
        this.userFacade = UserFacade.getInstance();
    }

    /**
     * Handles the login button action.
     * Authenticates the user and updates the application state based on the result.
     */
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = userFacade.login(username, password);

        if (user != null) {
            // Successful login: Inform MainController and close the login window
            sceneManager.updateCurrentUser();
            sceneManager.loadMainScene();
        } else {
            // Failed login: Display an error message
            messageLabel.setText("Invalid username or password.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }

    public void loadRegister() {
        sceneManager.loadRegisterScene();

    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
