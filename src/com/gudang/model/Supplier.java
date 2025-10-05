package com.gudang.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Supplier {
    private final StringProperty kode;
    private final StringProperty nama;
    private final StringProperty alamat;
    private final StringProperty telepon;

    public Supplier(String kode, String nama, String alamat, String telepon) {
        this.kode = new SimpleStringProperty(kode);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public String getKode() { return kode.get(); }
    public void setKode(String value) { kode.set(value); }
    public StringProperty kodeProperty() { return kode; }

    public String getNama() { return nama.get(); }
    public void setNama(String value) { nama.set(value); }
    public StringProperty namaProperty() { return nama; }

    public String getAlamat() { return alamat.get(); }
    public void setAlamat(String value) { alamat.set(value); }
    public StringProperty alamatProperty() { return alamat; }

    public String getTelepon() { return telepon.get(); }
    public void setTelepon(String value) { telepon.set(value); }
    public StringProperty teleponProperty() { return telepon; }
}
