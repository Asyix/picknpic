

package fr.polytech.picknpic.ui.controllers.GradeControllers;

import fr.polytech.picknpic.bl.facades.grade.GradeFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Grade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.controllers.UserControllers.ProfileController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Controller for displaying all grades.
 * Handles user interactions for retrieving and displaying grades in the application.
 */
public class DisplayAllGradesController {

    /**
     * The facade for grade-related operations.
     */
    private final GradeFacade gradeFacade;

    private ProfileController profileController;

    private User currentPageUser;

    @FXML
    private VBox gradesContainer;

    private boolean isInitialized = false; // Track if FXML is fully loaded

    /**
     * Initializes the controller.
     * Can be used to set default values or placeholders for UI elements.
     */
    public DisplayAllGradesController() {
        this.gradeFacade = GradeFacade.getGradeFacadeInstance();
    }

    @FXML
    public void initialize() {
        isInitialized = true; // Mark that FXML components are ready
        if (currentPageUser != null) {
            handleGetAllGrades();
        }
    }

    /**
     * Setter method for the current page user.
     * @param user The current page user.
     */
    public void setCurrentPageUser(User user) {
        this.currentPageUser = user;
        if (isInitialized) { // Only fetch grades if FXML is ready
            handleGetAllGrades();
        }
    }

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;
    }

    /**
     * Fetches and displays all grades.
     */
    public void handleGetAllGrades() {
        if (currentPageUser == null) {
            throw new IllegalStateException("currentPageUser is not set. Please ensure it is set before calling this method.");
        }

        int id_user = currentPageUser.getId();
        System.out.println("Fetching grades for user ID: " + id_user);
        List<Grade> grades = gradeFacade.getAllGrades(id_user);

        gradesContainer.getChildren().clear(); // Clear existing grades

        for (Grade grade : grades) {
            Pane gradePane = createGradePane(grade);
            gradesContainer.getChildren().add(gradePane);
        }
    }

    /**
     * Creates a pane to display a grade.
     *
     * @param grade The grade to display.
     * @return The pane containing the grade.
     */
    private Pane createGradePane(Grade grade) {
        Pane pane = new Pane();
        pane.setPrefSize(450, 150);
        pane.setStyle("-fx-background-color: #3E3E3E; -fx-border-color: white; -fx-padding: 10;");

        Label userGradedLabel = new Label("User Graded ID: " + grade.getIdUserGraded());
        userGradedLabel.setLayoutX(10);
        userGradedLabel.setLayoutY(10);
        userGradedLabel.setStyle("-fx-text-fill: white;");

        Label serviceGradedLabel = new Label("Service Graded ID: " + grade.getIdServiceGraded());
        serviceGradedLabel.setLayoutX(10);
        serviceGradedLabel.setLayoutY(30);
        serviceGradedLabel.setStyle("-fx-text-fill: white;");

        Label friendlinessLabel = new Label("Friendliness: " + grade.getFriendliness());
        friendlinessLabel.setLayoutX(10);
        friendlinessLabel.setLayoutY(50);
        friendlinessLabel.setStyle("-fx-text-fill: white;");

        Label rapidityLabel = new Label("Rapidity: " + grade.getRapidity());
        rapidityLabel.setLayoutX(10);
        rapidityLabel.setLayoutY(70);
        rapidityLabel.setStyle("-fx-text-fill: white;");

        Label qualityLabel = new Label("Quality: " + grade.getQuality());
        qualityLabel.setLayoutX(10);
        qualityLabel.setLayoutY(90);
        qualityLabel.setStyle("-fx-text-fill: white;");

        Label avgGradeLabel = new Label("Average Grade: " + grade.getAvgGrade());
        avgGradeLabel.setLayoutX(10);
        avgGradeLabel.setLayoutY(110);
        avgGradeLabel.setStyle("-fx-text-fill: white;");

        // Check if the current user is an admin
        if (LoginFacade.getInstance().getCurrentUser().isAdmin()) {
            // Create the red delete button
            javafx.scene.control.Button deleteButton = new javafx.scene.control.Button("Delete");
            deleteButton.setLayoutX(350); // Positioning the button
            deleteButton.setLayoutY(50);
            deleteButton.setStyle(
                    "-fx-background-color: #FF0000; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 5;");

            // Add hover effect for the delete button
            deleteButton.setOnMouseEntered(event -> deleteButton.setStyle(
                    "-fx-background-color: #CC0000; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 5;"));
            deleteButton.setOnMouseExited(event -> deleteButton.setStyle(
                    "-fx-background-color: #FF0000; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 5;"));

            // Add action to the delete button
            deleteButton.setOnAction(event -> handleDeleteGrade(grade, pane));

            pane.getChildren().add(deleteButton);
        }

        pane.getChildren().addAll(userGradedLabel, serviceGradedLabel, friendlinessLabel, rapidityLabel, qualityLabel, avgGradeLabel);

        return pane;
    }

    /**
     * Handles the action of deleting a grade.
     *
     * @param grade The grade to delete.
     * @param pane  The pane containing the grade.
     */
    private void handleDeleteGrade(Grade grade, Pane pane) {
        // Call the deleteGrade method in GradeFacade
        Grade deletedGrade = gradeFacade.deleteGrade(grade.getIdGrade());

        if (deletedGrade != null) {
            // Remove the grade pane from the UI
            gradesContainer.getChildren().remove(pane);
            System.out.println("Grade deleted successfully: " + deletedGrade.getIdGrade());
        } else {
            System.err.println("Failed to delete the grade with ID: " + grade.getIdGrade());
        }
    }

    public void handleGradeUser() {
        if (profileController != null) {
            profileController.loadCreateGradeScene();
        } else {
            throw new IllegalStateException("ProfileController is not set.");
        }
    }
}
