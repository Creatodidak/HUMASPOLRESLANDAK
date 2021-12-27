package com.creatodidak.humaspolreslandak.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class GetLaporan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Laporan> listDataLaporan;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Laporan> getListDataLaporan() {
        return listDataLaporan;
    }
    public void setListDataLaporan(List<Laporan> listDataLaporan) {
        this.listDataLaporan = listDataLaporan;
    }
}