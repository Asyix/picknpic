package fr.polytech.picknpic.ui;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.controllers.GradeControllers.ManageGradesController;
import fr.polytech.picknpic.ui.controllers.GradeControllers.DisplayAllGradesController;
import fr.polytech.picknpic.ui.controllers.MainController;
import fr.polytech.picknpic.ui.controllers.RequestControllers.ManageRequestController;
import fr.polytech.picknpic.ui.controllers.ServiceControllers.ManageServicesController;
import fr.polytech.picknpic.ui.controllers.ServiceControllers.DisplayAllServicesController;
import javafx.fxml.FXML;
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

            Stage requestStage = new Stage();
            requestStage.setScene(scene);
            requestStage.setTitle("Create Request");
            requestStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
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

            Stage requestStage = new Stage();
            requestStage.setScene(scene);
            requestStage.setTitle("Change Request Status");
            requestStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

            Stage servicesStage = new Stage();
            servicesStage.setScene(scene);
            servicesStage.setTitle("Create Service");
            servicesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
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

            Stage servicesStage = new Stage();
            servicesStage.setScene(scene);
            servicesStage.setTitle("Update Service");
            servicesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
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

            Stage servicesStage = new Stage();
            servicesStage.setScene(scene);
            servicesStage.setTitle("Delete Service");
            servicesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

            Stage gradesStage = new Stage();
            gradesStage.setScene(scene);
            gradesStage.setTitle("Create Grade");
            gradesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
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

            Stage gradesStage = new Stage();
            gradesStage.setScene(scene);
            gradesStage.setTitle("Delete Grade");
            gradesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
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

            Stage servicesStage = new Stage();
            servicesStage.setScene(scene);
            servicesStage.setTitle("Display All Services");
            servicesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
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

            Stage gradesStage = new Stage();
            gradesStage.setScene(scene);
            gradesStage.setTitle("Display All Grades");
            gradesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
