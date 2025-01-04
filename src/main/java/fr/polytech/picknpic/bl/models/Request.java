package fr.polytech.picknpic.bl.models;

/**
 * Represents a request in the Pick'n'Pic application.
 * This class models the data for a request created by a user for a specific service.
 */
public class Request {

    /** Unique identifier for the request. */
    private int id_request;

    /** Identifier for the buyer who created the request. */
    private int id_user_buyer;

    /** Identifier for the service being requested. */
    private int id_service;

    /** Identifier for the chat associated with the request. */
    private int id_chat;

    /** Image associated with the request, stored as a URL or file path. */
    private String image;

    /** Message or additional information provided by the buyer for the request. */
    private String message;

    /**
     * Status of the request.
     * Possible values: "waiting", "accepted waiting", "delivered", or "declined".
     */
    private String status;

    /**
     * Gets the unique identifier for the request.
     *
     * @return the unique request ID.
     */
    public int getIdRequest() {
        return id_request;
    }

    /**
     * Sets the unique identifier for the request.
     *
     * @param id_request the unique request ID.
     */
    public void setIdRequest(int id_request) {
        this.id_request = id_request;
    }

    /**
     * Gets the identifier for the buyer who created the request.
     *
     * @return the buyer's user ID.
     */
    public int getIdUserBuyer() {
        return id_user_buyer;
    }

    /**
     * Sets the identifier for the buyer who created the request.
     *
     * @param id_user_buyer the buyer's user ID.
     */
    public void setIdUserBuyer(int id_user_buyer) {
        this.id_user_buyer = id_user_buyer;
    }

    /**
     * Gets the identifier for the service being requested.
     *
     * @return the service ID.
     */
    public int getIdService() {
        return id_service;
    }

    /**
     * Sets the identifier for the service being requested.
     *
     * @param id_service the service ID.
     */
    public void setIdService(int id_service) {
        this.id_service = id_service;
    }

    /**
     * Gets the identifier for the chat associated with the request.
     *
     * @return the chat ID.
     */
    public int getIdChat() {
        return id_chat;
    }

    /**
     * Sets the identifier for the chat associated with the request.
     *
     * @param id_chat the chat ID.
     */
    public void setIdChat(int id_chat) {
        this.id_chat = id_chat;
    }

    /**
     * Gets the image associated with the request.
     *
     * @return the image URL or file path.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image associated with the request.
     *
     * @param image the image URL or file path.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the message or additional information provided by the buyer.
     *
     * @return the message text.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message or additional information provided by the buyer.
     *
     * @param message the message text.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the current status of the request.
     *
     * @return the status of the request.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the request.
     * Valid values are "waiting", "accepted waiting", "delivered", or "declined".
     *
     * @param status the status of the request.
     * @throws IllegalArgumentException if the status is invalid.
     */
    public void setStatus(String status) {
        if (status.equals("waiting") || status.equals("accepted waiting") || status.equals("delivered") || status.equals("declined")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status value");
        }
    }

    /**
     * Checks if the request has been delivered.
     *
     * @return true if the request is delivered, false otherwise.
     */
    public boolean isDelivered() {
        return "delivered".equals(this.status);
    }

    /**
     * Checks if the request is waiting for approval.
     *
     * @return true if the request status is "waiting", false otherwise.
     */
    public boolean isWaiting() {
        return "waiting".equals(this.status);
    }

    /**
     * Converts the request to a string representation for debugging.
     *
     * @return a string representation of the request object.
     */
    @Override
    public String toString() {
        return "Request{" +
                "id_request=" + id_request +
                ", id_user_buyer=" + id_user_buyer +
                ", id_service=" + id_service +
                ", id_chat=" + id_chat +
                ", image='" + image + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
