package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TambahSupplierController {

    @FXML private TextField txtTbhAlamat;
    @FXML private TextField txtTbhKode;
    @FXML private TextField txtTbhNama;
    @FXML private TextField txtTbhTelepon;
    @FXML private Label lblStatus;

    private Supplier supplier;
    private boolean isSaved = false;

    @FXML
    void simpanSupplier(ActionEvent event) {
        String kode = txtTbhKode.getText().trim();
        String nama = txtTbhNama.getText().trim();
        String telepon = txtTbhTelepon.getText().trim();

        if (kode.isEmpty() || nama.isEmpty() || telepon.isEmpty()) {
            lblStatus.setText("Error: Field wajib harus diisi.");
            return;
        }
        supplier = new Supplier(kode, nama, txtTbhAlamat.getText().trim(), telepon);
        isSaved = true;
        closeStage();
    }

    @FXML
    void batal(ActionEvent event) {
        closeStage();
    }

    public Supplier getResult() {
        if (isSaved) {
            return supplier;
        }
        return null;
    }

    private void closeStage() {
        ((Stage) txtTbhKode.getScene().getWindow()).close();
    }
}
