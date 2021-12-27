package com.creatodidak.humaspolreslandak.Adapter;

import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.creatodidak.humaspolreslandak.EditActivity;
import com.creatodidak.humaspolreslandak.Model.Laporan;
import com.creatodidak.humaspolreslandak.R;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class AdapterLaporan extends RecyclerView.Adapter<AdapterLaporan.MyViewHolder>{
    List<Laporan> mLaporanList;

    public AdapterLaporan(List <Laporan> LaporanList) {
        mLaporanList = LaporanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.laporan_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override


    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("Id = " + mLaporanList.get(position).getId());
        holder.mTextViewLaporan.setText("Laporan = " + mLaporanList.get(position).getLaporan());
        holder.mTextViewPersonil.setText("Personil = " + mLaporanList.get(position).getPersonil());
        holder.mTextViewSatuan.setText("Satuan = " + mLaporanList.get(position).getSatuan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mLaporanList.get(position).getId());
                mIntent.putExtra("Laporan", mLaporanList.get(position).getLaporan());
                mIntent.putExtra("Personil", mLaporanList.get(position).getPersonil());
                mIntent.putExtra("Satuan", mLaporanList.get(position).getSatuan());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mLaporanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewLaporan, mTextViewPersonil, mTextViewSatuan;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewLaporan = (TextView) itemView.findViewById(R.id.tvLaporan);
            mTextViewPersonil = (TextView) itemView.findViewById(R.id.tvPersonil);
            mTextViewSatuan = (TextView) itemView.findViewById(R.id.tvSatuan);
        }
    }
}