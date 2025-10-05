package com.gudang.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorController {

    @FXML
    private Label lblErrorMessage;

    public void setErrorMessage(String message) {
        lblErrorMessage.setText(message);
    }

    @FXML
    private void close(ActionEvent event) {
        ((Stage) lblErrorMessage.getScene().getWindow()).close();
    }
}
