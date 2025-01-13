
package fr.polytech.picknpic.bl.facades.purchase;

import fr.polytech.picknpic.bl.models.Purchase;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.PurchaseDAO;

/**
 * Singleton facade for handling purchase-related business logic.
 */
public class PurchaseFacade {

    private static PurchaseFacade purchaseFacade;
    private final AbstractFactory abstractFactory;

    /**
     * Private constructor to initialize the PurchaseFacade with the AbstractFactory.
     */
    private PurchaseFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the PurchaseFacade.
     *
     * @return The singleton instance of PurchaseFacade.
     */
    public static PurchaseFacade getPurchaseFacadeInstance() {
        if (purchaseFacade == null) {
            purchaseFacade = new PurchaseFacade();
        }
        return purchaseFacade;
    }

    /**
     * Makes a purchase for a specific photo and user.
     *
     * @param photoId The ID of the photo to be purchased.
     * @param userId  The ID of the user making the purchase.
     */
    public void purchase(int photoId, int userId) {
        PurchaseDAO purchaseDAO = abstractFactory.createPurchaseDAO();
        Purchase purchase = new Purchase();
        purchase.setPhotoId(photoId);
        purchase.setUserId(userId);

        boolean success = purchaseDAO.createPurchase(purchase);
        if (!success) {
            throw new RuntimeException("Failed to create purchase for photo ID: " + photoId);
        }
    }
}
