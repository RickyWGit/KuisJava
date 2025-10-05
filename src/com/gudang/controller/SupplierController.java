package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupplierController {

    @FXML private TableView<Supplier> tblSupplier;
    @FXML private TableColumn<Supplier, String> colKode;
    @FXML private TableColumn<Supplier, String> colNama;
    @FXML private TableColumn<Supplier, String> colAlamat;
    @FXML private TableColumn<Supplier, String> colTelepon;

    @FXML private TextField txtAlamat;
    @FXML private TextField txtCode;
    @FXML private TextField txtNama;
    @FXML private TextField txtTel;

    @FXML private Label lblStatus;

    private final ObservableList<Supplier> data = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        tblSupplier.setItems(data);

        tblSupplier.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    showSupplierDetails(newSelection);
                }
            }
        );
    }
    private void showSupplierDetails(Supplier supplier) {
        txtCode.setText(supplier.getKode());
        txtNama.setText(supplier.getNama());
        txtAlamat.setText(supplier.getAlamat());
        txtTel.setText(supplier.getTelepon());
    }

    @FXML
    void tambahSupplier(ActionEvent event) {
        String kode = txtCode.getText().trim();
        String nama = txtNama.getText().trim();
        String telepon = txtTel.getText().trim();
        String alamat = txtAlamat.getText().trim();

        if (kode.isEmpty() || nama.isEmpty() || telepon.isEmpty()) {
            lblStatus.setText("Error: Kode, Nama, dan Telepon harus diisi.");
            return;
        }

        for (Supplier supplier : data) {
            if (supplier.getKode().equalsIgnoreCase(kode)) {
                lblStatus.setText("Error: Kode supplier sudah ada.");
                return;
            }
        }

        data.add(new Supplier(kode, nama, alamat, telepon));
        clearFields();
        lblStatus.setText("Info: Supplier berhasil ditambahkan.");
    }

    @FXML
    void editSupplier(ActionEvent event) {
        Supplier selected = tblSupplier.getSelectionModel().getSelectedItem();

        if (selected == null) {
            lblStatus.setText("Error: Pilih supplier yang akan di-edit.");
            return;
        }

        String kode = txtCode.getText().trim();
        String nama = txtNama.getText().trim();
        String telepon = txtTel.getText().trim();
        String alamat = txtAlamat.getText().trim();

        if (kode.isEmpty() || nama.isEmpty() || telepon.isEmpty()) {
            lblStatus.setText("Error: Kode, Nama, dan Telepon tidak boleh kosong.");
            return;
        }
        selected.setKode(kode);
        selected.setNama(nama);
        selected.setAlamat(alamat);
        selected.setTelepon(telepon);

        tblSupplier.refresh();
        clearFields();
        lblStatus.setText("Info: Data supplier berhasil diperbarui.");
    }

    @FXML
    void hapusSupplier(ActionEvent event) {
        Supplier selected = tblSupplier.getSelectionModel().getSelectedItem();

        if (selected != null) {
            data.remove(selected);
            clearFields();
            lblStatus.setText("Info: Supplier berhasil dihapus.");
        } else {
            lblStatus.setText("Error: Pilih supplier yang akan dihapus.");
        }
    }

    private void clearFields() {
        txtCode.clear();
        txtNama.clear();
        txtAlamat.clear();
        txtTel.clear();
        tblSupplier.getSelectionModel().clearSelection();
    }
}

