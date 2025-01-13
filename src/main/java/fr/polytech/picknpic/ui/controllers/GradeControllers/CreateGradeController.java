package fr.polytech.picknpic.ui.controllers.GradeControllers;

import fr.polytech.picknpic.bl.facades.grade.GradeFacade;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.bl.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Controller for creating grades.
 * Handles user interactions for creating grades in the application.
 */
public class CreateGradeController {

    /** Facade for grade-related operations. */
    private final GradeFacade gradeFacade;

    /** The current page user. */
    private User currentPageUser;

    @FXML
    private TextField friendlinessField;

    @FXML
    private TextField rapidityField;

    @FXML
    private TextField qualityField;

    /**
     * Constructs a new `CreateGradeController` instance.
     * Initializes the {@link GradeFacade} singleton.
     */
    public CreateGradeController() {
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
     * Sets the current page user.
     * @param user The current page user.
     */
    public void setCurrentPageUser(User user) {
        this.currentPageUser = user;
    }

    /**
     * Handles user interaction for creating a grade.
     */
    @FXML
    public void handleCreateGrade() {
        try {
            // Parse user inputs
            int friendliness = validateInput(friendlinessField.getText(), "Friendliness");
            int rapidity = validateInput(rapidityField.getText(), "Rapidity");
            int quality = validateInput(qualityField.getText(), "Quality");

            // Calculate average grade
            float avg_grade = (friendliness + rapidity + quality) / 3.0f;

            // Ensure currentPageUser is not null
            if (currentPageUser == null) {
                throw new IllegalStateException("Current page user is not set.");
            }

            int id_user_graded = currentPageUser.getId();
            int id_service_graded = 1;

            // Create the grade
            gradeFacade.createGrade(id_user_graded, id_service_graded, friendliness, rapidity, quality, avg_grade);

            // Show success alert and navigate to the main scene
            showAlert("Grade Created", "Grade successfully created", "The grade has been added successfully.");
            SceneManager.loadMainScene();
        } catch (IllegalArgumentException e) {
            showAlert("Invalid Input", "Input Error", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            showAlert("Error", "Failed to create grade", "An error occurred while creating the grade: " + e.getMessage());
        }
    }


    /**
     * Validates the input for a rating field.
     *
     * @param input The user input.
     * @param fieldName The name of the field being validated.
     * @return The validated input as an integer.
     * @throws IllegalArgumentException If the input is invalid.
     */
    private int validateInput(String input, String fieldName) throws IllegalArgumentException {
        try {
            int value = Integer.parseInt(input);
            if (value < 0 || value > 5) {
                throw new IllegalArgumentException(fieldName + " must be between 0 and 5.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid integer.");
        }
    }

    /**
     * Loads the main scene.
     * This method will be triggered when the user clicks a relevant navigation button.
     */
    @FXML
    public void loadMainScene() throws Exception {
        SceneManager.loadMainScene();
    }

    /**
     * Initializes the placeholders for input fields.
     */
    @FXML
    public void initialize() {
        setupPlaceholder(friendlinessField, "Rate friendliness /5");
        setupPlaceholder(rapidityField, "Rate rapidity /5");
        setupPlaceholder(qualityField, "Rate quality /5");
    }

    /**
     * Sets up a placeholder behavior for a TextField.
     *
     * @param field       The TextField to set up.
     * @param placeholder The placeholder text to display when the field is empty and not focused.
     */
    private void setupPlaceholder(TextField field, String placeholder) {
        field.setText(placeholder);
        field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && field.getText().equals(placeholder)) {
                field.clear();
            } else if (!newValue && field.getText().isEmpty()) {
                field.setText(placeholder);
            }
        });
    }
}
