package fr.polytech.picknpic.ui.controllers.PurchaseControllers;

import fr.polytech.picknpic.bl.facades.purchase.PurchaseFacade;
import fr.polytech.picknpic.ui.controllers.PhotoControllers.DisplayUniquePhotoController;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Controller for handling purchase-related actions in the UI.
 */
public class PurchaseController {

    private final PurchaseFacade purchaseFacade;

    private SceneManager sceneManager;

    private int photoId;

    private DisplayUniquePhotoController displayUniquePhotoController;

    /**
     * Constructor for initializing the PurchaseController.
     */
    public PurchaseController() {
        this.purchaseFacade = PurchaseFacade.getPurchaseFacadeInstance();
    }

    /**
     * Handles the action of making a purchase.
     *
     * @param photoId The ID of the photo to be purchased.
     */
    @FXML
    public void makePurchase(int photoId) {

        try {
            System.out.println("Attempting to purchase photo with ID: " + photoId);
            // Validate the photo ID
            if (photoId <= 0) {
                throw new IllegalArgumentException("Invalid photo ID.");
            }

            // Get the current user ID
            int currentUserId = LoginFacade.getInstance().getCurrentUser().getId();

            // Make the purchase
            purchaseFacade.purchase(photoId, currentUserId);

            // Show success alert
            showAlert(Alert.AlertType.INFORMATION, "Purchase Successful",
                    "The purchase has been successfully completed.");
        } catch (Exception e) {
            // Handle and show error alert
            showAlert(Alert.AlertType.ERROR, "Purchase Failed",
                    "An error occurred while making the purchase: " + e.getMessage());
        }
    }

    public void handlePurchase() {
        makePurchase(this.photoId);
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    /**
     * Loads the main scene.
     * This method will be triggered when the user clicks "NO" in the confirm delete dialog.
     */
    @FXML
    public void loadMainScene() throws Exception {
        sceneManager.loadMainScene();
    }

    /**
     * Displays an alert dialog.
     *
     * @param alertType The type of alert to display.
     * @param title     The title of the alert.
     * @param message   The message of the alert.
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
