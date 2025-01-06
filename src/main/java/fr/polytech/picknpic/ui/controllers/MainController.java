package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.ui.controllers.UserControllers.LoginController;
import fr.polytech.picknpic.ui.controllers.RequestControllers.ManageRequestController;
import fr.polytech.picknpic.ui.controllers.ServiceControllers.ManageServicesController;
import fr.polytech.picknpic.ui.controllers.GradeControllers.ManageGradesController;
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

    // temporary create request navigation button
    @FXML
    private Button createRequestButton;

    // temporary change request status navigation button
    @FXML
    private Button changeRequestStatusButton;

    /** Temporary buttons to navigate to manage services. */
    @FXML
    private Button createServicesButton;

    @FXML
    private Button updateServicesButton;

    @FXML
    private Button deleteServicesButton;

    /** Temporary button to navigate to display all services. */
    @FXML
    private Button displayAllServicesButton;

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

    @FXML
    public void handleCreateRequest() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Request/createRequest.fxml"));
            Scene scene = new Scene(loader.load());

            ManageRequestController requestController = loader.getController();
            requestController.setMainController(this);

            Stage requestStage = new Stage();
            requestStage.setScene(scene);
            requestStage.setTitle("Create Request");
            requestStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleChangeRequestStatus() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Request/changeRequestStatus.fxml"));
            Scene scene = new Scene(loader.load());

            ManageRequestController requestController = loader.getController();
            requestController.setMainController(this);

            Stage requestStage = new Stage();
            requestStage.setScene(scene);
            requestStage.setTitle("Change Request Status");
            requestStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCreateService() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Service/createService.fxml"));
            Scene scene = new Scene(loader.load());

            ManageServicesController servicesController = loader.getController();
            servicesController.setMainController(this);

            Stage servicesStage = new Stage();
            servicesStage.setScene(scene);
            servicesStage.setTitle("Create Service");
            servicesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleUpdateService() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Service/updateService.fxml"));
            Scene scene = new Scene(loader.load());

            ManageServicesController servicesController = loader.getController();
            servicesController.setMainController(this);

            Stage servicesStage = new Stage();
            servicesStage.setScene(scene);
            servicesStage.setTitle("Update Service");
            servicesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDeleteService() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Service/deleteService.fxml"));
            Scene scene = new Scene(loader.load());

            ManageServicesController servicesController = loader.getController();
            servicesController.setMainController(this);

            Stage servicesStage = new Stage();
            servicesStage.setScene(scene);
            servicesStage.setTitle("Delete Service");
            servicesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCreateGrade() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Grade/createGrade.fxml"));
            Scene scene = new Scene(loader.load());

            ManageGradesController gradesController = loader.getController();
            gradesController.setMainController(this);

            Stage gradesStage = new Stage();
            gradesStage.setScene(scene);
            gradesStage.setTitle("Create Grade");
            gradesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDeleteGrade () {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Grade/deleteGrade.fxml"));
            Scene scene = new Scene(loader.load());

            ManageGradesController gradesController = loader.getController();
            gradesController.setMainController(this);

            Stage gradesStage = new Stage();
            gradesStage.setScene(scene);
            gradesStage.setTitle("Delete Grade");
            gradesStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
