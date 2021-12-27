package com.creatodidak.humaspolreslandak.Model;

import com.google.gson.annotations.SerializedName;

public class Laporan {
    @SerializedName("id")
    private String id;
    @SerializedName("laporan")
    private String laporan;
    @SerializedName("personil")
    private String personil;
    @SerializedName("satuan")
    private String satuan;

    public Laporan(){}

    public Laporan(String id, String laporan, String personil, String satuan) {
        this.id = id;
        this.laporan = laporan;
        this.personil = personil;
        this.satuan = satuan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLaporan() {
        return laporan;
    }

    public void setLaporan(String laporan) {
        this.laporan = laporan;
    }

    public String getPersonil() {
        return personil;
    }

    public void setPersonil(String personil) {
        this.personil = personil;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}