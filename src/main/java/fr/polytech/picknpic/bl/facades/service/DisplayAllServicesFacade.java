package fr.polytech.picknpic.bl.facades.service;

import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.ServiceDAO;

import java.util.List;

/**
 * Facade for displaying all services.
 * Provides a simplified interface for fetching services based on the user.
 * This class interacts with the DAO layer to retrieve data.
 */
public class DisplayAllServicesFacade {

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /** The singleton instance of DisplayAllServicesFacade. */
    private static DisplayAllServicesFacade displayAllServicesFacade;

    /**
     * Private constructor to ensure a single instance of DisplayAllServicesFacade.
     * Initializes the {@link AbstractFactory} for DAO creation.
     */
    private DisplayAllServicesFacade() {
        this.abstractFactory = AbstractFactory.getAbstractFactoryInstance();
    }

    /**
     * Retrieves the singleton instance of DisplayAllServicesFacade.
     *
     * @return The singleton instance of DisplayAllServicesFacade.
     */
    public static DisplayAllServicesFacade getInstance() {
        if (displayAllServicesFacade == null) {
            displayAllServicesFacade = new DisplayAllServicesFacade();
        }
        return displayAllServicesFacade;
    }

    /**
     * Retrieves all services owned by a specific user.
     *
     * @param id_user_owner The ID of the user who owns the services.
     * @return A list of {@link Service} objects owned by the user.
     */
    public List<Service> getAllServices(int id_user_owner) {
        ServiceDAO serviceDAO = abstractFactory.createServiceDAO();
        return serviceDAO.getAllServices(id_user_owner);
    }
}
