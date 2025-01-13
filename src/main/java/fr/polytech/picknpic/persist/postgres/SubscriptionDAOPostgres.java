
package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.SubscriptionDAO;
import fr.polytech.picknpic.bl.models.Subscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PostgreSQL implementation of the {@link SubscriptionDAO} interface.
 * Provides methods for subscribing to a subscription and viewing subscription benefits.
 */
public class SubscriptionDAOPostgres implements SubscriptionDAO {

    /**
     * Subscribes the current user to a subscription offered by another user.
     *
     * @param currentUserId                The ID of the user subscribing.
     * @param userThatOffersSubscriptionId The ID of the user offering the subscription.
     */
    @Override
    public void subscribe(int currentUserId, int userThatOffersSubscriptionId) {
        String query = "INSERT INTO \"User_Subscriptions\" (subscriber_id, subscription_id) VALUES (?, ?)";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, currentUserId);
            statement.setInt(2, userThatOffersSubscriptionId);

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
     * Retrieves a subscription by its ID.
     *
     * @param subscriptionId The ID of the subscription to retrieve.
     * @return The {@link Subscription} object with the specified ID.
     */
    @Override
    public Subscription getSubscriptionById(int subscriptionId) {
        String query = "SELECT provider_id, discount, description FROM \"Subscription\" WHERE subscription_id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, subscriptionId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Subscription subscription = new Subscription(subscriptionId);
                    subscription.setProviderId(resultSet.getInt("provider_id"));
                    subscription.setDiscount(resultSet.getDouble("discount"));
                    subscription.setDescription(resultSet.getString("description"));
                    return subscription;
                } else {
                    throw new RuntimeException("No subscription found with ID: " + subscriptionId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving subscription by ID", e);
        }
    }
}
