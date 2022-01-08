package com.example.tugas7crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sharga, Sjenis;
    private EditText Enama, Eharga, Ejenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout .activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sharga = i.getStringExtra("Iharga");
        Sjenis = i.getStringExtra("Ijenis");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Enama.setText(Snama);
        Eharga.setText(Sharga);
        Ejenis.setText(Sjenis);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sharga = String.valueOf(Eharga.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama produk",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")) {
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi data ",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMainan(new Mainan(Sid, Snama, Sharga, Sjenis));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMainan(new Mainan(Sid, Snama, Sharga, Sjenis));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
