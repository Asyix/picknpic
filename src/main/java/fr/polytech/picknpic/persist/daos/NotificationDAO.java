package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Notification;

/**
 * Data Access Object (DAO) interface for managing notifications.
 */
public interface NotificationDAO {

    /**
     * Retrieves and displays a notification by its ID.
     *
     * @param notificationId The ID of the notification to display.
     * @return The `Notification` object if found.
     */
    Notification displayNotification(int notificationId);
}
