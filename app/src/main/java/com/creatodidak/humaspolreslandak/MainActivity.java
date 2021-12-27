package com.creatodidak.humaspolreslandak;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.creatodidak.humaspolreslandak.Adapter.AdapterLaporan;
import com.creatodidak.humaspolreslandak.Model.GetLaporan;
import com.creatodidak.humaspolreslandak.Model.Laporan;
import com.creatodidak.humaspolreslandak.Rest.ApiClient;
import com.creatodidak.humaspolreslandak.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<GetLaporan> laporanCall = mApiInterface.getLaporan();
        laporanCall.enqueue(new Callback<GetLaporan>() {
            @Override
            public void onResponse(Call<GetLaporan> call, Response<GetLaporan>
                    response) {
                List<Laporan> LaporanList = response.body().getListDataLaporan();
                Log.d("Retrofit Get", "Jumlah data Laporan: " +
                        String.valueOf(LaporanList.size()));
                mAdapter = new AdapterLaporan(LaporanList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetLaporan> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}