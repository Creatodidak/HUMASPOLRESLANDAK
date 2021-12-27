package com.creatodidak.humaspolreslandak.Rest;

import com.creatodidak.humaspolreslandak.Model.GetLaporan;
import com.creatodidak.humaspolreslandak.Model.PostPutDelLaporan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("laporan_android")
    Call<GetLaporan> getLaporan();
    @FormUrlEncoded
    @POST("laporan")
    Call<PostPutDelLaporan> postLaporan(@Field("laporan") String laporan);
    @FormUrlEncoded
    @PUT("laporan")
    Call<PostPutDelLaporan> putLaporan(@Field("id") String id);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "laporan", hasBody = true)
    Call<PostPutDelLaporan> deleteLaporan(@Field("id") String id);
}