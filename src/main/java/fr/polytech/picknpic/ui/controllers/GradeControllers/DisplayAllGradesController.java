package fr.polytech.picknpic.ui.controllers.GradeControllers;

import fr.polytech.picknpic.bl.facades.grade.GradeFacade;
import fr.polytech.picknpic.ui.controllers.MainController;
import javafx.scene.control.Alert;

/**
 * Controller for displaying all grades.
 * Handles user interactions for retrieving and displaying grades in the application.
 */
public class DisplayAllGradesController {

    /** Facade for grade-related operations. */
    private final GradeFacade gradeFacade;

    /** The main controller for the application. */
    private MainController mainController;

    /**
     * Constructs a new `DisplayAllGradesController` instance.
     * Initializes the {@link GradeFacade} singleton.
     */
    public DisplayAllGradesController() {
        this.gradeFacade = GradeFacade.getGradeFacadeInstance();
    }

    /**
     * Sets the {@link MainController} instance.
     *
     * @param mainController The main controller to set.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Displays an alert with the given title, header, and message.
     *
     * @param title   The title of the alert.
     * @param header  The header text of the alert.
     * @param message The message text of the alert.
     */
    private void showAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles user interaction for retrieving all grades.
     * This method is triggered when the user requests to view all grades for a specific user.
     *
     * @param id_user The ID of the user whose grades should be retrieved.
     */
    public void handleGetAllGrades(int id_user) {
        try {
            gradeFacade.getAllGrades(id_user);
            showAlert("Grades Retrieved", "Grades successfully retrieved", "All grades for user ID: " + id_user + " have been retrieved.");
        } catch (Exception e) {
            showAlert("Error", "Failed to retrieve grades", "An error occurred while retrieving grades for user ID: " + id_user);
        }
    }
}
