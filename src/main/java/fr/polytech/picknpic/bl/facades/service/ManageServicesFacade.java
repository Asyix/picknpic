package fr.polytech.picknpic.bl.facades.service;

import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.ServiceDAO;

/**
 * Facade for managing services.
 * Provides a simplified interface for creating, updating, and deleting services.
 * This class interacts with the DAO layer to perform these operations.
 */
public class ManageServicesFacade {

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /** The singleton instance of ManageServicesFacade. */
    private static ManageServicesFacade manageServicesFacade;

    /**
     * Private constructor to ensure a single instance of ManageServicesFacade.
     * Initializes the {@link AbstractFactory} for DAO creation.
     */
    private ManageServicesFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of ManageServicesFacade.
     *
     * @return The singleton instance of ManageServicesFacade.
     */
    public static ManageServicesFacade getInstance() {
        if (manageServicesFacade == null) {
            manageServicesFacade = new ManageServicesFacade();
        }
        return manageServicesFacade;
    }

    /**
     * Creates a new service.
     *
     * @param id_user_owner The ID of the user who owns the service.
     * @param name          The name of the service.
     * @param example_image A URL or file path for an example image of the service.
     * @param price         The price of the service.
     * @param description   A description of the service.
     * @param nb_buyers     The number of buyers for the service.
     * @return The created {@link Service} object.
     */
    public Service createService(int id_user_owner, String name, String example_image, float price, String description, int nb_buyers) {
        ServiceDAO serviceDAO = abstractFactory.createServiceDAO();
        return serviceDAO.createService(id_user_owner, name, example_image, price, description, nb_buyers);
    }

    /**
     * Deletes a service by its ID.
     *
     * @param id_service The ID of the service to delete.
     * @return {@code true} if the service was successfully deleted; {@code false} otherwise.
     */
    public boolean deleteService(int id_service) {
        ServiceDAO serviceDAO = abstractFactory.createServiceDAO();
        return serviceDAO.deleteService(id_service);
    }

    /**
     * Updates an existing service.
     *
     * @param id_service    The ID of the service to update.
     * @param name          The new name of the service.
     * @param example_image The new example image of the service.
     * @param price         The new price of the service.
     * @param description   The new description of the service.
     * @return The updated {@link Service} object.
     */
    public Service updateService(int id_service, String name, String example_image, float price, String description) {
        ServiceDAO serviceDAO = abstractFactory.createServiceDAO();
        return serviceDAO.updateService(id_service, name, example_image, price, description);
    }
}