package com.gudang.controller;

import java.io.IOException;
import com.gudang.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SupplierController {

    @FXML private TableView<Supplier> tblSupplier;
    @FXML private TableColumn<Supplier, String> colKode;
    @FXML private TableColumn<Supplier, String> colNama;
    @FXML private TableColumn<Supplier, String> colAlamat;
    @FXML private TableColumn<Supplier, String> colTelepon;
    @FXML private Label lblStatus;

    private final ObservableList<Supplier> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        tblSupplier.setItems(data);
    }

    // KOREKSI: Nama metode diubah agar sesuai dengan tujuannya (membuka form)
    @FXML
    private void bukaFormTambah(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TambahSupplier.fxml"));
            Parent root = loader.load();
            TambahSupplierController controller = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Tambah Supplier Baru");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();

            Supplier supplierBaru = controller.getResult();
            if (supplierBaru != null) {
                boolean isDuplicate = data.stream().anyMatch(s -> s.getKode().equalsIgnoreCase(supplierBaru.getKode()));
                if (isDuplicate) {
                    lblStatus.setText("Error: Kode supplier sudah ada.");
                } else {
                    data.add(supplierBaru);
                    lblStatus.setText("Info: Supplier berhasil ditambahkan.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            lblStatus.setText("Error: Gagal membuka form.");
        }
    }

    // KOREKSI: Nama metode diubah
    @FXML
    private void bukaFormEdit(ActionEvent event) {
        Supplier selected = tblSupplier.getSelectionModel().getSelectedItem();
        if (selected == null) {
            lblStatus.setText("Error: Pilih supplier yang akan di-edit.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EditSupplier.fxml"));
            Parent root = loader.load();
            EditSupplierController controller = loader.getController();
            controller.initData(selected);

            Stage stage = createModalStage("Edit Supplier", root);
            stage.showAndWait();

            if (controller.isSaved()) {
                tblSupplier.refresh();
                lblStatus.setText("Info: Data supplier berhasil diperbarui.");
            }
        } catch (IOException e) {
            handleLoadError(e);
        }
    }

    @FXML
    private void hapusSupplier(ActionEvent event) {

    }

    private boolean isKodeDuplicate(String kode) {
        return data.stream().anyMatch(s -> s.getKode().equalsIgnoreCase(kode));
    }

    private Stage createModalStage(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        return stage;
    }

    private void handleLoadError(IOException e) {
        e.printStackTrace();
        lblStatus.setText("Error: Gagal membuka halaman baru.");
    }
}

