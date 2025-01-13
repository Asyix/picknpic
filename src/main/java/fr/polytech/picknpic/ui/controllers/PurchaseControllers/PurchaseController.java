
package fr.polytech.picknpic.ui.controllers.PurchaseControllers;

import fr.polytech.picknpic.bl.facades.purchase.PurchaseFacade;
import fr.polytech.picknpic.ui.controllers.PhotoControllers.DisplayUniquePhotoController;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Photo;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * Controller for handling purchase-related actions in the UI.
 */
public class PurchaseController {

    /**
     * The facade for purchase-related operations.
     */
    private final PurchaseFacade purchaseFacade;

    /**
     * The current photo to be purchased.
     */
    private Photo currentPhoto;

    /**
     * The controller for displaying unique photo details.
     */
    private DisplayUniquePhotoController displayUniquePhotoController;

    @FXML
    private Label confirmationLabel;

    /**
     * Constructor for initializing the PurchaseController.
     */
    public PurchaseController() {
        this.purchaseFacade = PurchaseFacade.getPurchaseFacadeInstance();
    }

    /**
     * Initializes the controller with the confirmationLabel
     */
    @FXML
    public void initialize() {
        // Update the label if the photo is already set
        if (currentPhoto != null) {
            updateConfirmationLabel();
        }
    }

    /**
     * Setter method to set the current photo
     */
    public void setPhoto(Photo photo) {
        this.currentPhoto = photo;
    }

    /**
     * Updates the confirmation label with the current photo name.
     */
    private void updateConfirmationLabel() {
        if (confirmationLabel != null) {
            if (currentPhoto != null) {
                confirmationLabel.setText("ARE YOU SURE YOU WANT TO BUY “" + currentPhoto.getTitle() + "”?");
            } else {
                confirmationLabel.setText("No photo selected.");
            }
        } else {
            System.err.println("Error: confirmationLabel is null in updateConfirmationLabel.");
        }
    }

    /**
     * Loads the main scene.
     * This method will be triggered when the user clicks "NO" in the confirm delete dialog.
     */
    @FXML
    public void loadMainScene() throws Exception {
        SceneManager.loadMainScene();
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

    /**
     * Handles the action of making a purchase.
     *
     * @param photo The photo to be purchased.
     */
    @FXML
    public void makePurchase(Photo photo) {

        try {
            System.out.println("Attempting to purchase photo with ID: " + photo.getPhotoId());
            // Validate the photo ID
            if (photo.getPhotoId() <= 0) {
                throw new IllegalArgumentException("Invalid photo ID.");
            }

            // Get the current user ID
            int currentUserId = LoginFacade.getInstance().getCurrentUser().getId();

            // Make the purchase
            purchaseFacade.purchase(photo.getPhotoId(), currentUserId);

            // Show success alert
            showAlert(Alert.AlertType.INFORMATION, "Purchase Successful",
                    "The purchase has been successfully completed.");
            loadMainScene();
        } catch (Exception e) {
            // Handle and show error alert
            showAlert(Alert.AlertType.ERROR, "Purchase Failed",
                    "An error occurred while making the purchase: " + e.getMessage());
        }
    }

    /**
     * Calls the makePurhcase method with the current photo
     */
    public void handlePurchase() {
        makePurchase(this.currentPhoto);
    }
}
