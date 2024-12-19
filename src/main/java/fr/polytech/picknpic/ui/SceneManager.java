package fr.polytech.picknpic.ui;

import fr.polytech.picknpic.bl.models.User;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Manages scenes and user interactions within the application.
 * Handles navigation between different views and maintains the current user state.
 */
public class SceneManager {

    /** The primary stage of the application. */
    private final Stage primaryStage;

    /** The currently logged-in user. */
    private User currentUser;

    /** The main controller responsible for the main scene. */
    private MainController mainController;

    /**
     * Constructs a new {@link SceneManager} instance.
     *
     * @param primaryStage The primary stage of the application.
     */
    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Sets the currently logged-in user and updates the main controller's welcome message.
     *
     * @param user The user to set as the currently logged-in user.
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
        updateMainControllerWelcomeMessage("Hello " + user.getUsername() + "!");
    }

    /**
     * Retrieves the currently logged-in user.
     *
     * @return The current {@link User}, or {@code null} if no user is logged in.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Loads the initial main scene and initializes the {@link MainController}.
     *
     * @throws Exception If an error occurs during the scene loading process.
     */
    public void loadInitialScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/hello.fxml"));
        Scene scene = new Scene(loader.load());

        mainController = loader.getController();
        mainController.setSceneManager(this);

        primaryStage.setTitle("Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Updates the main controller's welcome message.
     *
     * @param message The message to display on the main screen.
     */
    private void updateMainControllerWelcomeMessage(String message) {
        if (mainController != null) {
            mainController.updateWelcomeMessage(message);
        }
    }
}
