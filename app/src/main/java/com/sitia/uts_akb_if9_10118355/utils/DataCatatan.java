package com.sitia.uts_akb_if9_10118355.utils;

public class DataCatatan {

    //04 Juni 2021 - 10118355 - Siti Alawiah - IF9

    private String ID;
    private String TANGGAL;
    private String JUDUL;
    private String KATEGORI;
    private String CATATAN;



    public DataCatatan(){
    }

    public DataCatatan(String ID, String TANGGAL, String JUDUL, String KATEGORI, String CATATAN) {
        this.ID = ID;
        this.TANGGAL = TANGGAL;
        this.JUDUL = JUDUL;
        this.KATEGORI = KATEGORI;
        this.CATATAN = CATATAN;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTANGGAL() {
        return TANGGAL;
    }

    public void setTANGGAL(String TANGGAL) {
        this.TANGGAL = TANGGAL;
    }

    public String getJUDUL() {
        return JUDUL;
    }

    public void setJUDUL(String JUDUL) {
        this.JUDUL = JUDUL;
    }

    public String getKATEGORI() {
        return KATEGORI;
    }

    public void setKATEGORI(String KATEGORI) {
        this.KATEGORI = KATEGORI;
    }

    public String getCATATAN() {
        return CATATAN;
    }

    public void setCATATAN(String CATATAN) {
        this.CATATAN = CATATAN;
    }
}
