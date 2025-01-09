package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.ui.controllers.UserControllers.LoginController;
import fr.polytech.picknpic.ui.controllers.RequestControllers.ManageRequestController;
import fr.polytech.picknpic.ui.controllers.ServiceControllers.ManageServicesController;
import fr.polytech.picknpic.ui.controllers.GradeControllers.ManageGradesController;
import fr.polytech.picknpic.ui.controllers.UserControllers.RegisterController;
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

    @FXML Button manageUsersButton;

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

    @FXML
    private void initialize() {
        User currentUser = LoginFacade.getInstance().getCurrentUser();
        if (currentUser != null) {
            welcomeLabel.setText("Welcome, " + currentUser.getFirstName() + "!");
        } else {
            sceneManager.loadLoginScene();
        }
    }

    @FXML
    private void handleLogout() {
        LoginFacade.getInstance().setCurrentUser(null);
        sceneManager.loadLoginScene();
    }

    @FXML
    private void handleManageUsers() {
        sceneManager.loadManageUsersScene();
    }

    public void handleCreateRequest() {
        sceneManager.loadCreateRequestScene();
    }

    public void handleChangeRequestStatus() {
        sceneManager.loadChangeRequestStatusScene();
    }

    public void handleCreateService() {
        sceneManager.loadCreateServiceScene();
    }

    public void handleUpdateService() {
        sceneManager.loadUpdateServiceScene();
    }

    public void handleDeleteService() {
        sceneManager.loadDeleteServiceScene();
    }

    public void handleCreateGrade() {
        sceneManager.loadCreateGradeScene();
    }

    public void handleDeleteGrade() {
        sceneManager.loadDeleteGradeScene();
    }

    public void handleDisplayAllServices() {
        sceneManager.loadDisplayAllServicesScene();
    }

    public void handleDisplayAllGrades() {
        sceneManager.loadDisplayAllGradesScene();
    }


}
