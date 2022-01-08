package com.example.tugas7crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Mainan> ListMainan = new ArrayList<Mainan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout .activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMainan );
        mListView = (ListView) findViewById(R.id.list_mainan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMainan.clear();
        List<Mainan> mainan= db.ReadMainan();
        for (Mainan main: mainan) {
            Mainan judulModel = new Mainan();
            judulModel.set_id(main.get_id());
            judulModel.set_nama(main.get_nama());
            judulModel.set_harga(main.get_harga());
            judulModel.set_jenis(main.get_jenis());
            ListMainan.add(judulModel);
            if ((ListMainan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Mainan detailmain = (Mainan) o;
        String Sid = detailmain.get_id();
        String Snama = detailmain.get_nama();
        String Sharga = detailmain.get_harga();
        String Sjenis = detailmain.get_jenis();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iharga", Sharga);
        goUpdel.putExtra("Ijenis", Sjenis);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMainan.clear();
        mListView.setAdapter(adapter_off);
        List<Mainan> mainan = db.ReadMainan();
        for (Mainan main : mainan) {
            Mainan judulModel = new Mainan();
            judulModel.set_id(main.get_id());
            judulModel.set_nama(main.get_nama());
            judulModel.set_harga(main.get_harga());
            judulModel.set_jenis(main.get_jenis());
            ListMainan.add(judulModel);
            if ((ListMainan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}