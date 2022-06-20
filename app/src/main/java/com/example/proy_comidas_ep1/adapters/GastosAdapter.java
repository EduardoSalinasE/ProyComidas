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

public class GastosAdapter extends RecyclerView.Adapter<GastosAdapter.ViewHolder> {

    ArrayList<HashMap<String, String>> arrayList;
    public GastosAdapter(ArrayList<HashMap<String,String>> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public GastosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gastos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GastosAdapter.ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);
        holder.mtvFechaGasto.setText(map.get("fecha"));
        holder.mtvDescripcionGasto.setText(map.get("descripcion"));
        holder.mtvMontoGasto.setText(map.get("monto"));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtvFechaGasto, mtvDescripcionGasto, mtvMontoGasto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtvFechaGasto = itemView.findViewById(R.id.tvFechaGastos);
            mtvDescripcionGasto = itemView.findViewById(R.id.tvDescripcionGasto);
            mtvMontoGasto = itemView.findViewById(R.id.tvMontoGasto);
        }
    }
}
