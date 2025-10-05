package com.gudang.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorController {

    @FXML
    private Label lblErrorMessage;

    /**
     * Mengatur pesan error yang akan ditampilkan di jendela.
     * @param message Pesan error.
     */
    public void setErrorMessage(String message) {
        lblErrorMessage.setText(message);
    }

    /**
     * Menutup jendela error saat tombol OK di-klik.
     */
    @FXML
    private void close(ActionEvent event) {
        // Mendapatkan stage dari tombol dan menutupnya
        ((Stage) lblErrorMessage.getScene().getWindow()).close();
    }
}
