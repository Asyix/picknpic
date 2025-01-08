package fr.polytech.picknpic.bl.facades.grade;

import fr.polytech.picknpic.bl.models.Grade;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.GradeDAO;

/**
 * Singleton facade for displaying grades.
 * Provides a simplified interface for retrieving all grades for a specific user.
 */
public class DisplayAllGradesFacade {

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /** The singleton instance of the DisplayAllGradesFacade. */
    private static DisplayAllGradesFacade displayAllGradesFacade;

    /**
     * Private constructor to initialize the DisplayAllGradesFacade.
     * Sets the abstract factory instance.
     */
    private DisplayAllGradesFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of DisplayAllGradesFacade.
     *
     * @return The singleton instance of DisplayAllGradesFacade.
     */
    public static DisplayAllGradesFacade getInstance() {
        if (displayAllGradesFacade == null) {
            displayAllGradesFacade = new DisplayAllGradesFacade();
        }
        return displayAllGradesFacade;
    }

    /**
     * Retrieves all grades associated with a specific user.
     *
     * @param id_user The ID of the user whose grades are to be retrieved.
     * @return The Grade object containing all the user's grades.
     */
    public Grade getAllGrades(int id_user) {
        GradeDAO gradeDAO = abstractFactory.createGradeDAO();
        return gradeDAO.getAllGrades(id_user);
    }
}
