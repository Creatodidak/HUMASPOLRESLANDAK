package com.creatodidak.humaspolreslandak.Model;
import com.google.gson.annotations.SerializedName;

public class PostPutDelLaporan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Laporan mLaporan;
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
    public Laporan getLaporan() {
        return mLaporan;
    }
    public void setLaporan(Laporan Laporan) {
        mLaporan = Laporan;
    }

}