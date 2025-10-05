package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HapusSupplierController {

    @FXML
    private Label lblConfirmMessage;
    private boolean confirmed = false;

    public void initData(Supplier supplier) {
        lblConfirmMessage.setText("Apakah Anda yakin ingin menghapus supplier:\n" + supplier.getKode() + " - " + supplier.getNama() + "?");
    }

    @FXML
    private void hapus(ActionEvent event) {
        confirmed = true;
        closeStage();
    }

    @FXML
    private void batal(ActionEvent event) {
        closeStage();
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    private void closeStage() {
        ((Stage) lblConfirmMessage.getScene().getWindow()).close();
    }
}

