package fr.polytech.picknpic.ui.controllers.GradeControllers;

import fr.polytech.picknpic.bl.facades.grade.GradeFacade;
import fr.polytech.picknpic.ui.controllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import fr.polytech.picknpic.ui.SceneManager;

/**
 * Controller for managing grades.
 * Handles user interactions for creating and managing grades in the application.
 */
public class ManageGradesController {

    /** Facade for grade-related operations. */
    private final GradeFacade gradeFacade;

    /** The scene manager for managing scene transitions. */
    private SceneManager sceneManager;

    /**
     * Constructs a new `ManageGradesController` instance.
     * Initializes the {@link GradeFacade} singleton.
     */
    public ManageGradesController() {
        this.gradeFacade = GradeFacade.getGradeFacadeInstance();
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
     * Handles user interaction for managing grades.
     * This method is triggered when the user requests to manage grades.
     */
    public void handleCreateGrade() {

        int id_user_graded = 1;
        int id_service_graded = 1;
        int friendliness = 5;
        int rapidity = 5;
        int quality = 5;
        float avg_grade = 5;

        try {
            gradeFacade.createGrade(id_user_graded, id_service_graded, friendliness, rapidity, quality, avg_grade);
            showAlert("Grade Created", "Grade successfully created", "The grade has been added successfully.");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to create grade", "An error occurred while creating the grade.");
        }
    }

    /**
     * Handles user interaction for deleting grades.
     * This method is triggered when the user requests to delete a grade.
     */
    public void handleDeleteGrade() {

        int id_grade = 1;

        try {
            gradeFacade.deleteGrade(id_grade);
            showAlert("Grade Deleted", "Grade successfully deleted", "The grade has been deleted successfully.");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to delete grade", "An error occurred while deleting the grade.");
        }
    }

    /**
     * Loads the main scene.
     * This method will be triggered when the user clicks "NO" in the confirm delete dialog.
     */
    @FXML
    public void loadMainScene() throws Exception {
        sceneManager.loadMainScene();
    }

}