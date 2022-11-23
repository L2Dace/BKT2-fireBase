package com.example.firebasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cayThuocAdapter extends RecyclerView.Adapter<cayThuocAdapter.cayThuocViewHolder> {

    Context mContext;
    List<cayThuocNam> mListPlant;

    public cayThuocAdapter(Context mContext, List<cayThuocNam> mListPlant) {
        this.mContext = mContext;
        this.mListPlant = mListPlant;
    }

    public void setData(List<cayThuocNam> list){
        this.mListPlant = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public cayThuocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_list,parent,false);
        cayThuocViewHolder plantViewHolder = new cayThuocViewHolder(v);

        return plantViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull cayThuocViewHolder holder, int position) {
        cayThuocNam manga = mListPlant.get(position);
        if (manga == null){
            return;
        }

        holder.imgPlant.setImageResource(manga.getHinhAnh());
        holder.nameKHPlant.setText(manga.getTenKH());
        holder.namePlant.setText(manga.getTenThuongGoi());
    }

    @Override
    public int getItemCount() {
        if (mListPlant != null){
            return mListPlant.size();
        }
        return 0;
    }

    public class cayThuocViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPlant;
        private TextView nameKHPlant, namePlant;

        public cayThuocViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPlant = itemView.findViewById(R.id.img_plant);
            nameKHPlant = itemView.findViewById(R.id.tenKH_plant);
            namePlant = itemView.findViewById(R.id.tenthuongGoi_plant);
        }
    }
}
