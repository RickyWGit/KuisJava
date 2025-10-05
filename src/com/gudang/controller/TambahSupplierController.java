package com.gudang.controller;

import java.io.IOException;

import com.gudang.model.Supplier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TambahSupplierController {

    @FXML private TextField txtTbhAlamat;
    @FXML private TextField txtTbhKode;
    @FXML private TextField txtTbhNama;
    @FXML private TextField txtTbhTelepon;

    private Supplier supplier;
    private boolean isSaved = false;

    @FXML
    void simpanSupplier(ActionEvent event) {
        String kode = txtTbhKode.getText().trim();
        String nama = txtTbhNama.getText().trim();
        String telepon = txtTbhTelepon.getText().trim();

        if (kode.isEmpty() || nama.isEmpty() || telepon.isEmpty()) {
            showError("Error: Field wajib harus diisi.");
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

    private void showError(String message) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Error.fxml"));
            Parent root = loader.load();
            ErrorController controller = loader.getController();
            controller.setErrorMessage(message);

            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait(); // Tampilkan dan tunggu sampai ditutup

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
