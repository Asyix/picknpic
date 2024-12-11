package fr.polytech.picknpic;

import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Controller for the main application view.
 * Manages interactions on the main screen, including navigation to the login scene.
 */
public class MainController {

    /** The button for navigating to the login scene. */
    @FXML
    private Button loginButton;

    /** The label for displaying a welcome message. */
    @FXML
    private Label welcomeLabel;

    /** The scene manager for managing scene transitions and user state. */
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
     * Opens the login scene in a new stage, waits for user interaction,
     * and updates the welcome message upon successful login.
     */
    @FXML
    private void handleLogin() {
        // Open the login scene in a new stage
        Stage loginStage = new Stage();
        boolean success = sceneManager.loadLoginScene(loginStage);

        // Update the welcome label if login is successful
        if (success && sceneManager.getCurrentUser() != null) {
            welcomeLabel.setText("Hello " + sceneManager.getCurrentUser().getUsername() + "!");
        }
    }
}
