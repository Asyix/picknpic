
package fr.polytech.picknpic.bl.facades.grade;

import fr.polytech.picknpic.bl.models.Grade;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.GradeDAO;

/**
 * Singleton facade for managing grades.
 * Provides a simplified interface for creating and deleting grades.
 */
public class ManageGradesFacade {

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /** The singleton instance of the ManageGradesFacade. */
    private static ManageGradesFacade manageGradesFacade;

    /**
     * Private constructor to initialize the ManageGradesFacade.
     * Sets the abstract factory instance.
     */
    private ManageGradesFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of ManageGradesFacade.
     *
     * @return The singleton instance of ManageGradesFacade.
     */
    public static ManageGradesFacade getInstance() {
        if (manageGradesFacade == null) {
            manageGradesFacade = new ManageGradesFacade();
        }
        return manageGradesFacade;
    }

    /**
     * Creates a new grade in the system.
     *
     * @param id_grade The ID of the grade.
     * @param id_user_graded The ID of the user being graded.
     * @param id_service_graded The ID of the service being graded.
     * @param friendliness The friendliness rating.
     * @param rapidity The rapidity rating.
     * @param quality The quality rating.
     * @param avg_grade The average grade calculated from the ratings.
     * @return The created Grade object.
     */
    public Grade createGrade(int id_grade, int id_user_graded, int id_service_graded, int friendliness, int rapidity, int quality, float avg_grade) {
        GradeDAO gradeDAO = abstractFactory.createGradeDAO();
        return gradeDAO.createGrade(id_grade, id_user_graded, id_service_graded, friendliness, rapidity, quality, avg_grade);
    }

    /**
     * Deletes an existing grade from the system.
     *
     * @param id_grade The ID of the grade to delete.
     * @return The deleted Grade object.
     */
    public Grade deleteGrade(int id_grade) {
        GradeDAO gradeDAO = abstractFactory.createGradeDAO();
        return gradeDAO.deleteGrade(id_grade);
    }
}
