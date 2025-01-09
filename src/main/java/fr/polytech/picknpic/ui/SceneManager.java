package fr.polytech.picknpic.ui;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.controllers.MainController;
import fr.polytech.picknpic.ui.controllers.UserControllers.AddUserController;
import fr.polytech.picknpic.ui.controllers.UserControllers.LoginController;
import fr.polytech.picknpic.ui.controllers.UserControllers.ManageUsersController;
import fr.polytech.picknpic.ui.controllers.UserControllers.RegisterController;
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
    private User currentUser = LoginFacade.getInstance().getCurrentUser();

    /**
     * Constructs a new {@link SceneManager} instance.
     *
     * @param primaryStage The primary stage of the application.
     */
    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Updates the current user state by fetching the latest user from the {@link LoginFacade}.
     */
    public void updateCurrentUser() {
        this.currentUser = LoginFacade.getInstance().getCurrentUser();
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
        loadLoginScene();
    }


    /**
     * Loads the login scene and initializes the {@link LoginController}.
     */
    public void loadLoginScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/User/login.fxml"));
            Scene scene = new Scene(loader.load());

            LoginController loginController = loader.getController();
            loginController.setSceneManager(this);

            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.setTitle("Login");
            loginStage.showAndWait(); // Pause until login is complete
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadRegisterScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/User/register.fxml"));
            Scene scene = new Scene(loader.load());

            RegisterController registerController = loader.getController();
            registerController.setSceneManager(this);

            Stage registerStage = new Stage();
            registerStage.setScene(scene);
            registerStage.setTitle("Register");
            registerStage.showAndWait(); // Pause until registration is complete
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadManageUsersScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/User/manageUsers.fxml"));
            Scene scene = new Scene(loader.load());

            ManageUsersController manageUsersController = loader.getController();
            manageUsersController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Manage Users");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadMainScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/hello.fxml"));
            Scene scene = new Scene(loader.load());

            MainController mainController = loader.getController();
            mainController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Pick'n'Pic");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
