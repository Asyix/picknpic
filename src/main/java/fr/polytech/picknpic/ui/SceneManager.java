package fr.polytech.picknpic.ui;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private final Stage primaryStage;
    private final LoginFacade loginFacade;
    private User currentUser;

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.loginFacade = new LoginFacade();
    }

    public boolean loadLoginScene(Stage loginStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/login.fxml"));
            Scene scene = new Scene(loader.load());
            LoginController controller = loader.getController();

            // Passer l'instance de LoginFacade avec UserDAO injecté
            controller.setLoginFacade(loginFacade);
            controller.setSceneManager(this);

            loginStage.setScene(scene);
            loginStage.setTitle("Login");
            loginStage.showAndWait();

            return currentUser != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
