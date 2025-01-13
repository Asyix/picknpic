package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Service;

import java.util.List;

/**
 * Interface for performing data access operations related to services.
 * Provides methods for creating, updating, deleting, and fetching services.
 */
public interface ServiceDAO {

    /**
     * Creates a new service in the database.
     *
     * @param id_user_owner The ID of the user who owns the service.
     * @param name          The name of the service.
     * @param example_image The URL of an example image for the service.
     * @param price         The price of the service.
     * @param description   The description of the service.
     * @param nb_buyers     The number of buyers who have purchased the service.
     * @return The created service, or `null` if the operation failed.
     */
    Service createService(int id_user_owner, String name, String example_image, float price, String description, int nb_buyers);

    /**
     * Deletes a service from the database.
     *
     * @param id_service The ID of the service to delete.
     * @return `true` if the service was successfully deleted, `false` otherwise.
     */
    boolean deleteService(int id_service);

    /**
     * Updates an existing service in the database.
     *
     * @param id_service    The ID of the service to update.
     * @param name          The new name of the service.
     * @param example_image The new URL of an example image for the service.
     * @param price         The new price of the service.
     * @param description   The new description of the service.
     * @return The updated service, or `null` if the operation failed.
     */
    Service updateService(int id_service, String name, String example_image, float price, String description);

    /**
     * Fetches all services owned by a user.
     *
     * @param id_user_owner The ID of the user who owns the services.
     * @return A list of services owned by the user.
     */
    List<Service> getAllServices(int id_user_owner);

    /**
     * Fetches a service by its ID.
     *
     * @param serviceId The ID of the service to fetch.
     * @return The service with the given ID, or `null` if no such service exists.
     */
    Service getService(int serviceId);
}