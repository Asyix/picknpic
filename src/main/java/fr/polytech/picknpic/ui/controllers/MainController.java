package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.ui.controllers.UserControllers.LoginController;
import fr.polytech.picknpic.ui.controllers.RequestControllers.ManageRequestController;
import fr.polytech.picknpic.ui.controllers.ServiceControllers.ManageServicesController;
import fr.polytech.picknpic.ui.controllers.GradeControllers.ManageGradesController;
import fr.polytech.picknpic.ui.controllers.UserControllers.RegisterController;
import fr.polytech.picknpic.ui.controllers.NotificationControllers.NotificationController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    public void handleChangeRequestStatus() {
        sceneManager.loadChangeRequestStatusScene();
    }

    public void handleCreateService() {
        sceneManager.loadCreateServiceScene();
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

    public void handleDisplayNotification() {
        sceneManager.loadDisplayNotificationScene();
    }

    public void handlePublishPhoto() {
        sceneManager.loadPublishPhotoScene();
    }

    public void handleDisplayPhotos() {
        sceneManager.loadDisplayPhotosScene();
    }

}