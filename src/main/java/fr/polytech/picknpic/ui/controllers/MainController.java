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


    /** The label for displaying a welcome message. */
    @FXML
    private Label welcomeLabel;

    @FXML
    private void initialize() {
        User currentUser = LoginFacade.getInstance().getCurrentUser();
        if (currentUser != null) {
            welcomeLabel.setText("Welcome, " + currentUser.getFirstName() + "!");
        } else {
            SceneManager.loadLoginScene();
        }
    }

}