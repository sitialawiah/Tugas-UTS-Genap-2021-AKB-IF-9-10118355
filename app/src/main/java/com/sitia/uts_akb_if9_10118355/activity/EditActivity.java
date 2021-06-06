package com.sitia.uts_akb_if9_10118355.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sitia.uts_akb_if9_10118355.MainActivity;
import com.sitia.uts_akb_if9_10118355.R;
import com.sitia.uts_akb_if9_10118355.helper.SQLiteHelper;

import java.util.Calendar;

public class EditActivity extends AppCompatActivity {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    DatePickerDialog picker;
    private EditText et_judul,et_kategori,et_catatan,et_tanggal;
    private FloatingActionButton fabtambah;
    private SQLiteHelper helper;
    private String id,tanggal,judul,kategori,catatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        et_tanggal=(EditText)findViewById(R.id.et_tanggal);
        et_judul = findViewById(R.id.et_judul);
        et_kategori = findViewById(R.id.et_kategori);
        et_catatan = findViewById(R.id.et_catatan);
        FloatingActionButton fabtambah = (FloatingActionButton)findViewById(R.id.fabtambah);

        et_tanggal.setInputType(InputType.TYPE_NULL);
        et_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(EditActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String date=String.format("%d-%02d-%02d ", year,monthOfYear+1,dayOfMonth);
                                et_tanggal.setText(date);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        helper = new SQLiteHelper(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            id=bundle.getString("ID");
            tanggal=bundle.getString("TANGGAL");
            judul=bundle.getString("JUDUL");
            kategori=bundle.getString("KATEGORI");
            catatan=bundle.getString("CATATAN");

            et_tanggal.setText(tanggal);
            et_judul.setText(judul);
            et_kategori.setText(kategori);
            et_catatan.setText(catatan);
        }

        fabtambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tanggal = et_tanggal.getText().toString();
                String judul = et_judul.getText().toString();
                String kategori = et_kategori.getText().toString();
                String catatan = et_catatan.getText().toString();

                if(TextUtils.isEmpty(tanggal)){
                    et_tanggal.setError("Data Tidak boleh kosong");
                    et_tanggal.requestFocus();
                }else if(TextUtils.isEmpty(judul)){
                    et_judul.setError("Data Tidak boleh kosong");
                    et_judul.requestFocus();
                }else if(TextUtils.isEmpty(kategori)){
                    et_kategori.setError("Data Tidak boleh kosong");
                    et_kategori.requestFocus();
                }else if(TextUtils.isEmpty(catatan)){
                    et_catatan.setError("Data Tidak boleh kosong");
                    et_catatan.requestFocus();
                }else{
                    boolean isUpdate = helper.updateData(id,
                            tanggal,
                            judul,
                            kategori,
                            catatan);
                    if(isUpdate){
                        Toast.makeText(EditActivity.this,"Data berhasil disimpan",Toast.LENGTH_SHORT).show();
                        kosong();
                        startActivity(new Intent(EditActivity.this, MainActivity.class));
                        finish();
                    }else {
                        Toast.makeText(EditActivity.this,"Data gagal disimpan",Toast.LENGTH_SHORT).show();
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
