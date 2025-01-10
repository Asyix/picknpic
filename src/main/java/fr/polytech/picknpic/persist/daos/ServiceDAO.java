package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Service;

import java.util.List;

/**
 * Interface for performing data access operations related to services.
 * Provides methods for creating, updating, deleting, and fetching services.
 */
public interface ServiceDAO {

    Service createService(int id_user_owner, String name, String example_image, float price, String description, int nb_buyers);

    boolean deleteService(int id_service);

    Service updateService(int id_service, String name, String example_image, float price, String description);

    List<Service> getAllServices(int id_user_owner);
}