package com.gudang.controller;

import com.gudang.model.Barang; // Import kelas model Barang
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BarangController {

    @FXML
    private TableColumn<Barang, Integer> colJumlah;
    @FXML
    private TableColumn<Barang, String> colNama;
    @FXML
    private TableView<Barang> tblBarang;
    @FXML
    private TextField txtNama, txtJumlah;

    private final ObservableList<Barang> data = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        colNama.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colJumlah.setCellValueFactory(cell -> cell.getValue().jumlahProperty().asObject());
        tblBarang.setItems(data);
    }

    @FXML
    private void editBarang(ActionEvent event) {
        Barang selected = tblBarang.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setNama(txtNama.getText());
            selected.setJumlah(Integer.parseInt(txtJumlah.getText()));
            tblBarang.refresh();
        }
    }

    @FXML
    private void hapusBarang(ActionEvent event) {
        Barang selected = tblBarang.getSelectionModel().getSelectedItem();
        if (selected != null){
            data.remove(selected);
        }
    }

    @FXML
    private void tambahBarang(ActionEvent event) {
        if (!txtNama.getText().isEmpty() && !txtJumlah.getText().isEmpty()) {
            data.add(new Barang(txtNama.getText(), Integer.parseInt(txtJumlah.getText())));
            txtNama.clear();
            txtJumlah.clear();
        }
    }
}

