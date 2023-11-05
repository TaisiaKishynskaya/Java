package com.example.studentgroupapp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeleteConfirmationDialogController {
    private Stage dialogStage;
    private boolean deleteConfirmed = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.initStyle(StageStyle.UTILITY);
    }

    public boolean isDeleteConfirmed() {
        return deleteConfirmed;
    }

    @FXML
    private void handleDelete() {
        deleteConfirmed = true;
        dialogStage.close();
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}