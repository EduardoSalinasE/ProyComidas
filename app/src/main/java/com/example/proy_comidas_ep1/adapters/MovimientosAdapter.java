package com.example.proy_comidas_ep1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proy_comidas_ep1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovimientosAdapter extends RecyclerView.Adapter<MovimientosAdapter.ViewHolder> {

    ArrayList<HashMap<String,String>> arrayList;
    public MovimientosAdapter(ArrayList<HashMap<String,String>> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reporte, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovimientosAdapter.ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);
        holder.mtvFecha.setText(map.get("fecha"));
        holder.mtvDescripcion.setText(map.get("descripcion"));
        holder.mtvMonto.setText(map.get("monto"));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtvFecha, mtvDescripcion, mtvMonto;
        public ViewHolder(View view) {
            super(view);

            mtvFecha = itemView.findViewById(R.id.tvFecha);
            mtvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            mtvMonto = itemView.findViewById(R.id.tvMonto);

        }
    }

}
