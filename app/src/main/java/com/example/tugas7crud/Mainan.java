package com.example.tugas7crud;

public class Mainan {
    private String _id, _nama, _harga, _jenis;
    public Mainan (String id, String nama, String harga, String jenis) {
        this._id = id;
        this._nama = nama;
        this._harga = harga;
        this._jenis = jenis;
    }
    public Mainan() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama =_nama;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga =_harga;
    }
    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _jenis) {
        this._jenis =_jenis;
    }
}
