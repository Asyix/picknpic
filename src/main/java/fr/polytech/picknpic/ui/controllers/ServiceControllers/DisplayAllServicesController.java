package fr.polytech.picknpic.ui.controllers.ServiceControllers;

import fr.polytech.picknpic.bl.facades.service.ServiceFacade;
import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class DisplayAllServicesController {

    private final ServiceFacade serviceFacade;

    private SceneManager sceneManager;

    @FXML
    private VBox servicesContainer;

    public DisplayAllServicesController() {
        this.serviceFacade = ServiceFacade.getServiceFacadeInstance();
    }

    /**
     * Sets the {@link SceneManager instance}.
     * @param sceneManager The scene manager to set.
     */
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    public void initialize() {
        System.out.println("Initializing DisplayAllServicesController...");
        handleGetAllServices();
    }

    public void handleGetAllServices() {
        int id_user_owner = 1; // For now, hardcoded
        List<Service> services = serviceFacade.getAllServices(id_user_owner);

        System.out.println("Retrieved services: " + services.size());
        servicesContainer.getChildren().clear();

        for (Service service : services) {
            Pane servicePane = createServicePane(service);
            servicesContainer.getChildren().add(servicePane);
        }
    }

    private Pane createServicePane(Service service) {
        System.out.println("Creating pane for service: " + service.getName());
        Pane pane = new Pane();
        pane.setPrefSize(450, 100);
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

        pane.getChildren().addAll(nameLabel, priceLabel, descriptionLabel);

        return pane;
    }
}
