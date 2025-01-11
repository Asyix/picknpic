package fr.polytech.picknpic.ui;

import fr.polytech.picknpic.ui.controllers.MainController;
import fr.polytech.picknpic.ui.controllers.MainLayoutController;
import fr.polytech.picknpic.ui.controllers.UserControllers.*;
import fr.polytech.picknpic.ui.controllers.PhotoControllers.*;
import fr.polytech.picknpic.ui.controllers.PurchaseControllers.*;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.fxml.FXML;

/**
 * Manages scenes and user interactions within the application.
 * Handles navigation between different views and maintains the current user state.
 */
public class SceneManager {

    /**
     * The primary stage of the application.
     */
    private static Stage primaryStage;

    /**
     * The main layout controller for managing the main application layout.
     */
    private static MainLayoutController mainLayoutController;

    /**
     * Constructs a new {@link SceneManager} instance.
     *
     * @param primaryStage The primary stage of the application.
     */
    public SceneManager(Stage primaryStage) {
        SceneManager.primaryStage = primaryStage;
    }

    /**
     * Loads the initial main scene and initializes the {@link MainController}.
     *
     * @throws Exception If an error occurs during the scene loading process.
     */
    public static void loadInitialScene() throws Exception {
        loadLoginScene();
    }

    private static void loadMainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/mainLayout.fxml"));
            Scene scene = new Scene(loader.load());

            mainLayoutController = loader.getController();

            loadMainScene();

            primaryStage.setScene(scene);
            primaryStage.setTitle("Pick'n'Pic");
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load main layout", e);
        }
    }

    public static void handleLogin() {
        loadMainLayout();
    }

    /**
     * Loads the login scene and initializes the {@link LoginController}.
     */
    public static void loadLoginScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/login.fxml"));
            Scene scene = new Scene(loader.load());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.sizeToScene();
            primaryStage.show(); // Pause until login is complete
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadRegisterScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/register.fxml"));
            Scene scene = new Scene(loader.load());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Register");
            primaryStage.sizeToScene();
            primaryStage.show(); // Pause until registration is complete
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadMainScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/hello.fxml"));
            Parent content = loader.load();
            MainController mainController = loader.getController();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadProfileScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/profile.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadManageUsersScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/manageUsers.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadUpdateAccountScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/User/updateAccount.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadPostsScene() {
        // Implementation for loading posts scene
    }

    public static void loadNotificationsScene() {
        // Implementation for loading notifications scene
    }

    public static void loadChatScene() {
        // Implementation for loading chat scene
    }

    public static void loadReportsScene() {
        // Implementation for loading reports scene
    }

    // The following methods are related to the Request use-case

    /**
     * Loads the create request scene.
     */
    @FXML
    public static void loadCreateRequestScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Request/createRequest.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the update request scene.
     */
    @FXML
    public static void loadChangeRequestStatusScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Request/changeRequestStatus.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // The following methods are related to the Service use-case

    /**
     * Loads the delete request scene.
     */
    @FXML
    public static void loadCreateServiceScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Service/createService.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the update service scene.
     */
    @FXML
    public static void loadUpdateServiceScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Service/updateService.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the delete service scene.
     */
    @FXML
    public static void loadDeleteServiceScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Service/deleteService.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the display all services scene.
     */
    @FXML
    public static void loadDisplayAllServicesScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Service/displayAllServices.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // The following methods are related to the Grade use-case

    /**
     * Loads the create grade scene.
     */
    @FXML
    public static void loadCreateGradeScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Grade/createGrade.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the update grade scene.
     */
    @FXML
    public static void loadDeleteGradeScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Grade/deleteGrade.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the display all grades scene.
     */
    @FXML
    public static void loadDisplayAllGradesScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Grade/displayAllGrades.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public static void loadSeeBenefitsScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Subscription/seeBenefits.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public static void loadDisplayNotificationScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Notification/displayNotification.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public static void loadDeletePhotoScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Photo/deletePhoto.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public static void loadDisplayPhotosScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Photo/displayPhotos.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public static void loadPublishPhotoScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Photo/publishPhoto.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadPurchasePhotoScene(int photoId) {
        System.out.println("Loading purchase scene with Photo ID: " + photoId);
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Photo/purchasePhoto.fxml"));
            Parent content = loader.load();

            // Pass the photo ID to PurchaseController
            PurchaseController controller = loader.getController();
            controller.setPhotoId(photoId);

            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load purchase photo scene", e);
        }
    }


    @FXML
    public static void loadUpdatePhotoDetailsScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Photo/updatePhotoDetails.fxml"));
            Parent content = loader.load();
            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public static void loadUniquePhotoDetailsScene(String photoUrl, int photoId) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Photo/uniquePhotoDetails.fxml"));
            Parent content = loader.load();

            DisplayUniquePhotoController controller = loader.getController();
            controller.setPhotoUrl(photoUrl);
            controller.setPhotoId(photoId);
            PurchaseController purchaseController = new PurchaseController();
            purchaseController.setPhotoId(photoId);

            if (mainLayoutController != null) {
                mainLayoutController.setContent(content);
                primaryStage.sizeToScene();
            } else {
                throw new RuntimeException("MainLayoutController is not initialized");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load unique photo scene", e);
        }
    }


}