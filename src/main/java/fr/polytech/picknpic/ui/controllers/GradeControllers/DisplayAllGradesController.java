

package fr.polytech.picknpic.ui.controllers.GradeControllers;

import fr.polytech.picknpic.bl.facades.grade.GradeFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Grade;
import fr.polytech.picknpic.ui.SceneManager;
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

    private final GradeFacade gradeFacade;

    /** The scene manager for managing scene transitions. */
    private SceneManager sceneManager;

    @FXML
    private VBox gradesContainer;

    public DisplayAllGradesController() {
        this.gradeFacade = GradeFacade.getGradeFacadeInstance();
    }

    @FXML
    public void initialize() {
        //handleGetAllGrades();
    }

    public void handleGetAllGrades() {
        int id_user = LoginFacade.getInstance().getCurrentUser().getId();
        System.out.println("user id" + id_user);
        List<Grade> grades = gradeFacade.getAllGrades(id_user);

        gradesContainer.getChildren().clear(); // Clear existing children

        for (Grade grade : grades) {
            Pane gradePane = createGradePane(grade);
            gradesContainer.getChildren().add(gradePane);
        }
    }

    private Pane createGradePane(Grade grade) {
        Pane pane = new Pane();
        pane.setPrefSize(450, 100);
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

        pane.getChildren().addAll(userGradedLabel, serviceGradedLabel, friendlinessLabel, rapidityLabel, qualityLabel, avgGradeLabel);

        return pane;
    }
}
