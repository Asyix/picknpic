package fr.polytech.picknpic.ui;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.controllers.MainController;
import fr.polytech.picknpic.ui.controllers.UserControllers.AddUserController;
import fr.polytech.picknpic.ui.controllers.UserControllers.LoginController;
import fr.polytech.picknpic.ui.controllers.UserControllers.ManageUsersController;
import fr.polytech.picknpic.ui.controllers.UserControllers.RegisterController;
import fr.polytech.picknpic.ui.controllers.ServiceControllers.*;
import fr.polytech.picknpic.ui.controllers.GradeControllers.*;
import fr.polytech.picknpic.ui.controllers.RequestControllers.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.fxml.FXML;

/**
 * Manages scenes and user interactions within the application.
 * Handles navigation between different views and maintains the current user state.
 */
public class SceneManager {

    /** The primary stage of the application. */
    private final Stage primaryStage;

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
            primaryStage.setScene(scene);
            primaryStage.show(); // Pause until registration is complete
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


    // The following methods are related to the Request use-case

    /**
     * Loads the create request scene.
     */
    @FXML
    public void loadCreateRequestScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Request/createRequest.fxml"));
            Scene scene = new Scene(loader.load());

            ManageRequestController requestController = loader.getController();
            requestController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Create Request");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Loads the update request scene.
     */
    @FXML
    public void loadChangeRequestStatusScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Request/changeRequestStatus.fxml"));
            Scene scene = new Scene(loader.load());

            ManageRequestController requestController = loader.getController();
            requestController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Change Request Status");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // The following methods are related to the Service use-case

    /**
     * Loads the delete request scene.
     */
    @FXML
    public void loadCreateServiceScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Service/createService.fxml"));
            Scene scene = new Scene(loader.load());

            ManageServicesController servicesController = loader.getController();
            servicesController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Create Service");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the update service scene.
     */
    @FXML
    public void loadUpdateServiceScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Service/updateService.fxml"));
            Scene scene = new Scene(loader.load());

            ManageServicesController servicesController = loader.getController();
            servicesController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Update Service");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the delete service scene.
     */
    @FXML
    public void loadDeleteServiceScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Service/deleteService.fxml"));
            Scene scene = new Scene(loader.load());

            ManageServicesController servicesController = loader.getController();
            servicesController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Delete Service");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the display all services scene.
     */
    @FXML
    public void loadDisplayAllServicesScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Service/displayAllServices.fxml"));
            Scene scene = new Scene(loader.load());

            DisplayAllServicesController servicesController = loader.getController();
            servicesController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Display All Services");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // The following methods are related to the Grade use-case

    /**
     * Loads the create grade scene.
     */
    @FXML
    public void loadCreateGradeScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Grade/createGrade.fxml"));
            Scene scene = new Scene(loader.load());

            ManageGradesController gradesController = loader.getController();
            gradesController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Create Grade");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the update grade scene.
     */
    @FXML
    public void loadDeleteGradeScene () {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Grade/deleteGrade.fxml"));
            Scene scene = new Scene(loader.load());

            ManageGradesController gradesController = loader.getController();
            gradesController.setSceneManager(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Delete Grade");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the display all grades scene.
     */
    @FXML
    public void loadDisplayAllGradesScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Grade/displayAllGrades.fxml"));
            Scene scene = new Scene(loader.load());

            DisplayAllGradesController gradesController = loader.getController();
            gradesController.setSceneManager(this);

            gradesController.handleGetAllGrades();

            primaryStage.setScene(scene);
            primaryStage.setTitle("Display All Grades");
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
