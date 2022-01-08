package com.example.tugas7crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_mainan";
    private static final String tb_mainan = "tb_mainan";
    private static final String tb_kos_id = "id";
    private static final String tb_kos_nama = "nama";
    private static final String tb_kos_harga = "harga";
    private static final String tb_barang_jenis = "jenis";
    private static final String CREATE_TABLE_MAINAN = "CREATE TABLE " +
            tb_mainan + "("
            + tb_kos_id + " INTEGER PRIMARY KEY ,"
            + tb_kos_nama + " TEXT,"
            + tb_kos_harga + " TEXT, "
            + tb_barang_jenis + " TEXT" + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAINAN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateMainan (Mainan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kos_id, mdNotif.get_id());
        values.put(tb_kos_nama, mdNotif.get_nama());
        values.put(tb_kos_harga, mdNotif.get_harga());
        values.put(tb_barang_jenis, mdNotif.get_jenis());
        db.insert(tb_mainan, null, values);
        db.close();
    }
    public List<Mainan> ReadMainan() {
        List<Mainan> judulModelList = new ArrayList<Mainan>();
        String selectQuery = "SELECT * FROM " + tb_mainan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor Cursor = db.rawQuery(selectQuery, null);
        if (Cursor.moveToFirst()) {
            do {
                Mainan mdKontak = new Mainan();
                mdKontak.set_id(Cursor .getString(0));
                mdKontak.set_nama(Cursor .getString(1));
                mdKontak.set_harga(Cursor .getString(2));
                mdKontak.set_jenis(Cursor .getString(3));
                judulModelList.add(mdKontak);
            } while (Cursor .moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateMainan (Mainan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kos_nama, mdNotif.get_nama());
        values.put(tb_kos_harga, mdNotif.get_harga());
        values.put(tb_barang_jenis, mdNotif.get_jenis());
        return db.update(tb_mainan, values, tb_kos_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteMainan (Mainan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_mainan, tb_kos_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}