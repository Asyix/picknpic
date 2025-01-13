package fr.polytech.picknpic.bl.facades.notification;

import fr.polytech.picknpic.bl.models.Notification;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.NotificationDAO;

/**
 * Facade for managing notifications.
 * Provides a simplified interface for retrieving notification details.
 */
public class NotificationFacade {

    private final AbstractFactory abstractFactory;
    private static NotificationFacade notificationFacade;

    /**
     * Private constructor to enforce Singleton pattern.
     */
    private NotificationFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the NotificationFacade.
     *
     * @return The singleton instance of NotificationFacade.
     */
    public static NotificationFacade getNotificationFacadeInstance() {
        if (notificationFacade == null) {
            notificationFacade = new NotificationFacade();
        }
        return notificationFacade;
    }

    /**
     * Retrieves a notification by its ID.
     *
     * @param notificationId The ID of the notification to retrieve.
     * @return The Notification object.
     */
    public Notification displayNotification(int notificationId) {
        NotificationDAO notificationDAO = abstractFactory.createNotificationDAO();
        return notificationDAO.displayNotification(notificationId);
    }
}