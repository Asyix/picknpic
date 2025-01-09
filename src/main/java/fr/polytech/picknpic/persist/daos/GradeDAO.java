package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Grade;
import fr.polytech.picknpic.bl.models.Service;

import java.util.List;

/**
 * Interface for performing data access operations related to grades.
 * Provides methods for creating, deleting, and retrieving grades.
 */
public interface GradeDAO {

    /**
     * Creates a new grade in the database.
     *
     * @param id_grade The unique identifier of the grade.
     * @param id_user_graded The ID of the user being graded.
     * @param id_service_graded The ID of the service being graded.
     * @param friendliness The friendliness grade.
     * @param rapidity The rapidity grade.
     * @param quality The quality grade.
     * @param avg_grade The average grade.
     * @return The created {@link Grade} object.
     */
    Grade createGrade(int id_grade, int id_user_graded, int id_service_graded, int friendliness, int rapidity, int quality, float avg_grade);

    /**
     * Deletes an existing grade from the database.
     *
     * @param id_grade The ID of the grade to delete.
     * @return The deleted {@link Grade} object.
     */
    Grade deleteGrade(int id_grade);

    /**
     * Retrieves all grades for a specific user.
     *
     * @param id_user The ID of the user for whom grades are retrieved.
     * @return The retrieved {@link Grade} object.
     */
    List<Grade> getAllGrades(int id_user);
}
