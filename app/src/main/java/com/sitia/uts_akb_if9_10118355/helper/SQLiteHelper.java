package com.sitia.uts_akb_if9_10118355.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    private static final String NAMA_DATABASE = "catatan.db";
    private static final String NAMA_TABLE = "catatan";

    private static final String COL1 = "ID";
    private static final String COL2 = "TANGGAL";
    private static final String COL3 = "JUDUL";
    private static final String COL4 = "KATEGORI";
    private static final String COL5 = "CATATAN";

    public SQLiteHelper(@Nullable Context context ) {
        super(context, NAMA_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+NAMA_TABLE+" (" +
                COL1+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL2+ " TEXT, "+
                COL3+ " TEXT, "+
                COL4+ " TEXT, "+
                COL5+ " TEXT "+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+NAMA_TABLE);
    }

    public boolean insertData(String tanggal,String judul,String kategori,String catatan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL2,tanggal);
        values.put(COL3,judul);
        values.put(COL4,kategori);
        values.put(COL5,catatan);
        long result = db.insert(NAMA_TABLE,null,values);
        return result != -1;
    }

    public Cursor getDataAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM "+NAMA_TABLE+" ORDER BY "+COL2,null);
    }


    public boolean updateData(String id,String tanggal,String judul,String kategori,String catatan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL1,id);
        values.put(COL2,tanggal);
        values.put(COL3,judul);
        values.put(COL4,kategori);
        values.put(COL5,catatan);

        db.update(NAMA_TABLE,values,COL1+" = ? ",new String[]{id});
        return true;

    }

    public Integer deteleData(String id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(NAMA_TABLE, COL1+" = ? ",new String[]{id});
    }
}
