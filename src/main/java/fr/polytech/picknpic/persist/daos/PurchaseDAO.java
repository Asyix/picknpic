
package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Purchase;

/**
 * Interface for Purchase Data Access Object (DAO).
 * Defines methods for interacting with the Purchase table in the database.
 */
public interface PurchaseDAO {

    /**
     * Creates a new purchase in the database.
     *
     * @param purchase The purchase to be created.
     * @return true if the purchase was successfully created, false otherwise.
     */
    boolean createPurchase(Purchase purchase);
}
