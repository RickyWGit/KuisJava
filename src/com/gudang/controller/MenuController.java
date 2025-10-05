package com.gudang.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private void openBarang() {
        try {
            Stage stage = new Stage();
            // KOREKSI: Typo "-" diubah menjadi "="
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Barang.fxml"));
            // KOREKSI: Menggunakan Parent untuk menampung hasil load()
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Manajemen Barang");
            stage.show();
        } catch (IOException e) {
            System.err.println("Gagal membuka window Manajemen Barang.");
            e.printStackTrace();
        }
    }

    @FXML
    private void openSupplier() {
        try {
            Stage stage = new Stage();
            // KOREKSI: Typo path "/vwe/supplier.fxml" diubah menjadi "/view/Supplier.fxml" (asumsi)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Supplier.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Manajemen Supplier");
            stage.show();
        } catch (IOException e) {
            System.err.println("Gagal membuka window Manajemen Supplier.");
            e.printStackTrace();
        }
    }
}

