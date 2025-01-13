
package fr.polytech.picknpic.bl.models;

/**
 * Represents a Notification in the system.
 */
public class Notification {

    // Fields
    private int notificationId;
    private String description;
    private NotificationType type;

    // Constructor
    public Notification() {}

    // Getters and Setters

    /**
     * Gets the notification ID.
     * @return the notification ID.
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * Sets the notification ID.
     * @param notificationId the notification ID to set.
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Gets the description of the notification.
     * @return the description of the notification.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the notification.
     * @param description the description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the type of the notification.
     * @return the type of the notification.
     */
    public NotificationType getType() {
        return type;
    }

    /**
     * Sets the type of the notification.
     * @param type the type to set.
     */
    public void setType(NotificationType type) {
        this.type = type;
    }
}
