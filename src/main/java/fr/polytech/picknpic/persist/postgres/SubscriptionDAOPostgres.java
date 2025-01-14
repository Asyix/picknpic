package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.SubscriptionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PostgreSQL implementation of the {@link SubscriptionDAO} interface.
 * Provides methods for managing subscriptions in the database.
 */
public class SubscriptionDAOPostgres implements SubscriptionDAO {

    /**
     * Subscribes the current user to a subscription offered by another user.
     *
     * @param subscriberId The ID of the user subscribing.
     * @param providerId   The ID of the user offering the subscription.
     */
    @Override
    public void subscribe(int subscriberId, int providerId) {
        String query = "INSERT INTO \"Subscription\" (subscriber_id, provider_id) VALUES (?, ?)";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, subscriberId);
            statement.setInt(2, providerId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Subscription successful.");
            } else {
                System.out.println("Subscription failed.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while subscribing to a subscription", e);
        }
    }

    /**
     * Checks if a subscription exists between two users.
     *
     * @param subscriberId The ID of the subscriber.
     * @param providerId   The ID of the provider.
     * @return `true` if the subscription exists, `false` otherwise.
     */
    @Override
    public boolean isSubscribed(int subscriberId, int providerId) {
        String query = "SELECT 1 FROM \"Subscription\" WHERE subscriber_id = ? AND provider_id = ?";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, subscriberId);
            statement.setInt(2, providerId);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Returns true if a record exists
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while checking subscription status", e);
        }
    }

    /**
     * Deletes a subscription between a subscriber and a provider.
     *
     * @param subscriberId The ID of the subscriber.
     * @param providerId   The ID of the provider.
     */
    @Override
    public void unsubscribe(int subscriberId, int providerId) {
        String query = "DELETE FROM \"Subscription\" WHERE subscriber_id = ? AND provider_id = ?";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, subscriberId);
            statement.setInt(2, providerId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Unsubscription successful.");
            } else {
                System.out.println("No subscription found to delete.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while unsubscribing", e);
        }
    }
}
