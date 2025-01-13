
package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Notification;
import fr.polytech.picknpic.bl.models.NotificationType;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.NotificationDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PostgreSQL implementation of the `NotificationDAO` interface.
 */
public class NotificationDAOPostgres implements NotificationDAO {

    /**
     * Retrieves and displays a notification by its ID.
     *
     * @param notificationId The ID of the notification to display.
     * @return The `Notification` object if found.
     */
    @Override
    public Notification displayNotification(int notificationId) {
        String query = "SELECT notification_id, description, type FROM \"Notification\" WHERE notification_id = ?";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, notificationId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Notification notification = new Notification();
                    notification.setNotificationId(resultSet.getInt("notification_id"));
                    notification.setDescription(resultSet.getString("description"));
                    notification.setType(NotificationType.valueOf(resultSet.getString("type")));
                    return notification;
                } else {
                    throw new RuntimeException("No notification found with ID: " + notificationId);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving notification", e);
        }
    }
}
