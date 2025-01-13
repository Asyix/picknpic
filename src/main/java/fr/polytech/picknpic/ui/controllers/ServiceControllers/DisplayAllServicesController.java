package fr.polytech.picknpic.ui.controllers.ServiceControllers;

import fr.polytech.picknpic.bl.facades.service.ServiceFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Controller for displaying all services.
 * Fetches and renders service details in panes within a VBox.
 */
public class DisplayAllServicesController {

    /** The service facade for fetching service data. */
    private final ServiceFacade serviceFacade;

    /** The current logged-in user. */
    private final User currentUser;

    @FXML
    private VBox servicesContainer;

    /** Constructs a new DisplayAllServicesController instance. */
    public DisplayAllServicesController() {
        this.serviceFacade = ServiceFacade.getServiceFacadeInstance();
        this.currentUser = LoginFacade.getInstance().getCurrentUser(); // Fetch the current user
    }

    /**
     * Initializes the controller and fetches the services.
     */
    @FXML
    public void initialize() {
        handleGetAllServices();
    }

    /**
     * Fetches all services and populates the container with service panes.
     */
    public void handleGetAllServices() {
        try {
            int id_user_owner = 1 ; //currentUser.getId();
            List<Service> services = serviceFacade.getAllServices(id_user_owner); // Fetch all services

            servicesContainer.getChildren().clear();

            for (Service service : services) {
                Pane servicePane = createServicePane(service);
                servicesContainer.getChildren().add(servicePane);
            }
        } catch (Exception e) {
            System.err.println("Failed to retrieve services: " + e.getMessage());
        }
    }

    /**
     * Creates a pane for a given service.
     *
     * @param service The service to display.
     * @return A pane containing service details with conditional buttons.
     */
    private Pane createServicePane(Service service) {
        Pane pane = new Pane();
        pane.setPrefSize(450, 150);
        pane.setStyle("-fx-background-color: #3E3E3E; -fx-border-color: white; -fx-padding: 10;");

        Label nameLabel = new Label("Service Name: " + service.getName());
        nameLabel.setLayoutX(10);
        nameLabel.setLayoutY(10);
        nameLabel.setStyle("-fx-text-fill: white;");

        Label priceLabel = new Label("Price: $" + service.getPrice());
        priceLabel.setLayoutX(10);
        priceLabel.setLayoutY(30);
        priceLabel.setStyle("-fx-text-fill: white;");

        Label descriptionLabel = new Label("Description: " + service.getDescription());
        descriptionLabel.setLayoutX(10);
        descriptionLabel.setLayoutY(50);
        descriptionLabel.setStyle("-fx-text-fill: white;");

        if (currentUser.isAdmin()) {
            // Admin-specific buttons
            Button deleteButton = new Button("Delete");
            deleteButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
            deleteButton.setLayoutX(300);
            deleteButton.setLayoutY(30);
            deleteButton.setOnAction(event -> handleDeleteService(service));
            setupHoverEffect(deleteButton, "red", "#b30000");

            Button updateButton = new Button("Update");
            updateButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
            updateButton.setLayoutX(370);
            updateButton.setLayoutY(30);
            updateButton.setOnAction(event -> handleUpdateService(service));
            setupHoverEffect(updateButton, "blue", "#0000b3");

            pane.getChildren().addAll(nameLabel, priceLabel, descriptionLabel, deleteButton, updateButton);
        } else {
            // Non-admin button
            Button requestButton = new Button("Request");
            requestButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
            requestButton.setLayoutX(300);
            requestButton.setLayoutY(30);
            requestButton.setOnAction(event -> handleRequestService(service));
            setupHoverEffect(requestButton, "green", "#009900");

            pane.getChildren().addAll(nameLabel, priceLabel, descriptionLabel, requestButton);
        }

        return pane;
    }

    /**
     * Sets up a hover effect for a button, changing its background color when hovered.
     *
     * @param button      The button to apply the hover effect to.
     * @param defaultColor The default background color of the button.
     * @param hoverColor   The background color when the button is hovered.
     */
    private void setupHoverEffect(Button button, String defaultColor, String hoverColor) {
        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: " + hoverColor + "; -fx-text-fill: white;"));
        button.setOnMouseExited(event -> button.setStyle("-fx-background-color: " + defaultColor + "; -fx-text-fill: white;"));
    }

    /**
     * Handles the deletion of a service.
     *
     * @param service The service to delete.
     */
    private void handleDeleteService(Service service) {
        try {
            SceneManager.loadDeleteServiceScene(service);
        } catch (Exception e) {
            System.err.println("Failed to delete service: " + e.getMessage());
        }
    }

    /**
     * Handles the update action for a service.
     *
     * @param service The service to update.
     */
    private void handleUpdateService(Service service) {
        try {
            SceneManager.loadUpdateServiceScene(service);
        } catch (Exception e) {
            System.err.println("Failed to navigate to update service scene: " + e.getMessage());
        }
    }

    /**
     * Handles the request action for a service.
     *
     * @param service The service to request.
     */
    private void handleRequestService(Service service) {
        try {
            SceneManager.loadCreateRequestScene(service);
            System.out.println("passed");
        } catch (Exception e) {
            System.err.println("Failed to navigate to update service scene: " + e.getMessage());
        }
    }
}
