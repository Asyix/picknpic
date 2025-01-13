
package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Purchase;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.PurchaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PostgreSQL implementation of the PurchaseDAO.
 */
public class PurchaseDAOPostgres implements PurchaseDAO {

    /**
     * Creates a new purchase in the database.
     *
     * @param purchase The purchase to be created.
     * @return true if the purchase was successfully created, false otherwise.
     */
    @Override
    public boolean createPurchase(Purchase purchase) {
        String query = "INSERT INTO \"Purchase\" (photo_id, user_id) VALUES (?, ?)";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, purchase.getPhotoId());
            statement.setInt(2, purchase.getUserId());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; // Return true if at least one row was inserted

        } catch (SQLException e) {
            System.err.println("Error creating purchase: " + e.getMessage());
            return false;
        }
    }
}
