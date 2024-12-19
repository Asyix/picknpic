package fr.polytech.picknpic.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    /** The scene manager for managing scene transitions. */
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
     * Updates the welcome message on the screen.
     *
     * @param message The message to display on the welcome label.
     */
    public void updateWelcomeMessage(String message) {
        welcomeLabel.setText(message);
    }

    /**
     * Handles the login button action.
     * Opens the login scene and waits for user interaction.
     */
    @FXML
    private void handleLogin() {
        sceneManager.loadLoginScene();
    }
}
