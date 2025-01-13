
package fr.polytech.picknpic.bl.facades.service;

import fr.polytech.picknpic.bl.models.Service;

import java.util.List;

/**
 * Unified facade for managing and displaying services.
 * Combines functionality from {@link ManageServicesFacade} and {@link DisplayAllServicesFacade}.
 * Provides a single interface for service-related operations.
 */
public class ServiceFacade {

    /** The facade for managing services. */
    private final ManageServicesFacade manageServicesFacade;

    /** The facade for displaying all services. */
    private final DisplayAllServicesFacade displayAllServicesFacade;

    /** The singleton instance of ServiceFacade. */
    private static ServiceFacade serviceFacade;

    /**
     * Private constructor to ensure a single instance of ServiceFacade.
     * Initializes the {@link ManageServicesFacade} and {@link DisplayAllServicesFacade}.
     */
    private ServiceFacade() {
        this.manageServicesFacade = ManageServicesFacade.getInstance();
        this.displayAllServicesFacade = DisplayAllServicesFacade.getInstance();
    }

    /**
     * Retrieves the singleton instance of ServiceFacade.
     *
     * @return The singleton instance of ServiceFacade.
     */
    public static ServiceFacade getServiceFacadeInstance() {
        if (serviceFacade == null) {
            serviceFacade = new ServiceFacade();
        }
        return serviceFacade;
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
        return manageServicesFacade.createService(id_user_owner, name, example_image, price, description, nb_buyers);
    }

    /**
     * Deletes a service by its ID.
     *
     * @param id_service The ID of the service to delete.
     * @return {@code true} if the service was successfully deleted; {@code false} otherwise.
     */
    public boolean deleteService(int id_service) {
        return manageServicesFacade.deleteService(id_service);
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
        return manageServicesFacade.updateService(id_service, name, example_image, price, description);
    }

    /**
     * Retrieves all services owned by a specific user.
     *
     * @param id_user_owner The ID of the user who owns the services.
     * @return A list of {@link Service} objects owned by the user.
     */
    public List<Service> getAllServices(int id_user_owner) {
        return displayAllServicesFacade.getAllServices(id_user_owner);
    }

    /**
     * Retrieves a service by its ID.
     *
     * @param id_service The ID of the service to retrieve.
     * @return The {@link Service} object if found, otherwise {@code null}.
     */
    public Service getService(int id_service) {
        return manageServicesFacade.getService(id_service);
    }
}
