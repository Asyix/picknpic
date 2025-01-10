package fr.polytech.picknpic.bl.facades.request;

import fr.polytech.picknpic.bl.models.Request;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.RequestDAO;

/**
 * Facade for managing requests.
 * Provides a simplified interface for managing requests by delegating to the DAO layer.
 */
public class ManageRequestsFacade {

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /** The singleton instance of the ManageRequestsFacade. */
    private static ManageRequestsFacade manageRequestsFacade;

    /**
     * Constructs a new ManageRequestsFacade instance.
     * Initializes the {@link AbstractFactory} singleton for DAO creation.
     */
    private ManageRequestsFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Gets the singleton instance of the ManageRequestsFacade.
     *
     * @return The singleton instance of ManageRequestsFacade.
     */
    public static ManageRequestsFacade getInstance() {
        if (manageRequestsFacade == null) {
            manageRequestsFacade = new ManageRequestsFacade();
        }
        return manageRequestsFacade;
    }

    /**
     * Creates a new request.
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
        RequestDAO requestDAO = abstractFactory.createRequestDAO();
        return requestDAO.createRequest(id_user_buyer, id_service, id_chat, message, image, status);
    }

    /**
     * Changes the status of an existing request.
     *
     * @param id_request The ID of the request to update.
     * @param newStatus The new status to set for the request.
     * @return The updated {@link Request} object.
     */
    public Request changeRequestStatus(int id_request, String newStatus) {
        RequestDAO requestDAO = abstractFactory.createRequestDAO();
        return requestDAO.changeRequestStatus(id_request, newStatus);
    }
}