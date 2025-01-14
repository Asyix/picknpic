package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.bl.facades.service.ServiceFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controller for the main application view.
 * Manages interactions on the main screen, including navigation to the login scene.
 */
public class MainController {


    /** The label for displaying a welcome message. */
    @FXML
    private Label welcomeLabel;

    /** The ServiceFacade instance for accessing service operations. */
    private final ServiceFacade serviceFacade;

    /**
     * Constructor to initialize the ServiceFacade instance.
     */
    public MainController() {
        this.serviceFacade = ServiceFacade.getServiceFacadeInstance();
    }

    /**
     * Initializes the main view.
     * Displays a welcome message with the user's first name if they are logged in.
     * Otherwise, navigates to the login scene.
     */
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
        try {
            // Hardcoded service ID for demonstration purposes
            int serviceId = 1; // Replace this with dynamic input or other logic
            Service service = serviceFacade.getService(serviceId);
            SceneManager.loadCreateRequestScene(service);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void handleChangeRequestStatus() {
        SceneManager.loadChangeRequestStatusScene();
    }

    public void handleCreateService() {
        SceneManager.loadCreateServiceScene();
    }

    public void handleDisplayNotification() {
        SceneManager.loadDisplayNotificationScene();
    }

    public void handlePublishPhoto() {
        SceneManager.loadPublishPhotoScene();
    }

    public void handleDisplayPhotos() {
        SceneManager.loadDisplayPhotosScene();
    }
}