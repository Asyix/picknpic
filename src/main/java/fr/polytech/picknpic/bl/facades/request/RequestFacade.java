package fr.polytech.picknpic.bl.facades.request;

import fr.polytech.picknpic.bl.models.Request;

/**
 * Facade for handling request operations.
 * Provides a simplified interface for interacting with the ManageRequestsFacade.
 */
public class RequestFacade {

    /** The singleton instance of the RequestFacade. */
    private static RequestFacade requestFacadeInstance;

    /** The ManageRequestsFacade used to handle request operations. */
    private final ManageRequestsFacade manageRequestsFacade;

    /**
     * Constructs a new RequestFacade instance.
     * Initializes the {@link ManageRequestsFacade} singleton.
     */
    private RequestFacade() {
        this.manageRequestsFacade = ManageRequestsFacade.getInstance();
    }

    /**
     * Gets the singleton instance of the RequestFacade.
     *
     * @return The singleton instance of RequestFacade.
     */
    public static RequestFacade getRequestFacadeInstance() {
        if (requestFacadeInstance == null) {
            requestFacadeInstance = new RequestFacade();
        }
        return requestFacadeInstance;
    }

    /**
     * Creates a new request by delegating to the ManageRequestsFacade.
     *
     * @param id_user_buyer The ID of the user making the request.
     * @param id_service The ID of the service requested.
     * @param id_chat The ID of the associated chat.
     * @param message The message or details provided by the user.
     * @param image The image associated with the request (URL or file path).
     * @param status The initial status of the request.
     * @return The newly created {@link Request} object.
     */
    public Request createRequest(int id_user_buyer, int id_service, int id_chat, String message, String image, String status) {
        return manageRequestsFacade.createRequest(id_user_buyer, id_service, id_chat, message, image, status);
    }

    /**
     * Changes the status of an existing request by delegating to the ManageRequestsFacade.
     *
     * @param id_request The ID of the request to update.
     * @param newStatus The new status to set for the request.
     * @return The updated {@link Request} object.
     */
    public Request changeRequestStatus(int id_request, String newStatus) {
        return manageRequestsFacade.changeRequestStatus(id_request, newStatus);
    }
}
