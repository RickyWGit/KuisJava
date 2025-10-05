package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditSupplierController {

    @FXML private TextField txtEditKode;
    @FXML private TextField txtEditNama;
    @FXML private TextField txtEditAlamat;
    @FXML private TextField txtEditTelepon;
    @FXML private Label lblStatus;

    private Supplier supplierToEdit;
    private boolean isSaved = false;

    public void initData(Supplier supplier) {
        this.supplierToEdit = supplier;
        txtEditKode.setText(supplier.getKode());
        txtEditNama.setText(supplier.getNama());
        txtEditAlamat.setText(supplier.getAlamat());
        txtEditTelepon.setText(supplier.getTelepon());
    }

    @FXML
    void simpanPerubahan(ActionEvent event) {
        String nama = txtEditNama.getText().trim();
        String telepon = txtEditTelepon.getText().trim();

        if (nama.isEmpty() || telepon.isEmpty()) {
            lblStatus.setText("Error: Nama dan Telepon wajib diisi.");
            return;
        }

        supplierToEdit.setNama(nama);
        supplierToEdit.setAlamat(txtEditAlamat.getText().trim());
        supplierToEdit.setTelepon(telepon);

        isSaved = true;
        closeStage();
    }

    @FXML
    void batal(ActionEvent event) {
        closeStage();
    }

    public boolean isSaved() {
        return isSaved;
    }

    private void closeStage() {
        ((Stage) txtEditKode.getScene().getWindow()).close();
    }
}

