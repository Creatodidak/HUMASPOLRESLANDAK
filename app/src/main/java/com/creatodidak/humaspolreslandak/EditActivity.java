package com.creatodidak.humaspolreslandak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.creatodidak.humaspolreslandak.Model.PostPutDelLaporan;
import com.creatodidak.humaspolreslandak.Rest.ApiClient;
import com.creatodidak.humaspolreslandak.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    EditText edtLaporan;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtLaporan = (EditText) findViewById(R.id.edtLaporan);
        Intent mIntent = getIntent();
        edtLaporan.setText(mIntent.getStringExtra("Laporan"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelLaporan> updateLaporanCall = mApiInterface.putLaporan(

                        edtLaporan.getText().toString());
                updateLaporanCall.enqueue(new Callback<PostPutDelLaporan>() {
                    @Override
                    public void onResponse(Call<PostPutDelLaporan> call, Response<PostPutDelLaporan> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelLaporan> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtLaporan.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelLaporan> deleteLaporan = mApiInterface.deleteLaporan(edtLaporan.getText().toString());
                    deleteLaporan.enqueue(new Callback<PostPutDelLaporan>() {
                        @Override
                        public void onResponse(Call<PostPutDelLaporan> call, Response<PostPutDelLaporan> response) {
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelLaporan> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}