package fr.polytech.picknpic.bl.facades.grade;

import fr.polytech.picknpic.bl.models.Grade;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

/**
 * Facade for managing grade-related operations.
 * Provides a simplified interface for creating, deleting, and retrieving grades
 * by delegating to the appropriate data access objects.
 */
public class GradeFacade {

    /** Singleton instance of the GradeFacade. */
    private static GradeFacade gradeFacade;

    /** Facade for managing grades. */
    private final ManageGradesFacade manageGradesFacade;

    /** Facade for displaying all grades. */
    private final DisplayAllGradesFacade displayAllGradesFacade;

    /**
     * Private constructor for initializing the GradeFacade.
     * Uses the singleton instances of ManageGradesFacade and DisplayAllGradesFacade.
     */
    private GradeFacade() {
        AbstractFactory abstractFactory = AbstractFactory.getInstance();
        this.manageGradesFacade = ManageGradesFacade.getInstance();
        this.displayAllGradesFacade = DisplayAllGradesFacade.getInstance();
    }

    /**
     * Retrieves the singleton instance of the GradeFacade.
     *
     * @return The singleton instance of GradeFacade.
     */
    public static GradeFacade getGradeFacadeInstance() {
        if (gradeFacade == null) {
            gradeFacade = new GradeFacade();
        }
        return gradeFacade;
    }

    /**
     * Creates a new grade in the system.
     *
     * @param id_user_graded   The ID of the user being graded.
     * @param id_service_graded The ID of the service being graded.
     * @param friendliness     The friendliness rating.
     * @param rapidity         The rapidity rating.
     * @param quality          The quality rating.
     * @param avg_grade        The average grade.
     * @return The created Grade object.
     */
    public Grade createGrade(int id_user_graded, int id_service_graded, int friendliness, int rapidity, int quality, float avg_grade) {
        return manageGradesFacade.createGrade(0, id_user_graded, id_service_graded, friendliness, rapidity, quality, avg_grade);
    }

    /**
     * Deletes an existing grade from the system.
     *
     * @param id_grade The ID of the grade to delete.
     * @return The deleted Grade object.
     */
    public Grade deleteGrade(int id_grade) {
        return manageGradesFacade.deleteGrade(id_grade);
    }

    /**
     * Retrieves all grades for a specific user.
     *
     * @param id_user The ID of the user.
     * @return A Grade object containing all grades for the user.
     */
    public List<Grade> getAllGrades(int id_user) {
        return displayAllGradesFacade.getAllGrades(id_user);
    }
}
