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

    // temporary sceneManager to be deleted later
    private SceneManager sceneManager;

    @FXML
    private void initialize() {
        User currentUser = LoginFacade.getInstance().getCurrentUser();
        if (currentUser != null) {
            welcomeLabel.setText("Welcome, " + currentUser.getFirstName() + "!");
        } else {
            SceneManager.loadLoginScene();
        }
    }

    // Temporary methods to navigate to other scenes

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

    public void handleSeeBenefits() {
        sceneManager.loadSeeBenefitsScene();
    }
}
