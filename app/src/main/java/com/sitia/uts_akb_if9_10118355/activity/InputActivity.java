package com.sitia.uts_akb_if9_10118355.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sitia.uts_akb_if9_10118355.MainActivity;
import com.sitia.uts_akb_if9_10118355.R;
import com.sitia.uts_akb_if9_10118355.helper.SQLiteHelper;

import java.util.Date;

public class InputActivity extends AppCompatActivity {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    private EditText et_judul,et_kategori,et_catatan;
    private Date tanggal;
    private FloatingActionButton fabtambah;
    private SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        et_judul = findViewById(R.id.et_judul);
        et_kategori = findViewById(R.id.et_kategori);
        et_catatan = findViewById(R.id.et_catatan);
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        FloatingActionButton fabtambah = (FloatingActionButton)findViewById(R.id.fabtambah);

        helper = new SQLiteHelper(this);
        fabtambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tanggal = date.toString();
                String judul = et_judul.getText().toString();
                String kategori = et_kategori.getText().toString();
                String catatan = et_catatan.getText().toString();

                if(TextUtils.isEmpty(judul)){
                    et_judul.setError("Data Tidak boleh kosong");
                    et_judul.requestFocus();
                }else if(TextUtils.isEmpty(kategori)){
                    et_kategori.setError("Data Tidak boleh kosong");
                    et_kategori.requestFocus();
                }else if(TextUtils.isEmpty(catatan)){
                    et_catatan.setError("Data Tidak boleh kosong");
                    et_catatan.requestFocus();
                }else{
                    boolean isInsert = helper.insertData(tanggal,
                            judul,
                            kategori,
                            catatan);
                    if(isInsert){
                        Toast.makeText(InputActivity.this,"Data berhasil disimpan",Toast.LENGTH_SHORT).show();
                        kosong();
                        startActivity(new Intent(InputActivity.this, MainActivity.class));
                        finish();
                    }else {
                        Toast.makeText(InputActivity.this,"Data gagal disimpan",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }

            private void kosong(){

                et_judul.setText(null);
                et_kategori.setText(null);
                et_catatan.setText(null);
            }
        });
    }
}
