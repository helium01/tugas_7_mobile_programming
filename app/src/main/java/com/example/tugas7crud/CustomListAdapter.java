package com.example.tugas7crud;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Mainan> Mainan;
    public CustomListAdapter(Activity activity, List<Mainan> Mainan) {
        this.activity = activity;
        this.Mainan = Mainan;
    }
    @Override
    public int getCount() {
        return Mainan.size();
    }
    @Override
    public Object getItem(int location) {
        return Mainan.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout .custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView harga = (TextView)
                convertView.findViewById(R.id.text_harga);
        TextView jenis = (TextView)
                convertView.findViewById(R.id.text_jenis);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Mainan m = Mainan.get(position);
        nama.setText("Nama : "+ m.get_nama());
        harga.setText("Harga : "+ m.get_harga());
        jenis.setText("Jenis : "+ m.get_jenis());
        return convertView;
    }
}
