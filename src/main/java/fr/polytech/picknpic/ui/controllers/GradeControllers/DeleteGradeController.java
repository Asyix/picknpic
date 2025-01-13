package fr.polytech.picknpic.ui.controllers.GradeControllers;

import fr.polytech.picknpic.bl.facades.grade.GradeFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Controller for deleting grades.
 * Handles user interactions for deleting grades in the application.
 */
public class DeleteGradeController {

    /** Facade for grade-related operations. */
    private final GradeFacade gradeFacade;

    /** The scene manager for managing scene transitions. */
    private SceneManager sceneManager;

    /**
     * Constructs a new `DeleteGradeController` instance.
     * Initializes the {@link GradeFacade} singleton.
     */
    public DeleteGradeController() {
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
     * Handles user interaction for deleting a grade.
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
     * This method will be triggered when the user clicks a relevant navigation button.
     */
    @FXML
    public void loadMainScene() throws Exception {
        sceneManager.loadMainScene();
    }
}
