package fr.polytech.picknpic.ui.controllers.PostControllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ConfirmDeleteController {

    private Stage dialogStage;
    private boolean confirmed = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @FXML
    private void handleYes() {
        confirmed = true;
        dialogStage.close();
    }

    @FXML
    private void handleNo() {
        dialogStage.close();
    }
}