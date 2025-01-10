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
    private static Stage primaryStage;

    /** The main layout controller for managing the main application layout. */
    private static MainLayoutController mainLayoutController;

    /**
     * Constructs a new {@link SceneManager} instance.
     *
     * @param primaryStage The primary stage of the application.
     */
    public SceneManager(Stage primaryStage) {
        SceneManager.primaryStage = primaryStage;
    }

    /**
     * Loads the initial main scene and initializes the {@link MainController}.
     *
     * @throws Exception If an error occurs during the scene loading process.
     */
    public static void loadInitialScene() throws Exception {
        loadLoginScene();
    }

    private static void loadMainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/mainLayout.fxml"));
            Scene scene = new Scene(loader.load());

            mainLayoutController = loader.getController();

            loadMainScene();

            primaryStage.setScene(scene);
            primaryStage.setTitle("Pick'n'Pic");
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load main layout", e);
        }
    }

    public static void handleLogin() {
        loadMainLayout();
    }

    /**
     * Loads the login scene and initializes the {@link LoginController}.
     */
    public static void loadLoginScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/login.fxml"));
            Scene scene = new Scene(loader.load());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.sizeToScene();
            primaryStage.show(); // Pause until login is complete
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadRegisterScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/register.fxml"));
            Scene scene = new Scene(loader.load());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Register");
            primaryStage.sizeToScene();
            primaryStage.show(); // Pause until registration is complete
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadMainScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/hello.fxml"));
            Parent content = loader.load();
            MainController mainController = loader.getController();
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

    public static void loadProfileScene(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/profile.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                ProfileController profileController = loader.getController();
                profileController.initializeWithUser(user);
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadManageUsersScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/manageUsers.fxml"));
            Parent content = loader.load();
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

    public static void loadUpdateAccountScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/updateAccount.fxml"));
            Parent content = loader.load();
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

    public static void loadPostsScene() {
        // Implementation for loading posts scene
    }

    public static void loadNotificationsScene() {
        // Implementation for loading notifications scene
    }

    public static void loadChatScene() {
        // Implementation for loading chat scene
    }

    public static void loadReportsScene() {
        // Implementation for loading reports scene
    }
}