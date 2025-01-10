package fr.polytech.picknpic.ui;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.controllers.MainController;
import fr.polytech.picknpic.ui.controllers.MainLayoutController;
import fr.polytech.picknpic.ui.controllers.NavbarController;
import fr.polytech.picknpic.ui.controllers.UserControllers.*;
import javafx.scene.Parent;
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

    /** The main layout controller for managing the main application layout. */
    private MainLayoutController mainLayoutController;

    private Stage currentStage;

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


    private void loadMainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/mainLayout.fxml"));
            Scene scene = new Scene(loader.load());

            mainLayoutController = loader.getController();
            mainLayoutController.setSceneManager(this); // Pass SceneManager to MainLayoutController

            loadMainScene();

            primaryStage.setScene(scene);
            primaryStage.setTitle("Pick'n'Pic");
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load main layout", e);
        }
    }

    public void handleLogin() {
        loadMainLayout();
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

            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.sizeToScene();
            primaryStage.show(); // Pause until login is complete
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

            primaryStage.setScene(scene);
            primaryStage.setTitle("Register");
            primaryStage.sizeToScene();
            primaryStage.show(); // Pause until registration is complete
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadMainScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/hello.fxml"));
            Parent content = loader.load();
            MainController mainController = loader.getController();
            mainController.setSceneManager(this);
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void loadProfileScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/User/profile.fxml"));
            Parent content = loader.load();
            ProfileController profileController = loader.getController();
            profileController.setSceneManager(this);
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadManageUsersScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/User/manageUsers.fxml"));
            Parent content = loader.load();
            ManageUsersController manageUsersController = loader.getController();
            manageUsersController.setSceneManager(this);
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadUpdateAccountScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/User/updateAccount.fxml"));
            Parent content = loader.load();
            UpdateAccountController updateAccountController = loader.getController();
            updateAccountController.setSceneManager(this);
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadPostsScene() {
    }

    public void loadNotificationsScene() {
    }

    public void loadChatScene() {
    }


    public void loadReportsScene() {
    }
}
