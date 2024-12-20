package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.ui.controllers.UserControllers.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
     * Opens the login scene, waits for user interaction, and informs {@link SceneManager} if login is successful.
     */
    @FXML
    private void handleLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/login.fxml"));
            Scene scene = new Scene(loader.load());

            LoginController loginController = loader.getController();
            loginController.setMainController(this);

            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.setTitle("Login");
            loginStage.showAndWait(); // Pause until login is complete
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the successful login of a user.
     * Updates the {@link SceneManager} with the logged-in user.
     *
     * @param user The successfully logged-in user.
     */
    public void onUserLoggedIn(User user) {
        sceneManager.setCurrentUser(user);
    }
}
