package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Request;

/**
 * Interface for performing data access operations related to requests.
 * Provides methods for creating and updating request data.
 */
public interface RequestDAO {

    /**
     * Creates a new request with the specified details.
     *
     * @param id_user_buyer The ID of the user making the request.
     * @param id_service The ID of the service requested.
     * @param id_chat The ID of the associated chat.
     * @param message The message or details provided by the user.
     * @param image The image associated with the request (URL or file path).
     * @param status The initial status of the request. Valid values are:
     *               "waiting", "accepted waiting", "delivered", or "declined".
     * @return The newly created {@link Request} object.
     */
    Request createRequest(int id_user_buyer, int id_service, int id_chat, String message, String image, String status);

    /**
     * Changes the status of an existing request.
     *
     * @param id_request The ID of the request to update.
     * @param newStatus The new status to set for the request.
     * @return The updated {@link Request} object with the new status.
     */
    Request changeRequestStatus(int id_request, String newStatus);

}
